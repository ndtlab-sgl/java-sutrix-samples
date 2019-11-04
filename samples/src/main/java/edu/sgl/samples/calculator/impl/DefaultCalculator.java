package edu.sgl.samples.calculator.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import edu.sgl.samples.calculator.ICalculator;
import edu.sgl.samples.calculator.IOperator;

public class DefaultCalculator implements ICalculator<Integer> {

  private static List<IOperator<Integer>> operators;

  private static List<String> supportedOperators;

  static {
    operators = new ArrayList<IOperator<Integer>>();
    operators.add(new PlusOperator());
    operators.add(new MinusOperator());
    operators.add(new MultiplyOperator());
    operators.add(new DevideOperator());

    supportedOperators = new ArrayList<>();

    for (IOperator<Integer> operator : operators) {
      supportedOperators.addAll(Arrays.asList(operator.operators()));
    }
  }

  @Override
  public Integer calculate(String valueStr) {

    // Phan tich valueStr ra danh sach so va toan tu
    final String[] strs = valueStr.split(",");

    // Loop danh sach so phan tu de tinh toan
    List<Integer> numberValues = new ArrayList<>();
    List<String> operatorValues = new ArrayList<>();
    for (String str : strs) {
      if (StringUtils.isNumeric(str)) {
        numberValues.add(Integer.valueOf(str));
      }

      // Chi chap nhan cac toan tu dc ho tro
      if (supportedOperators.contains(str)) {
        operatorValues.add(str);
      }
    }

    System.out.println(numberValues);
    System.out.println(operatorValues);

    // Loop danh sach interface toan tu kiem tra va tinh tong 2 value
    Integer result = 0;
    for (int i = 0; i < numberValues.size(); i++) {
      int value = numberValues.get(i);

      if (i == 0) {
        result = value;
        continue;
      }

      String operatorStr = operatorValues.get(0);
      IOperator<Integer> defOperator = null;

      for (IOperator<Integer> operator : operators) {
        if (operator.isValid(operatorStr)) {
          defOperator = operator;
          operatorValues.remove(0);
          break;
        }
      }
      result = defOperator.operate(result, value);
    }

    // return gia tri tinh toan
    return result;
  }

}
