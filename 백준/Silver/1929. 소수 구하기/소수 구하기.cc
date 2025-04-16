#include <bits/stdc++.h>
using namespace std;

bool check(int n) {
    if (n <= 1)
        return 0;
    if (n == 2)
        return 1;
    if(n % 2 == 0)
        return 0;
    for(int i = 2; i * i <= n; i++)
        if(n % i == 0)
            return 0;
    return 1;
}

int main() {
    int LB = 0, UB = 0;
    scanf("%d %d", &LB, &UB);

    for(int i = LB; i <= UB; i++) {
        if(check(i))
            printf("%d\n", i);
    }

    return 0;
}