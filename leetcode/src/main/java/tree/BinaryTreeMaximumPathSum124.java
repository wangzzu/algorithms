package tree;

/**
 * Created by matt on 5/5/16.
 */
public class BinaryTreeMaximumPathSum124 {
	private static int ans=Integer.MIN_VALUE;
	public static void main(String[] args) {
		String[] str={"1","2","4","5","3","null","6"};
		System.out.println(maxPathSum(TreeNode.buildTree(str)));
	}

	public static int maxPathSum(TreeNode root) {
		maxPathSum1(root);
		return ans;
	}
	public static int maxPathSum1(TreeNode root){
		if(root==null){
			return 0;
		}
		int leftMax=Math.max(0,maxPathSum1(root.left));
		int rightMax=Math.max(0,maxPathSum1(root.right));
		ans=Math.max(ans,root.val+leftMax+rightMax);
		return root.val + Math.max(leftMax, rightMax);
	}
}
