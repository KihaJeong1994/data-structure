package com.example.datastructure.trie

class TrieNode {
    val ALPHABET_SIZE = 26
    var isEnd = false
    val children = MutableList<TrieNode?>(ALPHABET_SIZE){ null }
    fun insert(word:String) {
        val node = children[charToIdx(word.first())] ?: TrieNode()
        children[charToIdx(word.first())] = node
        if (word.length > 1) {
            node.insert(word.substring(1))
        } else {
            node.isEnd = true
        }
    }
    fun search(word:String):Boolean{
        val trieNode = children[charToIdx(word.first())]
        if(word.length==1) return trieNode !=null && trieNode.isEnd
        return (trieNode !=null) && trieNode.search(word.substring(1))
    }

    private fun charToIdx(char: Char):Int = char.compareTo('a')
}

fun main() {
    val root = TrieNode()
    root.insert("an")
    root.insert("and")
    println(root.search("an"))
    println(root.search("and"))
    println(root.search("andg"))
    root.insert("baz")
    println(root.search("baz"))

}