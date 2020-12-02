#include <iostream>
#include <stack>
#include <string>

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
    string s;
    cin >> s;
    int stick = 1;
    int answer = 0;
    stack<char> stk;
    stk.push(s[0]);

    for (int i = 1; i < s.size(); i++)
    {
        if (s[i] == '(')
        {
            stick++;
        }

        else if (s[i] == ')')
        {
            stick--;

            if (stk.top() == '(')
            {
                answer += stick;
            }

            else
            {
                answer++;
            }
        }
        stk.push(s[i]);
    }

    cout << answer;
}