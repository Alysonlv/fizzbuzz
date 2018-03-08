package com.alv.fizzbuzz.services;

import com.alv.fizzbuzz.services.impl.FizzBuzzServiceImpl;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * created by alyson.vasconcelos - 08/03/2018
 */
public class FizzBuzzServiceTest {

    private FizzBuzzService fizzBuzzService;

    @Before
    public void setUp() throws Exception {
        this.fizzBuzzService = new FizzBuzzServiceImpl();
    }

    @Test
    public void getFizzBuzzTest() throws Exception {
        String numbers = "1,2,3,4,5,6,7";

        assertEquals(7, fizzBuzzService.getFizzBuzz(numbers).size());
        assertEquals("fizz", fizzBuzzService.getFizzBuzz(numbers).get(2));
        assertEquals("buzz", fizzBuzzService.getFizzBuzz(numbers).get(4));
    }

    @Test(expected = RuntimeException.class)
    public void getFizzBuzzExceptionTest() throws Exception {
        String numbers = "1,2,3,4,5,6,7,A,";
        fizzBuzzService.getFizzBuzz(numbers).size();
    }
}
