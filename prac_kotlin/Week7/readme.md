### Range
시작점에서 끝지점 범위 안에서 1 step씩 전진하는 개념   
IntRange, CharRange 등의 타입이 존재한다.    

#### 표기법
1. 1..10
2. `Int()`.rangeTo(`index: Int`)
3. `Int()` until(`index: Int`)

#### 응용
IntRange, CharRange 등의 Range타입에 다음을 적용할수 있다.   
1. forEach{ }
2. filter{ } //return이 list임.   
3. toList()
4. for(i in 1..10) //파이썬 처럼 사용할 수도 있음

### Progression
Step이 존재하는 Range   
Range 생성 뒤에 step `Int` 로 생성할 수 있다.   
Progression은 Range의 일반화된 형태라고 볼 수 있다.

#### 응용
Range의 응용처럼 사용할 수 있다.   
파이썬처럼 사용할 수 있다.    
for(i in 1..10 step 3)

### Tries
Collection형태(순서가 있거나 집합적인)로 저장될 수 있는 데이터를 저장하는 특수한 Tree   
특히 prefix matching에 효과적으로 활용될 수 있다.

일반적인 String Array로 prefix 매칭을 시도할 때   
String Array의 word들의 개수가 n, 가장 긴 word의 길이가 k라고 한다면
Array의 모든 word들에 대해 최대 k번 만큼의 비교가 이루어져야 한다.
따라서 해당 알고리즘의 시간복잡도는 O(kn)이다.

만약 Tries로 prefix matching을 시도한다면   
모든 word가 Tries에 저장되어 있을 때 이 tries의 높이가 k라면(가장 긴 word의 길이가 k라면)
prefix의 길이가 l일 때 prefix와 matching되는 sub Tries까지 가는데에 l만큼 걸린다면
prefix를 포함하는 sub tries에 도달하는 시간 복잡도가 O(l), sub tries를 순회하는 것은 O((k-l)m)만큼의 시간복잡도를 가진다.
(이때 m은 sub tries의 word 개수)      
따라서 해당 알고리즘의 시간복잡도는 O(km)이다.

Hashmap으로 구현하면 원소의 생성과 삭제, 탐색의 시간복잡도가 O(1)으로
굉장히 빠르게 수행할 수 있다.

#### LAMDA 표현식 응용
forEach를 사용할 때 iterator it을 람다식을 이용해 이름을 부여해 줄 수 있다.   
아래 예제에서는 it을 element -> 라는 람다 표현식을 사용했다.   
만약 for문을 사용한다면 for(element in list)도 똑같이 작동한다.    
```kotlin
val list: List<Key>
list.forEach { element ->
    if(current.children[element] == null){
        current.children[element] = TrieNode(elemetn, current)
    }
    ...
}
```

#### extension function
코틀린에서 extension을 활용하여 다른 타입의 매개변수를 처리할 수 있다.   

```kotlin
fun Trie<Char>.insert(string: String){
    insert(string.toList())
}
```

#### count와 isEmpty property 구현
word의 집합 storedLists를 이용한다.

```kotlin
    val count: Int
        get() = storedLists.size
    val isEmpty: Boolean
        get() = count == 0
```

#### findIndices 구현
정렬된 리스트 안의 연속된 값의 범위를 찾는 함수

```kotlin
fun <T: Comparable<T>> ArrayList<T>.findIndices(
    value: T
): IntRange? {
    var lindex = 0
    var rindex = size
    var find = false

    while(lindex < rindex){
        var middle = (lindex+rindex)/2
        if(this[middle] == value){
            lindex = middle
            rindex = middle
            find = true
            break
        }
        else if(this[middle] > value)
            rindex = middle - 1
        else
            lindex = middle + 1
    }
    if(!find)
        return null
    while(lindex > 0 && this[lindex] == this[lindex-1]){
        lindex--;
    }
    while(rindex < size-1 && this[rindex] == this[rindex+1]){
        rindex++;
    }
    return lindex..rindex
}
```

### 문제 풀이
1. Trie를 구현할 때, 각 노드의 자식노드를 HashMap을 사용하지 않고 ArrayList로 구현하였다.
이 Trie 에 100개의 영어 word를 넣었다. (Trie의 각 노드는 영어 알파벳) 이때, 
특정 word X가 Trie에 존재하는지 여부를 알아내고자 할 경우,
최악의 경우 100개의 word를 모두 체크해야 X가 존재하는지 여부를 알 수 있을 것이다. (O)

만약 자식노드가 ArrayList로 구현되어 있고 word가 z, za, zb, ... , zz , zzz, zza, ... , zzz
같은 식으로 되어있을 때 word z...z가 trie에 있는지 확인하기 위해 모든 노드를 탐색하게 된다. 

2. 숫자 1~100을 ArrayList에 '내림차순'으로 정렬해놓았다. 이에 대하여 Binary Search를 사용하는 것은 불가능하다. (X)
