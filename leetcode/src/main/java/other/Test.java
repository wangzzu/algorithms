package other;

/**
 * Created by matt on 4/25/16.
 */
public class Test {
	public static void main(String[] args) throws Exception {
		CircleSequenceQueue queue = new CircleSequenceQueue();
		queue.add("a");
		queue.add("b");
		queue.add("c");
		queue.add("d");
		queue.add("e");
		queue.add("f");
		queue.delete();
		queue.delete();

		queue.add("g");

		while (!queue.isEmpty()) {
			System.out.println(queue.delete());
		}
	}
}
