import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class cls_registro {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Formulario");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.WEST;

        addLabelAndField(panel, "Nombre:", gbc, 0, 0);
        addLabelAndField(panel, "Apellido:", gbc, 0, 1);
        addLabelAndField(panel, "Correo:", gbc, 0, 2);
        addLabelAndField(panel, "Contacto:", gbc, 0, 3);
        addLabelAndField(panel, "Placa:", gbc, 0, 4);
        addComboBox(panel, "Estado:", gbc, 0, 5);

        JButton enviarButton = new JButton("Enviar");

        enviarButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nombre = nombreField.getText();
                String apellido = apellidoField.getText();
                String correo = correoField.getText();
                String contacto = contactoField.getText();
                String placa = placaField.getText();
                String estado = estadoComboBox.getSelectedItem().toString();

                System.out.println("Nombre: " + nombre);
                System.out.println("Apellido: " + apellido);
                System.out.println("Correo: " + correo);
                System.out.println("Contacto: " + contacto);
                System.out.println("Placa: " + placa);
                System.out.println("Estado: " + estado);
            }
        });

        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 2;
        panel.add(enviarButton, gbc);

        frame.add(panel);
        frame.setVisible(true);
    }

    private static JTextField nombreField = new JTextField(20);
    private static JTextField apellidoField = new JTextField(20);
    private static JTextField correoField = new JTextField(20);
    private static JTextField contactoField = new JTextField(20);
    private static JTextField placaField = new JTextField(20);
    private static JComboBox<String> estadoComboBox = new JComboBox<>(new String[]{"Aptdo-Chigdo", "Turbo-Aptdo","Aptdo-crpa", "curlao-Aptdo"});

      private static void addLabelAndField(JPanel panel, String labelText, GridBagConstraints gbc, int x, int y) {
        JLabel label = new JLabel(labelText);
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.gridwidth = 1;
        panel.add(label, gbc);
        gbc.gridx = x + 1;
        gbc.gridwidth = 2;
        panel.add(getCorrespondingTextField(labelText), gbc);
    }

    private static void addComboBox(JPanel panel, String labelText, GridBagConstraints gbc, int x, int y) {
        JLabel label = new JLabel(labelText);
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.gridwidth = 1;
        panel.add(label, gbc);
        gbc.gridx = x + 1;
        gbc.gridwidth = 2;
        panel.add(estadoComboBox, gbc);
    }

    private static JComponent getCorrespondingTextField(String labelText) {
        if (labelText.equals("Nombre:")) {
            return nombreField;
        } else if (labelText.equals("Apellido:")) {
            return apellidoField;
        } else if (labelText.equals("Correo:")) {
            return correoField;
        } else if (labelText.equals("Contacto:")) {
            return contactoField;
        } else if (labelText.equals("Placa:")) {
            return placaField;
        } else {
            return estadoComboBox;
        }
    }
}
