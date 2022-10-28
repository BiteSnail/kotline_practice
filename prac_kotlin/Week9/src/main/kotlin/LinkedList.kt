class LinkedList<T> : Iterable<T>, Collection<T> {
    private var head: node<T>? = null
    private var tail: node<T>? = null
    override var size = 0
        private set //read only

    override fun iterator(): Iterator<T>{
        return LinkedListIterator(this)
    }

    override fun isEmpty(): Boolean {
        return size == 0
    }

    override fun contains(element: T): Boolean {
        for (item in this)
            if (item == element) return true
        return false
    }

    override fun containsAll(elements: Collection<T>): Boolean {
        for (searched in elements)
            if(!contains(searched)) return false
        return true
    }

    override fun toString(): String {
        if (isEmpty()){
            return "Empty List"
        }
        return head.toString()
    }

    fun push(value: T): LinkedList<T> {
        head = node(value = value, next = head)
        if(tail == null){
            tail = head
        }
        size++
        return this
    }

    fun append(value: T): LinkedList<T>{
        if(isEmpty()){
            return push(value)
        }
        tail?.next = node(value = value)
        tail = tail?.next
        size++
        return this
    }

    fun nodeAt(index: Int): node<T>? {
        var currentNode = head
        var currentIndex = 0

        while(currentNode != null && currentIndex < index){
            currentNode = currentNode.next
            currentIndex++
        }
        return currentNode
    }

    fun insert(value: T, afterNode: node<T>): node<T>{
        if (tail == afterNode){ //after node -> newNode-> after node.next
            append(value)
            return tail!!
        }

        val newNode = node(value = value, next = afterNode.next)
        afterNode.next = newNode
        size++
        return newNode
    }

    fun pop(): T? {
        if (!isEmpty()) size--
        val result = head?.value
        head = head?.next
        if(isEmpty()){
            tail = null
        }
        return result
    }

    fun removeLast(): T? {
        val head = head ?: return null
        if(head.next == null) return pop()
        size--
        var prev = head
        var current = head
        var next = current.next
        while (next != null){
            prev = current
            current = next
            next = current.next
        }
        prev.next = null
        tail = prev
        return current.value
    }

    fun removeAfter(node: node<T>): T? {
        val result = node.next?.value
        if(node.next == tail) {
            tail = node
        }
        if (node.next != null){
            size--
        }
        node.next = node.next?.next
        return result
    }

    fun printInReverse(){
        this.nodeAt(0)?.printInReverse()
    }

    fun getMiddle(): node<T>?{
        var slow = this.nodeAt(0)
        var fast = this.nodeAt(0)
        while(fast != null){
            fast = fast.next
            if( fast != null ){
                slow = slow?.next
                fast = fast.next
            }
        }
        return slow
    }
    private fun addInReverse(list: LinkedList<T>, node: node<T>)
    {
        val next = node.next
        if(next != null){
            addInReverse(list, next)
        }
        list.append(node.value)
    }

    fun reversed(): LinkedList<T> {
        val result = LinkedList<T>()
        val head = this.nodeAt(0)
        if(head!= null){
            addInReverse(result, head)
        }
        return result
    }
    fun removeHead(): T? {
        val head = head ?: return null
        size--
        this.head = head.next
        if(isEmpty())
            this.tail = null
        return head.value
    }

    fun mergesorted(other: LinkedList<T>): LinkedList<T>{
        var result:LinkedList<T> = LinkedList<T>()


        return result
    }
}

class LinkedListIterator<K>(
    private val list: LinkedList<K>
) : Iterator<K>{
    private var index = 0
    private var lastNode: node<K>? = null

    override fun next(): K{
        if (index >= list.size) throw IndexOutOfBoundsException()
        lastNode = if (index == 0){
            list.nodeAt(0)
        }else
            lastNode?.next
        index++
        return lastNode!!.value
    }
    override fun hasNext(): Boolean{
        return index < list.size
    }
}