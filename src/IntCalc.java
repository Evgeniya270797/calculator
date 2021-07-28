import exceptions.DivisionByZero;
import exceptions.InvalidNumberInput;

public class IntCalc implements Calc<Integer> {

    private int currentResult = 0;

    @Override
    public void sum(Integer number) {
        currentResult += number;
    }

    @Override
    public void subtract(Integer number) {
        currentResult -= number;
    }

    @Override
    public void multiply(Integer number) {
        currentResult *= number;
    }

    @Override
    public void divide(Integer number) throws DivisionByZero {
        if (number == 0) {
            throw new DivisionByZero();
        } else {
            currentResult /= number;
        }
    }

    @Override
    public void reset() {
        currentResult = 0;
    }

    @Override
    public void setCurrentResult(Integer number) {
        this.currentResult = number;
    }

    @Override
    public Integer getCurrentResult() {
        return currentResult;
    }

    @Override
    public Integer parse(String input) throws InvalidNumberInput {
        int result;
        try {
            result = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new InvalidNumberInput();
        }
        return result;
    }
}
