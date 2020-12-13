# 3주차 문제 풀이
# :heart_eyes: 문제를 풀며 배운점이나 공부한 점 등 자유롭게 기록 남기기 :heart_eyes:

## dhwhc0711

### [2565 전깃줄](https://github.com/ProgWon/2020_JNU_Algorithm_Study/blob/main/week3/2565_dhwhc0711.cpp)
* 이 문제를 통해서 dp에 대한 개념을 다시 복습하기 좋았다고 생각합니다. **Top-Bottom , Bottom-Up** 방식 둘다로 풀이해봤습니다.
* 처음에는 전봇대의 번호에 맞는 index가 필요하다고 생각했으나 어차피 sort를 통해 index는 오름차순으로 정리가 가능하기 때문에 필요하지 않았습니다.
  * ex) 전깃줄의 번호가 1,3,5 인 경우 어차피 오름차순이므로 0,1,2의 Index로도 구별이 가능합니다
* pair 를 이용해 vector 를 구성했는데, sort시에 first 값으로 정렬되도록 구현되어 있어 사용해주었습니다.
* LCS 2 문제와 같이 인덱스의 마지막 값이 최댓값이 되는 줄 알았으나, 다른 경우였습니다. **dp 문제면 무조건 dp의 마지막 값이 max 값**이라고 생각했던 점을 고칠 수 있었습니다.

### [3085 사탕 게임](https://github.com/ProgWon/2020_JNU_Algorithm_Study/blob/main/week3/3085_dhwhc0711.cpp)


### [9252 LCS 2](https://github.com/ProgWon/2020_JNU_Algorithm_Study/blob/main/week3/9252_dhwhc0711.cpp)
* 2차원 벡터의 테이블에서 문자가 같으면 1을 추가하고, 만약 문자가 다른 경우에 왼쪽 값과 위 값의 최댓값을 기입해주도록 해서 길이를 구할 수 있었습니다.
* LCS 문자열을 찾는 부분에서 어려움을 겪었는데 문자가 추가되는 상황을 역추적(backtrack) 하여 찾을 수 있었습니다.
* 역추적
  * 새롭게 추가된 문자의 경우 숫자가 + 된다. 
  * 추가되지 않은 경우에는 +되지 않고 숫자가 같거나 클 수 있다.
  * 역추적 구현 방식
    * 왼쪽과 위 방향중에 같은 숫자가 있는지 찾는다. 
    * 만약 같은 숫자가 있다면 이동하고 i 나 j 값을 -1 해준다.
    * 위 케이스가 아닌 경우는 문자가 같은 케이스이므로 답에 문자를 더해주고 i 와 j 전부 -1 해준다.
* 구현에서는 별로 시간을 잡아 먹지 않았지만 인덱스 실수로 인해서 많은 시간을 허비한 문제였습니다. 
* LCS 벡터를 구현하는 경우 맨 앞의 문자를 0으로 두어 문자열의 길이 +1의 인덱스를 가지는 것을 착각해 인덱스 오류가 발생했습니다.

### [12865 평범한 배낭](https://github.com/ProgWon/2020_JNU_Algorithm_Study/blob/main/week3/12865_dhwhc0711.cpp)


### 기록하고 싶은 내용

***
 
## spacein1001

### [2565 전깃줄](https://github.com/ProgWon/2020_JNU_Algorithm_Study/blob/main/week3/2565_spacein1001.java)


### [3085 사탕 게임](https://github.com/ProgWon/2020_JNU_Algorithm_Study/blob/main/week3/3085_spacein1001.java)


### [9252 LCS 2](https://github.com/ProgWon/2020_JNU_Algorithm_Study/blob/main/week3/9252_spacein1001.java)

### [12865 평범한 배낭](https://github.com/ProgWon/2020_JNU_Algorithm_Study/blob/main/week3/12865_spacein1001.java)

### 기록하고 싶은 내용

***
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
### [9252 LCS 2](https://github.com/ProgWon/2020_JNU_Algorithm_Study/blob/main/week3/9252_noble5712.java)
* 학부때 LCS를 이론으로만 배워 실제로 구현하는 것이 처음이여서 꽤 어려웠습니다.
* 그냥 LCS의 크기를 세는것 이었으면 좀 더 간단했을텐데, LCS의 문장을 출력해주기위해 거꾸로 연산하여 문자를 판별해주는 과정이 어려웠습니다.
 * 문장을 출력하기 위해 행렬의 마지막부터 탐색하며 왼쪽과 위쪽을 탐색하며, 대각선으로 증가하는 경우에 스택에 넣어주고, 스택을 순차적으로 빼주었습니다.
### [12865 평범한 배낭](https://github.com/ProgWon/2020_JNU_Algorithm_Study/blob/main/week3/12865_noble5712.java)


### 기록하고 싶은 내용
* Arrays.sort 메소드의 경우 2차원배열의 정렬을 지원하지않아 Comparator를 사용해서 정렬 했어야 했는데 Comparator와 Comparable의 경우 예전에 한번 공부한 적이 있음에도, 오랜만에 보니 낯설었습니다. 좀 더 공부할 기회를 얻은것 같습니다.
* DP의 문제를 많이 풀어보지 못해 약한 모습을 보이는 것 같아, 추후에 개인적으로 복습을 해야 할 주차 였습니다.
