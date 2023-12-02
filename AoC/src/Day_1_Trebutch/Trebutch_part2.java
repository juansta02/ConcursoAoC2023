package Day_1_Trebutch;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class Trebutch_part2 {

    public static void main(String[] args) {
        File f = new File("C:/Users/juans/Desktop/AoC/src/Day_1_Trebutch/input.txt");
        try (Scanner sc = new Scanner(f);PrintStream ps = new PrintStream(new File("src/Day_1_Trebutch/output.txt"))) {
            System.setOut(ps);
            String linea;
            int res = 0;
            int contLinea = 0;
            while (sc.hasNextLine()) {
                linea = sc.nextLine() + "Ç";
                //System.out.println("-------------Linea nº" + (contLinea + 1) + ": " + linea);
                char[] lArray = linea.toCharArray();
                int decimal1 = -1;
                int decimal2 = -1;
                for (int i = 0; i < lArray.length; i++) {
                    int asciiVal = lArray[i];
                    if (96 < lArray[i] && lArray[i] < 123) {
                        int[] nums = comprobarNumero(lArray, i);
                        i = nums[0];
                        if (decimal1 == -1 && nums[1] != -1) {
                            decimal1 = nums[1];
                            //System.out.println("decimal1: " + decimal1);
                        } else if (nums[1] != -1) {
                            decimal2 = nums[1];
                            //System.out.println("decimal2 modificado a: " + decimal2);
                        }

                    } else if (47 < asciiVal && asciiVal < 58) {
                        if (decimal1 == -1) {
                            decimal1 = Character.getNumericValue(lArray[i]);
                            //System.out.println("decimal1: " + decimal1);
                        } else {
                            decimal2 = Character.getNumericValue(lArray[i]);
                            //System.out.println("decimal2 modificado a: " + decimal2);
                        }
                    }
                }
                if (decimal2 == -1) {
                    decimal2 = decimal1;
                }
                //System.out.println("decimal2: " + decimal2);
                int decimal = decimal1 * 10 + decimal2;
                res += decimal;
                System.out.println(decimal + " == " + linea + "\n");
                contLinea++;
                //System.out.println("La suma hasta el momento es " + res);
            }
            //System.out.println("El resultado es: " + res);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static int[] comprobarNumero(char[] lArray, int i) {
        int[] nums = new int[2];
        nums[1] = -1;
        String buffer = "";
        boolean encontrado = false;
        for (; i < lArray.length && 96 < lArray[i] && lArray[i] < 123 && !encontrado; i++) {
            buffer += lArray[i];
            //System.out.println("El buffer actual es: " + buffer);
            if (encontrado = buffer.contains("zero")) {
                nums[1] = 0;
                i-=3;
                //System.out.println("detectado un 0");
            } else if (encontrado = buffer.contains("one")) {
                nums[1] = 1;
                i-=2;
                //System.out.println("detectado un 1");
            } else if (encontrado = buffer.contains("two")) {
                nums[1] = 2;
                i-=2;
                //System.out.println("detectado un 2");
            } else if (encontrado = buffer.contains("three")) {
                nums[1] = 3;
                i-=4;
                //System.out.println("detectado un 3");
            } else if (encontrado = buffer.contains("four")) {
                nums[1] = 4;
                i-=3;
                //System.out.println("detectado un 4");
            } else if (encontrado = buffer.contains("five")) {
                nums[1] = 5;
                i-=3;
                //System.out.println("detectado un 5");
            } else if (encontrado = buffer.contains("six")) {
                nums[1] = 6;
                i-=2;
                //System.out.println("detectado un 6");
            } else if (encontrado = buffer.contains("seven")) {
                nums[1] = 7;
                i-=4;
                //System.out.println("detectado un 7");
            } else if (encontrado = buffer.contains("eight")) {
                nums[1] = 8;
                i-=4;
                //System.out.println("detectado un 8");
            } else if (encontrado = buffer.contains("nine")) {
                nums[1] = 9;
                i-=3;
                //System.out.println("detectado un 9");
            }
        }
        if(nums[1]==-1){
            //System.out.println("No se ha detectado ningun numero");
        }
        nums[0] = i - 1;
        return nums;
    }

}


