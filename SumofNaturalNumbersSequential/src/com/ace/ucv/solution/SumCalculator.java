package com.ace.ucv.solution;

import java.io.*;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class SumCalculator {
   private BigInteger bigInteger = new BigInteger("0");


   public BigInteger compute(String filePath) {
      Path path  = Paths.get(filePath);
      try (BufferedReader bufferedReader = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {
         String currentLine;
         Scanner scanner;
         int number;
         while ((currentLine = bufferedReader.readLine()) != null) {
            scanner  = new Scanner(currentLine);
            number = scanner.nextInt();
            bigInteger = bigInteger.add(BigInteger.valueOf(number));
         }
      } catch (FileNotFoundException e) {
         System.out.println(path.getFileName() + " File not found!");
      } catch (IOException e) {
         e.printStackTrace();
      }
      return bigInteger;
   }
}
