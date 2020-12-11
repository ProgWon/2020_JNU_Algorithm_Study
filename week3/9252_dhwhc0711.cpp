#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

void init()
{
    ios_base ::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
}
int main(void)
{
    init();
    string s1, s2;
    string answer = "";
    cin >> s1 >> s2;
    vector<vector<int>> v(s1.size() + 1, vector<int>(s2.size() + 1, 0));

    for (int i = 1; i <= s1.size(); i++)
    {
        for (int j = 1; j <= s2.size(); j++)
        {
            if (s1[i - 1] == s2[j - 1])
            {
                v[i][j] = v[i - 1][j - 1] + 1;
            }
            else
            {
                v[i][j] = max(v[i][j - 1], v[i - 1][j]);
            }
        }
    }

    int i = s1.size();
    int j = s2.size();

    while (i != 0 && j != 0)
    {
        // 역추적에서 새롭게 추가된 문자의 경우 1이 추가되는것을 이용한 풀이
        if (v[i][j] == v[i - 1][j])
        {
            i--;
        }
        else if (v[i][j] == v[i][j - 1])
        {
            j--;
        }
        else
        {
            answer += s1[i - 1];
            i--;
            j--;
        }
    }

    cout << v[s1.size()][s2.size()] << "\n";

    for (int i = answer.size() - 1; i >= 0; i--)
    {
        cout << answer[i];
    }
}