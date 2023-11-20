import java.util.Scanner;
import java.util.Arrays;

public class ArraySortAndCalculate {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the size of the array: ");
        int size = scanner.nextInt();
        
        double[] array = new double[size];
        
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < size; i++) {
            System.out.print("Element " + (i + 1) + ": ");
            array[i] = scanner.nextDouble();
        }
        
        Arrays.sort(array);
        
        double sum = 0;
        for (int i = 0; i < size; i++) {
            sum += array[i];
        }
        
        double average = sum / size;
        
        System.out.println("Sorted Array: " + Arrays.toString(array));
        System.out.println("Sum of Array Elements: " + sum);
        System.out.println("Average of Array Elements: " + average);
        
        scanner.close();
    }
}
