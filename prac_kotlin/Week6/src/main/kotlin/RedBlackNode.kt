
import java.lang.Math.max

val BLACK:Int = 0;
val RED:Int = 1;

class RedBlackNode<T: Comparable<T>>(val value: T) {
    var color:Int = RED;
    var parent:RedBlackNode<T>? = null;
    var leftChild:RedBlackNode<T>? = null;
    var rightChild:RedBlackNode<T>? = null;

    val grandparent:RedBlackNode<T>?
        get() = grandparent();
    val uncle:RedBlackNode<T>?
        get() = uncle();

    fun grandparent():RedBlackNode<T>?{
        return parent?.parent;
    }

    fun uncle(): RedBlackNode<T>?{
        val g = grandparent();
        return g?.let{
            if(it.rightChild == parent) it.leftChild else it.rightChild
        }
    }

}
