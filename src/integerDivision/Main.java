package integerDivision;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        Storage storage = new Storage();
        IntegerDivision integerDivision = new IntegerDivision(storage);
        View view = new View();

        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));) {

            int dividend = main.read(reader);
            int divisor = main.read(reader);

            integerDivision.divide(dividend, divisor);
            System.out.println(view.print(storage));
        }
    }

    private int read(BufferedReader reader) throws IOException {
        String readedLine = "0"; //insurance against null
        boolean emptyLine = true;

        System.out.print("Enter number from -2 147 483 648 to 2 147 483 647 : ");

        while (emptyLine) {
            readedLine = reader.readLine();

            if (readedLine.isEmpty()) {
                System.out.print("Line is empty, enter number from -2 147 483 648 to 2 147 483 647 :");
            } else {
                emptyLine = false;
            }
        }

        return Integer.parseInt(readedLine);
    }
}
