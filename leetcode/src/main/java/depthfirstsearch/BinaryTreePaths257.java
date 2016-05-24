package depthfirstsearch;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by matt on 5/24/16.
 */
public class BinaryTreePaths257 {
	public List<String> binaryTreePaths(TreeNode root) {
		List<String> list = new ArrayList<>();
		if (root == null) {
			return list;
		}
		treePath(root, root.val + "", list);
		return list;
	}

	public void treePath(TreeNode root, String path, List<String> list) {
		if (root == null) {
			return;
		}
		if (root.left == null && root.right == null) {
			list.add(path);
		} else {
			if (root.left == null) {
				path = path + "->" + root.right.val;
				treePath(root.right, path, list);
			} else if (root.right == null) {
				path = path + "->" + root.left.val;
				treePath(root.left, path, list);
			} else {
				treePath(root.right, path + "->" + root.right.val, list);
				treePath(root.left, path + "->" + root.left.val, list);
			}
		}
	}
}
