//complexiety: nlogn


import java.util.*;

public class unsortedEnd {
	
	public static int maxUnsorted(int[] start, int[] end) {
		
		//1.create a 2D array with 3 columns so as to map end, start and index
		// column 1 is index, 2 is start, 3 is end
		// index 		start		end
		
		int count = 0;
		int activities[][] = new int[start.length][3];
		ArrayList<Integer> ans = new ArrayList<>();
		
		//store info
		for (int i=0; i<start.length; i++) {
			activities[i][0] = i;
			activities[i][1] = start[i];
			activities[i][2] = end[i];
		}
		
		//sort 2D array: we have a lambda function which says sort on the basis of column 
		//with index 2 i.e. end time
		Arrays.sort(activities, Comparator.comparingDouble(o -> o[2]));
		
		//first activity
		count = 1;
		
		//added first activity
		ans.add(activities[0][0]);
		int lastEnd = activities[0][2];
		
		for(int i=1; i<end.length; i++) {
			if(activities[i][1] >= lastEnd) {
				count ++;
				ans.add(activities[i][0]);
				lastEnd = activities[i][2];
			}
		}
		
		System.out.println("Indices: "+ans);
		return count;
	}
	
	public static void main (String[] args) {
		int [] start = {1, 3, 0, 5, 8, 5};
		int [] end = {2, 4, 6, 7, 9, 9};
		int ans = maxUnsorted(start, end);
		
		System.out.println("Max activity: " + ans);
	}
}
