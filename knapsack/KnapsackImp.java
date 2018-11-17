package knapsack;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Lab sheet 2: Optimization Algorithms
 * Knapsack Implementation of fractional and discrete knapsack.
 */
public class KnapsackImp implements Knapsack
{
	private int[][] vtable;
	private int[] wm;
	private int[] vm;
	
	/**
	 * Implements the 0-1 knapsack problem.
	 * The value returned should be the maximum 
	 * value of a combination of products with the given value and 
	 * weight that can fit in a knapsack with the given capacity.
	 * The products are not divisible so each must be wholly included, 
	 * or entirely left out.
	 * The returned value should be the maximum value it is possible 
	 * to include in the knapsack.
	 * The arrays are assumed to be of equal size, and all non-negative values. 
	 * @param weights the array of weights of each type of product available.
	 * @param values the array of values of each type of product available.
	 * @param capacity the size of the knapsack
	 * @return the maximum possible value of the knapsack.
	 */
	public int discreteKnapsack(int[] weights, int[] values, int capacity)
	{
		
		int m = weights.length;
		int w = capacity;
		vtable = new int[m+1][w+1];
		wm = weights;
		vm = values;
		
		for(int i=1; i<m+1; i++) {
			for(int j=1; j<w+1; j++) {
				update(i,j);
			}
		}
		
		return vtable[m][w];
	}
	
	/**
	 * Updates vtable
	 * Ref: L3-Optimisation, Dynamic programming for knapsack slide
	 */
	private void update(int m, int w) 
	{
		if(w-wm[m-1] < 0) {
			vtable[m][w] = vtable[m-1][w];
		} else {
			int a = vtable[m-1][w-wm[m-1]] + vm[m-1];
			int b = vtable[m-1][w];
			vtable[m][w] = Math.max(a,b);
		}
	}
	
	/**
	 * Extracts highest value items from vtable
	 * Ref: L3-Optimisation, The final result slide
	 */
	private int total(int m, int w)
	{
		if(m == 0 || w <= 0) {
			return 0;
		}
		if(vtable[m][w] == vtable[m-1][w]) {
			return total(m-1, w);
		}
		return vm[m-1] + total(m-1, w-wm[m-1]);
	}

	/**
	 * Implements the fractional knapsack problem.
	 * The value returned should be the maximum 
	 * value of a combination of products with the given value and 
	 * weight that can fit in a knapsack with the given capacity.
	 * The products are divisible so a fraction of each maybe taken.
	 * The returned value should be the greatest integer 
	 * less than or equal to the maximum value.
	 * The arrays are assumed to be of equal size, and all non-negative values.
	 * @param weights the array of weights of each type of product available.
	 * @param values the array of values of each type of product available.
	 * @param capacity the size of the knapsack
	 * @return the greatest int less than or equal to the maximum possible value of the knapsack.
	 */
	public int fractionalKnapsack(int[] weights, int[] values, int capacity)
	{
		int m = weights.length;
		int w = capacity;
		wm = weights;
		vm = values;
		Integer[] index = new Integer[m];
		
		for(int i=0; i<index.length; i++) {
			index[i] = i;
		}
		
		//sort items highest to lowest value/weight ratio.
		Arrays.sort(index, new Comparator<Integer>() {
			public int compare(Integer a, Integer b) {
				if((double) vm[a]/wm[a] > (double) vm[b]/wm[b]) {
					return -1;
				} else {
					return 1;
				}
			}
		});
		
		//sum items that can fit in knapsack and break last item into fraction.
		int sum = 0;
		for(int i=0; i<index.length; i++) {
			if(w <= wm[index[i]]) {
				sum += vm[index[i]] * w / wm[index[i]];
				break;
			} else {
				w -= wm[index[i]];
				sum += vm[index[i]];
			}
		}
		
		return sum;
	}


}
