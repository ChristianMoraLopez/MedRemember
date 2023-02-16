package AppInterface.App.entidades;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MedicationList {
    private JTextField MedListAdd;
    private JLabel listaDeMedicamentosAgregadosLabel;
    private JButton agregarButton;
    private JButton salirButton;
    private JPanel MedicationPanel;
    private JPanel PanelAll;
    private JPanel TitlePanel;
    private JPanel MedListPanel;
    private JPanel PanelAllContent;
    public static ArrayList<String> medication = new ArrayList<>();


    public MedicationList() {
        // Botón enter para agregar medicamentos:


        PutMedicationList();


        agregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String newMed = MedListAdd.getText().trim();
                if (!newMed.isEmpty()) {
                    medication.add(newMed);
                    writeMedicationList(medication);
                    listaDeMedicamentosAgregadosLabel.setText("Lista de medicamentos agregados: " + medication);
                    MedListAdd.setText("");
                }
            }
        });

        // Agregar usando el botón enter:

        MedListAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String newMed = MedListAdd.getText().trim();
                if (!newMed.isEmpty()) {
                    medication.add(newMed);
                    writeMedicationList(medication);
                    listaDeMedicamentosAgregadosLabel.setText("Lista de medicamentos agregados: " + medication);
                    MedListAdd.setText("");
                }
            }
        });

        salirButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.exit(0);
            }
        });
    }



    public static void ShowPanel() {
        // Mostrar la ventana
        addMedicationArray.addArray();
        JFrame frame = new JFrame("MedicationList");
        frame.setContentPane(new MedicationList().PanelAllContent);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }

    private static ArrayList<String> readMedicationList() {
      addMedicationArray.txtReader();
        return medication;
    }

    private void writeMedicationList(ArrayList<String> medication) {
        addMedicationArray.textWriter(medication);

    }
    public static ArrayList<String> actualizeList() {
        medication = addMedicationArray.txtReader();
        System.out.println(medication);
        return medication;
    }

    public void PutMedicationList() {
        listaDeMedicamentosAgregadosLabel.setText("Lista de medicamentos agregados: " + actualizeList());
    }
}
