package depthfirstsearch;

/**
 * Created by matt on 5/24/16.
 */
public class BalancedBinaryTree110 {
	public boolean isBalanced1(TreeNode root) {
		return isHelp2(root, 0) >= 0;
	}

	/**
	 * 通过记录树的高度来避免计算
	 *
	 * @param root
	 * @param depth
	 * @return
	 */
	public int isHelp2(TreeNode root, int depth) {
		if (root == null) {
			return depth;
		}
		int leftDepth = isHelp2(root.left, depth + 1);
		int rightDepth = isHelp2(root.right, depth + 1);
		if (leftDepth < 0 || rightDepth < 0 || Math.abs(leftDepth - rightDepth) > 1) {
			return -1;
		}
		return Math.max(leftDepth, rightDepth);
	}

	/**
	 * 相对于上面的方法，这里又减少了重复计算
	 *
	 * @param root
	 * @return
	 */
	public boolean isBalanced2(TreeNode root) {
		if (root == null) {
			return true;
		}
		return isDepth(root) != -1;
	}

	public int isDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int left = isDepth(root.left);
		if (left == -1) {
			return -1;
		}
		int right = isDepth(root.right);
		if (right == -1) {
			return -1;
		}
		if (left - right > 1 || left - right < -1) {
			return -1;
		}
		return Math.max(left, right) + 1;
	}
}
