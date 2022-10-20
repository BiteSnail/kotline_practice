<b>추상적 자료형 (abstract data type)</b>   
데이터 + 연산(기능)에 대하여 명기한 개념(가상의 것(?))

<b>추상적 자료구조 (abstract data structure)</b>   
자료구조와 기능을 명시한 것 (실제의 것)

데이터 구조에서는 추상적 자료구조를 추상적 자료형이라는 개념을 이용해서 정리한다.

### [프로그래밍 실습 정리]   
<b>reassign 가능 여부에 따라</b>   
val, var

> comment는 인간(개발자)의 편의를 위해 사용된다.
> data type은 Type inference에 의해 자동으로 이루어지기도 한다.
> data type은 직접 지정해줄 수도 있는데 변수 이름 옆에 {: data_type}을 입력한다.
> -> 코틀린에서는 문자에 데이터 타입이 존재하고 이에 해당하는 데이터만을 저장할 수 있다.

<b>Array<Int>?</b>   
데이터가 있을 수도 있고 없을 수도 있다. null은 비어있다는 의미가 아닌 존재하지 않는다는 의미이다.

<b>print(scores2.size)</b>   
scores2는 현재 null값을 가지기 때문에 size라는 array<int>의 내부 변수에 접근할 수 없다. 따라서 해당 구문은 오류를 가진다. 그래서 print(scores2?.size)를 사용하여 scores2가 size를 가지는지 사전에 확인할 수 있다.

<b>!!</b>   
변수 뒤에 붙는 강제 옵션

<b>print(scores2.size) 와 print(scores2!!.size)의 오류 차이</b>   
전자는 컴파일러에서 오류가 검출되지만 후자는 런타임중에 예외 오류가 발생한다는 차이가 있다.

<b>? 사용 이유</b>   
nullpointer exception을 방지하기 위해서 사용한다.

<b>var max = -1 위 구문에서 경고가 뜨는 이유</b>   
-1이 사용되지 않았기 때문이다.

* 코틀린에서는 double형과 int형의 비교가 가능하다. 
(같은 추상자료형이라고 할 수있다 혹은 해당 연산이 구현되어져 있다)

* 함수의 반환 타입과 실제 반환하는 값이 다르다면 에러가 발생하게 된다.

* 함수의 매개변수는 var이 아닌 val로 선언되기 때문에 값을 바꿀 수 없다.

### class   
* class: 임의의 개체/객체에 대한 틀   
* 멤버변수(객체마다 가질 속성값)와 멤버함수(객체의 기능)를 가진다.
* 클래스 정의 시에 생성자 함수처럼 작성함.
```kotlin   
class Person( //like a initializer
    //member value
)
{
    //methods
}
```
* 접근 권한을 지정할 수 있다. (private, public, etc.)
* 생성할 때 val, var 설정하지 않았다면 init함수에서만 사용할 수 있다.

### Generics   
* 특정 데이터 타입에 국한되지 않는 프로그램을 구현하기 위해 사용한다.
* 클래스 내부에 Any클래스를 사용하게 되면 특정 타입만을 담을 수는 없기 때문에 프로그램 실행 중에 해당 객체에 어떤 클래스 객체가 존재하는지 알 수 없게 된다.
* template을 사용하여 위와 같은 문제를 해결 할 수 있다. class name<type>

> val 변수에서 class를 assign해서 그 안의 methods를 이용해 값을 바꾸는 것은 가능하다. 하지만 다른 값으로 reassign하는 것은 불가능하다.

### 문제풀이
1. 양의 정수 30 ~ 70 사이 중에서, 3의 배수를 모두 더한 값을 출력하는 프로그램을 작성해보자.
```kotlin
fun main()
{
    var result: Int = 0
    for(x in 30..70)
    {
        if(x%3 == 0){
            result += x
        }
    }
    println(result)
}
```