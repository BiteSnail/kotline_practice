fun main()
{
    var scores1 = arrayOf(100, 90, 80)
    var scores2 = Array<Int>? = null

    var scores3 = Array<Int> = scores2 ?: scores1
    //?: example
    print(scores3.get(0))
}