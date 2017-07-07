package com.beeva.app;

public class Calculadora{
  //public static char o='+';
  //public static double a=5.3, b=3.5;
    public static void main(String[] args)
    {
      Operaciones op = new Operaciones();
      char o;
      double a, b;

      o = args[1].charAt(0);
      a=Double.parseDouble(args[0]);
      b=Double.parseDouble(args[2]);

        System.out.println("Resultado: "+a+o+b+" = "+op.opers(a,o,b));
    }
}
