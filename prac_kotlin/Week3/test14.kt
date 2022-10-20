class Person(
    private var age: Int,
    public var name: String="Noname",
    sayhi: String
)
{
    init {
        println("$name ($age): $sayhi")
    }
}

fun main()
{
    var p1: Person = Person(10, "Kevin", "Hi, there!")
    println(p1.name)
}