fun main()
{
    val groupSize = 2
    when (groupSize){
        1 -> println("Single")
        2 -> println("Pair")
        3 -> {
            println("Trio")
        }
        else -> println("This is either nobody or a big crowd")
    }
}