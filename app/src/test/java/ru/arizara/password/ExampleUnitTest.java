package ru.arizara.password;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void correctPasswordLength(){
        String pass = "789456132";
        assertEquals(true, ValidPassword.stringLenght(pass));

    }
    @Test
    public void incorrectPasswordLength(){
        String pass = "7894";
        assertEquals(false, ValidPassword.stringLenght(pass));
    }

    @Test
    public void correctPasswordSymbol(){
        String pass = "dfasSDF_123";
        assertEquals(false, ValidPassword.invalidSymbol(pass));

    }
    @Test
    public void incorrectPasswordSymbol(){
        String pass = "dfasSDF!123";
        assertEquals(true, ValidPassword.invalidSymbol(pass));
        pass = "dfasSDF$123";
        assertEquals(true, ValidPassword.invalidSymbol(pass));
        pass = "dfasSDF;123";
        assertEquals(true, ValidPassword.invalidSymbol(pass));
        pass = "dfasSDF#123";
        assertEquals(true, ValidPassword.invalidSymbol(pass));
        pass = "dfasSDF)123";
        assertEquals(true, ValidPassword.invalidSymbol(pass));
    }

    @Test
    public void correctPasswordContainsDigit(){
        String pass = "dfasSDF_123";
        assertEquals(true, ValidPassword.containsDigit(pass));

    }
    @Test
    public void incorrectPasswordContainsDigit(){
        String pass = "dfasSDF";
        assertEquals(false, ValidPassword.invalidSymbol(pass));
    }

    @Test
    public void correctPasswordContainsLetter(){
        String pass = "dfasSDF123";
        assertEquals(true, ValidPassword.containsLetter(pass));

    }
    @Test
    public void incorrectPasswordContainsLetter(){
        String pass = "65894123";
        assertEquals(false, ValidPassword.containsLetter(pass));
    }

    @Test
    public void correctPasswordContainsLowLetter(){
        String pass = "123sdadasd";
        assertEquals(true, ValidPassword.containsLowLetter(pass));

    }
    @Test
    public void incorrectPasswordContainsLowLetter(){
        String pass = "SSSSDF123";
        assertEquals(false, ValidPassword.containsLowLetter(pass));
    }

    @Test
    public void correctPasswordContainsUpLetter(){
        String pass = "123asdSDF";
        assertEquals(true, ValidPassword.containsUpLetter(pass));

    }
    @Test
    public void incorrectPasswordContainsUpLetter(){
        String pass = "dfas123";
        assertEquals(false, ValidPassword.containsUpLetter(pass));
    }
}