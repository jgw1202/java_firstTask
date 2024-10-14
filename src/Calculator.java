public class Calculator {
    /* 연산 결과를 저장하는 컬렉션 타입 필드 선언 및 생성 */
    private String arithmeticSymbol;
    private int firstNum;
    private int secondNum;


    public Calculator(String arithmeticSymbol, int firstNum, int secondNum) {
        this.arithmeticSymbol = arithmeticSymbol;
        this.firstNum = firstNum;
        this.secondNum = secondNum;
    }
    public int calculate(String arithmeticSymbol, int firstNum, int secondNum) {
        /* 위 요구사항에 맞게 구현 */
        /* return 연산 결과 */
        int result = 0;

        if(arithmeticSymbol.equals("+")) {
            result = firstNum + secondNum;
        }
        else if(arithmeticSymbol.equals("-")) {
            result = firstNum - secondNum;
        }
        else if(arithmeticSymbol.equals("*")) {
            result = firstNum * secondNum;
        }
        else if(arithmeticSymbol.equals("/")) {
            result = firstNum / secondNum;
        }
        else if(arithmeticSymbol.equals("%")) {
            result = firstNum % secondNum;
        }

        return result;
    }

    public String getArithmeticSymbol() {
        return arithmeticSymbol;
    }

    public int getFirstNum() {
        return getFirstNum();
    }

    public int getSecondNum() {
        return getSecondNum();
    }

    public void setArithmeticSymbol(String arithmeticSymbol) {
        this.arithmeticSymbol = arithmeticSymbol;
    }
    public void setFirstNum(int firstNum) {
        this.firstNum = firstNum;
    }
    public void setSecondNum(int secondNum) {
        this.secondNum = secondNum;
    }


}