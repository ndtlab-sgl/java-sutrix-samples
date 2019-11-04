package edu.sgl.samples.calculator.impl;

public class DevideOperator extends AbstractOperator {


  @Override
  public Integer operate(Integer value1, Integer value2) {
    //System.out.println("Before Devide V1 = " + value1.intValue());
    //System.out.println("Before Devide V2 = " + value2.intValue());

    if (value2 == 0) {
      throw new IllegalArgumentException("Khong chap nhan chia 0");
    }

    value1 /= value2.intValue();
    //System.out.println("Minus = " + value1.intValue());
    return value1;
  }

  @Override
  public String[] operators() {
    return new String[] { "/", ":" };
  }
}
