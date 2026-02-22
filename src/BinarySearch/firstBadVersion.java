package BinarySearch;

public class firstBadVersion {
    public int firstBadVersion2(int n) {
        int l = 1;
        int r = n;
        int ans = n;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (isBadVersion(mid)) {
                ans = mid;      // possible first bad
                r = mid - 1;    // search left
            } else {
                l = mid + 1;    // search right
            }
        }
        return ans;
    }

    public boolean isBadVersion(int mid){

        return true;
    }
}
