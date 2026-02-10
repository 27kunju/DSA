package MultiThreading;

import java.util.*;
import java.util.concurrent.*;

public class CallableDemo {

    public static void main(String[] args) {

        List<String> stocks = Arrays.asList("ABC", "PSH", "EFV", "USR");
        List<Future<Double>> futures = new ArrayList<>();

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        for (String stock : stocks) {
            Callable<Double> task = new StockPriceFetcher(stock);
            Future<Double> future = executorService.submit(task);
            futures.add(future);
        }

        executorService.shutdown();

        for (int i = 0; i < stocks.size(); i++) {
            try {
                Double price = futures.get(i).get(); // blocking call
                System.out.println("Stock: " + stocks.get(i) + ", Price: " + price);
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
    }
}

class StockPriceFetcher implements Callable<Double> {

    private final String stockSymbol;

    public StockPriceFetcher(String stockSymbol) {
        this.stockSymbol = stockSymbol;
    }

    @Override
    public Double call() throws Exception {
        Thread.sleep(8000); // simulate API call
        return Math.random() * 1000;
    }
}
