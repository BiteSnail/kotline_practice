class Main{
}
typealias Predicate<T> = (T) -> Boolean
typealias Compare<T> = (T, T) -> Boolean

fun foo(p: Predicate<Int>) = p(42)
fun main() {
    val queue = RingBufferQueue<String>(2).apply{
        enqueue("Ray")
        enqueue("Brain")
        enqueue("Eric")
    };
    println(queue)

    val f: Predicate<Int> = {it > 0}
    println(foo(f))

    val p: Predicate<Int> = { it > 0 }
    println(listOf(1, -2).filter(p))


}

