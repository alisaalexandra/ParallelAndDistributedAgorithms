package com.ace.ucv.solution;

import com.ace.ucv.solution.model.MyThread;
import com.ace.ucv.solution.util.Util;

import java.math.BigInteger;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class Main {
   public static void main(String[] args) {
      BigInteger bigInteger = new BigInteger("0");
      long startTime;
      long endTime;
      long duration;
      long minutes;
      long seconds;
      long milliseconds;
      Map<String, Integer> files = Util.getFileNames();
      for (Map.Entry<String, Integer> entry : files.entrySet()) {
         int[] numbers = Util.getValuesFromFile(entry.getKey(), entry.getValue());
         System.out.print("File name: " + entry.getKey());
         startTime = System.nanoTime();
         int min = 0;
         int max = numbers.length / 5;
         int hop = numbers.length / 5;
         for (int currentNumber = 0; currentNumber < 5; currentNumber++) {
            MyThread myThread = new MyThread(numbers, min, max - 1, bigInteger);
            myThread.run();
            min = max;
            max = max + hop;
            bigInteger = MyThread.bigInteger;
         }
         endTime = System.nanoTime();
         duration = (endTime - startTime);
         minutes = TimeUnit.MINUTES.convert(duration, TimeUnit.NANOSECONDS);
         seconds = TimeUnit.SECONDS.convert(duration, TimeUnit.NANOSECONDS);
         milliseconds = TimeUnit.MILLISECONDS.convert(duration, TimeUnit.NANOSECONDS);
         System.out.print("Minutes: " + minutes);
         System.out.print(" Seconds: " + seconds);
         System.out.println(" Milliseconds: " + milliseconds);
         System.out.println(bigInteger);
         System.out.println();
      }
   }
}
