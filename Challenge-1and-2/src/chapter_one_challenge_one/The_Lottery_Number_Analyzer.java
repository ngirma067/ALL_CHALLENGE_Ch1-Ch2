
package chapter_one_challenge_one;

public class The_Lottery_Number_Analyzer {
    public static void main(String[] args) {
        String[] winningNumbers = {"12-34-56-78-90", "33-44-11-66-22", "01-02-03-04-05"};

        double highestAverage = 0;
        String bestNumber = "";

        for (String number : winningNumbers) {
            System.out.println("Analyzing: " + number);

            String cleanNumber = number.replace("-", "");

            char[] digitsChar = cleanNumber.toCharArray();
            int[] digits = new int[digitsChar.length];
            int sum = 0;

            for (int i = 0; i < digitsChar.length; i++) {
                digits[i] = Character.getNumericValue(digitsChar[i]);
                sum += digits[i];
            }

            double average = (double) sum / digits.length;

            System.out.println("Digit Sum: " + sum + ", Digit Average: " + average);


            if (average > highestAverage) {
                highestAverage = average;
                bestNumber = number;
            }
            System.out.println();
        }
        
        System.out.println("The winning number with the highest average is: " + bestNumber + " with an average of " + highestAverage);
    }
}
