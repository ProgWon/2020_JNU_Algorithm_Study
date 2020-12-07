#include <iostream>
#include <queue>
#include <unordered_map>
#include <algorithm>
using namespace std;
int m, n;
int cnt;
int room_num = 0;
int mx[4] = {0, -1, 0, 1};
int my[4] = {-1, 0, 1, 0};
unordered_map<int, int> room_area_sum;
int max_area = 0;

void bfs(int r, int c, vector<vector<int>> &map, vector<vector<int>> &room)
{
    queue<pair<int, int>> q;
    room_num++;
    room[r][c] = room_num;
    q.push(make_pair(r, c));

    while (!q.empty())
    {
        r = q.front().first;
        c = q.front().second;
        q.pop();

        for (int i = 0; i < 4; i++)
        {
            int nr = r + mx[i];
            int nc = c + my[i];

            if (nr < 0 || nc < 0 || nr >= m || nc >= n)
            {
                continue;
            }

            if (room[nr][nc] == 0 && (map[r][c] & (1 << i)) == 0)
            {
                room[nr][nc] = room_num;
                q.push(make_pair(nr, nc));
                cnt++;
            }
        }
    }
}

void breakWall(int r, int c, vector<vector<int>> &map, vector<vector<int>> &room)
{
    for (int i = 0; i < 4; i++)
    {
        int nr = r + mx[i];
        int nc = c + my[i];

        if (nr < 0 || nc < 0 || nr >= m || nc >= n)
        {
            continue;
        }

        if ((map[r][c] & (1 << i)) && (room[r][c] != room[nr][nc]))
        {
            int sum = room_area_sum[room[r][c]] + room_area_sum[room[nr][nc]];
            max_area = max(max_area, sum);
        }
    }
}

int main()
{
    cin >> n >> m;
    vector<vector<int>> map(m, vector<int>(n, 0));
    vector<vector<int>> room(m, vector<int>(n, 0));

    vector<int> answer;

    // map 에 값을 할당
    for (int i = 0; i < m; i++)
    {
        for (int j = 0; j < n; j++)
        {
            cin >> map[i][j];
        }
    }

    // map 전체를 순회하며 bfs를 돌릴지 말지 판단
    for (int i = 0; i < m; i++)
    {
        for (int j = 0; j < n; j++)
        {
            if (room[i][j] == 0)
            {
                cnt = 1;
                bfs(i, j, map, room);
                answer.push_back(cnt);
                room_area_sum.insert(make_pair(room_num, cnt));
            }
        }
    }

    // 벽을 부순 최댓값을 찾기
    for (int i = 0; i < m; i++)
    {
        for (int j = 0; j < n; j++)
        {
            breakWall(i, j, map, room);
        }
    }

    sort(answer.begin(), answer.end());
    cout << answer.size() << "\n";
    cout << answer.back() << "\n";
    cout << max_area;
}