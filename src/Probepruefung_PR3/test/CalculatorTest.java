package Probepruefung_PR3.test;

// Importiert die zu testende Klasse
import Probepruefung_PR3.Calculator;
// Importiert JUnit für Annotationen und Assertions
import org.junit.*;

import static org.junit.Assert.assertEquals;

public class CalculatorTest {

    private Calculator calculator; // Referenz auf das Calculator-Objekt
    private int result; // Speichert das Ergebnis der Rechenoperation
    private int firstNumber; // Erster Testwert
    private int secondNumber; // Zweiter Testwert

    @Before  //setup
    public void initTest() {
        calculator = new Calculator(); // Neues Calculator-Objekt erstellen
        firstNumber = 3;               // Testwert setzen
        secondNumber = 2;              // Testwert setzen
    }

    @Test
    public void multiply() {
        result = calculator.multiply(firstNumber, secondNumber); // Methode aufrufen
        //assertEquals(6, result); // entweder klasse importieren   importieren
        Assert.assertEquals(6, result); // oder mit Assert gross vorner
        // Prüft, ob Ergebnis der Multiplikation korrekt ist (3 * 2 = 6)
    }

    // @Ignore// zum ignorieren
    @Test
    public void subtract() {
        result = calculator.subtract(firstNumber, secondNumber); //exersicse
        //assertEquals(1,result); // entweder klasse importieren   importieren
        Assert.assertEquals(1, result); // oder  mit Assert gross vorher
        // Prüft, ob Ergebnis der Subtraktion korrekt ist (3 - 2 = 1)
    }

    // stuffe verify

    @After // teardown
    public void afterTest() {
        calculator = null; // Objekt auf null setzen, Speicher freigeben
        // Wird nach jedem Test ausgeführt, um saubere Umgebung sicherzustellen
    }
}