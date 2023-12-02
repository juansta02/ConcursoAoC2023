package Day_1_Trebutch;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Trebutch_part1 {
    public static void main(String[] args) {
        File f = new File("C:/Users/juans/Desktop/AoC/src/Day_1_Trebutch/input.txt");
        try (Scanner sc = new Scanner(f)) {
            String linea;
            int res = 0;
            int contLinea = 0;
            while (sc.hasNextLine()) {
                linea = sc.nextLine();
                /* System.out.println(linea); */
                char[] lArray = linea.toCharArray();
                char decimal1 = ' ';
                char decimal2 = ' ';
                for (int i = 0; i < lArray.length; i++) {
                    int asciiVal = lArray[i];
                    if(47 < asciiVal && asciiVal < 58)
                    if (47 < asciiVal && asciiVal < 58 && decimal1 == ' ') {
                        decimal1 = lArray[i];
                    } else if (47 < asciiVal && asciiVal < 58) {
                        decimal2 = lArray[i];
                    }
                }
                if (decimal2 == ' ') {
                    decimal2 = decimal1;
                }
                int decimal = (Character.getNumericValue(decimal1)) * 10 + Character.getNumericValue(decimal2);
                res += decimal;
                System.out.println("El decimal de la linea nº" + (contLinea + 1) + " es: " + decimal);
                /* System.out.println("La suma hasta el momento es: " + res); */
                contLinea++;
            }
            System.out.println("El resultado es: " + res);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}