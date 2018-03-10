package Unique

class Person {

    String name

    static constraints = {
        name unique:false
    }
}
