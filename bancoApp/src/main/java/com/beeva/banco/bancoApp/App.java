package com.beeva.banco.bancoApp;

import com.beeva.app.Operaciones;

public class App 
{
    public static void main( String[] args )
    {
        Operaciones o = new Operaciones();
        
        System.out.println(o.opers(9, '*', 3));
    }
}