package edu.sgl.samples.calculator.impl;

import edu.sgl.samples.calculator.IOperator;

public abstract class AbstractOperator implements IOperator<Integer> {

  @Override
  public boolean isValid(String operatorChar) {
    for (String operator : operators()) {
      if (operator.equals(operatorChar)) {
        return true;
      }
    }
    return false;
  }

}
