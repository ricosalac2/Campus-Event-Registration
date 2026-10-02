import javax.swing.*;
import java.awt.*;

public class Salac{
    public static void main(String[] args) {
        JFrame frame = new JFrame("Campus Event Registration");
        frame.setSize(500, 600);
        frame.setLayout(new FlowLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        JLabel lblName = new JLabel("Participant Name:");
        JTextField txtName = new JTextField(20);
        JLabel lblAge = new JLabel("Age:");
        JTextField txtAge = new JTextField(5);
        JLabel lblDept = new JLabel("College/Department:");
        JTextField txtDept = new JTextField(20);
        JLabel lblEvent = new JLabel("Event Category:");

        String[] events = {"Select Event", "Programming Competition", "Web Design Challenge", "Cybersecurity Seminar", "AI and Emerging Technologies", "IT Quiz Bowl"};
        JComboBox<String> cmbEvent = new JComboBox<>(events);

        JLabel lblAttend = new JLabel("Attendance Type:");
        JRadioButton rb1 = new JRadioButton("Student Participant");
        JRadioButton rb2 = new JRadioButton("Student Audience");
        JRadioButton rb3 = new JRadioButton("Faculty/Staff");

        ButtonGroup bg = new ButtonGroup();
        bg.add(rb1); 
        bg.add(rb2); 
        bg.add(rb3);

        JLabel lblWork = new JLabel("Workshops to Attend:");
        JCheckBox c1 = new JCheckBox("Java Programming");
        JCheckBox c2 = new JCheckBox("Web Development");
        JCheckBox c3 = new JCheckBox("Cybersecurity");
        JCheckBox c4 = new JCheckBox("Artificial Intelligence");
        JCheckBox c5 = new JCheckBox("Database Management");

        JLabel lblNotes = new JLabel("Special Request / Notes:");
        JTextArea txtNotes = new JTextArea(5, 20);

        JButton btnRegister = new JButton("REGISTER");
        JButton btnClear = new JButton("CLEAR");

        frame.add(lblName);
        frame.add(txtName);
        frame.add(lblAge);
        frame.add(txtAge);
        frame.add(lblDept); 
        frame.add(txtDept);
        frame.add(lblEvent);
        frame.add(cmbEvent);
        frame.add(lblAttend); 
        frame.add(rb1); 
        frame.add(rb2); 
        frame.add(rb3);
        frame.add(lblWork); 
        frame.add(c1); 
        frame.add(c2); 
        frame.add(c3); 
        frame.add(c4); 
        frame.add(c5);
        frame.add(lblNotes); 
        frame.add(txtNotes);
        frame.add(btnRegister); 
        frame.add(btnClear);

        btnRegister.addActionListener(e -> {
            String name = txtName.getText().trim();
            String ages = txtAge.getText().trim();
            String dept = txtDept.getText().trim();

            if (name.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Participant Name is empty!");
                txtName.requestFocus();
                return;
            }

            if (!name.matches("[a-zA-Z .]+")){
            JOptionPane.showMessageDialog(null, "Participant Name must be Letters only!");
            txtName.setText("");
            txtName.requestFocus();
            return;
            }

            if (ages.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Age is empty!");
                return;

            }
            int age = 0;
            try {
                age = Integer.parseInt(ages);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(frame, "Age must be a valid whole number!");
                return;
            }
            if (age <= 0) {
                JOptionPane.showMessageDialog(frame, "Age must be greater than zero!");
                return;
            }
            if (dept.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "College/Department is empty!");
                return;
            }
            if (cmbEvent.getSelectedIndex() == 0) {
                JOptionPane.showMessageDialog(frame, "An Event Category has not been selected!");
                return;
            }
            if (!rb1.isSelected() && !rb2.isSelected() && !rb3.isSelected()) {
                JOptionPane.showMessageDialog(frame, "Attendance Type has not been selected!");
                return;
            }

            String attendance = rb1.isSelected() ? "Student Participant" : rb2.isSelected() ? "Student Audience" : "Faculty/Staff";
            String workshops = "";
            if (c1.isSelected()) workshops += "Java Programming\n";
            if (c2.isSelected()) workshops += "Web Development\n";
            if (c3.isSelected()) workshops += "Cybersecurity\n";
            if (c4.isSelected()) workshops += "Artificial Intelligence\n";
            if (c5.isSelected()) workshops += "Database Management\n";
            if (workshops.isEmpty()) workshops = "None";

            String summary = "Participant Name: " + name + "\nAge: " + age + "\nCollege/Department: " + dept + "\nEvent Category: " + cmbEvent.getSelectedItem() + "\nAttendance Type: " + attendance + "\n\nWorkshops:\n" + workshops + "\nSpecial Request:\n" + txtNotes.getText();

            JOptionPane.showMessageDialog(frame, summary, "Registration Summary", JOptionPane.INFORMATION_MESSAGE);
        });

        btnClear.addActionListener(e -> {
            txtName.setText("");
            txtAge.setText("");
            txtDept.setText("");
            cmbEvent.setSelectedIndex(0);
            bg.clearSelection();
            c1.setSelected(false); c2.setSelected(false); c3.setSelected(false); c4.setSelected(false); c5.setSelected(false);
            txtNotes.setText("");
        });

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}