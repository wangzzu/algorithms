package depthfirstsearch;

/**
 * Created by matt on 5/24/16.
 */
public class SameTree100 {
	public boolean isSameTree(TreeNode p, TreeNode q) {
		if(p==null&&q==null){
			return true;
		}
		if((p==null&&q!=null)||(p!=null&&q==null)||(p.val!=q.val)){
			return false;
		}
		return isSameTree(p.left,q.left)&&isSameTree(p.right,q.right);
	}
}
