package com.ace.ucv.solution.model;

import java.math.BigInteger;


public class MyThread extends Thread {

   public static BigInteger bigInteger;
   private final int[] arr;
   private final int min;
   private final int max;

   public MyThread(int[] arr, int min, int max, BigInteger bigInteger) {
      this.arr = arr;
      this.min = min;
      this.max = max;
      MyThread.bigInteger = bigInteger;

   }

   @Override
   public void run() {
      for (int i = min; i <= max; i++) {
         add(i);
      }
   }

   public synchronized void add(int index) {
      bigInteger = bigInteger.add(BigInteger.valueOf(arr[index]));
   }
}
