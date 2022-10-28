import kotlin.collections.ArrayDeque

typealias Predicate<T> = (T) -> Boolean
typealias Compare<T> = (T, T) -> Boolean

fun foo(p: Predicate<Int>) = p(42)
fun main() {
    val nums = LinkedList<Int>()

    nums.apply{
        append(1)
        append(2)
        append(3)
        append(4)
    }
    nums.forEach{
        println(it)
    }
}

