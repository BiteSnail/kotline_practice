class Box {
    var content: Any? = null
    fun put(content: Any?){
        this.content = content
    }
    fun retrieve(): Any? {
        return content
    }
    fun isEmpty(): Boolean {
        return content == null
    }
}

fun main()
{
    val b1: Box = Box()
    b1.put("apple")

    val b2: Box = Box()
    b2.put(3)

    println(b1.retrieve())
    println(b2.retrieve())

    b1.put(5)
    println(b1.retrieve())
}