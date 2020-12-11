# 3주차 문제 풀이
# :heart_eyes: 문제를 풀며 배운점이나 공부한 점 등 자유롭게 기록 남기기 :heart_eyes:

## dhwhc0711

### [2565 전깃줄](https://github.com/ProgWon/2020_JNU_Algorithm_Study/blob/main/week3/2565_dhwhc0711.cpp)


### [3085 사탕 게임](https://github.com/ProgWon/2020_JNU_Algorithm_Study/blob/main/week3/3085_dhwhc0711.cpp)


### [9252 LCS 2](https://github.com/ProgWon/2020_JNU_Algorithm_Study/blob/main/week3/9262_dhwhc0711.cpp)

### [12865 평범한 배낭](https://github.com/ProgWon/2020_JNU_Algorithm_Study/blob/main/week3/12865_dhwhc0711.cpp)


### 기록하고 싶은 내용

 
## spacein1001

### [2565 전깃줄](https://github.com/ProgWon/2020_JNU_Algorithm_Study/blob/main/week3/2565_spacein1001.java)


### [3085 사탕 게임](https://github.com/ProgWon/2020_JNU_Algorithm_Study/blob/main/week3/3085_spacein1001.java)


### [9252 LCS 2](https://github.com/ProgWon/2020_JNU_Algorithm_Study/blob/main/week3/9262_spacein1001.java)

### [12865 평범한 배낭](https://github.com/ProgWon/2020_JNU_Algorithm_Study/blob/main/week3/12865_spacein1001.java)

### 기록하고 싶은 내용

## noble5712

### [2565 전깃줄](https://github.com/ProgWon/2020_JNU_Algorithm_Study/blob/main/week3/2565_noble5712.java)
* DP문제를 많이 풀어보지 못해 문제를 봤을 때, 직관적으로 DP로 풀어야겠다는 생각 조차 하지 못했습니다.
  * 여러 시도를 해보다가 찾아보니 LIS에 관련된 문제라는 것을 알게되고 LIS를 공부한 후에 풀어보니 비교적 간단한 문제였습니다. 어떤 조건을 걸어야 겹치지 않는지 정도 생각하는 과정이 필요했습니다.
  * LIS를 알아보니 완전탐색, 이분탐색, 동적 계획으로 풀이가 가능 한것을 알았는데, LIS를 알아보기전에 시도한 것이 완전 탐색으로 풀이 한 것 이었고, 너무 비효율적이라고 생각해서 빨리 포기한게 다행이라는 생각 들었습니다.
  * 스스로 이분 탐색에 대한 이해가 부족하다고 생각하는데, 이참에 이분 탐색에 대해 좀더 공부해봐야겠습니다.
* Top-down과 Bottom-up으로 모두 풀이해보았습니다. Top-down은 재귀적으로 풀이하니 직관적으로 알기 쉬운데, Bottom-up의 경우는 아직 어색해서 좀 더 많은 문제를 풀어야 할 것 같습니다.

### [3085 사탕 게임](https://github.com/ProgWon/2020_JNU_Algorithm_Study/blob/main/week3/3085_noble5712.java)
* 완전 탐색이 온전히 이루어질수 있도록 조건을 계속 만들어주는게 생각보다 머리 아팠습니다.
  * 배열로 입력을 받아 글자를 바꿔주지만 다음 연산을 위해 초기 배열로 초기화 시켜주어야 했습니다. 처음엔 2차원 배열을 깊은 복사하여 클론을 만들어내려고 했는데, 배열을 연산할 때마다 계속 클론을 생성하기엔 연산의 수가 불필요하게 늘어난다고 느껴서, 뒤집은 배열을 다시 또 뒤집어 초기 상태로 만들어주었습니다.
### [9252 LCS 2](https://github.com/ProgWon/2020_JNU_Algorithm_Study/blob/main/week3/9262_noble5712.java)

### [12865 평범한 배낭](https://github.com/ProgWon/2020_JNU_Algorithm_Study/blob/main/week3/12865_noble5712.java)


### 기록하고 싶은 내용
* Arrays.sort 메소드의 경우 2차원배열의 정렬을 지원하지않아 Comparator를 사용해서 정렬 했어야 했는데 Comparator와 Comparable의 경우 예전에 한번 공부한 적이 있음에도, 오랜만에 보니 낯설었습니다. 좀 더 공부할 기회를 얻은것 같습니다.
* 배낭문제는 짐을 쪼갤 수 있는 경우와 짐을 쪼갤 수 없는 경우로 나눌 수 있다. 짐을 쪼갤 수 있는 배낭문제를 Fraction Knapsack Problem 이라 하고, 짐을 쪼갤 수 없는 배낭문제를 0/1 Knapsack Problem 이라 한다. 알고리즘 또한 다르게 적용하는데, Fraction Knapsack Problem 의 경우 탐욕 알고리즘(Greedy)을 쓰며, 0/1 Knapsack Problem의 경우 DP 법을 쓴다. (FPTAS(Fully polynomial time approximation scheme) 으로 스케일링을 통한 방법도 있지만 근사치를 얻는 방법인지라 자칫 틀릴 수도 있다.)
