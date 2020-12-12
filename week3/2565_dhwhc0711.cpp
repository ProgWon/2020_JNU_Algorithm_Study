#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int N = 0;

void init()
{
    ios_base ::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
}

// Top - down 방식의 풀이
int recur(int n, vector<pair<int, int>> wire, int dp[])
{
    if (dp[n] == 0)
    {
        dp[n] = 1;

        for (int i = n + 1; i < N; i++)
        {
            if (wire[n].second < wire[i].second)
            {
                dp[n] = max(dp[n], recur(i, wire, dp) + 1);
            }
        }
    }
    return dp[n];
}

int main(void)
{
    init();
    int A, B;
    vector<pair<int, int>> wire;
    cin >> N;
    int dp[501] = {
        0,
    };

    for (int i = 0; i < N; i++)
    {
        cin >> A >> B;
        wire.push_back(make_pair(A, B));
    }

    sort(wire.begin(), wire.end());
    int answer = -1;
    // bottom - up 방식의 풀이
    for (int i = 0; i < N; i++)
    {
        answer = max(answer, recur(i, wire, dp));
    }

    for (int i = 0; i < N; i++)
    {
        dp[i] = 1;

        for (int j = 0; j < i; j++)
        {
            if (wire[i].second > wire[j].second)
            {
                dp[i] = max(dp[i], dp[j] + 1);
            }
        }
    }

    int answer = -1;

    for (int i = 0; i < N; i++)
    {
        answer = max(answer, dp[i]);
    }

    cout << N - answer;
}