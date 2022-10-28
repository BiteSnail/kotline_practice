

class Flower private constructor(val name: String) {
    var Bizz:String = "memememememem"
    inner class inn(val s:String){
        fun f1(){println("f1_inner")}
    }
    fun f1(){println("f1")}
    val a:inn = inn("hihi")
    class nes(val s:String){
        fun f2(){println("f2_nestd")}
    }


    companion object bud{
        private var numFlowers: Int = 0
        fun bloom(name: String): Flower?{
            val a = Flower(name)
            val b = nes("dfdf")
            b.f2()
            if(numFlowers > 0)
                return null
            numFlowers++
            return a
        }
    }

}