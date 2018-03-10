package Unique

import grails.testing.mixin.integration.Integration
import grails.transaction.Rollback
import spock.lang.Specification

@Integration
@Rollback
class TestUniquePersonSpec extends Specification {

    void "Create two people with different names"() {
        def me = new Person(name: "Robert")
        def you = new Person(name: "Jeff")

        expect: "Both saves to succeed"
        me.save()
        you.save()
    }

    void "Create two people with the same name"() {
        def me = new Person(name: "Robert")
        def you = new Person(name: "Robert")

        expect: "Second save to fail"
        me.save()
        !you.save()
    }

}
