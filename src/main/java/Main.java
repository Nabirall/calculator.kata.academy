import java.util.Scanner;

public class Main {
    private static final String[] RomanNumber = new String[]{
            "",
            "I",
            "II",
            "III",
            "IV",
            "V",
            "VI",
            "VII",
            "VIII",
            "IX",
            "X",
    };

    private static final String[] RomanNumbers = new String[]{
            "",
            "X",
            "XX",
            "XXX",
            "XL",
            "L",
            "LX",
            "LXX",
            "LXXX",
            "XC",
            "C"
    };

    public static void main(String[] args) {
        try {
            Scanner input = new Scanner(System.in);
            System.out.println(calc(input.nextLine()));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static String calc(String input) throws Exception {
        String[] inputLine = input.split(" ");
        if ((inputLine.length != 3)) {
            throw new Exception("throws Exception");
        }
        int a = tryParse(inputLine[0]);
        String operator = inputLine[1];
        int b = tryParse(inputLine[2]);
        int result = 0;
        boolean isRoman = false;
        if ((a == 0) && (b == 0)) {
            a = translateToArabic(inputLine[0]);
            b = translateToArabic(inputLine[2]);
            isRoman = true;
        }
        if (((a == 0) || (b == 0)) || ((a > 10) || (b > 10))) {
            throw new Exception("throws Exception");
        }
        switch (operator) {
            case "+":
                result = a + b;
                break;
            case "-":
                result = a - b;
                break;
            case "*":
                result = a * b;
                break;
            case "/":
                result = a / b;
                break;
            default:
                throw new Exception("throws Exception");
        }
        if (isRoman && result < 1) {
            throw new Exception("throws Exception");
        }
        if (isRoman) {
            return translateToRoman(result);
        } else return Integer.toString(result);

    }

    private static int tryParse(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    private static int translateToArabic(String value) {
        for (int i = 1; i < RomanNumber.length; i++) {
            if (RomanNumber[i].equals(value)) {
                return i;
            }
        }
        return 0;
    }

    private static String translateToRoman(int value) {
        return RomanNumbers[value / 10] + RomanNumber[value % 10];
    }
}