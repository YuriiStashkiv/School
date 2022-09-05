package actions;

public class Sort {
    public void radixSort(String[] input, int radix, int width) {
        for (int i = 0; i < width; i++) {
            performRadixSort(input, i, radix);
        }
    }

    private void performRadixSort(String[] input, int position, int radix) {

        int[] countArray = new int[radix];
        int nos = input.length;

        for (String value : input) {
            countArray[getDigit(position,
                    value, radix)]++;
        }

        for (int i = 1; i < radix; i++) {
            countArray[i]
                    = countArray[i]
                    + countArray[i - 1];
        }

        String[] tempArray = new String[nos];
        for (int i = nos - 1; i >= 0; i--) {
            tempArray[--countArray[getDigit(
                    position, input[i], radix)]]
                    = input[i];
        }

        for (int i = 0; i < nos; i++) {
            input[i] = tempArray[i];
        }
    }

    private int getDigit(int position, String value, int radix) {
        int nos = value.length() - 1;
        char c = value.toLowerCase().charAt(nos - position);
        return (int) c - 97;
    }
}
