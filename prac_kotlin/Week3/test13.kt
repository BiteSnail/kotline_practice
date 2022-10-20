class Person(
    private var age: Int,
    public var name: String="Noname"
)
{
}

fun main()
{
    var p1: Person = Person(10)
    println(p1.name)
}