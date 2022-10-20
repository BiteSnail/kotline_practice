class Box<T> {
    var content: T? = null
    fun put(content: T?){
        this.content = content
    }
    fun retrieve(): T? {
        return content
    }
    fun isEmpty(): Boolean {
        return content == null
    }
}

fun main()
{
    var b1: Box = Box<int>()
    b1.put(4)

    var b2: Box = Box<Boolean>()
    b2.put(true)

    println(b1.retrieve())
    println(b2.isEmpty())
}