class Trie<Key> {
    private val root = TrieNode<Key>(key=null, parent =null)
    private val storedLists: MutableSet<List<Key>> = mutableSetOf()
    val lists: List<List<Key>>
        get() = storedLists.toList()

    val count: Int
        get() = storedLists.size
    val isEmpty: Boolean
        get() = count == 0

    private fun count(){

    }

    fun insert(list: List<Key>){
        var current = root
        list.forEach{
            if(current.children[it] == null){
                current.children[it] = TrieNode(it, current)
            }
            current = current.children[it]!!
        }
        current.isTerminating = true
        storedLists.add(list)
    }

    fun contain(list: List<Key>): Boolean{
        var current = root
        for(i in list){
            val child = current.children[i] ?: return false
            current = child
        }
        return current.isTerminating
    }

    fun remove(collection: List<Key>){
        var current = root
        for(element in collection){
            val child = current.children[element] ?: return
            current = child
        }
        if(!current.isTerminating) return
        current.isTerminating = false
        storedLists.remove(collection)
        val parent = current.parent
        while (current.children.isEmpty() && !current.isTerminating){
            parent?.let{
                it.children[current.key!!] = null
                current = it
            }
        }
    }
}

fun Trie<Char>.insert(string: String){
    insert(string.toList())
}

fun Trie<Char>.contain(string: String){
    contain(string.toList())
}
fun Trie<Char>.remove(string: String){
    remove(string.toList())
}