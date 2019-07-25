public class Digit {
    private int number;
    private int[] values;

    Digit(String line) {
        values = new int[784];
        String[] numbers = line.split(",");

        number = Integer.parseInt(numbers[0]);
        for (int i = 1; i < numbers.length; i++) {
            values[i - 1] = simplify(Integer.parseInt(numbers[i]));
        }

    }

    public int getNumber() {
        return number;
    }

    public int[] getValues() {
        return values;
    }

    public int getValues(int index) {
        return values[index];
    }

    private int simplify(int number) {
        if (number > 200) {
            return 1;
        } else {
            return 0;
        }
    }
}
