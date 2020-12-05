package src.trees

import java.util.*
import kotlin.collections.ArrayList


fun main() {
    val treeNode = TreeNode(2)
    levelOrder(treeNode)
}


fun levelOrder(root:TreeNode?):List<List<Int>> {
    var result = mutableListOf<List<Int>>()
    var queue = LinkedList<TreeNode?>()
    if (root == null)
         return emptyList()
    queue.add(root)
    queue.add(null)
    var list = ArrayList<Int>()
    while (!queue.isEmpty())
    {
        val node = queue.poll()
        if (node == null)
        {
            result.add(list)
            list = ArrayList<Int>()
            if (queue.isEmpty() || (queue.size == 1 && queue.peek() == null))
                break
            queue.add(null)
            continue
        }
        else
        {
            list.add(node.`val`)
        }
        if (node.left != null)
            queue.add(node.left)
        if (node.right != null)
            queue.add(node.right)
    }
    return result
}