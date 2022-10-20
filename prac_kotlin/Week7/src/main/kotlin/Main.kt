fun <T: Comparable<T>> ArrayList<T>.findIndices(
    value: T
): IntRange? {
    var lindex = 0
    var rindex = size
    var find = false

    while(lindex < rindex){
        var middle = (lindex+rindex)/2
        if(this[middle] == value){
            lindex = middle
            rindex = middle
            find = true
            break
        }
        else if(this[middle] > value)
            rindex = middle - 1
        else
            lindex = middle + 1
    }
    if(!find)
        return null
    while(lindex > 0 && this[lindex] == this[lindex-1]){
        lindex--;
    }
    while(rindex < size-1 && this[rindex] == this[rindex+1]){
        rindex++;
    }
    return lindex..rindex
}

fun main(args: Array<String>) {
    val array = arrayListOf(1,2,3,3,3,4,5,5)
    val indices = array.findIndices(6)
    println(indices)
}