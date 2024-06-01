import java.util.*;

public class fractKnapsack {
	
	public static int sack(int value[], int weight[], int w) {
		
		//use greedy to select items with less weight and more value
		//calculate ratio: value/weight and select one with max ratio
		
		double ratio[][] = new double[value.length][2];
		//0th column => index; 1st column => ratio
		
		for (int i=0; i<value.length; i++) {
			ratio[i][0] = i;
			ratio[i][1] = value[i]/(double)weight[i];
		}
		
		//sorting in ascending order
		Arrays.sort(ratio, Comparator.comparingDouble(o -> o[1]));
		
		int capacity = w;
		int finalVal = 0;
		//sorting in descending order
		for(int i=ratio.length-1; i>=0; i--) {
			int idx = (int)ratio[i][0];
			if(capacity >= weight[idx]) {
				finalVal += value[idx];
				capacity -= weight[idx];
			}else {
				finalVal += (ratio[i][1]*capacity);
				capacity = 0;
				break;
			}
		}
		
		return finalVal;
	}
	
	public static void main(String[] args) {
		int value[] = {60, 100, 120};
		int weight[] = {10, 20, 30};
		int w = 50;
		
		int ans = sack(value, weight, w);
		
		System.out.println(ans);
	}
}
