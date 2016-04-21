package sort;

import java.util.*;

/**
 * Created by matt on 4/21/16.
 */
public class MergeIntervals {
	public static class Interval {
		int start;
		int end;

		Interval() {
			start = 0;
			end = 0;
		}

		Interval(int s, int e) {
			start = s;
			end = e;
		}

		@Override
		public String toString() {
			return "The Interval is: start " + start + " end " + end + ".";
		}
	}

	public static void main(String[] args) {
		ArrayList<Interval> intervals = new ArrayList<>();
		intervals.add(new Interval(2, 3));
		intervals.add(new Interval(3, 4));
		intervals.add(new Interval(6, 7));
		intervals.add(new Interval(1, 10));
		intervals.add(new Interval(10, 11));


		System.out.println(merge1(intervals).get(0).toString() + "\n");
		System.out.println(merge2(intervals).get(0).toString() + "\n");
		System.out.println(merge3(intervals).get(0).toString());
	}

	/**
	 * make compare from the first to the end
	 * runtime:21ms(too slow)
	 *
	 * @param intervals
	 * @return
	 */
	public static List<Interval> merge1(List<Interval> intervals) {
		ArrayList<Interval> ans = new ArrayList<>();
		if (intervals.size() == 0 || intervals == null) {
			return intervals;
		}
		Collections.sort(intervals, new Comparator<Interval>() {
			@Override
			public int compare(Interval int1, Interval int2) {
				if (int1.start != int2.start) {
					return (new Integer(int1.start)).compareTo(new Integer(int2.start));
				} else {
					return (new Integer(int1.end)).compareTo(new Integer(int2.end));
				}
			}
		});
		Interval first = intervals.get(0);
		for (int i = 1; i < intervals.size(); i++) {
			Interval next = intervals.get(i);
			if (first.start == next.start) {
				first = next;
			} else {
				if (first.end < next.start) {
					ans.add(first);
					first = next;
				} else if (first.end == next.start || first.end <= next.end) {
					first.end = next.end;
				}
			}
		}
		ans.add(first);
		return ans;
	}

	/**
	 * optimize the function of compare, and make compare from the end to the first
	 *
	 * @param intervals
	 * @return
	 */
	public static List<Interval> merge2(List<Interval> intervals) {
		if (intervals.size() == 0 || intervals == null) {
			return intervals;
		}
		Collections.sort(intervals, new Comparator<Interval>() {
			@Override
			public int compare(Interval int1, Interval int2) {
				return int1.end - int2.end;
			}
		});
		for (int i = intervals.size() - 1; i > 0; i--) {
			Interval int1 = intervals.get(i - 1);
			Interval int2 = intervals.get(i);
			if (int1.end >= int2.start) {
				int1.start = Math.min(int1.start, int2.start);
				int1.end = int2.end;
				intervals.remove(i);
			}
		}

		return intervals;
	}

	/**
	 * the latter one's start must > previous one's end
	 * @param intervals
	 * @return
	 */
	public static List<Interval> merge3(List<Interval> intervals) {
		int n = intervals.size();
		int[] starts = new int[n];
		int[] ends = new int[n];
		for (int i = 0; i < n; i++) {
			starts[i] = intervals.get(i).start;
			ends[i] = intervals.get(i).end;
		}
		Arrays.sort(starts);
		Arrays.sort(ends);
		List<Interval> res = new ArrayList<>();
		for (int i = 0, j = 0; i < n; i++) {
			if (i == n - 1 || starts[i + 1] > ends[i]) {
				res.add(new Interval(starts[j], ends[i]));
				j = i + 1;
			}
		}
		return res;
	}
}


