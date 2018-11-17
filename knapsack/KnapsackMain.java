package knapsack;

public class KnapsackMain {
	public static void main(String[] args){
    	int[] value = new int[] {11, 10, 16, 9, 30, 42, 36, 29, 39, 49};
    	int[] weight = new int[] {22, 27, 30, 35, 39, 6, 20, 7, 31, 37};
    	int capacity = 5;
    	
    	KnapsackImp k = new KnapsackImp();
    	System.out.println(k.discreteKnapsack(weight, value, capacity));
	}
}