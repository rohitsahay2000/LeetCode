import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderBotttom {


    public List<List<Integer>> levelOrderBottom(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();

        if (root == null)
            return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);

        List<Integer> nodesByLevel = new ArrayList<>();
        while (!queue.isEmpty()) {

            TreeNode node = queue.poll();
            if (node == null) {
                result.add(0,nodesByLevel);
                if (queue.isEmpty())
                    break;
                nodesByLevel = new ArrayList<>();
                queue.add(null);
            } else {
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
            }
            if(node!=null)
                nodesByLevel.add(node.val);
        }
        return result;
    }
}
