import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Calculator calculator = new Calculator();

        while (true) {
            System.out.print("첫 번째 숫자를 입력하세요: ");
            while (!scanner.hasNextInt()) {
                System.out.println("유효한 숫자를 입력하세요.");
                scanner.next();
                System.out.print("첫 번째 숫자를 입력하세요: ");
            }
            int firstNum = scanner.nextInt();

            System.out.print("두 번째 숫자를 입력하세요: ");
            while (!scanner.hasNextInt()) {
                System.out.println("유효한 숫자를 입력하세요.");
                scanner.next();
                System.out.print("두 번째 숫자를 입력하세요: ");
            }
            int secondNum = scanner.nextInt();

            System.out.print("사칙연산 기호를 입력하세요 (+, -, *, /, %): ");
            String arithmeticSymbol;
            while (true) {
                arithmeticSymbol = scanner.next();
                if (arithmeticSymbol.equals("+") || arithmeticSymbol.equals("-") || arithmeticSymbol.equals("*") || arithmeticSymbol.equals("/") || arithmeticSymbol.equals("%")) {
                    // 나눗셈 연산 시 분모가 0인지 확인
                    if ((arithmeticSymbol.equals("/") || arithmeticSymbol.equals("%")) && secondNum == 0) {
                        System.out.print("0으로 나눌 수 없습니다. 두 번째 숫자를 다시 입력하세요. : ");
                        while (!scanner.hasNextInt()) {
                            System.out.println("유효한 숫자를 입력하세요.");
                            scanner.next();
                            System.out.print("두 번째 숫자를 입력하세요: ");
                        }
                        secondNum = scanner.nextInt();
                    }
                    break;
                } else {
                    System.out.print("유효한 사칙연산 기호를 입력하세요 (+, -, *, /, %): ");
                }
            }

            int result = calculator.calculate(arithmeticSymbol, firstNum, secondNum);
            System.out.println("결과: " + result);

            System.out.print("더 계산하시겠습니까? (exit 입력 시 종료 / no 입력 시 무시): ");
            String exit = scanner.next();
            while (!exit.equals("exit") && !exit.equals("no")) {
                System.out.print("유효한 입력을 하세요 (exit, no): ");
                exit = scanner.next();
            }
            if (exit.equals("exit")) {
                break;
            }

            System.out.print("가장 먼저 저장된 데이터를 삭제하시겠습니까? (remove 입력 시 삭제 / no 입력 시 무시): ");
            String remove = scanner.next();
            while (!remove.equals("remove") && !remove.equals("no")) {
                System.out.print("유효한 입력을 하세요 (remove, no): ");
                remove = scanner.next();
            }
            if (remove.equals("remove")) {
                calculator.removeResult();
            }
        }

        scanner.close();
    }
}
