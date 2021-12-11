package gui;

import agent.ProviderAgent;
import model.ProviderMessage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Dylan Zote
 * created on 12/7/2021
 * Project jadeTutorial
 **/

public class ProviderGui extends JFrame {

    private final ProviderAgent providerAgent;

    public ProviderGui(ProviderAgent a) {
        super(a.getLocalName());
//        this.providerAgent = providerAgent;
        providerAgent = a;

        JFrame frame = new JFrame("Provider PAge");
        frame.setSize(200, 300);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 2));

        panel.add(new JLabel("Name:"));
        JTextField nameField = new JTextField(15);
        panel.add(nameField);

        panel.add(new JLabel("website:"));
        JTextField websiteField = new JTextField(15);
        panel.add(websiteField);

        panel.add(new JLabel("logo:"));
        JTextField logoField = new JTextField(15);
        panel.add(logoField);

        panel.add(new JLabel("resume:"));
        JTextField resumeField = new JTextField(15);
        panel.add(resumeField);

        panel.add(new JLabel("specialKeyword:"));
        JTextField specialKeywordField = new JTextField(15);
        panel.add(specialKeywordField);

        panel.add(new JLabel("hourlyCompensation:"));
        JTextField hourlyCompensationField = new JTextField(15);
        panel.add(hourlyCompensationField);

        panel.add(new JLabel("hourlyCompensation:"));
        JTextField proofOfBusinessField = new JTextField(15);
        panel.add(proofOfBusinessField);


        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    var name = nameField.getText().trim();
                    var website = websiteField.getText().trim();
                    var logo = logoField.getText().trim();
                    var resume = resumeField.getText().trim();
                    var specialKeyword = specialKeywordField.getText().trim();
                    var hourlyCompensation = hourlyCompensationField.getText().trim();
                    var proofOfBusiness = proofOfBusinessField.getText().trim();

                    var message = new ProviderMessage(name, website, logo, resume, specialKeyword, hourlyCompensation, proofOfBusiness);
                    providerAgent.SendMessage(message);
                }catch (Exception s) {
                    JOptionPane.showMessageDialog(ProviderGui.this, "Invalid values. "+s.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }

            }
        });


    }
}
