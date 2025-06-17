package Probepruefung_PR3;

public class Main {

    public static void main(String[] args) {

        System.out.println("Hallo, i am calculator ");
        int mult_result = Calculator.multiply(4, 5); // Beispielaufruf
        System.out.println("Multiply Ergebnis: " + mult_result);
 //wenn es static ist kann ohne new calculator


        Calculator c=new Calculator();
        System.out.println("3 * 2 = " + c.multiply(3, 2));
    }


}
