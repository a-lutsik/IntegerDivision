package integerDivision;

public class Storage {
    private int dividend;
    private int divisor;
    private int quotient;
    private int[] remainderNumber;
    private int[] multiplyResult;

    public int getDividend() {
        return dividend;
    }

    public void setDividend(int dividend) {
        this.dividend = dividend;
    }

    public int getDivisor() {
        return divisor;
    }

    public void setDivisor(int divisor) {
        this.divisor = divisor;
    }

    public int getQuotient() {
        return quotient;
    }

    public void setQuotient(int quotient) {
        this.quotient = quotient;
    }

    public int[] getRemainderNumber() {
        return remainderNumber;
    }

    public void setRemainderNumber(int[] remainderNumber) {
        this.remainderNumber = remainderNumber;
    }

    public int[] getMultiplyResult() {
        return multiplyResult;
    }

    public void setMultiplyResult(int[] multiplyResult) {
        this.multiplyResult = multiplyResult;
    }
}
