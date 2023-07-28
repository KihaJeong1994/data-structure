package com.example.datastructure.tree.btree

class BTree(val degree:Int){
    private var root:BTreeNode? = null

    fun traverse(){
        root?.traverse()
    }

    fun search(k:Int):BTreeNode?{
        return root?.search(k)
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
        if(root==null){
            root = BTreeNode(t=degree, leaf = true)
            root!!.keys[root!!.n] = k
            root!!.n++
        }else{
            // if root is full
            if(root!!.n == 2*degree-1){
                // create new root
                var s = BTreeNode(t=degree, false)

                // set old root as child of new root
                s.children[0] = root

                // split the old root and move 1 key to the new root
                s.splitChild(0,root!!)

                var i=0

                // decide which of the two children is going to have new key
                if(s.keys[0]!!<k) i++
                s.children[i]!!.insert(k)

                // change root
                root = s
            }else{
                root!!.insert(k)
            }
        }
    }

    class BTreeNode(private val t: Int, private val leaf:Boolean){
        val keys = MutableList<Int?>(2*t-1){null}
        val children = MutableList<BTreeNode?>(2*t){null}
        var n:Int = 0 // number of key

        fun traverse(){
            // there are keyCnt+1 child
            for(i in 0..n){
                if(!leaf) children[i]!!.traverse()
                print("${keys[i]} ")
            }
        }

        fun search(k:Int):BTreeNode?{
            // 1. find the appropriate key  : key[i]<=k<key[i+1]
            var i = 0
            while (i<n && k>keys[i]!!) i++

            // 2. check if key[i] == k
            if(k == keys[i]) return this

            // 3. if key is not found and this is leaf -> return null
            if(leaf) return null

            // go to the appropriate child
            return children[i]!!.search(k)
        }


        fun insert(k:Int){
            var i = n-1;
            if(leaf){
                while(i>=0 && keys[i]!! >k){
                    keys[i+1] = keys[i]
                    i--
                }
                keys[i+1] = k
                n++
            }else{
                while(i>=0 && keys[i]!! >k){
                    i--
                }
                if(children[i+1]!!.n == 2*t-1){
                    splitChild(i+1, children[i+1]!!)

                    if(keys[i+1]!! < k) i++
                }
                children[i+1]!!.insert(k)
            }

        }

        fun splitChild(i:Int, y:BTreeNode){
            val z:BTreeNode = BTreeNode(y.t,y.leaf)
            z.n = t-1

            // copy the last t-1 keys of y to z
            for(j in 0 until t-1) z.keys[j] = y.keys[j+t]

            // copy the last t children of y to z
            if(!y.leaf){
                for(j in 0 until t) z.children[j] = y.children[j+t]
            }

            // reduce number of keys in y
            y.n = t-1

            // create space of new child
            for(j in n downTo i+1) children[j+1] = children[j]

            // link the new child to this node
            children[i+1] = z

            for(j in n-1 downTo i) keys[j+1] = keys[j]
            keys[i] = y.keys[t-1]

            n++
        }
    }
}

fun main(){
    val bTree = BTree(degree = 3)
    bTree.insert(10)
    bTree.insert(20)
    bTree.traverse()
}