import java.util.Scanner;

public class InputHandler {
    private Scanner scanner = new Scanner(System.in);

    public int getIntInput(String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextInt()) {
            System.out.println("유효한 숫자를 입력하세요.");
            scanner.next();
            System.out.print(prompt);
        }
        return scanner.nextInt();
    }

    public double getDoubleInput(String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextDouble()) {
            System.out.println("유효한 숫자를 입력하세요.");
            scanner.next();
            System.out.print(prompt);
        }
        return scanner.nextDouble();
    }

    public String getStringInput(String prompt, String... validInputs) {
        System.out.print(prompt);
        String input;
        while (true) {
            input = scanner.next();
            for (String validInput : validInputs) {
                if (input.equals(validInput)) {
                    return input;
                }
            }
            System.out.print("유효한 입력을 하세요 (" + String.join(", ", validInputs) + "): ");
        }
    }

    public void closeScanner() {
        scanner.close();
    }
}
