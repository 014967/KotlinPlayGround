package leetcode.`Implement-trie-prefix-tre`

/**
 * @desc
 *
 * @input
 *
 * @output
 *
 * @example
 *
 */

fun main() {
    val trie = Trie()
    trie.insert("apple")
    println(trie.search("apple"))
    println(trie.search("app"))
    println(trie.startsWith("app"))
    trie.insert("app")
    println(trie.search("app"))
}
class Trie() {

    val treeNode = TreeNode()
    var flag = true

    val arr = HashMap<String, String>()
    class TreeNode {
        val set: HashMap<Char, Pair<Boolean, TreeNode?>> = HashMap()
    }
    fun insert(word: String) {
        arr[word] = word
        insertWithTree(word, treeNode)
    }

    private fun insertWithTree(word: String, treeNode: TreeNode?) {
        if (word.isEmpty()) {
            return
        }
        if (treeNode == null) {
            return
        }

        if (treeNode.set.containsKey(word[0])) {
            val newNode = treeNode.set[word[0]]!!.second
            val newWord = word.drop(1)
            if (newWord.isEmpty()) {
                treeNode.set[word[0]] = treeNode.set[word[0]]!!.copy(first = true)
            } else {
                insertWithTree(treeNode = newNode, word = newWord)
            }
        } else {
            treeNode.set[word[0]] = Pair(false, TreeNode())
            val newTreeNode = treeNode.set[word[0]]
            val newWord = word.drop(1)
            if (newWord.isEmpty()) {
                treeNode.set[word[0]] = treeNode.set[word[0]]!!.copy(first = true)
            } else {
                insertWithTree(treeNode = newTreeNode?.second, word = newWord)
            }
        }
    }

    fun search(word: String): Boolean {
        val copyNode = treeNode
        searchWithNode(word = word, copyNode = copyNode)
        var result = true
        result = flag

        flag = true
        return result
    }

    private fun searchWithNode(word: String, copyNode: TreeNode) {
        if (word.isEmpty()) {
            return
        }
        if (!flag) {
            return
        }
        if (copyNode.set.containsKey(word[0])) {
            val newWord = word.drop(1)
            if (newWord.isEmpty()) {
                flag = copyNode.set[word[0]]!!.first
            } else {
                searchWithNode(copyNode = copyNode.set[word[0]]!!.second!!, word = newWord)
            }
        } else {
            flag = false
        }
    }

    private fun searchStartWithNode(word: String, copyNode: TreeNode) {
        if (word.isEmpty()) {
            return
        }
        if (!flag) {
            return
        }
        if (copyNode.set.containsKey(word[0])) {
            val newWord = word.drop(1)
            searchStartWithNode(copyNode = copyNode.set[word[0]]!!.second!!, word = newWord)
        } else {
            flag = false
        }
    }

    fun startsWith(prefix: String): Boolean {
        val copyNode = treeNode

        if (copyNode.set.containsKey(prefix[0])) {
            searchStartWithNode(copyNode = copyNode.set[prefix[0]]!!.second!!, word = prefix.drop(1))
        } else {
            flag = false
        }

        var result = true
        result = flag

        flag = true
        return result
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * var obj = Trie()
 * obj.insert(word)
 * var param_2 = obj.search(word)
 * var param_3 = obj.startsWith(prefix)
 */
