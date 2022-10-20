## [3_1]
### Data Class
<i>왜 생성되었는가?</i>   
객체지향 패러다임에서 개발자들이 자주 만들던 함수들을 기본적으로 포함(편리를 위해서)
#### 특징
* 코틀린에서는 class member 변수에 대해서 자동으로 getter, setter(val은 예외)가 생성된다.
* 클래스 생성 시 자동으로 포함되는 함수
  * hashcode()
  * copy()
  * equals()
  * toString()
  * componentsN()
* 다른 클래스를 상속받는 것이 불가능하다.
* 기본 생성자에 1개 이상의 멤버변수를 선언해야 한다.
* 다른 종류의 클래스로 만들 수 없다.
* data class를 print한다면 자동으로 toString()된 값이 출력된다.

#### 멤버함수 override

```kotlin
data class TestDataClass(
  var a: Int,
  val b: String="Empty"
){
    override fun toString(): String {
      return "Var a = $a, Val b = $b"
    }
}
```

### 추상 클래스
객체 완성이 불가능한 클래스이다. 혼자서는 사용될 수 없고 반드시 상속받아서 사용된다.   
추상 클래스의 멤버 변수나 함수는 모두 '추상형'일 필요는 없다. 
추상클래스에서 추상형 변수는 abstract 를 앞에 붙여주고 상속받는 클래스에서는 override 를 붙인다.

>상속되는 함수는 이름 뿐만 아니라 반환 타입까지도 전부 같아야 한다.   

13p.   
<b>Q1) 매개변수 없어도 생성이 되는 이유는?</b>   
상속받은 클래스에 b, c의 기본 생성자가 있기 때문에 매개변수가 없어도 생성된다.   
<b>Q2) 컴파일 에러가 나는 이유는?</b>   
o1은 ChildOfAbstClass 가 아니라 TestAbstClass 이기 때문에 f3에 접근할 수 없다.   
<b>Q3) 어떤 경우에 추상클래스가 요긴하게 사용될까?</b>   
변수와 함수는 동일하지만, 서로 다른 변수/함수가 존재하는 클래스들을 만들 때 유용하다.

### 인터페이스(interface)
객체생성이 불가능한 데이터구조로 이름 그대로 인터페이스 기능을 수행한다.
다른 클래스에서 인터페이스를 상속하여 사용할 수 있기 때문에 미완성 된 함수가 존재할 수 있다.

### 클래스 상속
코틀린에서는 일반적으로 클래스 상속이 불가능하다.
하지만 'open' 키워드를 붙여줌으로써 상속 가능하도록 만들어 줄 수 있다.

### Generics with constraints
함수를 만들 때에 범용적으로 사용하기 위해서 사용하는 방법이다.   

함수에서 T에 대한 정보(특성)를 추가적으로 줄 수 있다.
```kotlin
fun <T: Closeable> fun2(x: T){ //전해야하는 특성이 1개일 때
    x.close()
}
fun <T> fun3(x: T) where T: Closeable, T: iterable<T> { //여러개일 때
    x.close()
    var it = x.iterator()
}
```

### Getter & Setter
| 클래스 선언                         | Getter | Setter | 유형       | 비고            |
|--------------------------------|--------|--------|----------|---------------|
| class Person(name:String)      | X      | X      | 생성사 매개변수 | init에서만 접근 가능 |
| class Person(var name: String) | O      | O      | 속성       |               |
| class Person(val name: String) | O      | X      | 속성       |               |

변수 선언 후 get, set으로 지정 가능
```kotlin
class Man(
  var address: String = "Nowhere" 
          get
          set(v) {field = "address $v"}
)
```

### 문제 풀이
1. Data class 는 객체 생성을 할 수 없는 특수한 클래스이다. (X)
2. Abstract class 는 객체 생성을 할 수 없는 특수한 클래스이다. (O)
3. Abstract class 의 변수들 중에 abstract 키워드가 붙은 변수의 초기값을 설정 할 수 있다.(x)
4. Interface 는 멤버변수를 가질 수 없다. (?)

## [3_2]
### Complexity
비교의 척도 : <b>Time & Memory usage</b>   

### Big O notation
* 표기법 종류
  * Big O : 상한선표기(worst case)
  * Big Omega : 하한선 표기(best case) 
  * Big Theta : 상-하한선 사이 표기(average case)

### Time Complexity
* Constant time : O(1)
* Linear time : O(n)
* Quadratic time : O(n^m)
* Logarithm time : O(logN) 이진탐색
* Quasilinear time : O(n logN)

### 문제 풀이
1. 아래 프로그램의 Time Complexity 를 Big O notation 으로 나타내보자.   
O(1), i 혹은 j 가 n으로 바뀐다면 O(n^2)

## [3_3]
### Linked List
리스트를 이루는 각 개체를 Node 라고 한다.    
<b>Q)각 Node는 어떤 값(변수)과 기능(함수)을 가져야 할까? </b>   
표현하고 싶은 데이터와 다음 노드를 가리키는 값을 가지고 있어야 한다.
또한 자기가 가진 값에 접근할 수 있는 기능이 있어야 한다.   

DIY. push, append 함수 정의
```kotlin
fun push(value: T): LinkedList<T> { //c++에서의 레퍼런스 반환과 유사
  head = node(value = value, next = head)
  if(tail == null){
    tail = head
  }
  size++
  return this
}
fun append(value: T): LinkedList<T>{
  if(isEmpty()){
    return push(value) //push() returns LinkedList<T>
  }
  tail?.next = node(value = value)
  tail = tail?.next
  size++
  return this
}
```
insert 함수에서 !!의 의미 : 해당 변수가 null 이면 exception 발생

> Array와 LinkedList의 차이점   
> 접근 방법에 대한 차이 : 비순차적, 순차적   
> 메모리 할당의 차이 : 미리 할당, 추가할 때 마다 할당   
> 특징 : 연속적, 연결적   
> 동일한 기능을 수행하는 함수의 time complexity 

Array와 LinkedList의 특징을 알고 상황에 맞게 적용하는 것이 중요하다.

## 4Week

DIY > 단순 배열과 연결리스트의 Complexity를 비교해보자   

| function | array | linked-list |
| --- | --- |-------------|
| pop | O(N)| O(1)        |
| removeLast | O(1) | O(N)        |
| removeAfter | O(N) | O(1)        |

Q> week3_3 20p. 변수(반복자)'item'의 자료형은 뭘까?
LinkedList 클래스에 Iterable를 상속하였다.
iterator() 생성자 함수를 override하는 것으로 보아 iterator 클래스가 Iterable 클래스에 속해 있다는 것을 알 수 있다.   
for(item in list) 구문에서 자동으로 iterator를 생성해 주는 것 같다.
아마도 C언어로 따지자면 for(iterator = list.iterator(); iterator.hasNext(); item = iterator.next())
정도가 되지 않을까?   
item은 iterator 클래스의 next()의 반환값을 따르는 것 같다.
즉 여기에서는 Int이다.

### Collection
Collection을 상속받은 클래스는 size, isEmpty, contains, allcontains를 override해야 한다.
Collection을 상속받은 클래스끼리 원소의 값이 포함되는 지를 확인할 수 있다.

Q> containsAll 함수의 Time Complexity는?   
contains의 시간복잡도가 O(N)이고 containsAll 함수에서 contains를 N번 만큼 실행하므로 O(N^2)이다.

### Linked List 개량하기

```kotlin
    fun getMiddle(): node<T>?{
        var slow = this.nodeAt(0)
        var fast = this.nodeAt(0)
        while(fast != null){
            fast = fast.next
            if( fast != null ){
                slow = slow?.next
                fast = fast.next
            }
        }
        return slow
    }

    private fun addInReverse(list: LinkedList<T>, node: node<T>)
    {
      val next = node.next
      if(next != null){
        addInReverse(list, next)
      }
      list.append(node.value)
    }
    
    fun reversed(): LinkedList<T> {
      val result = LinkedList<T>()
      val head = this.nodeAt(0)
      if(head!= null){
        addInReverse(result, head)
      }
      return result
    }
```


### Stack
* LIFO 구조
* object.apply {}를 이용하면 객체 이름을 생략하고 내부 메소드를 사용할 수 있다.
> Q> push, pop 의 Time complexity는?   
> push, pop : O(1)   
> 단순 Array라도 마지막 값을 추가하거나 제거하는 것은 상수시간이 걸리기 때문이다.

peek 함수에서 count가 왜 필요할까? storage.size로만 사용해도 되지 않을까?

### 문제풀이
1. LinkedList에서 제일 뒤에 item을 추가하는 작업의 Time complexity는 O(n)이다. (X)
2. Stack 의 pop() 기능의 Time complexity는 O(1)이다. (O)
3. Stack에 가장 나중에 넣은 item은 가장 먼저 나오게 된다. (O)   
//1번에서 추가하는 작업은 tail의 next에 할당해 주기만 하면 된다. 그래서 O(1)

## Week 4_1
### Companion
* 클래스 내에 존재하는 객체, 자신이 속한 클래스의 생성자에 언제나 접근이 가능하다.
* 다만, 아우터 클래스의 멤버 변수의 접근은 불가능하다. (객체로서 이미 존재하기 때문)
* Singleton 패턴을 만들어 줄 수도 있다.   
* 객체의 이름을 생략할 수 있다.   
* 1개만 생성 가능
### Nested
* 클래스 안에 존재하는 클래스.
* out class가 생성되지 않아도 생성 가능하다.
### Inner
* nested클래스와 달리 inner를 붙여 주어야 한다.
* outer class가 생성 되어 있어야 생성 가능하다.
### Sealed
* 여러 다른 클래스를 묶어서 사용할 수 있도록 해주는 클래스   
### Enum
* 상수들의 모임을 클래스로 만든 것
* 생성자와 멤버함수도 사용할 수 있다.
### Secondary constructor
* 여러 버전의 생성자를 만들 수 있다. (C++의 오버로딩)
* this 지시자를 이용해 서로를 호출할 수 있다. (재활용성 증가)
### Standard LibraryL Functions
#### let
주어진 객체에 대해 안전한 operation이 가능하도록 해줌
#### when
C언어에서 switch-case 느낌
#### with
주어진 객체에 대한 멤버변수/함수 접근을 편리하게 함
#### run
let과의 차이점으로 자신이 속한 클래스에 접근이 불가능한 점이 있다.
#### also
let과 유사하나 also를 사용한 객체가 재호출 된다.
#### apply
also와 유사하게 객체 자신을 리턴, 주어진 객체를 this로 표시한다.
#### TODO function
주석으로 적어놓고 구현을 하지 않는 문제를 예방 가능하게해줌.

## Week 4_2
### Queue
* FIFO 구조   
* item이 queue로 들어가는 부분과 나오는 부분이 다르다.
* Array로 구현하였을 때 Time Complexity
  * isEmpty() : O(1)
  * peek(): O(1)
  * enqueue(): O(1)
  * dequeue() : O(N)
* LinkedList로 구현하였을 때 Time Complexity
  * isEmpty() : O(1)
  * peek() : O(1) //front 값을 가져오는 것이기 때문에
  * enqueue() : O(1)
  * dequeue() : O(1)
