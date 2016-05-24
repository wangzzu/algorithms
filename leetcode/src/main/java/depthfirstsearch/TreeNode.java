package depthfirstsearch;

/**
 * Created by matt on 5/24/16.
 */
public class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}

	public static TreeNode buildTree(String[] num) {
		return buildTree(num, 0, num.length - 1);
	}

	public static TreeNode buildTree(String[] num, int start, int end) {
		if (start > end || num[start].equalsIgnoreCase("null")) {
			return null;
		}
		int rootVal = Integer.valueOf(num[start]);
		TreeNode node = new TreeNode(rootVal);
		int mid = (end + start) / 2;
		node.left = buildTree(num, start + 1, mid);
		node.right = buildTree(num, mid + 1, end);
		return node;
	}
}
