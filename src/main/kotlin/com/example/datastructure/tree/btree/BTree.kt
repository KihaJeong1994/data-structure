package com.example.datastructure.tree.btree

class BTree(val degree:Int){
    private var root:BTreeNode? = null

    fun traverse(){
        root?.traverse()
    }

    fun search(k:Int):BTreeNode?{
        return root?.search(k)
    }

    class BTreeNode(private val degree: Int, private val leaf:Boolean){
        private val key:List<Int?> = List(2*degree-1){null}
        private val children:List<BTreeNode?> = List(2*degree){null}
        private var keyCnt:Int = 0

        fun traverse(){
            // there are keyCnt+1 child
            for(i in 0..keyCnt){
                if(!leaf) children[i]!!.traverse()
                print("${key[i]} ")
            }
        }

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

        /**
         * 1) Initialize x as root
         * 2) While x is not leaf, do following
         *  a) Find the child of x that is going to be traversed next. Let the child be y
         *  b) If y is not full, change x to point to y
         *  c) If y is full, split it and change x to point to one of the two parts of y. If k is smaller than mid key in y, then set
         *  x as the first part of y. Else second part of y. When we split y, we move a key from y to its parent x.
         * 3) The loop in step 2 stops when x is leaf. x must have space for 1 extra key as we have been splitting all nodes
         * in advance. So simply insert k to x.
         *
        * */
        fun insert(k:Int){

        }
    }
}