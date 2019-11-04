package edu.sgl.samples.calculator.impl;

public class MinusOperator extends AbstractOperator {

  @Override
  public Integer operate(Integer value1, Integer value2) {

    //System.out.println("Before Minus V1 = " + value1.intValue());
    //System.out.println("Before Minus V2 = " + value2.intValue());
    value1 -=value2.intValue();
    //System.out.println("Minus = " + value1.intValue());
    return value1;
  }

  @Override
  public String[] operators() {
    return new String[] { "-" };
  }

}
