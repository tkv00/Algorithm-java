# [level 2] 물고기 종류 별 잡은 수 구하기 - 293257 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/293257) 

### 성능 요약

메모리: undefined, 시간: 

### 구분

코딩테스트 연습 > GROUP BY

### 채점결과

합계: 100.0 / 100.0

### 제출 일자

2025년 07월 17일 04:37:08

### 문제 설명

<p>낚시앱에서 사용하는 <code>FISH_INFO</code> 테이블은 잡은 물고기들의 정보를 담고 있습니다. <code>FISH_INFO</code> 테이블의 구조는 다음과 같으며 <code>ID</code>, <code>FISH_TYPE</code>, <code>LENGTH</code>, <code>TIME</code>은 각각 잡은 물고기의 ID, 물고기의 종류(숫자), 잡은 물고기의 길이(cm), 물고기를 잡은 날짜를 나타냅니다. </p>
<table class="table">
        <thead><tr>
<th>Column name</th>
<th>Type</th>
<th>Nullable</th>
</tr>
</thead>
        <tbody><tr>
<td>ID</td>
<td>INTEGER</td>
<td>FALSE</td>
</tr>
<tr>
<td>FISH_TYPE</td>
<td>INTEGER</td>
<td>FALSE</td>
</tr>
<tr>
<td>LENGTH</td>
<td>FLOAT</td>
<td>TRUE</td>
</tr>
<tr>
<td>TIME</td>
<td>DATE</td>
<td>FALSE</td>
</tr>
</tbody>
      </table>
<p>단, 잡은 물고기의 길이가 10cm 이하일 경우에는 <code>LENGTH</code> 가 NULL 이며, <code>LENGTH</code> 에 NULL 만 있는 경우는 없습니다.</p>

<p><code>FISH_NAME_INFO</code> 테이블은 물고기의 이름에 대한 정보를 담고 있습니다. <code>FISH_NAME_INFO</code> 테이블의 구조는 다음과 같으며, <code>FISH_TYPE</code>, <code>FISH_NAME</code> 은 각각 물고기의 종류(숫자), 물고기의 이름(문자) 입니다.</p>
<table class="table">
        <thead><tr>
<th>Column name</th>
<th>Type</th>
<th>Nullable</th>
</tr>
</thead>
        <tbody><tr>
<td>FISH_TYPE</td>
<td>INTEGER</td>
<td>FALSE</td>
</tr>
<tr>
<td>FISH_NAME</td>
<td>VARCHAR</td>
<td>FALSE</td>
</tr>
</tbody>
      </table>
<hr>

<h5>문제</h5>

<p><code>FISH_NAME_INFO</code>에서 물고기의 종류 별 물고기의 이름과 잡은 수를 출력하는 SQL문을 작성해주세요.</p>

<p>물고기의 이름 컬럼명은 <code>FISH_NAME</code>, 잡은 수 컬럼명은 <code>FISH_COUNT</code>로 해주세요.<br>
결과는  잡은 수 기준으로 내림차순 정렬해주세요.</p>

<hr>

<p><code>FISH_INFO</code> 테이블이 다음과 같고</p>
<table class="table">
        <thead><tr>
<th>ID</th>
<th>FISH_TYPE</th>
<th>LENGTH</th>
<th>TIME</th>
</tr>
</thead>
        <tbody><tr>
<td>0</td>
<td>0</td>
<td>13.37</td>
<td>2021/12/04</td>
</tr>
<tr>
<td>1</td>
<td>0</td>
<td>50</td>
<td>2020/03/07</td>
</tr>
<tr>
<td>2</td>
<td>0</td>
<td>40</td>
<td>2020/03/07</td>
</tr>
<tr>
<td>3</td>
<td>1</td>
<td>43.33</td>
<td>2022/03/09</td>
</tr>
<tr>
<td>4</td>
<td>1</td>
<td>NULL</td>
<td>2022/04/08</td>
</tr>
<tr>
<td>5</td>
<td>2</td>
<td>32</td>
<td>2020/04/28</td>
</tr>
</tbody>
      </table>
<p><code>FISH_NAME_INFO</code>  테이블이 다음과 같다면</p>
<table class="table">
        <thead><tr>
<th>FISH_TYPE</th>
<th>FISH_NAME</th>
</tr>
</thead>
        <tbody><tr>
<td>0</td>
<td>BASS</td>
</tr>
<tr>
<td>1</td>
<td>SNAPPER</td>
</tr>
<tr>
<td>2</td>
<td>ANCHOVY</td>
</tr>
</tbody>
      </table>
<p>종류가 0인 물고기는 3마리, 1인 물고기는 2마리, 2인 물고기는 1마리를 잡았으며, 각각 이름이 'BASS', 'SNAPPER', 'ANCHOVY' 입니다. 따라서 잡은 수를 기준으로 내림차순 정렬하면 결과는 다음과 같습니다.</p>
<table class="table">
        <thead><tr>
<th>FISH_COUNT</th>
<th>FISH_NAME</th>
</tr>
</thead>
        <tbody><tr>
<td>3</td>
<td>BASS</td>
</tr>
<tr>
<td>2</td>
<td>SNAPPER</td>
</tr>
<tr>
<td>1</td>
<td>ANCHOVY</td>
</tr>
</tbody>
      </table>

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges