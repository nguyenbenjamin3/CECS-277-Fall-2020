import java.util.Random;
import java.util.Arrays;
public class Main
{
    public static int sum(int [] tempA)
    {
        int total = 0;
        for (int i=0; i< tempA.length; i++)
            total += tempA[i];
        return total;
    }
    public static int max(int [] n){
        int max = 0;
        for (int i = 0; i <n.length; i++)
            if (n[i] > max){
                max = n[i];
        
        }return max;
    }
    public static int min(int [] n){
        int min = 501;
        for (int i = 0; i<n.length; i++)
            if (n[i] < min){
                min = n[i];
        
            
        }return min;
    }
    public static double ave(int [] n){
        double average = 0;
        for (int i=0; i < n.length; i++)
            average += n[i];
        average = average/20;
        return average;
    }
	public static void main(String[] args) {
	    Random rd = new Random();
	    int[] numbers = new int[20];
	    for (int i = 0; i < numbers.length ; i++){
	        numbers[i] = rd.nextInt( 401) +100;
	    }
	
	    System.out.println(Arrays.toString(numbers));
	    
	    double ave = ave(numbers);
	    int max = max(numbers);
	    int min = min(numbers);
	    int sum = sum(numbers);
	    
	    System.out.println("Max:" + max);
	    System.out.println("Min:" + min);
	    System.out.println("Sum:" + sum);
	    System.out.println("Average:" + ave);
	    for (int i = 0; i < numbers.length; i++)
	        System.out.printf("%03d ", numbers[i]);
	    
	    int mySum = sum(numbers);
	    
	    
	    System.out.println(mySum);
	    
		System.out.println("\nHello World");
	}
}
