#include <iostream>
#include <queue>
#include <vector>
#include <stack>
using namespace std;
int N, M;

// 격자 이동 좌표
int mx[4] = {0, 0, 1, -1};
int my[4] = {1, -1, 0, 0};
int cnt = 0;

void init()
{
    ios_base ::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
}

void dfs(int r, int c, vector<vector<int>> &map)
{

    map[r][c] = 1;
    cnt++;

    for (int i = 0; i < 4; i++)
    {
        int nr = r + mx[i];
        int nc = c + my[i];

        // 격자를 넘어서는 경우 넘어가기
        if (nr < 0 || nc < 0 || nr >= M || nc >= N)
        {
            continue;
        }

        // DFS 탐색
        if (map[nr][nc] == 0)
        {
            dfs(nr, nc, map);
        }
    }
}

int main()
{
    init();
    int K;
    cin >> M >> N >> K;
    vector<vector<int>> map(M, vector<int>(N, 0));
    vector<int> answer;

    // 모눈종이에 직사각형 그리기
    for (int i = 0; i < K; i++)
    {
        int x1, x2, y1, y2;
        cin >> x1 >> y1 >> x2 >> y2;

        for (int j = y1; j < y2; j++)
        {
            for (int k = x1; k < x2; k++)
            {
                map[j][k] = 1;
            }
        }
    }

    // 격자 탐색하기
    for (int i = 0; i < M; i++)
    {
        for (int j = 0; j < N; j++)
        {
            if (map[i][j] == 0)
            {
                cnt = 0;
                dfs(i, j, map);
                answer.push_back(cnt);
            }
        }
    }

    // 정렬해주기
    sort(answer.begin(), answer.end());
    cout << answer.size() << "\n";

    for (auto idx : answer)
    {
        cout << idx << " ";
    }
}