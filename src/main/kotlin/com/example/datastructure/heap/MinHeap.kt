package com.example.datastructure.heap

class MinHeap<T:Comparable<T>>: AbstractHeap<T>() {

    override fun heapifyFromBottom(i: Int) {
        var idx = i
        while (idx!=0 && list[parent(idx)]>list[idx]){
            val tmp = list[parent(idx)]
            list[parent(idx)] = list[idx]
            list[idx] = tmp
            idx = parent(idx)
        }
    }

    override fun heapify(i: Int) {
        var minIdx = i
        if(lChild(i)<list.size) minIdx = if(list[lChild(i)]<list[i]) lChild(i) else i
        if(rChild(i)<list.size) minIdx = if(list[rChild(i)]<list[minIdx]) rChild(i) else minIdx
        if(minIdx != i){
            val tmp = list[minIdx]
            list[minIdx] = list[i]
            list[i] = tmp
            heapify(minIdx)
        }
    }

    override fun delete() {
        list[0] = list[list.size-1]
        list.removeLast()
        heapify(0)
    }

    override fun insert(t: T) {
        list.add(t)
        heapifyFromBottom(list.size-1)
    }
}

fun main(){
    val minHeap = MinHeap<Int>()
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
}