data class node<T>(
    var value: T, var next: node<T>? = null
)
{
    override fun toString(): String {
        return if (next != null){
            "${value} -> ${next.toString()}"
        } else{
            "$value"
        }
    }
    fun printInReverse() {
        this.next?.let{
            it.printInReverse()
            print(" -> ")
        }
        print(this.value)
    }
}

