package com.beeva.app;

public class Operaciones{
  public double opers(double a, char o, double b){
    double c=0;

    switch(o){
      case '+':
      c=a+b;
      break;
      case '-':
      c=a-b;
      break;
      case '*':
      c=a*b;
      break;
      case '/':
      c=a/b;
      break;
    }
    return c;
  }
}
