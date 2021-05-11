package com.ace.ucv.solution;

import java.io.IOException;

public class MainNumberGeneratorTest {
   public static void main(String[] args) throws IOException {
      String[] fileNames = {"1E1N-3Digits.txt", "1E1N-5Digits.txt", "1E1N-7Digits.txt", "1E1N-9Digits.txt",
              "1E3N-3Digits.txt", "1E3N-5Digits.txt", "1E3N-7Digits.txt", "1E3N-9Digits.txt",
              "1E5N-3Digits.txt", "1E5N-5Digits.txt", "1E5N-7Digits.txt", "1E5N-9Digits.txt",
              "1E7N-3Digits.txt", "1E7N-5Digits.txt", "1E7N-7Digits.txt", "1E7N-9Digits.txt",
              "1E8N-3Digits.txt", "1E8N-5Digits.txt", "1E8N-7Digits.txt", "1E8N-9Digits.txt"};

      RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
      for (String currentFileName : fileNames) {
         randomNumberGenerator.generateNumbers(100000000,9,currentFileName);
      }
   }
}
