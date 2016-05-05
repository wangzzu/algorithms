package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by matt on 5/5/16.
 */
public class BinaryTreeLevelOrderTraversal102 {
	/**
	 * 1.利用了ArrayList插入的有序性；
	 * 2.用二叉树的深度代表该水平行在list中的索引
	 *
	 * @param root
	 * @return
	 */
	public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> ans = new ArrayList<List<Integer>>();
		if (root == null) {
			return ans;
		}
		transval(ans, root, 1);
		return ans;
	}

	public void transval(List<List<Integer>> ans, TreeNode root, int depth) {
		if (root == null) {
			return;
		}
		if (ans.size() == depth - 1) {
			List<Integer> list = new ArrayList<>();
			list.add(root.val);
			ans.add(list);
		} else if (ans.size() >= depth) {
			List<Integer> list = ans.get(depth - 1);
			list.add(root.val);
		}
		transval(ans, root.left, depth + 1);
		transval(ans, root.right, depth + 1);
	}
}
