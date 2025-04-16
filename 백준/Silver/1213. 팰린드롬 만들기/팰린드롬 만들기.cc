#include <bits/stdc++.h>

using namespace std;

int main() {
	int alphaCnt[26] = { 0, };
	int oddCnt = 0;
	char odd;
	string input;
	string ret;
	cin >> input;

	for (int i = 0; input[i] != '\0'; i++) {
		alphaCnt[input[i] - 65]++;
	}
	for (int i = 0; i < 26; i++) {
		if ((alphaCnt[i] % 2) != 0) {
			oddCnt++;
			odd = i + 65;
		}
	}
	
	if (input.size() % 2 != 0) {
		if (oddCnt > 1) {
			cout << "I'm Sorry Hansoo" << "\n";
			return 0;
		}

		int idx = 0;
		string alpha = "A";
		alphaCnt[odd - 65]--;
		for (int i = 0; i < 26; i++) {
			while (alphaCnt[i] != 0) {
				ret.insert(idx, alpha);
				ret.insert(idx, alpha);

				idx++;
				alphaCnt[i] -= 2;
			}
			alpha[0]++;
		}
		string oddStr;
		oddStr += odd;
		ret.insert(idx, oddStr);

	} // 문자열 길이가 홀수일 때
	else {
		if (oddCnt > 0) {
			cout << "I'm Sorry Hansoo" << "\n";
			return 0;
		}
		
		int idx = 0;
		string alpha = "A";
		for (int i = 0; i < 26; i++) {
			while (alphaCnt[i] != 0) {
				ret.insert(idx, alpha);
				ret.insert(idx, alpha);
				
				idx++;
				alphaCnt[i] -= 2;
			}
			alpha[0]++;
		}

	} // 문자열 길이가 짝수일 때

	cout << ret;

	return 0;
}