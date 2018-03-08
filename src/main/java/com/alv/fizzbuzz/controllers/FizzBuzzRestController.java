package com.alv.fizzbuzz.controllers;

import com.alv.fizzbuzz.services.FizzBuzzService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * created by alyson.vasconcelos - 07/03/2018
 */
@RestController
public class FizzBuzzRestController {

    private final Logger LOG = LoggerFactory.getLogger(this.getClass());

    @Autowired
    FizzBuzzService fizzBuzzService;

    @RequestMapping(value = "/api/v1/fizzbuzz/", method = RequestMethod.POST)
    public List<String> getFizzBuzz(@RequestBody String numbers) {
        return fizzBuzzService.getFizzBuzz(numbers);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Exception> handleError(HttpServletRequest req, Exception ex) {
        LOG.error(ex.getMessage(), ex);
        return new ResponseEntity<Exception>(ex, HttpStatus.BAD_REQUEST);
    }
}
