package Probepruefung_PR3.test;

import Probepruefung_PR3.Calculator;
import org.junit.*;

import static org.junit.Assert.assertEquals;

public class CalculatorTest {

    private Calculator calculator;
    private int result;
    private int firstNumber;
    private int secondNumber;

    @Before  //setup
    public void initTest() {
        calculator = new Calculator();
        firstNumber = 3;
        secondNumber = 2;
    }

    @Test
    public void multiply() {
        result = calculator.multiply(firstNumber, secondNumber);
        //assertEquals(6, result); // entweder klasse importieren   importieren
        Assert.assertEquals(6, result); // oder mit Assert gross vorner
    }

    // @Ignore// zum ignorieren
    @Test
    public void subtract() {
        result = calculator.subtract(firstNumber, secondNumber); //exersicse
        //assertEquals(1,result); // entweder klasse importieren   importieren
        Assert.assertEquals(1, result); // oder  mit Assert gross vorher
    }


    // stuffe verify


    @After // teardown
    public void afterTest() {
        calculator = null;
    }
}