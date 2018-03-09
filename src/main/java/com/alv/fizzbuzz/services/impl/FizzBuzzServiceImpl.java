package com.alv.fizzbuzz.services.impl;

import com.alv.fizzbuzz.services.FizzBuzzService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * created by alyson.vasconcelos - 07/03/2018
 */
@Service
public class FizzBuzzServiceImpl implements FizzBuzzService {

    private final Logger LOG = LoggerFactory.getLogger(this.getClass());
    private final String ERROR_MESSAGE = "Wrong parameter! \n Please type just numbers, at least one number and use comma to separate them";

    @Override
    public List<String> getFizzBuzz(String numbers) {

        try {
            List<Integer> list = getListNumbers(numbers);
            return list.stream().map(n -> {
                return (n % 3 == 0 && n % 5 == 0) ? "fizz buzz"
                        : n % 3 == 0 ? "fizz"
                        : n % 5 == 0 ? "buzz" : "" + n;
            }).collect(Collectors.toList());

        } catch (Exception e) {
            LOG.error("Wrong parameter! \n Please type just numbers, at least one number and use comma to separate them", e);
            throw new IllegalArgumentException(ERROR_MESSAGE);
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
