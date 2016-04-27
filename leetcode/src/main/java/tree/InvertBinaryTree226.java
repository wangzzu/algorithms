package tree;

/**
 * Created by matt on 4/27/16.
 */
public class InvertBinaryTree226 {
	public static TreeNode invertTree(TreeNode root) {
		if (root==null){
			return root;
		}
		TreeNode tmp=root.left;
		root.left=invertTree(root.right);
		root.right=invertTree(tmp);
		return root;
	}
}
