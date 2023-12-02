package Day_1_Trebutch;

import java.io.File;
import java.util.Scanner;

import javax.swing.plaf.synth.SynthSplitPaneUI;

public class compararLineas {
    public static void main(String[] args) {
        File f1 = new File("src/Day_1_Trebutch/output.txt");
        File f2 = new File("src/Day_1_Trebutch/output_santiago.txt");
        String linea1 = "";
        String linea2 = "";
        try (Scanner sc1 = new Scanner(f1); Scanner sc2 = new Scanner(f2)) {
            int i=1;
            while (sc1.hasNextLine() && sc2.hasNextLine()) {
                linea1 = sc1.nextLine();
                linea1 = linea1.substring(0, linea1.length()-1);
                linea2 = sc2.nextLine();
                linea2 = linea2.substring(0, linea2.length()-1);
                System.out.println(linea1);
                System.out.println(linea2);
                /* if (!linea1.equals(linea2)) {
                    System.out.println("Linea "+ i + " incorrecta: " + linea2);
                } */
                i++;
            }

        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
