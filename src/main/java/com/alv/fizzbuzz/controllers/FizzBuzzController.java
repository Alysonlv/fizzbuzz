package com.alv.fizzbuzz.controllers;

import com.alv.fizzbuzz.services.FizzBuzzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * created by alyson.vasconcelos - 07/03/2018
 */
@Controller
public class FizzBuzzController {

    @Autowired
    FizzBuzzService fizzBuzzService;

    private static final String INDEX_PAGE = "/index";

    @RequestMapping({"","/","/fizzbuzz"})
    public String renderFizzBuzz(Model model) {
        return INDEX_PAGE;
    }

    @PostMapping("/fizzbuzz/add")
    public ModelAndView getFizzBuzz(String numbers) {
        ModelAndView mv = new ModelAndView(INDEX_PAGE);
        mv.addObject("numbers", numbers);
        mv.addObject("fizzbuzz", fizzBuzzService.getFizzBuzz(numbers));

        return mv;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(Exception.class)
    public ModelAndView handleError(HttpServletRequest req, Exception ex) {
        ModelAndView mv = new ModelAndView();
        mv.addObject("error_message",ex.getMessage());
        mv.setViewName(INDEX_PAGE);
        return mv;
    }

}
