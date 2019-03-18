package com.boot.unitTest;

import static org.junit.Assert.assertEquals;

import com.boot.cotroller.HomeCotroller;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * Unit test for simple App.
 */
@RunWith(JUnit4.class)
public class AppTest 
{
    @Test
    public void testApp(){
        HomeCotroller cotroller = new HomeCotroller();
        String response = cotroller.home();
        assertEquals(response,"Das Boot, reporting for duty");
    }


}
