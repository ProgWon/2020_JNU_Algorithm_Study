#include <iostream>
#include <queue>
#include <vector>
#include <stack>
using namespace std;

void init()
{
    ios_base ::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
}

// stack 을 이용한 dfs 로 풀이
int dfs_stack(int start, int end, vector<vector<int>> &v, vector<int> &dist)
{
    stack<int> stk;
    stk.push(start);

    while (!stk.empty())
    {
        bool isConnected = false;
        int cur_node = stk.top();

        for (auto i = v[cur_node].begin(); i != v[cur_node].end(); i++)
        {
            int next_node = *i;

            if (dist[next_node] == 0)
            {
                isConnected = true;
                stk.push(next_node);
                dist[next_node] = dist[cur_node] + 1;

                if (next_node == end)
                    return dist[next_node];

                break;
            }
        }

        if (!isConnected)
            stk.pop();
    }

    return -1;
}

// 재귀를 이용한 dfs 풀이
void dfs(int start, int end, vector<vector<int>> &v, vector<int> &dist)
{
    int cur_node = start;

    for (int i = 0; i < v[cur_node].size(); i++)
    {
        int next_node = v[cur_node][i];

        if (dist[next_node] == 0)
        {
            dist[next_node] = dist[cur_node] + 1;
            dfs(next_node, end, v, dist);
        }
    }
}

// queue 를 이용한 bfs 풀이
int bfs(int start, int end, vector<vector<int>> &v, vector<int> dist)
{
    queue<int> q;
    q.push(start);

    while (!q.empty())
    {
        int cur_node = q.front();
        q.pop();

        for (int i = 0; i < v[cur_node].size(); i++)
        {
            int next_node = v[cur_node][i];

            if (dist[next_node] == 0)
            {
                q.push(next_node);
                dist[next_node] = dist[cur_node] + 1;
                if (next_node == end)
                    return dist[next_node];
            }
        }
    }

    return -1;
}

int main()
{
    init();

    int n, a1, a2, m, answer;

    cin >> n >> a1 >> a2 >> m;
    vector<vector<int>> v(n + 1);
    vector<int> dist(n + 1, 0);

    for (int i = 0; i < m; i++)
    {
        int x, y;
        cin >> x >> y;
        v[x].push_back(y);
        v[y].push_back(x);
    }

    cout << bfs(a1, a2, v, dist);
    cout << dfs_stack(a1, a2, v, dist);
    dfs(a1, a2, v, dist);
    cout << (dist[a2] == 0 ? -1 : dist[a2]);
}