class Main{
}
fun f1(value:Int) = value

fun fofof(a:Int){

}
fun CheckParentheses(exp:String ): Boolean{
    val s = Stack<Char>()
    for(c in exp){
        when (c){
            '(' -> s.push(c)
            ')' -> if (s.isEmpty){
                return false
            } else{
                s.pop()
            }

        }
    }
    return s.isEmpty
}
fun main(){
    var s = "((asdf)asdf)"
    var s2 = "(asdf(asdf)asdf)asdf)"
    var s3 = "(asdf((asfasdfa))"
    println(CheckParentheses(s));
    println(CheckParentheses(s2));
    println(CheckParentheses(s3));
}
