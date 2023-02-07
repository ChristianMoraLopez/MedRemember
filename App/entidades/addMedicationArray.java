
package AppInterface.App.entidades;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.*;

/**
 * addMedicationArray
 */
public class addMedicationArray {



    public static void addArray() {
        ArrayList<String> medication = new ArrayList<>();
        ArrayList<String> medicationsInTxt = txtReader();
        String newMedication = "";


        FileReader fr = null;
        BufferedReader br = null;

        try {
            fr = new FileReader("medicamentos.xml");
            br = new BufferedReader(fr);
            medication = new ArrayList<>(Arrays.asList(br.readLine().split("\\s+")));
        } catch (FileNotFoundException e) {
            // TODO 
            e.printStackTrace();
        } catch (IOException e) {
            // TODO 
            e.printStackTrace();
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
                if (fr != null) {
                    fr.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if (medication.isEmpty()) {
            newMedication = JOptionPane.showInputDialog(null, "Agrega un medicamento");
            medication.add(newMedication);

            try {
                BufferedWriter bw = new BufferedWriter(new FileWriter("medicamentos.xml", true)); // Modificación para agregar al final del archivo
                bw.write(newMedication + "\n"); // Escribir el nuevo medicamento en una nueva línea
                bw.close();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Error al agregar el medicamento", "Error", JOptionPane.ERROR_MESSAGE);
            }

        } else {
            int confirm = JOptionPane.showConfirmDialog(null, "Ya tienes medicamentos agregados, ¿Deseas agregar otro?");
            if (confirm == JOptionPane.CANCEL_OPTION) {
                System.out.println(medication);
                System.exit(0);
            }

            if (confirm == JOptionPane.NO_OPTION) {
                JOptionPane.showMessageDialog(null, "No se agregó ningún medicamento");
            }
            if (confirm == JOptionPane.YES_OPTION) {
                newMedication = JOptionPane.showInputDialog(null, "Agrega un medicamento");}

            if (medicationsInTxt.contains(newMedication)) {
                JOptionPane.showMessageDialog(null, "Este medicamento ya está agregado", "Advertencia", JOptionPane.WARNING_MESSAGE);
            } else {
                try {
                    BufferedWriter bw = new BufferedWriter(new FileWriter("medicamentos.xml", true));
                    bw.write(newMedication + "\n");
                    bw.close();
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "Error al agregar el medicamento", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }


    public static ArrayList<String> txtReader() {
        ArrayList<String> medication = new ArrayList<>();
        try {
            FileReader fr = new FileReader("medicamentos.xml");
            BufferedReader br = new BufferedReader(fr);
            String line;

            while ((line = br.readLine()) != null) {
                medication.add(line);
            }

            br.close();
            fr.close();

        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "No se encontró el archivo medicamentos.xml", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error al leer el archivo medicamentos.xml", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return medication;
    }

    public static void textWriter(ArrayList<String>  newMedication) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("medicamentos.xml", true));
            bw.write(newMedication + "\n");
            bw.close();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error al agregar el medicamento", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }



}