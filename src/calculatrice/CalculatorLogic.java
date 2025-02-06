package calculatrice;

public class CalculatorLogic {
    private double firstNumber;
    private double secondNumber;
    private String operation;

    public CalculatorLogic() {
        reset();
    }

    public void setFirstNumber(double value) {
        firstNumber = value;
    }

    public void setSecondNumber(double value) {
        secondNumber = value;
    }

    public double getFirstNumber() {
        return firstNumber;
    }

    public double getSecondNumber() {
        return secondNumber;
    }

    public void setOperation(String op) {
        operation = op;
    }

    public String getOperation() {
        return operation;
    }

    // Exécute l'opération et renvoie le résultat
    
    public double calculate() {
        double result = 0.0;
        switch (operation) {
            case "+":
                result = firstNumber + secondNumber;
                break;
            case "-":
                result = firstNumber - secondNumber;
                break;
            case "*":
                result = firstNumber * secondNumber;
                break;
            case "/":
                if (secondNumber == 0) {
                    throw new ArithmeticException("Division par zéro !");
                }
                result = firstNumber / secondNumber;
                break;
        }
        return result;
    }

   //Réinitialise les valeurs
    public void reset() {
        firstNumber = 0;
        secondNumber = 0;
        operation = "";
    }
}

