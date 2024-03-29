정렬할 데이터가 배열 A[]와 같이 주어졌을 때 아래 정렬의 수행 과정 각각을 단계별로 보이시오.

1. 선택 정렬 
2. 버블 정렬(왼쪽에서 오른쪽으로 진행)
3. 삽입 정렬 

## 주어진 배열
```java
A[] = {20 50 60 30 40 10}
```

### 1. 선택 정렬

선택정렬의 알고리즘

```java
n=6
SelectionSort(A[],n){
    for(i=0; i < n-1; i++{ //n-1번 반복
        min=i;
        for (j=i+1; j<n; j++){ //미정렬 부분에서 최솟값 찾기
            if(A[min] > A[j])
                min = j;
            A[i]와 A[min]의 자리 바꿈 //최솟값과 데이터A[i]와 위치 교환
        }
    }
    return (A);
}
```
A[]의 0번 인덱스 부터 시작하므로 i=0, min=0 이다.  
정렬되지 않은 부분과 비교를 시작한다. j는 i+1인 1 부터 시작한다.  
min은 0이므로 A[min]=20, j는 1이므로 A[j]=50이 된다.  
20 보다 50이 크기에 if문에서 아무런 변화가 없다.  
j+1이 되어 j는 2가 되므로 A[j]=60, j가 3일때는 30, j가 4일때는 40 이 되어 마찬가지로 20보다 크기에 min에는 아무런 변화가 없다.  
j가 5가 되면 A[j]=10 이기에, A[min]의 값인 20 보다 작은값이 되어 if문이 참인 경우가 된다.  
min = j의 값인 5 이다.  
A[0] 과 A[min] 의 자리를 바꾼다.  
바꾼 후엔 A[]={10 50 60 30 40 20}이 된다.

위의 알고리즘을 한번 더 반복하면,  
i=1, min=1 , A[min]=50 이 되며, j가 3일 경우 A[j]=30 이고, if문이 참이 된다.  
따라서 min= j의 값인 3이다. 하지만 j가 5일 경우에 A[j] = 20, 현재 최솟값인 A[3]=30 보다 작으므로, if문이 참이 되어 min=5가 된다.
A[1] 과 A[min] 의 자리를 바꾼다.  
바꾼 후엔 A[] = {10 20 60 30 40 50}  

다시 반복한다.  
i=2, min=2, A[min] = 60, j=3일때 A[j] = 30, if문이 참이 된다.  
min=3이 된다. 더 반복해도 if문이 참이 되지 않는다.  
A[2]와 A[min] 의 자리를 바꾼다.  
바꾼 후엔 A[]={10 20 30 60 40 50}

다시 반복과정을 거치면  
i=3, min=3, A[min]= 60, j=4일때 A[j] = 40, if문이 참이 된다.  
min=4 가 된다. 더 반복해도 if문이 참이 되지 않는다.  
A[3] 과 A[min] 의 자리를 바꾼다.  
A[] = {10 20 30 40 60 50}  

다시 반복한다.  
i=4, min=4, A[min]=60, j=5일때 A[j]=50, if문이 참이 된다.  
min=5 가 된다.  
A[4] 와 A[min] 의 자리를 바꾼다.  
A[] = {10 20 30 40 50 60} 이 된다.  
---
### 버블 정렬
2) 버블 정렬(왼쪽에서 오른쪽으로 진행)

버블정렬 알고리즘

```java
n=6
BubbleSort (A[], n)
{
	for (i=0; i < n-1; i++) // 단계: (n-1)번 반복
		for (j=0; j < n-1; j++) // 왼쪽에서 오른쪽으로 진행하는 경우
			if (A[j] > A[j+1]) // ‘왼쪽 데이터 > 오른쪽 데이터’이면
				A[j]와 A[j+1]의 자리바꿈;
	return (A);
}
```

A[] = {20 50 60 30 40 10}

왼쪽에서 부터 오른쪽으로 진행한다.  
왼쪽 데이터가 오른쪽 데이터 보다 클 경우 자리를 바꾼다.  
20, 50은 그대로 이다. 50, 60도 그대로 이다.  
60, 30은 왼쪽 데이터가 크기때문에 자리를 바꿔준다.  
60, 40 도 왼쪽 데이터가 크기 때문에 자리를 바꿔준다.  
60, 10 도 왼쪽 데이터가 크기 때문에 자리를 바꿔준다.

단계 한번을 한 결과 A[] = {20 50 30 40 10 60}

다음 단계를 진행한다. 20, 50 은 그대로 이다. 50, 30 은 왼쪽 데이터가 크기때문에 자리를 바꿔준다. 50, 40 도 바꿔준다. 50, 10도 바꿔 준다.  
단계 진행 결과는 {20 30 40 10 50 60}

다음 단계를 진행한다. 20, 30은 그대로 이다. 30,40도 그대로 이다. 40, 10 은 왼쪽이 크기에 자리를 바꿔준다.  
단계 진행 결과는 {20 30 10 40 50 60}

다음 단계를 진행한다. 20, 30은 그대로 이다. 30, 10은 왼쪽이 크기에 자리를 바꿔준다.  
단계 진행 결과는 {20 10 30 40 50 60}

다음 단계를 진행한다. 20, 10 이 왼쪽이 크기에 자리를 바꿔준다.  
단계 진행 결과는 {10 20 30 40 50 60} 이 된다.

---
### 삽입 정렬
삽입 정렬

삽입정렬 알고리즘

```java
InsertionSort (A[ ], n)
{
	for (i=1; i < n; i++) {// A[0] 정렬 부분;1, ⋯, (n-1)까지 (n-1)번 반복
		val = A[i]; // 미정렬 부분 A[i..n-1]의 첫 번째 데이터 선택
		for (j=i; j > 0 && A[j-1] > val; j--) // 삽입할 위치 찾기
			A[j] = A[j-1]; // 정렬 부분의 A[j-1]이 크면 뒤로 한 칸 이동
		A[j] = val; // 찾아진 위치에 선택된 데이터 삽입
	}
	return (A);
}
```

A[] = {20 | 50 60 30 40 10} , *정렬 및 미정렬 부분은 ‘|’ 로 구분하였습니다.

단계 1. 정렬 부분 A[0] = 20 , 미정렬 부분의 첫번째 데이터 val = A[1] = 50  
j=1, A[j-1] = 20 이고, val 값은 50 이고, 20 은 50보다 작기때문에 아무런 변화가 없다.  
A[] = {20 50 | 60 30 40 10}

단계 2. 정렬 부분 A[1] = 50, 미정렬 부분의 첫번째 데이터 val = A[2] = 60  
j=2, A[j-1] = 50 이고, val 값은 60이고, 50은 60보다 작기 때문에 아무런 변화가 없다.  
A[] = {20 50 60 | 30 40 10}

단계 3. 정렬부분 A[2] = 60, 미정렬 부분의 첫번째 데이터 val = A[3] = 30  
j=3, A[j-1] = 60 이고, val 값은 30 이고, 60은 30보다 크기때문에 A[j]에 A[j-1]의 값을 넣어준다.(즉 뒤로 한칸 이동한다.)  
{20 50 60 | 30 40 10} ⇒ {20 50 60 | 60 40 10} 가 된다.
j— 연산 후 다음 반복  

j=2, A[j-1] = 50 이고, val 값은 30이고, 50은 30보다 크기 때문에 뒤로 한칸 이동한다.  
{20 50 60 | 60 40 10} ⇒ {20 50 50 | 60 40 10} 이 된다.  
j— 연산 후 다음 반복  

j=1, A[j-1] = 20 이고, val 값은 30이고, 20은 30보다 작기 때문에 for문의 조건이 아니다.  
A[j] 에 val 값을 넣어준다.  
{20 50 50 | 60 40 10} ⇒ {20 30 50 | 60 40 10} 이 된다.  
A[] = {20 30 50 60 | 40 10}

단계 4. 정렬부분 A[3] = 60, 미정렬 부분의 첫번째 데이터 val = A[4] = 40  
j=4, A[j-1]=60, val 값은 40이다. 60은 40보다 크기때문에 뒤로 한 칸 이동한다.  
{20 30 50 60 | 40 10} ⇒ {20 30 50 60 | 60 10} 가 된다.
j—연산 후 반복한다.

j=3, A[j-1]=50, val인 40보다 크기 때문에 뒤로 한 칸 이동한다.  
{20 30 50 60 | 60 10} ⇒ {20 30 50 50 | 60 10}  
j=2, A[j-1] = 30, val인 40보다 작기 때문에 for문의 조건이 아니다.  
A[j] 에 val 값을 넣어준다.  

{20 30 50 50 | 60 10} ⇒ {20 30 40 50 | 60 10}
A[] = {20 30 40 50 60 | 10}

단계 5. 정렬부분 A[4] = 60, 미정렬 부분의 첫번째 데이터 val = A[5] = 10
위와 같은 단계를 거치면  
A[] = {10 20 30 40 50 60} 이 된다.
---

## 퀵정렬
주어진 배열에 대해서 퀵 정렬의 분할 함수 Partition()을 적용한 후의 결과 배열을 구하시오(단, A[0]이 피벗이다.)

```java
A[] = {35 60 40 25 50 15 30 65 20 10}
```
   퀵정렬 알고리즘

```java
    n=10
    QuickSort (A[ ], n)
    {
    	if (n > 1) {
    	// ① 피벗을 기준으로 두 부분배열로 분할
    	// pivot은 제자리를 잡은 피벗의 위치(인덱스)를 표시
    	pivot = Partition (A[0..n-1], n);
    	// ② 왼쪽 부분배열에 대한 퀵 정렬의 순환 호출
    	QuickSort (A[0..pivot-1], pivot);
    	// ③ 오른쪽 부분배열에 대한 퀵 정렬의 순환 호출
    	QuickSort (A[pivot+1..n-1], n-pivot-1);
    }
    
    int Partition (A[ ], n)
    {
    	Left = 1; Right = n-1;
    	while (Left < Right) {
    		while (Left < n && A[Left] < A[0]) Left++;
    		while (Right > 0 && A[Right] >= A[0]) Right--;
    		if (Left < Right)
    			A[Left]와 A[Right]의 위치 교환
    		else
    			피벗 A[0]와 A[Right]의 위치 교환
    	}
    return (Right);
    }
```

   피벗 A[0]인 35 를 중심으로, A[1]부터 오른쪽으로 가면서 피벗 보다 큰 값을 찾고, A[n-1] 부터 왼쪽으로 가면서 피벗보다 작은 값을 찾는다

   A[1] 은 60이므로 피벗보다 큰 값이다. A[9]은 10이므로 피벗보다 작은 값이다. 그 둘의 자리를 바꾼다.  
   바꾼 후 : {35 **10** 40 25 50 15 30 65 20 **60**}

   계속 오른쪽으로 가면서 피벗 보다 큰 값을 찾고, 왼쪽으로 가면서 피벗 보다 작은 값을 찾는다.  
   A[2]=40이 피벗보다 큰 값이고, A[8] =20이 피벗보다 작은 값이다. 그 둘의 자리를 바꾼다.  
   바꾼 후 : {35 10 **20** 25 50 15 30 65 **40** 60}

   다시 반복하면 A[4]=50 이 피벗보다 큰 값, A[6]=30이 피벗보다 작은 값이다. 둘의 자리를 바꾼다.  
   바꾼 후 : {35 10 20 25 **30** 15 **50** 65 40 60}  
   현재 시점에서는 Left=5 가 Right=5 로 동일하기 때문에 더 이상 진행하지 않고, 피벗과 Right의 값을 바꾼다.  
   바꾼 후 : {15 10 20 25 30 35 50 65 40 60}

   바꾸고 나면 피벗인 35를 기준으로 오른쪽에는 피벗보다 큰 값들만 있는 배열, 왼쪽에는 작은 값들만 있는 배열이 된다.  
   왼쪽의 배열부터 다시 현재 과정을 반복한다.

   왼쪽 부분 배열 : {15 10 20 25 30}  
   피벗 : 15  
   피벗보다 큰 값을 찾기위해 왼쪽에서부터 오른쪽으로 가면 20, 작은 값을 찾기위해 오른쪽에서 부터 왼쪽으로 가면 10이 나온다. 이 때, Right=1가 Left=2 이기에 다른 진행을 하지 않는다. 피벗과 Right를 바꾼다.

   바꾼 후 왼쪽 부분 배열 : {10 15 20 25 30}  
   오른쪽 부분 배열도 과정을 반복한다.

   오른쪽 부분 배열 : {50 65 40 60}  
   피벗 : 50
   피벗보다 큰 값을 찾기위해 왼쪽에서 부터 오른쪽으로 가면 65, 작은값을 찾기위해 오른쪽에서 부터 왼쪽으로 가면 40이 나온다.  
   그 둘의 값을 바꿔준다.  
   바꾼 후 오른쪽 부분 배열 : {50 40 65 60}

   다시 반복하다보면 rght=1, left=2 가 되기에, 더 진행을 하지 않고 피벗과 right를 바꾼다.
   바꾼 후 : {40 50 65 60}
  
   다시 피벗을 중심으로 오른쪽으로 부분배열은 {65 60} 이고, 피벗65보다 작은값인 60과 자리를 바꾼다.  
   바꾼 후 {60 65} 가 되며  
   전체 배열은 {10 15 20 25 30 35 40 50 60 65} 가 된다.
