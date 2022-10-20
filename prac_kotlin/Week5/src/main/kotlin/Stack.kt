interface StackInterface<Element>{
    val count: Int // count가 왜 있어야 하는지?
        get
    fun peek(): Element?
    val isEmpty: Boolean
        get() = count == 0
    fun push(element: Element)
    fun pop(): Element?
}

class Stack<Element>() : StackInterface<Element>{
    private val storage = arrayListOf<Element>()
    override fun toString() = buildString {
        appendLine("----top----")
        storage.asReversed().forEach {
            appendLine("$it")
        }
        appendLine("----------")
    }
    override fun peek(): Element? {
        return storage.lastOrNull()
    }
    override val count: Int
        get() = storage.size
    override fun push(element: Element){
        storage.add(element)
    }

    override fun pop(): Element? {
        if (storage.size == 0){
            return null
        }
        return storage.removeAt(count -1)
    }
}
