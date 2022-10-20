### 이진트리
자식을 최대 2개까지 가질 수 있는 트리

### 이진트리의 순회
InOrder, PreOrder, PostOrder   
visit()이라는 행위가 어느 시점에서 일어나는지에 따라 달라진다.   
특정 규칙을 만족하면 순회 시에 정렬된 형태를 얻을 수 있다.   

```kotlin
    fun traversePreOrder(visit: BinaryVisitor<T>){
        visit(value)
        leftChild?.traverseInOrder(visit)
        rightChild?.traverseInOrder(visit)
    }
    fun traversePostOrder(visit: BinaryVisitor<T>){
        leftChild?.traverseInOrder(visit)
        rightChild?.traverseInOrder(visit)
        visit(value)
    }
```

#### Binary Search Tree
leftChild.value < Cur.value < Right Child.value    
위 식을 만족하는 이진트리   
* 동일한 데이터를 배열로 다루는 경우와 이진탐색 트리로 다루는 경우   
(모든 경우는 worst case로 가정)

| 기능     | ARRAY | BST     |
|--------|-------|---------|
| lookup | O(N)  | O(logN) |
| insert | O(N)  | O(logN) |
| Remove | O(N)  | O(logN) |

입력 시에 오름차순 혹은 내림차순으로 데이터가 insert되면
트리 불균형 문제가 발생!   
기술적 혹은 인위적으로 해결방법을 제시해야 함.

##### contain
이진 탐색 트리의 특성을 활용해 탐색   
탐색의 효율은 O(logN)   

##### remove
case1 : Leaf Node   
Parent 노드의 Child 중 해당 Node를 삭제
case2 : Internal Node   
자식이 한개 있는 경우, null이 아닌 자식을 parent화 연결   
자식이 두개 있는 경우, 오른쪽 자식의 가장 작은 value를 삭제한 노드 위치로 지정

#### 문제 풀이
1. Binary Tree 는 1개의 노드가 child 노드를 최소 1개, 최대 2개를 가져야 한다.
(X) //최소 0개 최대 2개
2. Binary Search Tree (BST) 를 이용하면, 특정 item 을 find 하는 작업을 Time complexity O(log n)으로 가능하다. (O)

### List & Set & Map
생성하는 방식에 따라 Mutable, Immutable이 결정된다.   

#### Hashmap
##### Hash
효율적인 자료구조 또는 보안 목적으로 사용된다.   
Input 값을 어떤 미지의 계산을 통해 output을 생성한다.
아주 가끔 output값이 collision을 발생시킬 수 있다.

Hash-Value 쌍으로 되어있는 Map   
하지만 탐색 속도가 매우 빠르다. O(1)

### Extension function/property
정의가 완료된 클래스에 추가로 함수/변수를 정의하는 것   
overloading시에 완전히 동일한 함수가 존재 하면 확장함수가 무시된다.   
정적 바인딩되므로, 컴파일 타임에 타입이 결정된다.

[사용방법]   
fun 클래스이름.함수이름(...매개변수...): 리턴타입 {...}

### assert
매개변수의 값에 따라 false인 경우 오류를 발생시킴

### AVL Tree
기존 이진트리의 최악의 경우를 해결하기 위해 self-balancing이 추가됨   
leftchild와 rightchild의 높이가 같은 tree   

트리에 노드를 추가하거나 제거할 때 다음과 같은 
4가지 회전을 이용해 트리를 밸런스하게 유지한다.   
1. Right Rotate
2. Left Rotate
3. Right-Left Rotate
4. Left-Right Rotate

각각의 노드가 leftchild의 height과 rightchild의 height의 차이의 절대값이 1이 유지되도록 해준다.

#### AVL Tree가 완벽하게 균형잡혔을 때
1. leaf node의 개수를 리턴해주는 함수
2. 전체 노드의 개수를 리턴해주는 함수
```kotlin
fun leafNodesOfPerfect(height: Int): Int{
    return 2.0.pow(height).toInt()
}

fun nodesOfPerfect(height: Int): Int{
    return leafNodesOfPerfect(height + 1) - 1
}
```

### Red-Black Tree
Self-balancing 된 트리지만 AVL 트리보다는 비교적 rough하게 self-balancing한다.

