package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by matt on 5/5/16.
 */
public class UniqueBinarySearchTreesII95 {
	public static void main(String[] args) {
		System.out.println(generateTrees(10).size());
	}

	public static List<TreeNode> generateTrees(int n) {
		List<TreeNode> ans = new ArrayList<TreeNode>();
		if (n <= 0) {
			return ans;
		}
		return generateTrees(1, n);
	}

	public static List<TreeNode> generateTrees(int left, int right) {
		List<TreeNode> ans = new ArrayList<TreeNode>();
		if (left > right) {
			ans.add(null);
			return ans;
		}
		for (int nodeNum = left; nodeNum <= right; nodeNum++) {
			List<TreeNode> leftNode = generateTrees(left, nodeNum - 1);
			List<TreeNode> rightNode = generateTrees(nodeNum + 1, right);
			for (int i = 0; i < leftNode.size(); i++) {
				TreeNode leftn = leftNode.get(i);
				for (int j = 0; j < rightNode.size(); j++) {
					TreeNode rightn = leftNode.get(i);
					System.out.println(" hah");
					TreeNode node = new TreeNode(nodeNum);
					node.left = leftn;
					node.right = rightn;
					ans.add(node);
				}
			}
		}
		return ans;
	}
}
