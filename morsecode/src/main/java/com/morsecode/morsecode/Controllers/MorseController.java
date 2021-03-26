package com.morsecode.morsecode.Controllers;

import com.morsecode.morsecode.MorseTranslator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/morse")
public class MorseController {
    @GetMapping("/translate/{morseCode}")
    public String IntegerToRoman(@PathVariable(value = "morseCode") String morseCode)
    {
        return new MorseTranslator().translate(morseCode);
    }
}
