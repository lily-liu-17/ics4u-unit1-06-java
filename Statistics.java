/*
*
* This is Mean and Median
*
* @author  Lily Liu
* @version 1.0
* @since   2022-09-30
*/

// These are some imports.
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;

/**
* This is the statistics program.
*/
final class Statistics {

    /**
    * Prevent instantiation
    * Throw an exception IllegalStateException.
    * if this ever is called
    *
    * @throws IllegalStateException
    *
    */
    private Statistics() {
        throw new IllegalStateException("Cannot be instantiated");
    }

    /**
    * The mean() function.
    *
    * @param arrayOfIntegers the collection of integers
    * @param quantity the number of integers within the array
    * @return the mean of the integers
    */
    public static float mean(final Integer[] arrayOfIntegers,
        final float quantity) {

        // this is my variable in my mean function
        float mean = 0;

        // this is the loop to find the mean.
        for (int counter : arrayOfIntegers) {
            mean += counter;
        }
        mean = mean / quantity;

        return mean;
    }

    /**
    * The median() function.
    *
    * @param arrayOfIntegers the collection of integers
    * @param quantity the nuber of integers within the array
    * @return the median of the integers
    */
    public static float median(final Integer[] arrayOfIntegers,
        final float quantity) {

        // these are my variables in my median function.
        float median = 0;
        final double extra = 0.5;
        Arrays.sort(arrayOfIntegers);

        // this is the calculation for the median.
        if (quantity % 2 == 0) {
            median = arrayOfIntegers[(int) (quantity / 2 - extra)];
        } else {
            median = (arrayOfIntegers[(int) (quantity / 2 - extra)]
                         + arrayOfIntegers[(int) (quantity / 2 + extra)])
                         / 2;
        }
        // this returns the medians calculated number.
        return median;
    }

    /**
    * The starting main() function.
    *
    * @param args No args will be used
    */
    public static void main(final String[] args) {

        Integer tempNumber;
        final float mean;
        final float median;
        final Integer[] arrayOfIntegers;
        final ArrayList<Integer> listOfNumbers = new ArrayList<Integer>();
        final Path filePath = Paths.get("set3.txt");
        final Charset charset = Charset.forName("UTF-8");

        try (BufferedReader reader = Files.newBufferedReader(
                                     filePath, charset)) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                tempNumber = Integer.parseInt(line);
                listOfNumbers.add(tempNumber);
            }
        } catch (IOException errorCode) {
            System.err.println(errorCode);
        }

        arrayOfIntegers = listOfNumbers.toArray(new Integer[0]);
        final float quantity = arrayOfIntegers.length;

        System.out.println("\nCalculating stats...");
        mean = mean(arrayOfIntegers, quantity);
        median = median(arrayOfIntegers, quantity);

        System.out.println("The mean is: " + mean);
        System.out.println("The median is: " + median);

        System.out.println("\nDone.");
    }
}
