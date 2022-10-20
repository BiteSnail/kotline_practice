class RedBlackTree<T: Comparable<T>> {
    var root:RedBlackNode<T>? = null

    private fun insert(node:RedBlackNode<T>?, value: T):RedBlackNode<T>{
        node ?: return RedBlackNode(value);

        if(node.value < value){
            return insert(node.rightChild, value);
        }
    }

    fun insert(value: T){
        root = insert(root, value)
    }
}