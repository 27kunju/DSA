package Stack;

import java.util.*;

public class astroidsCollision {


        public int[] asteroidCollision(int[] asteroids) {

            Stack<Integer> stack = new Stack<>();

            for (int asteroid : asteroids) {

                while (!stack.isEmpty()
                        && stack.peek() > 0
                        && asteroid < 0
                        && stack.peek() < -asteroid) {

                    stack.pop();
                }

                if (!stack.isEmpty()
                        && stack.peek() > 0
                        && asteroid < 0) {

                    if (stack.peek() == -asteroid) {
                        stack.pop();
                    }

                    // Current asteroid destroyed
                } else {
                    stack.push(asteroid);
                }
            }

            int[] result = new int[stack.size()];

            for (int i = stack.size() - 1; i >= 0; i--) {
                result[i] = stack.pop();
            }

            return result;
        }

}
