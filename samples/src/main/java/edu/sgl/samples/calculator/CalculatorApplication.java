package edu.sgl.samples.calculator;

import java.util.ArrayList;
import java.util.List;

import edu.sgl.samples.calculator.impl.DefaultCalculator;

public class CalculatorApplication {

  private static ICalculator<Integer> defaultCalculator = new DefaultCalculator();

  public static void main(String[] args) {
    System.out.println("##### Running Calculator Application! #####");

    final List<String> inputByCsv = new ArrayList<>();
    inputByCsv.add("1,2,3,4,5,6,+,+,+,+,*");
    inputByCsv.add("6,7,8,9,-,+,+");
    inputByCsv.add("4,1,3,/,+");

    for (String str : inputByCsv) {
      int value = defaultCalculator.calculate(str);
      System.out.println("value = " + value);
    }

    System.out.println("##### End Running Calculator Application! #####");
  }

}
