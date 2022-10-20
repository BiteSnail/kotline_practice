fun f(k: Int): Int{
    k *= 2
    return k
}

fun main()
{
    var k: Int = 5
    var ret: Int = f(k)

    println("$k\t$ret")
}