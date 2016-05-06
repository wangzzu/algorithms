package tree;

/**
 * Created by matt on 5/6/16.
 */
public class PopulatingNextRightPointersinEachNode116 {
	/**
	 * 关键在于考虑到所有的情况
	 *
	 * @param root
	 */
	public void connect(TreeLinkNode root) {
		if (root == null) {
			return;
		}
		if (root.left != null) {
			root.left.next = root.right;
		}
		if (root.right != null && root.next != null) {
			root.right.next = root.next.left;
		}
		connect(root.left);
		connect(root.right);
	}
}
