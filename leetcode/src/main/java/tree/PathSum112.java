package tree;

/**
 * Created by matt on 5/5/16.
 */
public class PathSum112 {
	/**
	 * iterator and find the role
	 *
	 * @param root
	 * @param sum
	 * @return
	 */
	public boolean hasPathSum(TreeNode root, int sum) {
		if (root == null) {
			return false;
		} else if (root.left == null && root.right == null) {
			if (sum == root.val) {
				return true;
			} else {
				return false;
			}
		} else {
			return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
		}
	}
}
