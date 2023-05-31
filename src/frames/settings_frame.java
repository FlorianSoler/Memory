package frames;

import javax.swing.*;
import javax.swing.text.AttributeSet.FontAttribute;

public class settings_frame extends JFrame{

    //inputs
    private JTextField pseudo1_TextField;
    private JTextField pseudo2_TextField;
    private JComboBox theme_comboBox;
    private JComboBox taille_comboBox;
    
    //buttons
    private JButton validation_button;
    
    //labels
    //private JLabel Title_label;
    private JLabel pseudo_1_label;
    private JLabel pseudo_2_label;
    private JLabel theme_label;
    private JLabel taille_label;

    

    public settings_frame(){
        this.setTitle("Memory settings");;
        this.setSize(340, 340);
        BuildFrame();
    }

    private void BuildFrame(){

        pseudo_1_label = new JLabel("Pseudo 1:");
        pseudo_1_label.setBounds(10, 10, 100, 30);

        pseudo1_TextField = new JTextField();
        pseudo1_TextField.setBounds(120, 10, 150, 30);

        pseudo_2_label = new JLabel("Pseudo 2:");
        pseudo_2_label.setBounds(10, 50, 100, 30);

        pseudo2_TextField = new JTextField();
        pseudo2_TextField.setBounds(120, 50, 150, 30);

        theme_label = new JLabel("Thème :");
        theme_label.setBounds(10, 90, 100, 30);

        theme_comboBox = new JComboBox<>(new String[]{"Thème 1", "Thème 2", "Thème 3"});
        theme_comboBox.setBounds(120, 90, 150, 30);

        taille_label = new JLabel("Taille :");
        taille_label.setBounds(10, 130, 100, 30);

        taille_comboBox = new JComboBox<>(new String[]{"4x5", "5x5", "4x4"});
        taille_comboBox.setBounds(120, 130, 150, 30);

        validation_button = new JButton("Jouer");
        validation_button.setBounds(120, 170, 100, 30);

        // Ajout des composants à la fenêtre
        add(pseudo_1_label);
        add(pseudo1_TextField);
        add(pseudo_2_label);
        add(pseudo2_TextField);
        add(theme_label);
        add(theme_comboBox);
        add(taille_comboBox);
        add(taille_label);
        add(validation_button);

        setLayout(null);
    }

    void onclick(){

    }
    
}