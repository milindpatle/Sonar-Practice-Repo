package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AppTest {
    
    @Test
    public void testAppMain() {
        // This is a simple test to verify the class exists
        App app = new App();
        assertNotNull(app);
    }
    
    @Test
    public void testMainMethod() {
        // Test that main method runs without exceptions
        assertDoesNotThrow(() -> App.main(new String[]{}));
    }
}