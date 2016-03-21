package ten;

/**
 * 题目：在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，
 * 判断数组中是否含有该整数。（ http://ac.jobdu.com/problem.php?pid=1384）
 * 
 * @author matt
 *
 */
public class FindInPartiallySortedMatrix_03 {
	public static void main(String[] args) {
		int[][] a = { { 1, 2, 8, 9 }, { 2, 4, 9, 12 }, { 4, 7, 10, 13 }, { 6, 8, 11, 15 } };
		System.out.println("9是否存在数组中：" + IsFound(a, 4, 4, 9));
		System.out.println("17是否存在数组中：" + IsFound(a, 4, 4, 17));
		System.out.println(a[0][0]);
	}

	public static boolean IsFound(int[][] a, int colums, int rows, int num) {
		boolean found = false;
		if (a != null && colums > 0 && rows > 0) {
			int row = rows;
			int colum = 0;
			while (colum < colums && row > 0) {
				if (a[colum][row - 1] == num) {
					found = true;
					break;
				} else if (a[colum][row - 1] < num) {
					colum++;
				} else {
					row--;
				}
			}
		}
		return found;
	}
}
