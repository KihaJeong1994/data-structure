package com.example.datastructure.tree.btree

class BTree(val degree:Int){
    private var root:BTreeNode? = null

    fun search(k:Int):BTreeNode?{
        return root?.search(k)
    }

    class BTreeNode(private val degree: Int, private val leaf:Boolean){
        private val key:List<Int?> = List(2*degree-1){null}
        private val children:List<BTreeNode?> = List(2*degree){null}
        private var keyCnt:Int = 0

        fun search(k:Int):BTreeNode?{
            // 1. find the appropriate key  : key[i]<=k<key[i+1]
            var i = 0
            while (i<keyCnt && k>key[i]!!) i++

            // 2. check if key[i] == k
            if(k == key[i]) return this

            // 3. if key is not found and this is leaf -> return null
            if(leaf) return null

            // go to the appropriate child
            return children[i]!!.search(k)
        }
    }
}