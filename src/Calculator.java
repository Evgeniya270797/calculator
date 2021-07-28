import exceptions.DivisionByZero;
import exceptions.InvalidNumberInput;

import java.util.Scanner;

class Calculator {

    private final Scanner scanner = new Scanner(System.in);
    private final Print print = new Print();
    private final DoubleCalc doubleCalc = new DoubleCalc();
    private final IntCalc intCalc = new IntCalc();
    private Regime regime;

    private enum Regime {
        DBL,
        DEC
    }

    /**
     * Запуск калькулятора
     */
    public void run() {
        regime = Regime.DBL;

        while (true) {
            String input = scanner.next().toLowerCase();
            switch (input) {
                case "dec":
                    setDecRegime();
                    break;
                case "dbl":
                    setDblRegime();
                    break;
                case "=":
                    printCurrentNumber();
                    break;
                case "c":
                    reset();
                    break;
                case "exit":
                    return;
                default:
                    processInput(getCurrentCalc(), input);
                    break;

            }
        }
    }

    /**
     * Метод выводит текущий результат
     */
    private void printCurrentNumber() {
        print.printCurrentNumber(getCurrentCalc().getCurrentResult());
    }

    /**
     * Метод сбрасывает текущее значение калькулятора
     */
    private void reset() {
        getCurrentCalc().reset();
    }

    /**
     * Возвращает нужный объект калькулятора,в завимости от текущего режима
     * @return
     */
    private Calc getCurrentCalc() {
        return switch (regime) {
            case DBL -> doubleCalc;
            case DEC -> intCalc;
        };
    }

    /**
    * Устанавливает режим работы с вещественными числами
    */
    private void setDblRegime() {
        reset();
        regime = Regime.DBL;
    }

    /**
     * Устанавливает режим работы с целыми числами
     */
    private void setDecRegime() {
        reset();
        regime = Regime.DEC;
    }

    /**
     * Обрабатывет ввод числа или операнда и производит нужную операцию в зависмости от введенного операнда
     * @param calc
     * @param initialInput
     */
    private void processInput(Calc calc, String initialInput) {
        String input = initialInput;
        String operand;
        if (!isOperand(input)) {
            try {
                calc.setCurrentResult(calc.parse(input));
            } catch (InvalidNumberInput e) {
                print.printInputError();
            }
            return;
        } else {
            operand = input;
        }

        while (true) {
            input = scanner.next();
            try {
                switch (operand) {
                    case "+" -> calc.sum(calc.parse(input));
                    case "-" -> calc.subtract(calc.parse(input));
                    case "*" -> calc.multiply(calc.parse(input));
                    case "/" -> calc.divide(calc.parse(input));
                }
            } catch (InvalidNumberInput e) {
                print.printInputError();
                continue;
            } catch (DivisionByZero e) {
                print.printMessageDivisionByZero();
                continue;
            }
            break;
        }
    }

    /**
     * Метод проверяет является ли введенное число операндом или нет
     * @param input
     * @return
     */
    private boolean isOperand(String input) {
        return switch (input) {
            case "+", "-", "*", "/" -> true;
            default -> false;
        };
    }
}
