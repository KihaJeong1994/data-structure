package com.example.datastructure.heap

class MinHeap<T>: AbstractHeap<T>() {
    val list = mutableListOf<T>()

    override fun heapify() {
        TODO("Not yet implemented")
    }

    override fun delete() {
        TODO("Not yet implemented")
    }

    override fun insert(t: T) {
        list.add(t)
        heapify()
    }
}