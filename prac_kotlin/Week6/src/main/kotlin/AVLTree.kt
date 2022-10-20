import java.lang.Math.max

class AVLTree<T: Comparable<T>> {
    var root: AVLNode<T>? = null
    override fun toString() = root?.toString() ?: "empty tree"

    private fun leftRotate(TargetNode: AVLNode<T>): AVLNode<T>{
        var TurnedNode = TargetNode.rightChild!!
        TargetNode.rightChild = TurnedNode.leftChild
        TurnedNode.leftChild = TargetNode
        TargetNode.height = max(TargetNode.leftHeight, TargetNode.rightHeight) + 1
        TurnedNode.height = max(TurnedNode.leftHeight, TurnedNode.rightHeight) + 1
        return TurnedNode
    }
    private fun rightRotate(node: AVLNode<T>): AVLNode<T>{
        val pivot = node.leftChild!!
        node.leftChild = pivot.rightChild
        pivot.rightChild = node
        node.height = max(node.leftHeight, node.rightHeight) + 1
        pivot.height = max(pivot.leftHeight, pivot.rightHeight) + 1
        return pivot
    }
    private fun rightLeftRoate(node: AVLNode<T>): AVLNode<T>{
        val rightChild = node.rightChild ?: return node
        node.rightChild = rightRotate(rightChild)
        return leftRotate(node)
    }
    private fun leftRightRotate(node: AVLNode<T>): AVLNode<T>{
        val leftChild = node.leftChild ?: return node
        node.leftChild = leftRotate(leftChild)
        return rightRotate(node)
    }
    private fun balanced(node: AVLNode<T>): AVLNode<T>{
        return when (node.balanceFactor){
            2 -> {
                if (node. leftChild?.balanceFactor == -1)
                    leftRightRotate(node)
                else
                    rightRotate(node)
            }
            -2 -> {
                if (node.rightChild?.balanceFactor == 1)
                    rightLeftRoate(node)
                else
                    leftRotate(node)
            }
            else -> node
        }
    }
    private fun insert(node: AVLNode<T>?, value: T):AVLNode<T>?{
        node ?: return AVLNode(value)
        if (value < node.value){
            node.leftChild = insert(node.leftChild, value)
        }else{
            node.rightChild = insert(node.rightChild, value)
        }
        val balancedNode = balanced(node)
        balancedNode?.height = Math.max(
            balancedNode?.leftHeight ?: 0,
            balancedNode.rightHeight ?: 0
        ) + 1
        return balancedNode
    }
    fun insert(value: T){
        root = insert(root, value)
    }

}