/*
 * Sunny and Johnny like to pool their money and go to the ice cream parlor. Johnny never buys the same flavor 
 * that Sunny does. The only other rule they have is that they spend all of their money. Given a list of prices
 * for the flavors of ice cream, select the two that will cost all of the money they have.
 */

package icecreamparlor;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class IcreCreamParlor {

    // Complete the icecreamParlor function below.
    static int[] icecreamParlor(int m, int[] arr) {
        
        Map<Integer, Integer> cost = new HashMap<>();
        int[] complementary = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            cost.put(arr[i], i);
            complementary[i] = m - arr[i];
        }

        List<Integer> output = new ArrayList<>();
        
        for (int k = 0; k < arr.length; k++) {
            if (cost.containsKey(complementary[k])) {
                output.add(k+1);
                output.add(cost.get(complementary[k]) + 1);
                System.out.println(k+1 + " " + (cost.get(complementary[k]) + 1));
                break;
            }
        }

        int[] outputArray = new int[output.size()];
        return output.stream().mapToInt(i->i).toArray();
    }

    

    public static void main(String[] args) throws IOException {
    	final File file = new File("src\\icecreamparlor\\input.txt");
        final Scanner scanner = new Scanner(file);
        
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int m = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] arr = new int[n];

            String[] arrItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int arrItem = Integer.parseInt(arrItems[i]);
                arr[i] = arrItem;
            }

            int[] result = icecreamParlor(m, arr);
            System.out.println(tItr);
            System.out.println(result[0]);
            System.out.println(result[1]);
        }

        scanner.close();
    }
}
