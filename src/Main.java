import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите арифметическое выражение (например, 5 + 3):");

        try {
            String input = scanner.nextLine();
            String result = calc(input);
            System.out.println("Результат: " + result);
        } catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        } finally {
            scanner.close();
            System.out.println("Выход из программы.");
        }
    }

    static String calc(String input) throws Exception {
        String[] parts = input.trim().split(" ");
        if (parts.length != 3) {
            throw new Exception("Введите выражение в формате 'число операция число'");
        }

        int num1 = parseNumber(parts[0]);
        String operation = parts[1];
        int num2 = parseNumber(parts[2]);

        switch (operation) {
            case "+":
                return String.valueOf(num1 + num2);
            case "-":
                return String.valueOf(num1 - num2);
            case "*":
                return String.valueOf(num1 * num2);
            case "/":
                if (num2 == 0) {
                    throw new Exception("Ошибка: Деление на ноль!");
                }
                return String.valueOf(num1 / num2);
            default:
                throw new Exception("Неизвестная операция. Используйте +, -, * или /.");
        }
    }

    static int parseNumber(String str) throws Exception {
        try {
            int number = Integer.parseInt(str);
            if (number < 1 || number > 10) {
                throw new Exception("Числа должны быть от 1 до 10 включительно.");
            }
            return number;
        } catch (NumberFormatException e) {
            throw new Exception("Введите корректные целые числа.");
        }
    }
}

