package hospital.ui;

import javax.swing.*;
import java.awt.*;

public class Panels {

    public static JPanel createHomePanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBackground(Color.LIGHT_GRAY);
        panel.setBorder(BorderFactory.createLineBorder(new Color(59, 25, 25), 20));


        JLabel label = new JLabel("<html><div style='text-align: center;'>WELCOME TO<br>HOSPITAL MANAGEMENT SYSTEM</div></html>", SwingConstants.CENTER);
        label.setFont(new Font("Serif", Font.BOLD, 40));

        panel.add(label, BorderLayout.CENTER);
        return panel;
    }

    public static JPanel createPatientPanel() {

        JPanel panel = new JPanel(new BorderLayout());
        JPanel formPanel = new JPanel(new GridLayout(5, 2, 10, 10));
        formPanel.setBorder(BorderFactory.createLineBorder(new Color(59, 25, 25), 10));

        JLabel titleLabel = new JLabel("Patient Details", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Serif", Font.BOLD, 18));
        panel.add(titleLabel, BorderLayout.NORTH);

        JTextField nameField = new JTextField();
        JTextField ageField = new JTextField();
        JTextField addressField = new JTextField();
        JTextField contactField = new JTextField();

        formPanel.add(Utils.createLabel("Name:"));
        formPanel.add(nameField);
        formPanel.add(Utils.createLabel("Age:"));
        formPanel.add(ageField);
        formPanel.add(Utils.createLabel("Address:"));
        formPanel.add(addressField);
        formPanel.add(Utils.createLabel("Contact:"));
        formPanel.add(contactField);

        JPanel buttonPanel = new JPanel();
        JButton saveButton = Utils.createButton("Save");
        JButton viewPatientsButton = Utils.createButton("View Patients");

        buttonPanel.add(saveButton);
        buttonPanel.add(viewPatientsButton);

        saveButton.addActionListener(e -> {

            if (nameField.getText().isEmpty() || ageField.getText().isEmpty() || addressField.getText().isEmpty() || contactField.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please fill in all the fields.", "Validation Error", JOptionPane.ERROR_MESSAGE);
            } else {
                DataStorage.addPatient(nameField.getText(), ageField.getText(), addressField.getText(), contactField.getText());
                JOptionPane.showMessageDialog(null, "Patient saved successfully!");
            }
        });


        viewPatientsButton.addActionListener(e ->
                JOptionPane.showMessageDialog(null, "Patients:\n" + DataStorage.getPatients(), "Patient Records", JOptionPane.INFORMATION_MESSAGE)
        );


        panel.add(formPanel, BorderLayout.CENTER);
        panel.add(buttonPanel, BorderLayout.SOUTH);
        return panel;
    }

    public static JPanel createDoctorPanel() {

        JPanel panel = new JPanel(new BorderLayout());
        JPanel formPanel = new JPanel(new GridLayout(5, 2, 10, 10));
        formPanel.setBorder(BorderFactory.createLineBorder(new Color(59, 25, 25), 10));

        JLabel titleLabel = new JLabel("Doctor Details", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Serif", Font.BOLD, 18));
        panel.add(titleLabel, BorderLayout.NORTH);

        JTextField nameField = new JTextField();
        JTextField specializationField = new JTextField();
        JTextField contactField = new JTextField();
        JTextField experienceField = new JTextField();

        formPanel.add(Utils.createLabel("Name:"));
        formPanel.add(nameField);
        formPanel.add(Utils.createLabel("Specialization:"));
        formPanel.add(specializationField);
        formPanel.add(Utils.createLabel("Experience (years):"));
        formPanel.add(experienceField);
        formPanel.add(Utils.createLabel("Contact:"));
        formPanel.add(contactField);

        JPanel buttonPanel = new JPanel();
        JButton saveButton = Utils.createButton("Save");
        JButton viewDoctorsButton = Utils.createButton("View Doctors");

        buttonPanel.add(saveButton);
        buttonPanel.add(viewDoctorsButton); // Add View Button next to Save Button

        saveButton.addActionListener(e -> {
            // Validate inputs
            if (nameField.getText().isEmpty() || specializationField.getText().isEmpty() || experienceField.getText().isEmpty() || contactField.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please fill in all the fields.", "Validation Error", JOptionPane.ERROR_MESSAGE);
            } else {
                DataStorage.addDoctor(nameField.getText(), specializationField.getText(), experienceField.getText(), contactField.getText());
                JOptionPane.showMessageDialog(null, "Doctor saved successfully!");
            }
        });

        // View Doctors Button ActionListener
        viewDoctorsButton.addActionListener(e -> {
            StringBuilder data = new StringBuilder();
            data.append("Doctors:\n").append(DataStorage.getDoctors()).append("\n");
            JOptionPane.showMessageDialog(null, data.toString(), "Doctor Records", JOptionPane.INFORMATION_MESSAGE);
        });

        panel.add(formPanel, BorderLayout.CENTER);
        panel.add(buttonPanel, BorderLayout.SOUTH);
        return panel;

    }
}
