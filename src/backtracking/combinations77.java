package backtracking;

import java.util.ArrayList;
import java.util.List;

public class combinations77 {

    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {

        solve(1,n,k, new ArrayList<>());

        return result;
    }

    public void solve(int index, int n, int k , List<Integer> temp ){

        if(k==0){
            result.add(new ArrayList<>(temp));
            return;
        }

        if(index> n){
            return;
        }

        for(int i = index; i<=n;i++){

            temp.add(i);

            solve(i+1,n,k-1, temp);

            temp.remove(temp.size()-1);

        }
    }
}
