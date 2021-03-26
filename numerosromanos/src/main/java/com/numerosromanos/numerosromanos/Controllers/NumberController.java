package com.numerosromanos.numerosromanos.Controllers;

import com.numerosromanos.numerosromanos.Domain.NumberTransactions;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/number")
public class NumberController {

    @GetMapping("/toRoman/{integerNumber}")
    public String IntegerToRoman(@PathVariable(value = "integerNumber") int integerNumber)
    {
        return new NumberTransactions().integerToRoman(integerNumber);
    }
}
