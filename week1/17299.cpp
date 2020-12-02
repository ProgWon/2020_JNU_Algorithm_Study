#include <iostream>
#include <stack>
#include <vector>
#include <unordered_map>

using namespace std;

void init()
{
    ios_base ::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
}

int main()
{
    init();

    int N, A;
    unordered_map<int, int> map;
    stack<pair<int, int>> stk;
    cin >> N;
    vector<int> num(N, 0);

    for (int i = 0; i < N; i++)
    {
        cin >> A;
        num[i] = A;
        map[A]++;
    }

    stk.push(make_pair(0, map[num[0]]));

    for (int i = 1; i < N; i++)
    {
        int check = map[num[i]];

        while (!stk.empty())
        {
            if (stk.top().second < check)
            {
                num[stk.top().first] = num[i];
                stk.pop();
            }

            else
                break;
        }

        stk.push(make_pair(i, check));
    }

    while (!stk.empty())
    {
        num[stk.top().first] = -1;
        stk.pop();
    }

    for (int i = 0; i < num.size(); i++)
    {
        cout << num[i] << " ";
    }
}