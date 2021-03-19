package Radix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class StringUtil {

    // Retorna una cadena compuesta por n caracteres c
    // Ejemplo: replicate('x',5) ==> 'xxxxx'
    public static String replicate(char c, int n)
    {
        StringBuilder sBuilder = new StringBuilder(c);
        sBuilder.append(String.valueOf(c).repeat(Math.max(0, n)));
        return sBuilder.toString();
    }

    // Retorna una cadena compuesta por n caracteres c
    // Ejemplo: replicate('x',5) ==> 'xxxxx'
    public static int[] Sort(String[] arr)
    {
        var length = maxLength(arr);
        var hash = new HashMap<Character, ArrayList<String>>();

        var strArray = generateHash(arr);

        return null;
    }

    public static String[] generateHash(String[] arr)
    {
        var length = maxLength(arr);
        var hash = new HashMap<Character, ArrayList<String>>();

        for (var currentPosition = length-1; currentPosition >= 0; currentPosition--) {
            for (String str : arr) {
                AddToHash(hash, str, currentPosition);
            }

            arr = HashToArray(hash, arr.length);
        }
        return null;
    }

    private static void AddToHash(HashMap<Character, ArrayList<String>> hash, String str, int currentPosition)
    {
       if (hash.containsKey(str.charAt(currentPosition)))
       {
            hash.get(str.charAt(currentPosition)).add(str);
       }
       else
       {
           hash.put(str.charAt(currentPosition), new ArrayList<>());
       }
    }

    private static String[] HashToArray(HashMap<Character, ArrayList<String>> hash, int length)
    {

    }

    // Retorna una cadena de longitud n, compuesta por s
    // y precedida de tantos caracteres c como sea necesario
    // para completar la longitud mencionada
    // Ejemplo lpad("5",3,'0') ==> "005"
    private static String lpad(String s, int n, char c)
    {
        int currentLength = s.length();
        StringBuilder sBuilder = new StringBuilder(s);
        for(int x = 0; x < n - currentLength; x++)
        {
            sBuilder.insert(0, c);
        }
        return sBuilder.toString();
    }

    // Retorna un String[] conteniendo los elementos de arr
    // representados como cadenas de caracteres
    public static String[] toStringArray(int[] arr)
    {
        return Arrays.stream(arr).mapToObj(String::valueOf).toArray(String[]::new);
    }

    // Retorna un String[] conteniendo los elementos de arr
    // representados como cadenas de caracteres
    public static int[] toIntArray(String[] arr)
    {
        return Arrays.stream(arr).mapToInt(Integer::parseInt).toArray();
    }

    // Retorna la longitud del elemento con mayor cantidad
    // de caracteres del array arr
    private static int maxLength(String[] arr)
    {
        int larger=arr[0].length(), i;
        for(i=1; i<10; i++)
        {
            if(arr[i].length()>larger)
                larger = arr[i].length();
        }
        return larger;
    }

    // Completa los elemento del arr agregando caracteres c
    // a la izquierda, dejando a todos con la longitud del mayor
    public static void lNormalize(String[] arr, char c)
    {   int maxLength = maxLength(arr);

        for(int i=0; i < 10; i++)
        {
            arr[i] = lpad(arr[i], maxLength, c);
        }
    }
}
