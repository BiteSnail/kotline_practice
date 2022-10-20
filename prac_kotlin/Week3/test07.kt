fun main()
{
    val a = 5
    val b = 12

    if (a > b){
        println("a is greater.")
    } else if(a< b){
        println("b is greater.")
    } else{
        println("a==b")
    }

    val c: Double = b * 1.0 / a
    if(c > 1)
        println("c > 1")
    else{
        println("c <= 1")
    }

    println("program end.")
}