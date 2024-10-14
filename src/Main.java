import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while(true) {
            System.out.print("첫 번째 숫자를 입력하세요: ");
            int firstNum = scanner.nextInt();
            System.out.print("두 번째 숫자를 입력하세요: ");
            int secondNum = scanner.nextInt();

            System.out.print("사칙연산 기호를 입력하세요: ");
            String arithmeticSymbol = scanner.next();

            Calculator calculator = new Calculator(arithmeticSymbol, firstNum, secondNum);

            int result = calculator.calculate(arithmeticSymbol,firstNum,secondNum);



            System.out.println("결과: " + result);

            System.out.print("더 계산하시겠습니까? (exit 입력 시 종료) ");
            String exit = scanner.next();
            System.out.println();
            if(exit.equals("exit")) {
                break;
            }
        }

    }
}