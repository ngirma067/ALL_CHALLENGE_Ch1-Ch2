
package chapter_one_challenge_one;

  import java.util.Scanner;

public class The_Cryptic_Message_Decoder {
    public static void main(String[] args) {
        // Step 1: Take input from user
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the secret number: ");
        int num = input.nextInt();

        // Step 2: Find total digits using Math.log10
        int digits = (int) Math.log10(num) + 1;

        // Step 3: Extract first and last digits
        int first = (int) (num / Math.pow(10, digits - 1));
        int last = num % 10;

        // Step 4: Extract second and second-last digits
        int second = (int) (num / Math.pow(10, digits - 2)) % 10;
        int secondLast = (int) ((num % Math.pow(10, digits - 1)) / 10) % 10;

        // Step 5: Perform operations
        int product = first * last;          // Product of first and last digit
        int sum = second + secondLast;       // Sum of second and second-last digit

        // Step 6: Concatenate product and sum to form final code
        String finalCode = "" + product + sum;

        // Step 7: Display result
        System.out.println("The decrypted code is: " + finalCode);

        input.close();
    }
}
