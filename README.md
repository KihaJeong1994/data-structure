# Data Structure

This repository contains the implementations of various ***data structures***.

I think it will be helpful to implement the data structure by myself for deeply understanding the inner process and the usage of data structure.

https://www.geeksforgeeks.org/data-structures/?ref=shm

I usually refer to the link above to study about the data structures.

Let's get started!

## Heap

> A Heap is a special Tree-based Data Structure in which the tree is complete binary tree.

Heap : a **complete binary tree** based data structure

Complete binary tree : a binary tree that all levels of the tree are **fully filled** except possibly the last level

### Type

1. Max Heap : max value in root node. same thing must be done for its left and right sub-tree also.
2. Min Heap : min value in root node. same thing must be done for its left and right sub-tree also.

![](https://media.geeksforgeeks.org/wp-content/uploads/20230315185259/heap.png)

### Properties

- Complete Binary Tree : fully filled tree -> represented using **array**
- Heap Property : minimum(or maximum) value always at root
- Parent-Child Relationship : Parent node index = i -> left child node index = 2i+1, right child node index = 2i+2
- Efficient Insertion and Removal
  - Insertion(O(logN)) : inserted at the next available position in the bottom-rightmost level -> heapify(restore heap property by comparing the element with its parent and swapping if necessary)
  - Removal of root element (O(logN)): replace root with the last element -> heapify
- Efficient Access to Extremal Elements

### Heapify

***Heapify*** is the process to rearrange the elements to maintain the property of heap data structure