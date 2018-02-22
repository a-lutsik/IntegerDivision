package integerDivision;

public class IntegerDivision {

    private Storage storage;

    public IntegerDivision(Storage storage) {
        this.storage = storage;
    }

    public void divide(int dividend, int divisor) {
        StringBuilder remainder = new StringBuilder();

        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);

        storage.setDividend(dividend);
        storage.setDivisor(divisor);
        storage.setQuotient(dividend / divisor);

        String[] digits = String.valueOf(dividend).split("");
        int[] remainderNumber = new int[digits.length + 1];
        int[] multiplyResult = new int[digits.length];
        int mod;

        for (int i = 0; i < digits.length; i++) {
            remainder.append(digits[i]);
            remainderNumber[i] = Integer.parseInt(remainder.toString());

            if (remainderNumber[i] >= divisor) {
                mod = remainderNumber[i] % divisor;
                multiplyResult[i] = remainderNumber[i] / divisor * divisor;
                remainder.replace(0, remainder.length(), String.valueOf(mod));
            }

            if (i == digits.length - 1) {
                remainderNumber[i+1] = Integer.parseInt(remainder.toString());
            }
        }

        storage.setRemainderNumber(remainderNumber);
        storage.setMultiplyResult(multiplyResult);
    }
}
