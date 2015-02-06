package cook.gui;

import cook.data.Locations;
import cook.data.Settings;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class StartFrame extends JFrame {

    public StartFrame() {
        initComponents();
    }

    private void initComponents() {
        panel1 = new JPanel();
        panel2 = new JPanel();
        label1 = new JLabel();
        label2 = new JLabel();
        panel3 = new JPanel();
        label3 = new JLabel();
        comboBox1 = new JComboBox<>(Locations.values());
        panel4 = new JPanel();
        label4 = new JLabel();
        textField1 = new JTextField();
        panel5 = new JPanel();
        button1 = new JButton();

        //======== this ========
        setTitle("Dream Cooking");
        Container contentPane = getContentPane();
        contentPane.setLayout(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);

        //======== panel1 ========
        {
            panel1.setBackground(new Color(48, 48, 48));
            panel1.setLayout(null);

            //======== panel2 ========
            {
                panel2.setBorder(new TitledBorder(new LineBorder(new Color(232, 215, 65), 1, true), "Welcome to:", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION,
                    new Font("Century Gothic", Font.PLAIN, 14), new Color(232, 215, 65)));
                panel2.setBackground(new Color(48, 48, 48));
                panel2.setLayout(null);

                //---- label1 ----
                label1.setText("Dream Cooking");
                label1.setForeground(new Color(232, 215, 65));
                label1.setFont(new Font("Century Gothic", Font.PLAIN, 32));
                panel2.add(label1);
                label1.setBounds(5, 25, 250, 40);

                //---- label2 ----
                label2.setText("Version: 0.1");
                label2.setForeground(new Color(232, 215, 65));
                label2.setFont(new Font("Century Gothic", Font.PLAIN, 14));
                panel2.add(label2);
                label2.setBounds(255, 40, 90, 25);

                { // compute preferred size
                    Dimension preferredSize = new Dimension();
                    for(int i = 0; i < panel2.getComponentCount(); i++) {
                        Rectangle bounds = panel2.getComponent(i).getBounds();
                        preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                        preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                    }
                    Insets insets = panel2.getInsets();
                    preferredSize.width += insets.right;
                    preferredSize.height += insets.bottom;
                    panel2.setMinimumSize(preferredSize);
                    panel2.setPreferredSize(preferredSize);
                }
            }
            panel1.add(panel2);
            panel2.setBounds(10, 5, 350, 65);

            //======== panel3 ========
            {
                panel3.setBorder(new TitledBorder(new LineBorder(new Color(232, 215, 65), 1, true), "Step One:", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION,
                    new Font("Century Gothic", Font.PLAIN, 14), new Color(255, 51, 51)));
                panel3.setBackground(new Color(48, 48, 48));
                panel3.setLayout(null);

                //---- label3 ----
                label3.setText("Location");
                label3.setForeground(new Color(232, 215, 65));
                label3.setFont(new Font("Century Gothic", Font.PLAIN, 18));
                panel3.add(label3);
                label3.setBounds(5, 20, 120, 20);

                //---- comboBox1 ----
                comboBox1.setBackground(new Color(102, 102, 102));
                comboBox1.setForeground(new Color(232, 215, 65));
                comboBox1.setFont(new Font("Century Gothic", Font.PLAIN, 14));
                panel3.add(comboBox1);
                comboBox1.setBounds(10, 45, 155, comboBox1.getPreferredSize().height);

                { // compute preferred size
                    Dimension preferredSize = new Dimension();
                    for(int i = 0; i < panel3.getComponentCount(); i++) {
                        Rectangle bounds = panel3.getComponent(i).getBounds();
                        preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                        preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                    }
                    Insets insets = panel3.getInsets();
                    preferredSize.width += insets.right;
                    preferredSize.height += insets.bottom;
                    panel3.setMinimumSize(preferredSize);
                    panel3.setPreferredSize(preferredSize);
                }
            }
            panel1.add(panel3);
            panel3.setBounds(10, 70, 175, 85);

            //======== panel4 ========
            {
                panel4.setBorder(new TitledBorder(new LineBorder(new Color(232, 215, 65), 1, true), "Step Two:", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION,
                    new Font("Century Gothic", Font.PLAIN, 14), new Color(255, 153, 0)));
                panel4.setBackground(new Color(48, 48, 48));
                panel4.setLayout(null);

                //---- label4 ----
                label4.setText("Food Name");
                label4.setForeground(new Color(232, 215, 65));
                label4.setFont(new Font("Century Gothic", Font.PLAIN, 18));
                panel4.add(label4);
                label4.setBounds(5, 20, 145, 20);

                //---- textField1 ----
                textField1.setFont(new Font("Century Gothic", Font.PLAIN, 14));
                textField1.setText("Ex. Raw lobster");
                textField1.setBackground(new Color(102, 102, 102));
                textField1.setForeground(new Color(232, 215, 65));
                panel4.add(textField1);
                textField1.setBounds(10, 45, 150, 30);

                { // compute preferred size
                    Dimension preferredSize = new Dimension();
                    for(int i = 0; i < panel4.getComponentCount(); i++) {
                        Rectangle bounds = panel4.getComponent(i).getBounds();
                        preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                        preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                    }
                    Insets insets = panel4.getInsets();
                    preferredSize.width += insets.right;
                    preferredSize.height += insets.bottom;
                    panel4.setMinimumSize(preferredSize);
                    panel4.setPreferredSize(preferredSize);
                }
            }
            panel1.add(panel4);
            panel4.setBounds(190, 70, 170, 85);

            //======== panel5 ========
            {
                panel5.setBorder(new TitledBorder(new LineBorder(new Color(232, 215, 65), 1, true), "Step Three:", TitledBorder.LEADING, TitledBorder.DEFAULT_POSITION,
                    new Font("Century Gothic", Font.PLAIN, 14), new Color(0, 204, 51)));
                panel5.setBackground(new Color(48, 48, 48));
                panel5.setLayout(null);

                //---- button1 ----
                button1.setText("Start");
                button1.setFont(new Font("Century Gothic", Font.PLAIN, 24));
                button1.setForeground(new Color(0, 204, 51));
                panel5.add(button1);
                button1.setBounds(10, 20, 330, 35);
                button1.addActionListener(e -> {
                    Locations send = (Locations)comboBox1.getSelectedItem();
                    Settings.rangeArea = send.getRangeArea().getArea();
                    Settings.bankArea = send.getBankArea().getArea();
                    Settings.cookItemName = textField1.getText();
                    dispose();
                });

                { // compute preferred size
                    Dimension preferredSize = new Dimension();
                    for(int i = 0; i < panel5.getComponentCount(); i++) {
                        Rectangle bounds = panel5.getComponent(i).getBounds();
                        preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                        preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                    }
                    Insets insets = panel5.getInsets();
                    preferredSize.width += insets.right;
                    preferredSize.height += insets.bottom;
                    panel5.setMinimumSize(preferredSize);
                    panel5.setPreferredSize(preferredSize);
                }
            }
            panel1.add(panel5);
            panel5.setBounds(10, 160, 350, 65);

            { // compute preferred size
                Dimension preferredSize = new Dimension();
                for(int i = 0; i < panel1.getComponentCount(); i++) {
                    Rectangle bounds = panel1.getComponent(i).getBounds();
                    preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                    preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                }
                Insets insets = panel1.getInsets();
                preferredSize.width += insets.right;
                preferredSize.height += insets.bottom;
                panel1.setMinimumSize(preferredSize);
                panel1.setPreferredSize(preferredSize);
            }
        }
        contentPane.add(panel1);
        panel1.setBounds(0, 0, 370, 235);

        { // compute preferred size
            Dimension preferredSize = new Dimension();
            for(int i = 0; i < contentPane.getComponentCount(); i++) {
                Rectangle bounds = contentPane.getComponent(i).getBounds();
                preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
            }
            Insets insets = contentPane.getInsets();
            preferredSize.width += insets.right;
            preferredSize.height += insets.bottom;
            contentPane.setMinimumSize(preferredSize);
            contentPane.setPreferredSize(preferredSize);
        }
        pack();
        setLocationRelativeTo(getOwner());
    }

    private JPanel panel1;
    private JPanel panel2;
    private JLabel label1;
    private JLabel label2;
    private JPanel panel3;
    private JLabel label3;
    private JComboBox<Locations> comboBox1;
    private JPanel panel4;
    private JLabel label4;
    private JTextField textField1;
    private JPanel panel5;
    private JButton button1;
}
