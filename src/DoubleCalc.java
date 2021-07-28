import exceptions.DivisionByZero;
import exceptions.InvalidNumberInput;

public class DoubleCalc implements Calc<Double> {

    private double currentResult = 0;

    @Override
    public void sum(Double number) {
        currentResult += number;
    }

    @Override
    public void subtract(Double number) {
        currentResult -= number;
    }

    @Override
    public void multiply(Double number) {
        currentResult *= number;
    }

    @Override
    public void divide(Double number) throws DivisionByZero {
        if(number==0.0){
            throw new DivisionByZero();
        }else{
            currentResult /= number;
        }
    }

    @Override
    public void reset() {
        currentResult = 0.0;
    }

    @Override
    public void setCurrentResult(Double number) { this.currentResult = number;}

    @Override
    public Double getCurrentResult() {
        return currentResult;
    }

    @Override
    public Double parse(String input) throws InvalidNumberInput {
        double result;
        try {
            result = Double.parseDouble(input);
        } catch (NumberFormatException e) {
            throw new InvalidNumberInput();
        }
        return result;
    }
}
