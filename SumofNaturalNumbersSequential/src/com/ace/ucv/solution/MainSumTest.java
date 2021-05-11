package com.ace.ucv.solution;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class MainSumTest {
   public static void main(String[] args) {
      String[] fileNames = {"1E1N-3Digits.txt","1E1N-5Digits.txt","1E1N-7Digits.txt","1E1N-9Digits.txt",
              "1E3N-3Digits.txt","1E3N-5Digits.txt","1E3N-7Digits.txt","1E3N-9Digits.txt",
              "1E5N-3Digits.txt","1E5N-5Digits.txt","1E5N-7Digits.txt","1E5N-9Digits.txt",
              "1E7N-3Digits.txt","1E7N-5Digits.txt","1E7N-7Digits.txt","1E7N-9Digits.txt",
              "1E8N-3Digits.txt","1E8N-5Digits.txt","1E8N-7Digits.txt","1E8N-9Digits.txt"};
      SumCalculator sum = new SumCalculator();
      long startTime;
      long endTime;
      long duration;
      long minutes;
      long seconds;
      for (String currentFileName: fileNames) {
         System.out.print("File name: " + currentFileName);
         startTime = System.nanoTime();
         System.out.println( " sum: " + sum.compute(currentFileName));
         endTime = System.nanoTime();
         duration = (endTime - startTime);
         minutes = TimeUnit.MILLISECONDS.toMinutes(duration / 1000000);
         seconds = TimeUnit.MILLISECONDS.toSeconds(duration / 1000000);
         System.out.print("Minutes: " + minutes);
         System.out.println(" Seconds: " + seconds);
         System.out.println();
      }
   }

}
