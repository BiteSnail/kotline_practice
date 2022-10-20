import jdk.incubator.vector.VectorOperators.Binary

class Main{
}
fun makeBinaryTree(): AVLNode<Int>{
    val zero = BinaryNode(0)
    val one = BinaryNode(1)
    val five = BinaryNode(5)
    val seven = BinaryNode(7)
    val eight = BinaryNode(8);
    val nine = BinaryNode(9)
    seven.leftChild = one
    one.leftChild = zero
    one.rightChild = five
    seven.rightChild = nine
    nine.leftChild = eight
    val tree = seven
    return tree
}

fun main() {
    val tree = BinarySearchTree<Int>();
    (0..10).forEach{
        tree.insert(it)
    }
    tree.contains(5);

}

