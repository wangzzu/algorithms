package tree;

/**
 * Created by matt on 4/27/16.
 */
public class BalancedBinaryTree110 {
	public static void main(String[] args) {

	}

	/**
	 * 简单，但是会重复计算很多
	 *
	 * @param root
	 * @return
	 */
	public static boolean isBalanced1(TreeNode root) {
		if (root == null) {
			return true;
		}
		int left = getDepth(root.left);
		int right = getDepth(root.right);
		int diff = left - right;
		if (diff > 1 || diff < -1) {
			return false;
		}
		return isBalanced1(root.left) && isBalanced1(root.right);
	}

	/**
	 * the depth of the tree
	 *
	 * @param root
	 * @return
	 */
	public static int getDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return 1 + Math.max(getDepth(root.left), getDepth(root.right));
	}


	/**
	 * 减少树深度的中间量
	 *
	 * @param root
	 * @return
	 */
	public static boolean isBalanced2(TreeNode root) {
		return isHelp2(root, 0) >= 0;
	}

	public static int isHelp2(TreeNode root, int depth) {
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
}
