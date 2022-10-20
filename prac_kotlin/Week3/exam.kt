fun main()
{
    var result: Int = 0
    for(x in 30..70)
    {
        if(x%3 == 0){
            result += x
        }
    }
    println(result)
}