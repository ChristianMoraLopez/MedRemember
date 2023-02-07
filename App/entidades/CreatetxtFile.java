package AppInterface.App.entidades;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.*;

public class CreatetxtFile {
    public static void main(String[] args) {



       
       

    }
    
    public void ReadtxtFile() {
            

        ArrayList<String> listaMedicamentos = new ArrayList<>();
        
        if (new File("medicamentos.xml").exists()) {
            // El archivo existe
            // Lectura de la lista de medicamentos desde el archivo:
            try {
                BufferedReader br = new BufferedReader(new FileReader("medicamentos.xml"));
                // Poner medicamentos en un array
                listaMedicamentos = new ArrayList<>(Arrays.asList(br.readLine().split("\\s+")));
                br.close();
            } catch (FileNotFoundException ex) {
                JOptionPane.showMessageDialog(null, "El archivo medicamentos.xml no se encuentra", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Error al leer el archivo medicamentos.xml", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            // El archivo no existe
            // Creación del archivo
            JOptionPane.showMessageDialog(null, "El archivo medicamentos.xml no se encuentra", "Error", JOptionPane.ERROR_MESSAGE);


            try {
                BufferedWriter bw = new BufferedWriter(new FileWriter("medicamentos.xml", true)); // Modificación para agregar al final del archivo
                String nuevoMedicamento = JOptionPane.showInputDialog(null, "Agrega un medicamento");
                bw.write(nuevoMedicamento + "\n"); // Escribir el nuevo medicamento en una nueva línea
                bw.close();
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Error al agregar el medicamento", "Error", JOptionPane.ERROR_MESSAGE);
            }

        }

        System.out.println(listaMedicamentos);
    }
    }

