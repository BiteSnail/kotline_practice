class Main{
}

fun main(){
    val list = LinkedList<Int>().apply {
        append(1)
        append(2)
        append(3)
    }
    val reverselist = list.reversed()
    println(list)
    println(reverselist)
    print(list.getMiddle()?.value)
}
