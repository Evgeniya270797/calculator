import exceptions.DivisionByZero;
import exceptions.InvalidNumberInput;

interface Calc<T> {
    /**
     * Суммирует число с результатом
     * @param number
     */
    void sum(T number);

    /**
     * Вычитает число от результата
     * @param number
     */
    void subtract(T number);

    /**
     * Умножает число на результат
     * @param number
     */
    void multiply(T number);

    /**
     * Делить результат на число
     * @param number
     * @throws DivisionByZero
     */
    void divide(T number) throws DivisionByZero;
    /**
     * Сбрасывает результат
     */
    void reset();

    /**
     * Установить значение текущего результата
     * @param number
     */
    void setCurrentResult(T number);

    /**
     * Получить значение текущего результата
     * @return
     */
    T getCurrentResult();

    /**
     * Перевод строки в число
     * @param input
     * @return
     * @throws InvalidNumberInput
     */
    T parse(String input) throws InvalidNumberInput;

}
