package com.company;



import static org.junit.Assert.assertTrue;

/**
 * Created by Andrei on 08.03.2017.
 */
public class Test {

    private static Model model=new Model();
    private static int nrTesteExecutate = 0;
    private static int nrTesteCuSucces = 0;

    @org.junit.Test
    public void setUpBeforeClass1() throws Exception {

    }

    @org.junit.Test
    public void tearDownAfterClass1() throws Exception {
        System.out.println("S-au executat " + nrTesteExecutate + " teste din care "+ nrTesteCuSucces + " au avut succes!");
    }

    @org.junit.Test
    public void setUp1() throws Exception {
        System.out.println("Incepe un nou test!");
        nrTesteExecutate++;
    }

    @org.junit.Test
    public void tearDown1() throws Exception {
        System.out.println("S-a terminat testul curent!");
    }

    @org.junit.Test
    public void testIfCorect11() throws Exception {

    }

    @org.junit.Test
    public void testAdunare() throws Exception {
        Polinom poli1=new Polinom("2x^2+3x+5");
        Polinom poli2=new Polinom("3x^2+4x+6");
        Polinom rezultatAsteptat=new Polinom("5x^2+7x+11");
        Polinom rezultatObtinut=this.model.adunare(poli1,poli2);
        //System.out.println(rezultatAsteptat.afisarePolinom());
        assertTrue(rezultatObtinut.equals(rezultatAsteptat));
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