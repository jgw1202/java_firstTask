public class Main {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        InputHandler inputHandler = new InputHandler();

        while (true) {
            int firstNum = inputHandler.getIntInput("첫 번째 숫자를 입력하세요: ");
            int secondNum = inputHandler.getIntInput("두 번째 숫자를 입력하세요: ");
            String arithmeticSymbol = inputHandler.getStringInput("사칙연산 기호를 입력하세요 (+, -, *, /, %): ", "+", "-", "*", "/", "%");

            // 나눗셈 연산 시 분모가 0인지 확인
            if ((arithmeticSymbol.equals("/") || arithmeticSymbol.equals("%")) && secondNum == 0) {
                System.out.println("0으로 나눌 수 없습니다.");
                secondNum = inputHandler.getIntInput("두 번째 숫자를 다시 입력하세요: ");
            }

            try {
                int result = calculator.calculate(arithmeticSymbol, firstNum, secondNum);
                System.out.println("결과: " + result);
            } catch (ArithmeticException e) {
                System.out.println(e.getMessage());
                continue;
            }

            String exit = inputHandler.getStringInput("더 계산하시겠습니까? (exit 입력 시 종료 / yes 입력 시 무시): ", "exit", "yes");
            if (exit.equals("exit")) {
                break;
            }

            String remove = inputHandler.getStringInput("가장 먼저 저장된 데이터를 삭제하시겠습니까? (remove 입력 시 삭제 / no 입력 시 무시): ", "remove", "no");
            if (remove.equals("remove")) {
                calculator.removeResult();
            }
        }

        inputHandler.closeScanner();
    }
}
