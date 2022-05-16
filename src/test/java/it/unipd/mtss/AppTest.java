package it.unipd.mtss;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class AppTest {
    @Test
    public void placeholderTest() {
        App a = new App();
        assertEquals(0, a.placeholder());
    }
}
