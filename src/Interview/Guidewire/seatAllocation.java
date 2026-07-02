package Interview.Guidewire;

import java.util.*;

public class seatAllocation {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {

        Map<Integer, Set<Integer>> map = new HashMap<>();

        // Store reserved seats row-wise
        for (int[] seat : reservedSeats) {
            map.computeIfAbsent(seat[0], k -> new HashSet<>()).add(seat[1]);
        }

        // Rows without any reserved seats
        int result = (n - map.size()) * 2;

        // Process only rows having reserved seats
        for (Set<Integer> reserved : map.values()) {

            boolean left =
                    !reserved.contains(2) &&
                            !reserved.contains(3) &&
                            !reserved.contains(4) &&
                            !reserved.contains(5);

            boolean middle =
                    !reserved.contains(4) &&
                            !reserved.contains(5) &&
                            !reserved.contains(6) &&
                            !reserved.contains(7);

            boolean right =
                    !reserved.contains(6) &&
                            !reserved.contains(7) &&
                            !reserved.contains(8) &&
                            !reserved.contains(9);

            if (left && right) {
                result += 2;
            } else if (left || middle || right) {
                result += 1;
            }
        }

        return result;
    }

    public int maxNumberOfFamilies(int N, String S) {

        // Row -> Reserved seat letters
        Map<Integer, Set<Character>> map = new HashMap<>();

        if (S == null || S.trim().isEmpty()) {
            return N * 2;
        }

        String[] seats = S.split(" ");

        for (String seat : seats) {

            int row = Integer.parseInt(seat.substring(0, seat.length() - 1));
            char col = seat.charAt(seat.length() - 1);

            map.computeIfAbsent(row, k -> new HashSet<>()).add(col);
        }

        int result = (N - map.size()) * 2;

        for (Set<Character> reserved : map.values()) {

            boolean left =
                    !reserved.contains('B') &&
                            !reserved.contains('C') &&
                            !reserved.contains('D') &&
                            !reserved.contains('E');

            boolean middle =
                    !reserved.contains('D') &&
                            !reserved.contains('E') &&
                            !reserved.contains('F') &&
                            !reserved.contains('G');

            boolean right =
                    !reserved.contains('F') &&
                            !reserved.contains('G') &&
                            !reserved.contains('H') &&
                            !reserved.contains('J');

            if (left && right) {
                result += 2;
            } else if (left || middle || right) {
                result += 1;
            }
        }

        return result;
    }
}
