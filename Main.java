package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here

        View view=new View();
        Calculator calculator =new Calculator();
        Controller controller=new Controller(view, calculator);
        

    }
}
