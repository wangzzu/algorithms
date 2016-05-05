package tree;

/**
 * Created by matt on 5/5/16.
 */
public class SymmetricTree101 {
	/**
	 * 使用分治思想，递归进行判断
	 *
	 * @param root
	 * @return
	 */
	public boolean isSymmetric(TreeNode root) {
		if (root == null) {
			return true;
		} else {
			return isSymmetric(root.left, root.right);
		}
	}

	public boolean isSymmetric(TreeNode left, TreeNode right) {
		if (left == null && right == null) {
			return true;
		} else if (left == null || right == null) {
			return false;
		} else {
			return (left.val == right.val) && isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
		}
	}
}
