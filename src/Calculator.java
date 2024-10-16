import java.util.LinkedList;
import java.util.Queue;

public class Calculator {
    private int result;
    private Queue<Integer> resultQueue = new LinkedList<>();

    public int calculate(String arithmeticSymbol, int firstNum, int secondNum) {
        switch (arithmeticSymbol) {
            case "+":
                result = firstNum + secondNum;
                break;
            case "-":
                result = firstNum - secondNum;
                break;
            case "*":
                result = firstNum * secondNum;
                break;
            case "/":
                if (secondNum != 0) {
                    result = firstNum / secondNum;
                } else {
                    throw new ArithmeticException("0으로 나눌 수 없습니다.");
                }
                break;
            case "%":
                if (secondNum != 0) {
                    result = firstNum % secondNum;
                } else {
                    throw new ArithmeticException("0으로 나눌 수 없습니다.");
                }
                break;
            default:
                throw new IllegalArgumentException("유효하지 않은 연산자입니다.");
        }
        resultQueue.add(result);
        return result;
    }

    public void removeResult() {
        resultQueue.poll();
        if (resultQueue.peek() != null) {
            System.out.println(resultQueue.peek());
        } else {
            System.out.println("큐가 비어 있습니다.");
        }
    }


}
