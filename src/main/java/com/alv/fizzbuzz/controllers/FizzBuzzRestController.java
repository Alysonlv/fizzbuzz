package com.alv.fizzbuzz.controllers;

import com.alv.fizzbuzz.services.FizzBuzzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * created by alyson.vasconcelos - 07/03/2018
 */
@RestController
public class FizzBuzzRestController {

    @Autowired
    FizzBuzzService fizzBuzzService;

    @RequestMapping(value = "/api/v1/fizzbuzz/", method = RequestMethod.POST)
    public List<String> getFizzBuzz(@RequestBody String numbers) {
        return fizzBuzzService.getFizzBuzz(numbers);
    }
}
