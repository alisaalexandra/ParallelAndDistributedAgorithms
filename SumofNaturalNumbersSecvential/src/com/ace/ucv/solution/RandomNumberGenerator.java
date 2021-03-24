package com.ace.ucv.solution;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomNumberGenerator {

   private final Random random;
   private final ArrayList<Integer> generatedNumbers;

   public RandomNumberGenerator() {
      this.generatedNumbers = new ArrayList<>();
      this.random = new Random(19);
   }

   public List<Integer> generateNumbers(int arraySize, int digits, String fileName) throws IOException {
         int minimumRange = (int) Math.pow(10, digits - 1);
         int maximumRange = (int) Math.pow(10, digits) - 1;
         int randomNumber;
         try (PrintWriter file = new PrintWriter(
                 new BufferedWriter(
                         new FileWriter(fileName)));
         ) {
         for (int i = 0; i < arraySize; i++) {
            randomNumber  = (random.nextInt(maximumRange - minimumRange + 1) + minimumRange);
            file.println(randomNumber);
         }
         } catch (IOException e) {
            e.printStackTrace();
         }
      return generatedNumbers;
   }

   public void write() {
      int number;
      try (PrintWriter file = new PrintWriter(
              new BufferedWriter(
                      new FileWriter("1000000000Numbers3Digits.txt")));
      ) {
         for (int i = 1; i <= 200_000_000; i++) {
            int low = 1;
            int high = 200_000_000;
            number = random.nextInt(high-low) + low;
            file.println(number);
         }
      } catch (IOException e) {
         e.printStackTrace();
      }
   }
}
