# [level 1] 중요한 단어를 스포 방지 - 468370 

[문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/468370) 

### 성능 요약

메모리: 73.8 MB, 시간: 1.74 ms

### 구분

코딩테스트 연습 > 2025 카카오 하반기 1차

### 채점결과

정확성: 100.0<br/>합계: 100.0 / 100.0

### 제출 일자

2026년 04월 29일 14:06:01

### 문제 설명

<p>카카오톡은 메시지의 일부를 가려두었다가, 클릭했을 때만 공개되는 <strong>스포 방지</strong> 기능을 제공합니다. 이 기능을 활용하면 중요한 정보를 가리고 보낼 수 있습니다.</p>

<p>무지는 이 기능을 이용해 하나의 메시지 곳곳에 스포 방지 기능을 적용해 당신에게 보냈습니다. 당신은 메시지 시작부터 왼쪽 → 오른쪽 순서로 스포 방지 구간을 하나씩 클릭해 공개되는 단어들 중, 중요한 단어가 몇 개인지 확인하려 합니다.</p>

<p>단어 및 중요한 단어 규칙</p>

<ul>
<li>단어는 공백으로 구분되며, 알파벳 소문자와 숫자로만 구성된 연속된 문자열입니다.</li>
<li>단어를 구성하는 문자들의 인덱스 중 <strong>하나 이상</strong>이 스포 방지 구간에 포함될 경우, 해당 단어는 스포일러 방지 단어로 간주합니다. 즉, 단어 내 일부 문자에만 스포일러 방지 기능이 적용되더라도, 해당 단어 전체를 스포일러 방지 단어로 간주합니다.</li>
<li>한 단어가 여러 개의 스포 방지 구간에 걸쳐 있을 수 있으며, 하나의 스포 방지 구간에 여러 단어가 포함될 수 있습니다.</li>
<li>스포 방지 구간을 클릭해 단어의 모든 문자가 공개되었을 때, 그 단어가 아래 조건을 모두 만족하면 중요한 단어입니다.

<ol>
<li>스포 방지 단어여야 합니다.</li>
<li>메시지의 스포 방지 구간이 아닌 구간(= 어떤 스포 방지 구간에도 속하지 않는 모든 구간: 각 구간의 앞·사이·뒤 포함)에 등장한 적이 없어야 합니다.</li>
<li>이전에 공개된 스포 방지 단어와 중복되지 않아야 합니다.</li>
<li>여러 단어가 동시에 공개된 경우, 왼쪽부터 순서대로 하나씩 중요한 단어인지 판단합니다.</li>
</ol></li>
</ul>

<p>무지가 당신에게 보내온 메시지를 나타내는 문자열 <code>message</code>와 스포 방지가 적용된 구간을 나타내는 2차원 정수 배열 <code>spoiler_ranges</code>가 매개변수로 주어질 때, 스포 방지 단어 중 중요한 단어의 수를 return 하도록 solution 함수를 완성해 주세요.</p>

<hr>

<h5>제한사항</h5>

<ul>
<li>1 ≤ <code>message</code>의 길이 ≤ 20,000

<ul>
<li><code>message</code>는 알파벳 소문자, 숫자 그리고 공백으로 이루어져 있습니다.</li>
<li><code>message</code>는 하나 이상의 단어로 구성된 문자열입니다.</li>
<li>공백은 연속해서 등장하지 않습니다.</li>
</ul></li>
<li>1 ≤ <code>spoiler_ranges</code>의 길이 ≤ 1,000

<ul>
<li><code>spoiler_ranges[i]</code>는 [<code>start</code>, <code>end</code>] 형태로 스포 방지를 적용한 구간을 나타냅니다. 이때 <code>start</code>와 <code>end</code>는 문자 인덱스이며, 두 인덱스 모두 구간에 포함됩니다.</li>
<li>0 ≤ <code>start</code> ≤ <code>end</code> &lt; <code>message</code>의 길이</li>
<li>모든 구간은 서로 겹치지 않으며, <code>start</code> 기준으로 오름차순 정렬되어 주어집니다.</li>
</ul></li>
</ul>

<hr>

<h5>테스트 케이스 구성 안내</h5>

<p>아래는 테스트 케이스 구성을 나타냅니다. 각 그룹은 하나 이상의 하위 그룹으로 이루어져 있으며, 하위 그룹의 모든 테스트 케이스를 통과하면 해당 그룹에 할당된 점수를 획득할 수 있습니다.</p>
<table class="table">
        <thead><tr>
<th>그룹</th>
<th>총점</th>
<th>추가 제한 사항</th>
</tr>
</thead>
        <tbody><tr>
<td>#1</td>
<td>7%</td>
<td><code>message</code>의 모든 단어는 중복없이 한 번씩만 등장합니다.</td>
</tr>
<tr>
<td>#2</td>
<td>13%</td>
<td>모든 스포 방지 구간은 각각 정확히 한 단어의 시작과 끝을 가리킵니다. <code>spoiler_ranges</code>의 길이 = 1</td>
</tr>
<tr>
<td>#3</td>
<td>45%</td>
<td>모든 스포 방지 구간은 각각 정확히 한 단어의 시작과 끝을 가리킵니다.</td>
</tr>
<tr>
<td>#4</td>
<td>35%</td>
<td>추가 제한 사항 없음</td>
</tr>
</tbody>
      </table>
<hr>

<h5>입출력 예</h5>
<table class="table">
        <thead><tr>
<th>message</th>
<th>spoiler_ranges</th>
<th>result</th>
</tr>
</thead>
        <tbody><tr>
<td>"here is muzi here is a secret message"</td>
<td>[[0, 3], [23, 28]]</td>
<td>1</td>
</tr>
<tr>
<td>"my phone number is 01012345678 and may i have your phone number"</td>
<td>[[5, 5], [25, 28], [34, 40], [53, 59]]</td>
<td>4</td>
</tr>
</tbody>
      </table>
<hr>

<h5>입출력 예 설명</h5>

<p><strong>입출력 예 #1</strong></p>

<p><img src="https://grepp-programmers.s3.ap-northeast-2.amazonaws.com/production/presigned_urls/4a110964-5cd9-46e2-8591-6def901e7f34/ChatGPT%20Image%202025%E1%84%82%E1%85%A7%E1%86%AB%209%E1%84%8B%E1%85%AF%E1%86%AF%209%E1%84%8B%E1%85%B5%E1%86%AF%20%E1%84%8B%E1%85%A9%E1%84%92%E1%85%AE%2007_20_38%20%283%29.png" title="" alt="ChatGPT Image 2025년 9월 9일 오후 07_20_38 (3).png"><br>
스포 방지 처리된 채팅입니다.</p>

<p><img src="https://grepp-programmers.s3.ap-northeast-2.amazonaws.com/production/presigned_urls/123de199-421a-435b-8af0-bd4e9aea564f/ChatGPT%20Image%202025%E1%84%82%E1%85%A7%E1%86%AB%209%E1%84%8B%E1%85%AF%E1%86%AF%209%E1%84%8B%E1%85%B5%E1%86%AF%20%E1%84%8B%E1%85%A9%E1%84%92%E1%85%AE%2007_20_38%20%281%29.png" title="" alt="ChatGPT Image 2025년 9월 9일 오후 07_20_38 (1).png"><br>
첫 번째 스포 방지를 해제한 채팅입니다. 첫 번째 스포 방지 구간을 해제하면 단어 here이 공개됩니다. here은 스포 방지 구간이 아닌 영역에서 등장한 적 있습니다. 따라서 중요한 단어가 아닙니다.</p>

<p><img src="https://grepp-programmers.s3.ap-northeast-2.amazonaws.com/production/presigned_urls/034bbc86-4aea-44d8-91e5-39c8e6c8655e/ChatGPT%20Image%202025%E1%84%82%E1%85%A7%E1%86%AB%209%E1%84%8B%E1%85%AF%E1%86%AF%209%E1%84%8B%E1%85%B5%E1%86%AF%20%E1%84%8B%E1%85%A9%E1%84%92%E1%85%AE%2007_20_38.png" title="" alt="ChatGPT Image 2025년 9월 9일 오후 07_20_38.png"><br>
두 번째 스포 방지를 해제한 채팅입니다. 두 번째 스포 방지 구간을 해제하면 단어 secret이 공개됩니다. secret은 중요한 단어입니다.<br>
중요한 단어는 secret 하나뿐이므로 1을 return 해야 합니다.</p>

<p><strong>입출력 예 #2</strong></p>

<p><img src="https://grepp-programmers.s3.ap-northeast-2.amazonaws.com/production/presigned_urls/f0a3e8db-8894-4010-8c11-c7165638fadf/ChatGPT%20Image%202025%E1%84%82%E1%85%A7%E1%86%AB%209%E1%84%8B%E1%85%AF%E1%86%AF%2010%E1%84%8B%E1%85%B5%E1%86%AF%20%E1%84%8B%E1%85%A9%E1%84%8C%E1%85%A5%E1%86%AB%2012_48_32%20%286%29.png" title="" alt="ChatGPT Image 2025년 9월 10일 오전 12_48_32 (6).png"><br>
스포 방지 처리된 채팅입니다.</p>

<p><img src="https://grepp-programmers.s3.ap-northeast-2.amazonaws.com/production/presigned_urls/0e9c4b05-9980-48fa-84c3-a350c7c39940/ChatGPT%20Image%202025%E1%84%82%E1%85%A7%E1%86%AB%209%E1%84%8B%E1%85%AF%E1%86%AF%2010%E1%84%8B%E1%85%B5%E1%86%AF%20%E1%84%8B%E1%85%A9%E1%84%8C%E1%85%A5%E1%86%AB%2012_48_32%20%285%29.png" title="" alt="ChatGPT Image 2025년 9월 10일 오전 12_48_32 (5).png"><br>
첫 번째 스포 방지를 해제한 채팅입니다. 첫 번째 스포 구간을 해제하면 단어 phone이 공개됩니다. 이 단어는 스포 방지 구간이 아닌 구간에서 등장한 적이 없고 이전에 공개된 스포 방지 단어와 중복되지 않으므로 중요한 단어입니다.</p>

<p><img src="https://grepp-programmers.s3.ap-northeast-2.amazonaws.com/production/presigned_urls/6ab775db-f568-42a1-87dd-f8485a6aae01/ChatGPT%20Image%202025%E1%84%82%E1%85%A7%E1%86%AB%209%E1%84%8B%E1%85%AF%E1%86%AF%2010%E1%84%8B%E1%85%B5%E1%86%AF%20%E1%84%8B%E1%85%A9%E1%84%8C%E1%85%A5%E1%86%AB%2012_48_32%20%284%29.png" title="" alt="ChatGPT Image 2025년 9월 10일 오전 12_48_32 (4).png"><br>
두 번째 스포 방지를 해제한 채팅입니다. 두 번째 스포 구간을 해제하면 단어 01012345678이 공개됩니다. 이 단어는 중요한 단어입니다.</p>

<p><img src="https://grepp-programmers.s3.ap-northeast-2.amazonaws.com/production/presigned_urls/b6ae633a-0e8c-499d-8753-7a84e678aef5/ChatGPT%20Image%202025%E1%84%82%E1%85%A7%E1%86%AB%209%E1%84%8B%E1%85%AF%E1%86%AF%2010%E1%84%8B%E1%85%B5%E1%86%AF%20%E1%84%8B%E1%85%A9%E1%84%8C%E1%85%A5%E1%86%AB%2012_48_32%20%283%29.png" title="" alt="ChatGPT Image 2025년 9월 10일 오전 12_48_32 (3).png"></p>

<p>세 번째 스포 방지를 해제한 채팅입니다. 세 번째 스포 구간을 해제하면 단어 may, i가 공개됩니다. 두 단어 모두 중요한 단어입니다.</p>

<p><img src="https://grepp-programmers.s3.ap-northeast-2.amazonaws.com/production/presigned_urls/519d202d-eea0-4e47-b894-3b4ddd22ace0/ChatGPT%20Image%202025%E1%84%82%E1%85%A7%E1%86%AB%209%E1%84%8B%E1%85%AF%E1%86%AF%2010%E1%84%8B%E1%85%B5%E1%86%AF%20%E1%84%8B%E1%85%A9%E1%84%8C%E1%85%A5%E1%86%AB%2012_48_32.png" title="" alt="ChatGPT Image 2025년 9월 10일 오전 12_48_32.png"></p>

<p>마지막 스포 방지를 해제한 채팅입니다. 마지막 스포 구간을 해제하면 phone, number이 공개됩니다. 이 중 phone은 이전에 공개된 스포 방지 단어에 포함되어 있고 number은 스포 방지 구간이 아닌 영역에서 공개된 적이 있습니다. 따라서 중요한 단어가 아닙니다.</p>

<p>스포 방지가 적용된 단어 중 중요한 단어는 phone, 01012345678, may, i 4개입니다. 따라서 4를 return 해야 합니다.</p>


> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges