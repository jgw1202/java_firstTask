import java.util.LinkedList;
import java.util.Queue;

public class Calculator {
    private int result;
    private Queue<Integer> resultQueue = new LinkedList<>();

    public int calculate(OperatorType operatorType, int firstNum, int secondNum) {
        switch (operatorType) {
            case ADD:
                result = firstNum + secondNum;
                break;
            case SUBTRACT:
                result = firstNum - secondNum;
                break;
            case MULTIPLY:
                result = firstNum * secondNum;
                break;
            case DIVIDE:
                if (secondNum != 0) {
                    result = firstNum / secondNum;
                } else {
                    throw new ArithmeticException("0으로 나눌 수 없습니다.");
                }
                break;
            case MODULUS:
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
            System.out.println("현재 가장 먼저 저장딘 데이터(peek) : " + resultQueue.peek());
        } else {
            System.out.println("큐가 비어 있습니다.");
        }
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

}
