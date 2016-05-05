package tree;

/**
 * Created by matt on 5/4/16.
 */
public class LowestCommonAncestorofaBinarySearchTree235 {
	/**
	 * 1.如果当前节点的值比两个输入节点的值都大，那么最低父节点一定在当前节点的左子树；
	 * 2.如果当前节点的值比两个输入节点的值都小，那么最低父节点一定在当前节点的右子树；
	 * 3.否则就是当前节点。
	 *
	 * @param root
	 * @param p
	 * @param q
	 * @return
	 */
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root.val < p.val && root.val < q.val) {
			return lowestCommonAncestor(root.right, p, q);
		} else if (root.val > p.val && root.val > q.val) {
			return lowestCommonAncestor(root.left, p, q);
		} else {
			return root;
		}
	}
}
