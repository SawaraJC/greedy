//same logic as disjoint. count non overlapping ones

import java.util.*;

public class actSel {
	
	//approach:
	//1. sort on the basis of end time
	//2. always select A0 (first activity)
	//3. start time of any activity >= end time of lst chosen activity
	
	public static int maxAct(int[] start, int[] end) {
		int count = 0;
		
		//create an arraylist to store indices
		ArrayList<Integer> ans = new ArrayList<>();
		
		//increase the count because we will 
		//always select first activity as it 
		//will be performed in least time
		count = 1;
		
		//store index
		ans.add(0);
		
		//variable to store the end time of 
		//last chosen activity
		int lastEnd = end[0];
		
		for(int i=0; i<end.length; i++) {
			if(start[i] >= lastEnd) {
				count++;
				ans.add(i);
				lastEnd = end[i];
			}
		}
		
		System.out.println(ans);
		return count;
	}
	
	public static void main(String[] args) {
		int [] start = {1, 3, 0, 5, 8, 5};
		int [] end = {2, 4, 6, 7, 9, 9};
		int ans = maxAct(start, end);
		
		System.out.println("Max activity: " + ans);
	}
}
