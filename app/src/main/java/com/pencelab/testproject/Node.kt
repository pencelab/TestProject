package com.pencelab.testproject

class Node (private var leftChild: Node?, private var rightChild: Node?){

    fun height() : Int {
        if(this.leftChild == null && this.rightChild == null)
            return 0

        val leftChildHeight = this.leftChild?.height() ?: 0
        val rightChildHeight = this.rightChild?.height() ?: 0

        return 1 + if (leftChildHeight > rightChildHeight) leftChildHeight else rightChildHeight
    }

    fun releaseChildren(){
        this.leftChild?.releaseChildren()
        this.rightChild?.releaseChildren()
    }
}