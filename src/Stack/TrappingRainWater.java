package Stack;

import java.util.*;

public class TrappingRainWater {
    public static void main(String[] args) {
        int[] height = {3,0,0,2,0 , 4};
        System.out.println("Trapped Rain Water = " + trap2(height));
    }

    public static int trap(int[] height) {
        int n = height.length;
        Stack<Integer> st = new Stack<>();
        int ans = 0;

        for (int i = 0; i < n; i++) {
            // Process until stack has smaller height than current
            while (!st.isEmpty() && height[i] > height[st.peek()]) {
                int top = st.pop(); // Middle bar

                if (st.isEmpty()) break; // No left boundary

                int distance = i - st.peek() - 1; // Width between left and right
                int boundedHeight = Math.min(height[i], height[st.peek()]) - height[top];

                ans += distance * boundedHeight;
            }
            st.push(i);
        }
        return ans;
    }

    public static int trap2(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }

        int l = 0, r = height.length - 1;
        int leftMax = height[l], rightMax = height[r];
        int res = 0;
        while (l < r) {
            if (leftMax < rightMax) {
                l++;
                leftMax = Math.max(leftMax, height[l]);
                res += leftMax - height[l];
            } else {
                r--;
                rightMax = Math.max(rightMax, height[r]);
                res += rightMax - height[r];
            }
        }
        return res;
    }
}
