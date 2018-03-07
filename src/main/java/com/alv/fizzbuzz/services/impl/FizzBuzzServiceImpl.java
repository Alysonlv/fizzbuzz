package com.alv.fizzbuzz.services.impl;

import com.alv.fizzbuzz.services.FizzBuzzService;
import org.springframework.cglib.core.CollectionUtils;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * created by alyson.vasconcelos - 07/03/2018
 */
@Service
public class FizzBuzzServiceImpl implements FizzBuzzService {

    @Override
    public List<String> getFizzBuzz(String numbers) {

        try {
            List<Integer> list = getListNumbers(numbers);
            return list.stream().map(n -> {
                return n % 3 == 0 ? "fizz" : n % 5 == 0 ? "buzz" : "" + n;
            }).collect(Collectors.toList());

        } catch (Exception e) {
            throw new IllegalArgumentException("Wrong parameter! \n Please type just numbers, at least one number and use comma to separate them");
        }
    }

    /*
    Transforme the String input into a list of numbers
     */
    private List<Integer> getListNumbers(String numbers) {
        numbers = numbers.replaceAll(" ","");
        List<String> list = Arrays.asList(numbers.split(","));

        return list.stream().mapToInt(n -> Integer.parseInt( ((String)n).trim()  )).boxed().collect(Collectors.toList());
    }
}
