import java.util.LinkedList;
import java.util.Queue;

public class Calculator<T extends Number> {
    private T result;
    private Queue<T> resultQueue = new LinkedList<>();

    public T calculate(OperatorType operator, T firstNum, T secondNum) {
        double first = firstNum.doubleValue();
        double second = secondNum.doubleValue();
        double calcResult;

        switch (operator) {
            case ADD:
                calcResult = first + second;
                break;
            case SUBTRACT:
                calcResult = first - second;
                break;
            case MULTIPLY:
                calcResult = first * second;
                break;
            case DIVIDE:
                if (second != 0) {
                    calcResult = first / second;
                } else {
                    throw new ArithmeticException("0으로 나눌 수 없습니다.");
                }
                break;
            case MODULO:
                if (second != 0) {
                    calcResult = first % second;
                } else {
                    throw new ArithmeticException("0으로 나눌 수 없습니다.");
                }
                break;
            default:
                throw new IllegalArgumentException("유효하지 않은 연산자입니다.");
        }

        result = (T) Double.valueOf(calcResult);
        resultQueue.add(result);
        return result;
    }

    public void removeResult() {
        resultQueue.poll();
        if (resultQueue.peek() != null) {
            System.out.println("현재 가장 먼저 저장된 데이터(peek) : " + resultQueue.peek());
        } else {
            System.out.println("큐가 비어 있습니다.");
        }
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }
}
