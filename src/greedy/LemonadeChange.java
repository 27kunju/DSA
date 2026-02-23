package greedy;

public class LemonadeChange {
    public boolean lemonadeChange(int[] bills) {
        int five = 0;
        int ten = 0;

        for (int bill : bills) {
            if (bill == 5) {
                five++;
            }
            else if (bill == 10) {
                if (five == 0) return false;
                five--;
                ten++;
            }
            else { // bill == 20
                if (ten > 0 && five > 0) {
                    ten--;
                    five--;
                } else if (five >= 3) {
                    five -= 3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
    /*

    We only track $5 and $10 because:

    $5 is required for every change

    $10 helps optimize change for $20

    $20 is never used for change
    Customer pays $20
    Change needed = $15
    How can we give $15?
    There are only two valid combinations:
    $10 + $5 (best option)
    $5 + $5 + $5
    You never give $20 as change, so storing $20 is useless.
    Why prefer $10 + $5 over 3 × $5?
    Because $5 notes are more valuable for future customers.
    Example:
    If you use 3 × $5 today,
    tomorrow a $10 customer may come and you’ll be stuck.So greedy rule:
    For $20: - Use $10 + $5 if possible
             - Else use 3 × $5
             - Else return false
     */
}
