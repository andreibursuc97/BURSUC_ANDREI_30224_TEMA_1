package com.company;



import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

import java.util.ArrayList;

import static org.junit.Assert.assertTrue;

/**
 * Created by Andrei on 08.03.2017.
 */
public class Test {

    private static Model model;
    private static int nrTesteExecutate = 0;
    private static int nrTesteCuSucces = 0;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        model=new Model();
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
        System.out.println("S-au executat " + nrTesteExecutate + " teste din care "+ nrTesteCuSucces + " au avut succes!");
    }

    @Before
    public void setUp() throws Exception {
        System.out.print("Incepe un nou test pentru");

    }

    @After
    public void tearDown() throws Exception {
        System.out.println("S-a terminat testul curent!");
        nrTesteExecutate++;
    }


    @org.junit.Test
    public void testAdunare1() throws Exception {
        System.out.print(" adunare!\n");
        Polinom poli1=new Polinom("2x^2+3x+5");
        Polinom poli2=new Polinom("3x^2+4x+6");
        Polinom rezultatAsteptat=new Polinom("5x^2+7x+11");
        Polinom rezultatObtinut=this.model.adunare(poli1,poli2);
        //System.out.println(rezultatAsteptat.afisarePolinom());
        assertTrue(rezultatObtinut.equals(rezultatAsteptat));
        nrTesteCuSucces++;
    }

    @org.junit.Test
    public void testAdunare2() throws Exception {
        System.out.print(" adunare!\n");
        Polinom poli1=new Polinom("3x^20+5x^6+2x+4");
        Polinom poli2=new Polinom("7x^5+3x+2x^6");
        Polinom rezultatAsteptat=new Polinom("3x^20+7x^6+7x^5+5x+4");
        Polinom rezultatObtinut=this.model.adunare(poli1,poli2);
        //System.out.println(rezultatAsteptat.afisarePolinom());
        assertTrue(rezultatObtinut.equals(rezultatAsteptat));
        nrTesteCuSucces++;
    }

    @org.junit.Test
    public void testScadere2() throws Exception {
        System.out.print(" scadere!\n");
        Polinom poli1=new Polinom("3x^20+5x^6+2x+4");
        Polinom poli2=new Polinom("7x^5+3x+2x^6");
        Polinom rezultatAsteptat=new Polinom("3x^20+3x^6-7x^5-x+4");
        Polinom rezultatObtinut=this.model.scadere(poli1,poli2);
        //System.out.println(rezultatAsteptat.afisarePolinom());
        assertTrue(rezultatObtinut.equals(rezultatAsteptat));
        nrTesteCuSucces++;
    }

    @org.junit.Test
    public void testScadere1() throws Exception {
        System.out.print(" scadere!\n");
        Polinom poli1=new Polinom("2x^2+3x+5");
        Polinom poli2=new Polinom("3x^2+4x+6");
        Polinom rezultatAsteptat=new Polinom("-x^2-x-1");
        Polinom rezultatObtinut=this.model.scadere(poli1,poli2);
        //System.out.println(rezultatAsteptat.afisarePolinom());
        assertTrue(rezultatObtinut.equals(rezultatAsteptat));
        nrTesteCuSucces++;
    }

    @org.junit.Test
    public void testInmultire1() throws Exception {
        System.out.print(" inmultire!\n");
        Polinom poli1=new Polinom("2x^2+3x+5");
        Polinom poli2=new Polinom("3x^2+4x+6");
        Polinom rezultatAsteptat=new Polinom("6x^4+17x^3+39x^2+38x+30");
        Polinom rezultatObtinut=this.model.inmultire(poli1,poli2);
        //System.out.println(rezultatObtinut.afisarePolinom());
        assertTrue(rezultatObtinut.equals(rezultatAsteptat));
        nrTesteCuSucces++;
    }

    @org.junit.Test
    public void testInmultire2() throws Exception {
        System.out.print(" inmultire!\n");
        Polinom poli1=new Polinom("3x^20+5x^6+2x+4");
        Polinom poli2=new Polinom("7x^5+3x+2x^6");
        Polinom rezultatAsteptat=new Polinom("6x^26+21x^25+9x^21+10x^12+35x^11+19x^7+22x^6+28x^5+6x^2+12x");
        Polinom rezultatObtinut=this.model.inmultire(poli1,poli2);
        //System.out.println(rezultatAsteptat.afisarePolinom());
        assertTrue(rezultatObtinut.equals(rezultatAsteptat));
        nrTesteCuSucces++;
    }

    @org.junit.Test
    public void testImpartire1() throws Exception {
        System.out.print(" impartire!\n");
        Polinom poli1=new Polinom("x^4-3x^2+5x+4");
        Polinom poli2=new Polinom("x-2");
        Polinom cat=new Polinom("x^3+2x^2+x+7");
        Polinom rest=new Polinom("18");
        ArrayList<Monom> list=new ArrayList<>();
        Polinom rezultatObtinut=this.model.impartire(poli1,poli2,list);
        Polinom restAsteptat=new Polinom(rezultatObtinut.getListaRest());
        //System.out.println(rezultatAsteptat.afisarePolinom());
        assertTrue(rezultatObtinut.equals(cat));
        assertTrue(rest.equals(restAsteptat));
        nrTesteCuSucces++;
    }

    @org.junit.Test
    public void testImpartire2() throws Exception {
        System.out.print(" impartire!\n");
        Polinom poli1=new Polinom("3x^20+5x^6+2x+4");
        Polinom poli2=new Polinom("7x^5+3x+2x^6");
        ArrayList<Monom> list=new ArrayList<>();
        Polinom rezultatObtinut=this.model.impartire(poli1,poli2,list);
        Polinom rest=new Polinom(rezultatObtinut.getListaRest());
        Polinom nou = model.inmultire(rezultatObtinut, poli2);
        nou = model.adunare(nou, rest);
        poli1=new Polinom("3x^20+5x^6+2x+4");
        assertTrue(nou.equals(poli1));
        nrTesteCuSucces++;
    }

    @org.junit.Test
    public void testDerivare1() throws Exception {
        System.out.print(" derivare!\n");
        Polinom poli1=new Polinom("x^4-3x^2+5x+4");
        Polinom rezultatAsteptat=new Polinom("4x^3-6x+5");
        Polinom rezultatObtinut=this.model.derivare(poli1);
        assertTrue(rezultatObtinut.equals(rezultatAsteptat));
        nrTesteCuSucces++;
    }

    @org.junit.Test
    public void testDerivare2() throws Exception {
        System.out.print(" derivare!\n");
        Polinom poli1=new Polinom("7x^5+3x+2x^6");
        Polinom rezultatAsteptat=new Polinom("35x^4+3+12x^5");
        Polinom rezultatObtinut=this.model.derivare(poli1);
        assertTrue(rezultatObtinut.equals(rezultatAsteptat));
        nrTesteCuSucces++;
    }

    @org.junit.Test
    public void testIntegrare2() throws Exception {
        System.out.print(" derivare!\n");
        Polinom poli1=new Polinom("7x^5+x+2x^6");
        Polinom rezultatObtinut=this.model.integrare(poli1);
        int i=0;
        for(Monom m:rezultatObtinut.getListaMonoame()) {
            if (i == 0) assertTrue(m.getCoeficient() == (2.0 / 7) && m.getGrad()==7);
            else if (i == 1) assertTrue(m.getCoeficient() == (7.0 / 6) && m.getGrad()==6);
            else assertTrue(m.getCoeficient() == 0.5 && m.getGrad()==2);
            i++;
        }
        //assertTrue(rezultatObtinut.getListaMonoame());
        //assertTrue(rezultatAsteptat.equals(rezultatObtinut.afisarePolinom()));
        nrTesteCuSucces++;
    }


    @org.junit.Test
    public void testIntegrare1() throws Exception {
        System.out.print(" derivare!\n");
        Polinom poli1=new Polinom("x^4-3x^2+5x+4");
        Polinom rezultatObtinut=this.model.integrare(poli1);
        int i=0;
        for(Monom m:rezultatObtinut.getListaMonoame()) {
            if (i == 0) assertTrue(m.getCoeficient() == (1.0 / 5) && m.getGrad()==5);
            else if (i == 1) assertTrue(m.getCoeficient() == -1 && m.getGrad()==3);
            else if (i == 2)  assertTrue(m.getCoeficient() == 2.5 && m.getGrad()==2);
            else assertTrue(m.getCoeficient() == 4 && m.getGrad()==1);
            i++;
        }
        //assertTrue(rezultatObtinut.getListaMonoame());
        //assertTrue(rezultatAsteptat.equals(rezultatObtinut.afisarePolinom()));
        nrTesteCuSucces++;
    }


  /*  private static Model model=new Model();
    private static int nrTesteExecutate = 0;
    private static int nrTesteCuSucces = 0;



    @BeforeClass
    public void setUpBeforeClass() throws Exception {

    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {

    }

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testIfCorect1() throws Exception {

    }

    @Test
    public void testIfCorect2() throws Exception {

    }*/
}