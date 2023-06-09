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

    val treeNode = TreeNode(' ')
    class TreeNode(val `val`: Char) {
        val set: HashSet<TreeNode> = HashSet()
    }
    fun insert(word: String) {
        insertWithTree(word, treeNode)
    }

    private fun insertWithTree(word: String, treeNode: TreeNode?) {
        if (word.isEmpty()) {
            return
        }
        if (treeNode == null) {
            return
        }
        if (treeNode.set.indexOf(TreeNode(word[0])) == -1) {
            treeNode.set.add(TreeNode(word[0]))
            insertWithTree(word.substring(1, word.length), treeNode.set.first())
        } else {
        }
    }

    fun search(word: String): Boolean {
        return true
    }

    fun startsWith(prefix: String): Boolean {
        return true
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * var obj = Trie()
 * obj.insert(word)
 * var param_2 = obj.search(word)
 * var param_3 = obj.startsWith(prefix)
 */
