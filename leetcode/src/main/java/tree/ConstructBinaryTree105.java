package tree;

/**
 * Construct Binary Tree from Preorder and Inorder Traversal
 * Created by matt on 4/23/16.
 */
public class ConstructBinaryTree105 {
	public static void main(String[] args){
		int[] a={10,9,7,3,6,8,5,2,1,4,0};
		int[] b={3,7,9,6,10,2,5,1,8,4,0};
		TreeNode treeNode=buildTree(a,b);
		TreeNode treeNode1=buildTree(a,b);
	}

	/**
	 * write by me
	 * runtime:46s(3.9%)
	 * @param preorder
	 * @param inorder
	 * @return
	 */
	public static TreeNode buildTree(int[] preorder, int[] inorder) {
		if(preorder.length==0||preorder.length!=inorder.length){
			return null;
		}
		TreeNode root=new TreeNode(preorder[0]);
		if(preorder.length==1){
			return root;
		}
		int i=0;
		while (inorder[i]!=preorder[0]){
			i++;
		}
		int leftLength=i;
		int rightLength=preorder.length-i-1;
		int[] leftPre=new int[leftLength];
		int[] leftIno=new int[leftLength];
		int[] rightPre=new int[rightLength];
		int[] rightIno=new int[rightLength];
		for (int j=0;j<leftLength;j++){
			leftPre[j]=preorder[j+1];
			leftIno[j]=inorder[j];
		}
		for(int j=0;j<rightLength;j++){
			rightPre[j]=preorder[leftLength+1+j];
			rightIno[j]=inorder[leftLength+1+j];
		}
		root.left=buildTree(leftPre,leftIno);
		root.right=buildTree(rightPre,rightIno);
		return root;
	}

	/**
	 * runtime:1s(99%)
	 * @param preorder
	 * @param inorder
	 * @return
	 */
	public TreeNode buildTree2(int[] preorder, int[] inorder) {
		return buildTree(preorder, 0, preorder.length, inorder, 0, inorder.length);
	}
	private static TreeNode buildTree(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
		if (preStart == preEnd||inStart==inEnd) {
			return null;
		}
		int rootVal=preorder[preStart];
		int rootIndex=-1;
		for(int i=inStart,j=inEnd-1;i<=j;i++,j--){
			if(inorder[i]==rootVal){
				rootIndex=i;
				break;
			}else if(inorder[j]==rootVal){
				rootIndex=j;
				break;
			}
		}
		if (rootIndex==-1){
			return null;
		}
		TreeNode root=new TreeNode(rootVal);
		root.left=buildTree(preorder,preStart+1,preStart+(rootIndex-inStart)+1,inorder,inStart,rootIndex);
		root.right=buildTree(preorder,preStart+(rootIndex-inStart)+1,preEnd,inorder,rootIndex+1,inEnd);
		return root;
	}
}
