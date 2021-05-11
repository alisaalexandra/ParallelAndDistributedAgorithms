package com.ace.ucv.solution.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class Util {

   private Util() {
   }

   public static Map<String, Integer> getFileNames() {
      Map<String, Integer> fileNamesByDigits = new HashMap<>();
      fileNamesByDigits.put("1E1N-3Digits.txt", 10);
      fileNamesByDigits.put("1E1N-5Digits.txt", 10);
      fileNamesByDigits.put("1E1N-7Digits.txt", 10);
      fileNamesByDigits.put("1E1N-9Digits.txt", 10);
      fileNamesByDigits.put("1E3N-3Digits.txt", 1_000);
      fileNamesByDigits.put("1E3N-5Digits.txt", 1_000);
      fileNamesByDigits.put("1E3N-7Digits.txt", 1_000);
      fileNamesByDigits.put("1E3N-9Digits.txt", 1_000);
      fileNamesByDigits.put("1E5N-3Digits.txt", 100_000);
      fileNamesByDigits.put("1E5N-5Digits.txt", 100_000);
      fileNamesByDigits.put("1E5N-7Digits.txt", 100_000);
      fileNamesByDigits.put("1E5N-9Digits.txt", 100_000);
      fileNamesByDigits.put("1E7N-3Digits.txt", 10_000_000);
      fileNamesByDigits.put("1E7N-5Digits.txt", 10_000_000);
      fileNamesByDigits.put("1E7N-7Digits.txt", 10_000_000);
      fileNamesByDigits.put("1E7N-9Digits.txt", 10_000_000);
      fileNamesByDigits.put("1E8N-3Digits.txt", 100_000_000);
      fileNamesByDigits.put("1E8N-5Digits.txt", 100_000_000);
      fileNamesByDigits.put("1E8N-7Digits.txt", 100_000_000);
      fileNamesByDigits.put("1E8N-9Digits.txt", 100_000_000);
      return fileNamesByDigits;
   }
   public static int[] getValuesFromFile(String fileName) {
      File file = new File(Paths.get("").toAbsolutePath().toString() + "\\" + fileName);
      try {
         List<String> strings = new ArrayList<>();
         List<String> numbersAsStrings = Files.readAllLines(file.toPath());
         numbersAsStrings.parallelStream().forEachOrdered(line -> strings.addAll(Arrays.asList(line.split(" "))));
         List<Integer> numbers = strings.stream().map(Integer::parseInt).collect(Collectors.toList());
         return numbers.stream().mapToInt(i -> i).toArray();

      } catch (IOException e) {
         e.printStackTrace();
      }
      return null;
   }

   public static int[] getValuesFromFile(String fileName, int capacity) {
      File file = new File(fileName);
      int[] numbers = new int[capacity];
      try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
         String text;
         int i = 0;
         while ((text = reader.readLine()) != null) {
            numbers[i] = (Integer.parseInt(text));
            i++;
         }
      } catch (IOException e) {
         e.printStackTrace();
      }
      return numbers;
   }
}