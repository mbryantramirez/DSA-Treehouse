package trees.kotlin.minimalheighttree

import trees.kotlin.TreeNode

fun main() {
    val arr = arrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
    printTreeInOrder(minimalHeightTree(arr))
}

fun minimalHeightTree(arr: Array<Int>): TreeNode? {
    return addToTree(arr, 0, arr.size - 1)
}

fun addToTree(arr: Array<Int>, start: Int, end: Int): TreeNode? {
    if (start > end) return null
    val mid = (start + end) / 2
    val middle = TreeNode(arr[mid])
    middle.left = addToTree(arr, start, mid - 1)
    middle.right = addToTree(arr, mid + 1, end)
    return middle
}

fun printTreeInOrder(root: TreeNode?) {
    root?.let {
        root.left?.let { left ->
            printTreeInOrder(left)
        }
        println(root.data)
        root.right?.let { right ->
            printTreeInOrder(right)
        }
    }
}
