package greedy;

public class gasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0,totalCost = 0;
        for(int i =0;i<gas.length;i++){
            totalGas +=gas[i];
            totalCost += cost[i];
        }

        if(totalGas <totalCost){
            return -1;
        }

        int currentGas = 0,startIndex = 0;
        for(int i = 0;i<gas.length;i++){
            currentGas +=gas[i] -cost[i];
            if(currentGas <0){
                startIndex = i+1;
                currentGas  =0;
            }
        }

        return startIndex;
    }

    /*
    If we fail at index i, none of the stations before i can be a valid start.
    So we reset startIndex to i+1.Since total gas is sufficient, the final startIndex will complete the circuit.
     */

}
