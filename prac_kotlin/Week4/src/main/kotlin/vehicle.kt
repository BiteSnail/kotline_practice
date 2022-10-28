abstract class vehicle(
    var name:String,
    var size:Int,
    var weigth:Int,
    var price:Int
) {
    abstract fun Info()
}

interface movable{
    val speed:Int
    var accel:Int
}

interface flable:movable{
    fun fly()
    fun land()
}

class airplane(
    name:String,
    size:Int,
    weigth: Int,
    price: Int,
    override var speed: Int,
    override var accel: Int
) : vehicle(name,size,weigth,price), flable{
    override fun Info() {
        println("${name} : ${price}")
    }
    override fun fly() {
        println("슉 날아갑니다..")
    }

    override fun land() {
        println("휭 착륙합니다..")
    }
}