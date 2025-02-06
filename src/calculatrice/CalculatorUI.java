package calculatrice;

import javax.swing.*;
import java.awt.*;

public class CalculatorUI extends JFrame {
    private JTextField display;
    private JPanel buttonPanel;
    private JButton[] numberButtons;
    private JButton addButton, subButton, mulButton, divButton, equalButton, clearButton;
    private CalculatorLogic logic;

    public CalculatorUI() {
        logic = new CalculatorLogic();  
        initUI();                       // Création de l'interface
        setTitle("Ma Calculatrice");
        setSize(300, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);    // Centre la fenêtre à l'écran
        setVisible(true);
    }

    private void initUI() {
        // Zone d'affichage
        display = new JTextField();
        display.setEditable(false);  // L'utilisateur ne peut pas taper directement
        add(display, BorderLayout.NORTH);

        // Panneau contenant les boutons (4x4)
        buttonPanel = new JPanel(new GridLayout(4, 4, 5, 5));
        add(buttonPanel, BorderLayout.CENTER);

        // Boutons 0 à 9
        numberButtons = new JButton[10];
        for (int i = 0; i < 10; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            buttonPanel.add(numberButtons[i]);
        }

        // Boutons d'opération
        addButton    = new JButton("+");
        subButton    = new JButton("-");
        mulButton    = new JButton("*");
        divButton    = new JButton("/");
        equalButton  = new JButton("=");
        clearButton  = new JButton("C");

        // Ajout des boutons d'opération au panneau
        buttonPanel.add(addButton);
        buttonPanel.add(subButton);
        buttonPanel.add(mulButton);
        buttonPanel.add(divButton);
        buttonPanel.add(equalButton);
        buttonPanel.add(clearButton);

        // Mise en place des listeners
        CalculatorListeners listeners = new CalculatorListeners(this, logic);
        for (JButton numberBtn : numberButtons) {
            numberBtn.addActionListener(listeners);
        }
        addButton.addActionListener(listeners);
        subButton.addActionListener(listeners);
        mulButton.addActionListener(listeners);
        divButton.addActionListener(listeners);
        equalButton.addActionListener(listeners);
        clearButton.addActionListener(listeners);
    }

    // Permet aux autres classes de modifier / lire le texte de l'affichage
    public JTextField getDisplay() {
        return display;
    }
}
