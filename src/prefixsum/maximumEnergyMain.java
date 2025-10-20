package prefixsum;

public class maximumEnergyMain {
    public static void main(String[] args) {
        int[] energy = {-2,-3,-1};
        int k = 2;
        System.out.println(maximumEnergy(energy,k));

    }
    public static int maximumEnergy(int[] energy, int k) {
        int max = Integer.MIN_VALUE;
        int n = energy.length;

        for (int i = 0; i < n; i++) {
            int currIndex = i;
            int currEnergy = 0;

            while (currIndex < n) {
                currEnergy += energy[currIndex];
                currIndex += k;
            }

            if (currEnergy > max) {
                max = currEnergy;
            }
        }

        return max;
    }
}
