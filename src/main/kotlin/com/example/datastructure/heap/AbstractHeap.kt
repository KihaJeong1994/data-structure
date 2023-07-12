package com.example.datastructure.heap

abstract class AbstractHeap<T:Comparable<T>>:Heap<T>{
    val list = mutableListOf<T>()
    protected abstract fun heapifyFromBottom(i: Int)
    protected abstract fun heapify(i:Int)
    fun root() = list[0];
    protected fun parent(i:Int) = (i-1)/2
    protected fun lChild(i:Int) = 2*i+1
    protected fun rChild(i:Int) = 2*i+2
}