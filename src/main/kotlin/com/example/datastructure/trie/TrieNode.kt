package com.example.datastructure.trie

class Trie{
    private val root = TrieNode()

    fun insert(word: String){
        var node = root
        var idx:Int
        for(c in word){
            idx = charToIdx(c)
            if(node.children[idx]==null) node.children[idx] = TrieNode()
            node = node.children[idx]!!
        }
        node.isEnd = true
    }

    fun search(word: String):Boolean{
        var node = root
        for(c in word){
            var idx = charToIdx(c)
            if(node.children[idx]==null){
                return false
            }
            node = node.children[idx]!!
        }
        return node.isEnd
    }

    private fun charToIdx(char: Char):Int = char.compareTo('a')

    class TrieNode {
        val ALPHABET_SIZE = 26
        var isEnd = false
        val children = MutableList<TrieNode?>(ALPHABET_SIZE){ null }
    }
}


fun main() {
    val trie = Trie()
    trie.insert("an")
    trie.insert("and")
    println(trie.search("an"))
    println(trie.search("and"))
    println(trie.search("andg"))
    trie.insert("baz")
    println(trie.search("baz"))

}