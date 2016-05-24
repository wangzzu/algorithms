package depthfirstsearch;

/**
 * Created by matt on 5/24/16.
 */
public class MaximumDepthofBinaryTree104 {
	public int maxDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int leftDepth = maxDepth(root.left);
		int rightDepth = maxDepth(root.right);
		return leftDepth > rightDepth ? leftDepth + 1 : rightDepth + 1;
	}
}
