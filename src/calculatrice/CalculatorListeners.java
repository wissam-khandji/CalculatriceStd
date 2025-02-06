package calculatrice;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class CalculatorListeners implements ActionListener {
    private final CalculatorUI ui;
    private final CalculatorLogic logic;
    
    // Indique si l'utilisateur vient de sélectionner une opération
    private boolean isOperationJustSelected;

    public CalculatorListeners(CalculatorUI ui, CalculatorLogic logic) {
        this.ui = ui;
        this.logic = logic;
        this.isOperationJustSelected = false;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Récupération du texte du bouton cliqué
        String command = ((JButton) e.getSource()).getText();

        // Si c'est un chiffre (0-9)
        if (command.matches("\\d")) {
            // S'il y avait juste eu un clic sur une opération, on efface l'affichage
            if (isOperationJustSelected) {
                ui.getDisplay().setText("");
                isOperationJustSelected = false;
            }
            // Ajoute le chiffre dans la zone de texte
            ui.getDisplay().setText(ui.getDisplay().getText() + command);

        // Si c'est une opération (+, -, *, /)
        } else if (command.equals("+") || command.equals("-") || 
                   command.equals("*") || command.equals("/")) {
            // Stocke le premier nombre et l'opération
            logic.setFirstNumber(Double.parseDouble(ui.getDisplay().getText()));
            logic.setOperation(command);
            isOperationJustSelected = true;

        // Si c'est le bouton "="
        } else if (command.equals("=")) {
            // Récupère le deuxième nombre
            logic.setSecondNumber(Double.parseDouble(ui.getDisplay().getText()));
            try {
                double result = logic.calculate();
                ui.getDisplay().setText(String.valueOf(result));
            } catch (ArithmeticException ex) {
                ui.getDisplay().setText("Erreur");
            }

        // Si c'est le bouton "C" (Clear)
        } else if (command.equals("C")) {
            logic.reset();
            ui.getDisplay().setText("");
        }
    }
}

