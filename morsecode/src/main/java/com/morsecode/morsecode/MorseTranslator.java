package com.morsecode.morsecode;

import java.util.TreeMap;

public class MorseTranslator {
    private TreeMap<String, String> morseAlphabet;

    public MorseTranslator()
    {
        morseAlphabet = new TreeMap<>();
        morseAlphabet.put(".-", "A");
        morseAlphabet.put("-...", "B");
        morseAlphabet.put("-.-.", "C");
        morseAlphabet.put("-..", "D");
        morseAlphabet.put(".", "E");
        morseAlphabet.put("..-.", "F");
        morseAlphabet.put("--.", "G");
        morseAlphabet.put("....", "H");
        morseAlphabet.put("..", "I");
        morseAlphabet.put(".---", "J");
        morseAlphabet.put("-.-", "K");
        morseAlphabet.put(".-..", "L");
        morseAlphabet.put("--", "M");
        morseAlphabet.put("-.", "N");
        morseAlphabet.put("--.--", "Ñ");
        morseAlphabet.put("---", "O");
        morseAlphabet.put(".--.", "P");
        morseAlphabet.put("--.-", "Q");
        morseAlphabet.put(".-.", "R");
        morseAlphabet.put("...", "S");
        morseAlphabet.put("-", "T");
        morseAlphabet.put("..-", "U");
        morseAlphabet.put("...-", "V");
        morseAlphabet.put(".--", "W");
        morseAlphabet.put("-..-", "X");
        morseAlphabet.put("-.--", "Y");
        morseAlphabet.put("--..", "Z");
        morseAlphabet.put("&", " ");

    }

    public String translate(String morseCode)
    {
        morseCode = morseCode.replace("   ", " & ");

        var morseCharacters =  morseCode.split(" ");
        StringBuilder result = new StringBuilder();
        for (var character: morseCharacters) {
            result.append(morseAlphabet.get(character));
        }
      return result.toString();
    }
}
