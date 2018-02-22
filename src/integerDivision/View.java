package integerDivision;

public class View {

    public String print(Storage storage) {
        StringBuilder stringBuilder = new StringBuilder();

        if (storage == null) {
            return "";
        }

        if (storage.getDividend() == 0) {
            return "0";
        }

        if (storage.getDividend() < storage.getDivisor()) {
            stringBuilder.append("_").append(storage.getDividend()).append("¦").append(storage.getDivisor()).append("\n")
                    .append(collect(count(storage.getDividend()), ' ')).append(0)
                    .append("¦").append(collect(count(storage.getDivisor()), '-')).append("\n")
                    .append(makeDivider(storage.getDividend(), 1)).append("¦").append(0).append("\n")
                    .append(" ").append(storage.getDividend()).append("\n");

            return stringBuilder.toString();
        }

        for (int i = 0; i < storage.getRemainderNumber().length; i ++) {
            int remainderNumber = storage.getRemainderNumber()[i];

            if (i == storage.getRemainderNumber().length - 1) {
                stringBuilder.append(String.format("%" + (i + 2) + "s", remainderNumber)).append("\n");
                break;
            }

            int multiplyResult = storage.getMultiplyResult()[i];

            if (multiplyResult != 0) {

                String lastReminder = String.format("%" + (i + 2) + "s", "_" + String.valueOf(remainderNumber));
                stringBuilder.append(lastReminder).append("\n");

                String multiply = String.format("%" + (i + 2) + "d", multiplyResult);
                stringBuilder.append(multiply).append("\n");

                Integer tab = lastReminder.length() - count(multiplyResult);
                stringBuilder.append(makeDivider(remainderNumber, tab)).append("\n");
            }
        }

        modify(storage.getDividend(), storage.getDivisor(), storage.getQuotient(), stringBuilder);
        return stringBuilder.toString();
    }

    String makeDivider(int reminderNumber, int tab) {
        return collect(tab, ' ') + collect(count(reminderNumber), '-');
    }

    StringBuilder modify(int dividend, int divisor, int quotient, StringBuilder stringBuilder) {
        int[] index = new int[3];
        for (int i = 0, j = 0; i < stringBuilder.length(); i++) {
            if (stringBuilder.charAt(i) == '\n') {
                index[j] = i;
                j++;
            }

            if (j == 3) {
                break;
            }
        }

        int tab = count(dividend) + 1 - index[0];
        stringBuilder.insert(index[2], collect(tab, ' ') +"¦" + quotient);
        stringBuilder.insert(index[1], collect(tab, ' ') +"¦" + collect(String.valueOf(quotient).length(), '-'));
        stringBuilder.insert(index[0], "¦" + divisor);
        stringBuilder.replace(1, index[0], String.valueOf(dividend));

        return stringBuilder;
    }

    String collect(int symbolsNumber, char symbol) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < symbolsNumber; i++) {
            stringBuilder.append(symbol);
        }

        return stringBuilder.toString();
    }

    private int count(int number) {
        String numberString = String.valueOf(number);
        return numberString.length();
    }
}
