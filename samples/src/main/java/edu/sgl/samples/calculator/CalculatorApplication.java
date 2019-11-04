package edu.sgl.samples.calculator;

import java.util.ArrayList;
import java.util.List;

import edu.sgl.samples.calculator.impl.DefaultCalculator;

public class CalculatorApplication {

  public static void main(String[] args) {
    System.out.println("Running Calculator Application!");
    final List<String> inputByCsv = new ArrayList<>();
    inputByCsv.add("1,2,3,4,5,6,+,+,+,+,*");
    inputByCsv.add("6,7,8,9,-,+,+");
    inputByCsv.add("4,0,3,/,+");

    for (String str : inputByCsv) {
      int value = new DefaultCalculator().calculate(str);
      System.out.println("value = " + value);
    }
  }

}
