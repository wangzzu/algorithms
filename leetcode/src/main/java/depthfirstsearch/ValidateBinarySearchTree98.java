package depthfirstsearch;

/**
 * Created by matt on 5/24/16.
 */
public class ValidateBinarySearchTree98 {

	/**
	 * 二叉搜索树：右子树的所有节点的值都要大于根结点的值，左子树的所有节点的值都要小于根结点的值
	 *
	 * @param root
	 * @return
	 */
	public boolean isValidBST(TreeNode root) {
		return isBST(root, Long.MIN_VALUE, Long.MAX_VALUE); // 使用long是为了考虑边界情况
	}

	public boolean isBST(TreeNode root, long min, long max) {
		if (root == null) {
			return true;
		}
		if (root.val <= min || root.val >= max) {
			return false;
		}
		return isBST(root.left, min, root.val) && isBST(root.right, root.val, max);
	}
}
