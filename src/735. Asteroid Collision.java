/*
// Using stack to store integer
case 1: input larger than 0
    push into stack
case 2: input smaller pr equal than 0
    if value of input is smaller than peek:
        loop until it disappears;
    if value of input is equal with peek:
        they vanish together;
    if stack is empty or peek smaller than zero
        push into stack
*/

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> s = new Stack<>();
        for (int i: asteroids) {
            if (i > 0) {
                s.push(i);
            } else {
                while (!s.empty() && s.peek() > 0 && s.peek() < -i) {
                    s.pop();
                }
                if (!s.empty() && s.peek() > 0 && s.peek() == -i) {
                    s.pop();
                } else if (s.empty() || s.peek() < 0) {
                    s.push(i);
                }
            }

        }

        int[] res = new int[s.size()];
        for (int i = res.length - 1; i >= 0; i--) {
            res[i] = s.pop();
        }
        return res;
    }
}