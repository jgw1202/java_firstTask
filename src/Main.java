public class Main {
    public static void main(String[] args) {
        InputHandler inputHandler = new InputHandler();
        Calculator calculator = new Calculator();

        while (true) {
            int firstNum = inputHandler.getIntInput("첫 번째 숫자를 입력하세요: ");
            int secondNum = inputHandler.getIntInput("두 번째 숫자를 입력하세요: ");

            String arithmeticSymbol = inputHandler.getStringInput("사칙연산 기호를 입력하세요 (+, -, *, /, %): ", "+", "-", "*", "/", "%");

            // 나눗셈과 나머지 연산에서 두 번째 숫자가 0인 경우 예외 처리
            if ((arithmeticSymbol.equals("/") || arithmeticSymbol.equals("%")) && secondNum == 0) {
                System.out.print("0으로 나눌 수 없습니다.");
                secondNum = inputHandler.getIntInput("두 번째 숫자를 입력하세요: ");
            }

            OperatorType operator = OperatorType.fromSymbol(arithmeticSymbol);

            int result = calculator.calculate(operator, firstNum, secondNum);
            System.out.println("결과: " + result);

            String exit = inputHandler.getStringInput("더 계산하시겠습니까? (exit 입력 시 종료 / no 입력 시 무시): ", "exit", "no");
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
