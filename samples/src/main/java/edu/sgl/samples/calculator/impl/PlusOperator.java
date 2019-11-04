package edu.sgl.samples.calculator.impl;

public class PlusOperator extends AbstractOperator {

  @Override
  public Integer operate(Integer value1, Integer value2) {

    //System.out.println("Before Plus V1 = " + value1.intValue());
    //System.out.println("Before Plus V2 = " + value2.intValue());
    value1 += value2.intValue();
    //System.out.println("Plus = " + value1.intValue());
    return value1;
  }

  @Override
  public String[] operators() {
    return new String[] { "+" };
  }

}
