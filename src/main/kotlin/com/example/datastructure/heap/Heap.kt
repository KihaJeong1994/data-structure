package com.example.datastructure.heap

interface Heap<T:Comparable<T>> {
    fun insert(t:T)
    fun delete()
}