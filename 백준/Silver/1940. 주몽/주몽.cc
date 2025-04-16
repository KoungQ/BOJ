#include <bits/stdc++.h>

using namespace std;

int main() {
	int n, m, cnt = 0;
	cin >> n >> m;

	int* UniqNum = new int[n];
	for (int i = 0; i < n; i++)
		cin >> UniqNum[i];
	
	for (int i = 0; i < n - 1; i++) {
		for (int j = i + 1; j < n; j++) {
			if (UniqNum[i] + UniqNum[j] == m)
				cnt++;
		}
	}

	cout << cnt << "\n";

	return 0;
}