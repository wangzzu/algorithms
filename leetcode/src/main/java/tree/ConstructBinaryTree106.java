package tree;

/**
 * Construct Binary Tree from Inorder and Postorder Traversal
 * Created by matt on 4/23/16.
 */
public class ConstructBinaryTree106 {
	public static void main(String[] args){
		int[] a={3,7,9,6,10,2,5,1,8,4,0};
		int[] b={3,7,6,9,2,1,5,0,4,8,10};
		TreeNode treeNode=buildTree(a,b);
	}
	public static TreeNode buildTree(int[] inorder, int[] postorder) {
		return buildTree(inorder, 0, inorder.length, postorder, 0, postorder.length);
	}
	private static TreeNode buildTree(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd) {
		if(inStart==inEnd||inEnd-inStart!=postEnd-postStart){
			return null;
		}
		int rootVal=postorder[postEnd-1];
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
		if(rootIndex==-1){
			return null;
		}
		TreeNode rootTree=new TreeNode(rootVal);
		rootTree.left=buildTree(inorder,inStart,rootIndex,postorder,postStart,postStart+(rootIndex-inStart));
		rootTree.right=buildTree(inorder,rootIndex+1,inEnd,postorder,postStart+(rootIndex-inStart),postEnd-1);
		return rootTree;
	}
}
