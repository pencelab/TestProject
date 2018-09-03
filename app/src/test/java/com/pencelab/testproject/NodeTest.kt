package com.pencelab.testproject

import org.junit.After
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

class NodeTest {

    private var root: Node? = null

    @Before
    fun init(){
        val node10 = Node(null, null)

        val node7 = Node(null, null)
        val node8 = Node(null, null)
        val node9 = Node(node10, null)

        val node4 = Node(null, node7)
        val node5 = Node(null, null)
        val node6 = Node(node8, node9)

        val node2 = Node(node4, node5)
        val node3 = Node(null, node6)

        this.root = Node(node2, node3)
    }

    @Test
    fun shouldCalculateTreeHeightCorrectly() {
        assertEquals(4, root?.height() ?: 0)
    }

    @Test
    fun shouldCalculateEmptyTreeHeightCorrectly() {
        val nullNode: Node? = null
        assertEquals(0, nullNode?.height() ?: 0)
    }

    @Test
    fun shouldCalculateOneNodeTreeHeightCorrectly() {
        val nullNode: Node? = Node(null, null)
        assertEquals(0, nullNode?.height() ?: 0)
    }

    @Test
    fun shouldCalculateTwoNodesTreeHeightCorrectly() {
        val nullNode: Node? = Node(Node(null, null), null)
        assertEquals(1, nullNode?.height() ?: 0)
    }

    @After
    fun destroy(){
        root?.releaseChildren()
    }
}