public class Print {

    /**
     * Выводит сообщение об ошибке ввода
     */
    public void printInputError(){ System.out.println("Введите корректное число или операнд:"); }

    /**
     * Выводит переданное число
     */
    public void printCurrentNumber(Object number) { System.out.println(number); }

    /**
     * Выводит сообщение об ошибке деления на ноль
     */
    public void printMessageDivisionByZero(){ System.out.println("На ноль делить нельзя. Введите другое число:"); }

}
