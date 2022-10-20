### LinkedList의 개량
필요에 따라 같이 사용할 수 있다.
* 양방향 리스트
* 원형 리스트   

### Queue with Ring Buffer
최대 용량이 존재해야 한다는 단점이 있지만,
시간복잡도 상으로 다른 방식으로 구현한 큐보다 이점을 가진다.

```kotlin
    fun first(): Element?{
        if (count > 0)
            return elements[read_point] as Element;
        return null;
    }

    fun write(element:Element): Boolean {
        if (count == size)
            return false
        elements.set(write_point, element);
        count++;
        write_point = (write_point+1) % size;
        return true;
    }

    fun read(): Element?{
        if (count <= 0)
            return null
        val ret = first();
        read_point = (read_point+1) % size;
        count--;
        return ret;
    }

    override fun toString(): String {
        var ret = "["
        var tmp_read_point = read_point;
        var tmp_count = count;
        while(tmp_count > 0){
            ret += " ${elements.get(tmp_read_point)}";
            tmp_read_point = (tmp_read_point+1) % size;
            tmp_count--;
        }
        ret += " ]";
        return ret;
    }
```

Q> DSALG   
enqueue("R") : DSALGR
enqueue("O") : DSALGRO
dequeue()    : SALGRO
enqueue("C") : SALGROC
dequeue()    : ALGROC
dequeue()    : LGROC
enqueue("K") : LGROCK

```kotlin
    fun QueueInterface<T>.reverse(){
        val aux = Stack<T>()
        var next = this.dequeue()
        while (next != null){
            aux.push(next)
            next = this.dequeue()
        }
        var next2 = aux.pop()
        while(next2 != null){
            this.enqueue(next2)
            next2 = aux.pop()
        }
    }
```

Q> Queue 와 Stack의 차이점은?   
Queue : FIFO, Stack : LIFO   

Q> 실생활에서 Queue, Stack 개념의 예시   
Stack: 헬스장 바, 쓰레기통
Queue: 공장의 컨테이너, 접속 대기열

### Deque
Queue와 Stack의 특징을 모두 가지고 있음. 앞/뒤 모두 삽입/삭제 가능   

### 문제풀기
1. 코틀린 ArrayList를 사용해서 Queue를 구현하면, Enqueue 기능의 Time Complexity는 항상 O(n)이다. (X)   
2. Ring buffer 구조를 사용하여 Queue 를 구현하면, LinkedList 의 장점을 취하 면서도 LinkedList 의 단점이었던 “부가적인 작업으로 인한 load”를 감소할 수 있게 된다. (O)

### Type alias
타입명에 대한 별칭을 지정해 주는 키워드   
클래스를 지정할 때는 typealias NodeSet = Set<Tree.Node>    
함수에 대해서 사용할 때에는 typealias TheFunc = (Int, String, Any) -> Unit

### foreach
continue 혹은 break문과 유사하게 작동하기 위해   
return@foreach 혹은 return@run 를 사용한다.

### Elvis operator
?:   객체가 null일 경우 취할 default값을 명시하는 키워드

### Naming Convention
* Class
  * Camel case
*  Function, Variable
  * Camel case 단, 첫 글자는 소문자
* Constant
  * 모두 대문자, 단어 사이는 _로 구분

### Java Import
코틀린은 자바의 powerset이므로 자바 패키지를 import할 수 있다.

### Tree
트리를 구성하는 데이터 단위를 Node라고 한다. 이 Node를 서로 잇는 것을 Edge라고 한다.    
Node가 부모를 가지지 않으면 Root, 자식을 가지지 않으면 Leaf라고 한다.

#### DFT
Depth First Traversal   재귀함수 및 스택으로 구현이 가능하다.   

```kotlin
    fun forEachDepthFirst(visit: Visitor<T>){
        visit(this)
        children.forEach {
            it.forEachDepthFirst(visit)
        }
    }
```
