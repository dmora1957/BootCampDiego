package Radix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;

public class StringUtil {

    // Retorna una cadena compuesta por n caracteres c
    // Ejemplo: replicate('x',5) ==> 'xxxxx'
    public static String replicate(char c, int n) {
        StringBuilder sBuilder = new StringBuilder(c);
        sBuilder.append(String.valueOf(c).repeat(Math.max(0, n)));
        return sBuilder.toString();
    }

    // Comienza el proceso de ordenamiento
    // recibe el array desordenado y lo devuelve ordenados
    public static String[] Sort(String[] stringArray) {
        var length = maxLength(stringArray);

        for (var currentPositionToSort = length - 1; currentPositionToSort >= 0; currentPositionToSort--) {

            var hash = generateHash(stringArray, currentPositionToSort);

            stringArray = hashToArray(hash, stringArray.length);
        }
        return stringArray;
    }

    public static HashMap<Character, ArrayList<String>> generateHash(String[] arr, int currentPositionToSort) {
        var hash = new HashMap<Character, ArrayList<String>>();
        for (String str : arr) {
            AddToHash(hash, str, currentPositionToSort);
        }

        return hash;
    }

    //Evalua si existe la key, equivalente al valor que existe en la posicion actual
    //Si existe lo agrega al arraylist de value sino genera un nuevo arraylist
    private static void AddToHash(HashMap<Character, ArrayList<String>> hash, String str, int currentPosition) {
        if (hash.containsKey(str.charAt(currentPosition))) {
            hash.get(str.charAt(currentPosition)).add(str);
        } else {
            hash.put(str.charAt(currentPosition), new ArrayList<String>(Arrays.asList(str)));
        }
    }

    //convierte el hash de arraylist a un arraylist con todos los valores
    private static String[] hashToArray(HashMap<Character, ArrayList<String>> hash, int length) {
        Collection<ArrayList<String>> valueSet = hash.values();

        var strings = new ArrayList<String>();

        for (ArrayList<String> string : valueSet) {
            strings.addAll(string);
        }
        String[] result = new String[strings.size()];
        result = strings.toArray(result);
        return result;
    }

    // Retorna una cadena de longitud n, compuesta por s
    // y precedida de tantos caracteres c como sea necesario
    // para completar la longitud mencionada
    // Ejemplo lpad("5",3,'0') ==> "005"
    private static String lpad(String s, int n, char c) {
        int currentLength = s.length();
        StringBuilder sBuilder = new StringBuilder(s);

        var replicatedChar = replicate(c, n - currentLength);

        sBuilder.insert(0, replicatedChar);

        return sBuilder.toString();
    }

    // Retorna un String[] conteniendo los elementos de arr
    // representados como cadenas de caracteres
    public static String[] toStringArray(int[] arr) {
        return Arrays.stream(arr).mapToObj(String::valueOf).toArray(String[]::new);
    }

    // Retorna un String[] conteniendo los elementos de arr
    // representados como cadenas de caracteres
    public static int[] toIntArray(String[] arr) {
        return Arrays.stream(arr).mapToInt(Integer::parseInt).toArray();
    }

    // Retorna la longitud del elemento con mayor cantidad
    // de caracteres del array arr
    private static int maxLength(String[] arr) {
        int larger = arr[0].length(), i;
        for (i = 1; i < 10; i++) {
            if (arr[i].length() > larger) {
                larger = arr[i].length();
            }
        }
        return larger;
    }

    // Completa los elemento del arr agregando caracteres c
    // a la izquierda, dejando a todos con la longitud del mayor
    public static void lNormalize(String[] arr, char c) {
        int maxLength = maxLength(arr);

        for (int i = 0; i < arr.length; i++) {
            arr[i] = lpad(arr[i], maxLength, c);
        }
    }
}
