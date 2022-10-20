data class node<T>(
    var value: T, var next: node<T>? = null
)
{
    override fun toString(): String {
        return if (next != null){
            "$value -> ${next.toString()}"
        } else{
            "$value"
        }
    }
    fun printInReverse() {
        this.next?.printInReverse()
        if(this.next != null){
            print(" -> ")
        }
        print(this.value.toString())
    }
}

