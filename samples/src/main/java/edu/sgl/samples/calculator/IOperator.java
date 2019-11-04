package edu.sgl.samples.calculator;

public interface IOperator<T> {

  T operate(T value1, T value2);

  boolean isValid(String operatorChar);

  String[] operators();

}
