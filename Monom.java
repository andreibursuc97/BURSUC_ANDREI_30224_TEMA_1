package com.company;

import java.security.InvalidParameterException;

/**
 * Created by Andrei on 04.03.2017.
 */

public class Monom {

    private int coeficient;
    private int grad;

    public Monom(String monom)
    {
        String[] parts;
        if(monom.lastIndexOf('^')==monom.length()-1) throw new InvalidParameterException();
        if(monom.lastIndexOf('x')!=-1)
            this.coeficient=Integer.parseInt(monom.substring(0,monom.lastIndexOf('x')));
        else
        {
            this.coeficient=Integer.parseInt(monom);
            this.grad=0;
        }

        if(monom.contains("x^")) {
            parts=monom.split("\\^");
            this.grad = Integer.parseInt(parts[1]);
        }
        else if(monom.contains("x"))
                this.grad=1;
             else this.grad=0;
        System.out.println(this.coeficient+" "+this.grad);
    }


}