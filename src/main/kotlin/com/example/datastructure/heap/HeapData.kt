package com.example.datastructure.heap

class HeapData<T:Comparable<T>>(
    private val comparator: Comparator<T> = Comparator { o1, o2 -> o1.compareTo(o2) }
    ):Heap<T>{

    val list = mutableListOf<T>()

    override fun insert(t: T) {
        list.add(t)
        heapifyFromBottom(list.size-1)
    }

    override fun delete() {
        list[0] = list.last()
        list.removeLast()
        heapify(0)
    }
    private fun heapifyFromBottom(i: Int){
        var idx = i
        while (i>0 && comparator.compare(list[parent(idx)], list[idx])>0){
            val tmp = list[parent(idx)]
            list[parent(idx)] = list[idx]
            list[idx] = tmp
            idx = parent(idx)
        }
    }
    private fun heapify(i:Int){
        var minIdx = i
        if(lChild(i)<list.size) minIdx = if(comparator.compare(list[lChild(i)], list[minIdx])<0) lChild(i)  else minIdx
        if(rChild(i)<list.size) minIdx = if(comparator.compare(list[rChild(i)], list[minIdx])<0) rChild(i)  else minIdx
        if(minIdx!=i){
            val tmp = list[minIdx]
            list[minIdx] = list[i]
            list[i] = tmp
            heapify(minIdx)
        }
    }
    fun root() = list[0];
    protected fun parent(i:Int) = (i-1)/2
    protected fun lChild(i:Int) = 2*i+1
    protected fun rChild(i:Int) = 2*i+2

}

fun main(){
    val minHeap = HeapData<Int>()
    minHeap.insert(9)
    minHeap.insert(7)
    minHeap.insert(5)
    minHeap.insert(3)
    minHeap.insert(1)
    println(minHeap.list)
    minHeap.delete()
    minHeap.delete()
    println(minHeap.list)
    println(minHeap.root())

    val maxHeap = HeapData<Int> { o1, o2 -> o2 - o1 }
    maxHeap.insert(9)
    maxHeap.insert(7)
    maxHeap.insert(5)
    maxHeap.insert(3)
    maxHeap.insert(1)
    println(maxHeap.list)
    maxHeap.delete()
    maxHeap.delete()
    println(maxHeap.list)
    println(maxHeap.root())
}