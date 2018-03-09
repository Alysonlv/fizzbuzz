package com.alv.fizzbuzz.controllers;

import com.alv.fizzbuzz.services.FizzBuzzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * created by alyson.vasconcelos - 07/03/2018
 */
@RestController
public class FizzBuzzRestController {

    @Autowired
    FizzBuzzService fizzBuzzService;

    @RequestMapping(value = "/api/v1/fizzbuzz/", method = RequestMethod.POST)
    public String getFizzBuzz(@RequestBody String numbers) {
        return fizzBuzzService.getFizzBuzz(numbers).toString();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(Exception.class)
    public String handleError(HttpServletRequest req, Exception ex) {
        return ex.getMessage();
    }
}
