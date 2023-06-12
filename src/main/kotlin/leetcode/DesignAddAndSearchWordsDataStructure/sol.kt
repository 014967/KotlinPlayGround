package leetcode.DesignAddAndSearchWordsDataStructure

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
    val wordDictionary = WordDictionary()
    wordDictionary.addWord("a")
    wordDictionary.addWord("ab")
    println(wordDictionary.search("a"))
    println(wordDictionary.search("a."))
    println(wordDictionary.search("ab"))
    println(wordDictionary.search(".a"))
    println(wordDictionary.search(".b"))
    println(wordDictionary.search("ab."))
    println(wordDictionary.search("."))
    println(wordDictionary.search(".."))
}

class WordDictionary() {

    val trie = Trie()
    fun addWord(word: String) {
        trie.insert(word)
    }

    fun search(word: String): Boolean {
        return trie.search(word)
    }
}

class Trie() {

    val treeNode = TreeNode()
    var flag = true

    class TreeNode {
        val set: HashMap<Char, Pair<Boolean, TreeNode?>> = HashMap()
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

        if (treeNode.set.containsKey(word[0])) {
            treeNode.set['.'] = Pair(true, TreeNode())
            val anyNewNode = treeNode.set['.']

            val newNode = treeNode.set[word[0]]!!.second
            val newWord = word.drop(1)
            if (newWord.isEmpty()) {
                treeNode.set['.'] = treeNode.set['.']!!.copy(true)
                treeNode.set[word[0]] = treeNode.set[word[0]]!!.copy(first = true)
            } else {
                insertWithTree(treeNode = anyNewNode?.second, word = newWord)
                insertWithTree(treeNode = newNode, word = newWord)
            }
        } else {
            treeNode.set[word[0]] = Pair(false, TreeNode())

            treeNode.set['.'] = Pair(false, TreeNode())
            val anyNewNode = treeNode.set['.']

            val newTreeNode = treeNode.set[word[0]]
            val newWord = word.drop(1)
            if (newWord.isEmpty()) {
                treeNode.set['.'] = treeNode.set['.']!!.copy(first = true)
                treeNode.set[word[0]] = treeNode.set[word[0]]!!.copy(first = true)
            } else {
                insertWithTree(treeNode = newTreeNode?.second, word = newWord)
                insertWithTree(treeNode = anyNewNode?.second, word = newWord)
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
}
