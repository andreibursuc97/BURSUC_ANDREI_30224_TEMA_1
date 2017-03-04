package com.company;

import java.security.InvalidParameterException;

/**
 * Created by Andrei on 04.03.2017.
 */

public class Monom implements Comparable<Monom> {

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
        //System.out.println(this.coeficient+" "+this.grad);
    }

    public Monom(){}

    @Override
    public int compareTo(Monom o) {
        if(this.grad<o.grad)
            return -1;
        else
            if(this.grad>o.grad)
                return 1;
        return 0;
    }

    @Override
    public boolean equals(Object obj) {
        Monom mon=new Monom();
        if(obj instanceof Monom)
            mon=(Monom)obj;
        else return false;
        return this.grad==mon.grad;
    }

    public int getCoeficient()
    {
        return this.coeficient;
    }

    public int getGrad(){
        return this.grad;
    }

    public void setCoeficient(int coef)
    {
        this.coeficient=coef;
    }

    public void setGrad(int grad){
        this.grad=grad;
    }

}