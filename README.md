사칙연산 계산기 프로그램

기본적인 사칙연산 기능을 제공하는 계산기 프로그램입니다.

덧셈, 뺼셈, 곱셈, 나눗셈, 나머지 기능을 제공합니다.

exit 를 입력하면 프로그램은 종료됩니다.

-- 트러블 슈팅 --

- 배경 : queue를 만들고 매 반복 시 연산 결과(result)를 큐에 add 하여 담고, remove 하면 맨 앞 데이터 삭제를 하는 식으로 코드를 구성함
- 발단 : removeResult 메소드 디버깅 중 poll() 이후, peek()로 큐 안 데이터를 출력해봤으나 null이 나옴
- 전개 : add() 대신 offer()를 사용하여 데이터 삽입을 해봤지만 결과는 그대로임
- 위기 : peek()는 queue가 비어있는 경우 null을 반환, 따라서 데이터 삽입이 이루어지지 않고 있음
- 절정 : 디버깅 중 계속해서 객체가 새로 초기화되는 것을 발견했음. 삽입함수의 문제가 아닌 calculator 객체생성 위치가 반복문 내부에 있어서 매번 저장을 해도 새 객체 생성 이후 삭제를 하여 null 이 나왔던 것이었음
- 결말 : Calculator 객체 생성 코드를 while문 밖으로 빼니 정상적으로 실행됨. 문제점을 너무 함수의 문제로 국한시 했던 실수였던 것 같음
