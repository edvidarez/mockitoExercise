package mx.iteso;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.internal.verification.VerificationModeFactory.times;

public class TacitKnowledgePrinterTest {

    List mockedList = mock(List.class);
    private TacitKnowledgePrinter tc;
    private Printer p;
    //Test printNumbers with a limit of 10
        //Verify calculate being called 10 times
        //Verify expected result

    //Test printNumbers with a limit of 0
        //Verify Exception
    @Before
    public void setUp() {
        p = mock(Printer.class);
        tc = new TacitKnowledgePrinter(p);
    }
    @Test
    public void printNumbersTest(){
        tc.printNumbers(1);
        verify(p, times(1)).print(anyString());
    }
    @Test
    public void printTenNumbersTest(){
        tc.printNumbers(10);
        verify(p, times(10)).print(anyString());
    }
    @Test
    public void printNumbers15Test(){
        assertEquals("12Tacit4KnowledgeTacit78TacitKnowledge11Tacit1314TacitKnowledge",tc.printNumbers(15));
    }
    @Test(expected = RuntimeException.class)
    public void printZeroNumberTest(){
        tc.printNumbers(0);
    }

    @Test(timeout = 1000) // performance test
    public void printNumbersTimeTest(){
        tc.printNumbers(10500);
    }

    @Test
    public void forbiddenTest() {
        assertTrue(true);
    }

}
