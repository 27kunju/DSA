package Stream;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class StreamProductMain {
    public static void main(String[] args) {
        Product p1 = new Product(1L, "baby", "Toys", 100.0);
        Product p2 = new Product(2L, " James Bond", "Books", 150.0);
        Product p3 = new Product(3L, "car1", "Baby", 106.0);
        Product p4 = new Product(4L, "carBook", "Books", 300.0);
        Product p5 = new Product(5L, "car2", "Baby", 200.0);

        List<Product> prodlist = new ArrayList<>();
        prodlist.add(p1);
        prodlist.add(p2);
        prodlist.add(p3);
        prodlist.add(p4);
        prodlist.add(p5);

        Customer c1 = new Customer(1L, "Mahesh", 1);
        Customer c2 = new Customer(2L, "Rajesh", 2);

        Order o1 = new Order(1L, "confirm", LocalDate.of(2021, 03, 15), LocalDate.now(), prodlist, c1);
        Order o2 = new Order(2L, "pending", LocalDate.of(2021, 02, 02), LocalDate.now(), prodlist, c2);
        Order o3 = new Order(3L, "pending", LocalDate.of(2021, 02, 04), LocalDate.now(), Arrays.asList(p1, p2), c1);

        List<Order> ordersList = Arrays.asList(o1, o2, o3);

        List<Product> booKs = prodlist.stream().filter(p -> p.getCategory().equals("Books") && p.getPrice() > 100).toList();
        List<Order> orders = ordersList.stream().filter( o-> o.getProductsList().stream().anyMatch(p->p.getCategory().equals("Baby"))).toList();
//        System.out.println(orders.toString());
//        System.out.println(booKs);

        List<Product> priceDiscount = prodlist.stream()
                .filter(p -> p.getCategory().equals("Toys"))
                .map(e -> new Product(e.getId(), e.getName(), e.getCategory(), e.getPrice() - 0.1 * e.getPrice()))
                .toList();
//        System.out.println(priceDiscount);

        LocalDate start = LocalDate.of(2021, 2, 1);
        LocalDate end = LocalDate.of(2021, 4, 1);

        List<Product> productsOrdered = ordersList.stream()
                .filter(o -> o.getCustomer().getTier() == 2) // customer tier 2
                .filter(o -> !o.getOrderDate().isBefore(start) && !o.getOrderDate().isAfter(end)) // date between start & end
                .flatMap(o -> o.getProductsList().stream()) // extract products
                .distinct() // remove duplicates if needed
                .toList();
//        System.out.println(productsOrdered);

        Product p = prodlist.stream()
                .filter(e -> e.getCategory().equals("Books"))
                .min(Comparator.comparing(Product::getPrice))
                .orElse(null); // returns null if no book found

//        System.out.println(p);

        List<Order> orders1 = ordersList.stream().sorted(Comparator.comparing(Order::getOrderDate).reversed()).limit(3).toList();

//        System.out.println(orders1);

        List<Product> recentProducts = ordersList.stream().filter(o -> o.getOrderDate().isEqual(LocalDate.of(2021,03,15)))
                .peek(System.out::println).flatMap(o -> o.getProductsList().stream()).toList();

//        System.out.println(recentProducts);

        double sum = ordersList.stream().filter(o->
                o.getOrderDate().isAfter(LocalDate.of(2021,02,01)) && o.getOrderDate().isBefore(LocalDate.of(2021,02,28)))
                .flatMap(o -> o.getProductsList().stream()).mapToDouble(Product::getPrice).sum();

//        System.out.println(sum);

        double avgOrderValue = ordersList.stream()
        .filter(o -> o.getOrderDate().isEqual(LocalDate.of(2021,03,15)))
                .flatMap(o ->o.getProductsList().stream()).mapToDouble(Product::getPrice).average().orElse(0.0);

//        System.out.println(avgOrderValue);

        Map<Long, Integer> mapOrders = ordersList.stream().collect(Collectors.toMap(Order::getId, o->o.getProductsList().size()));

        Map<Long, Integer> mapOrders2 = ordersList.stream()
                .collect(Collectors.groupingBy(
                        Order::getId,                              // group by order id
                        Collectors.summingInt(o -> o.getProductsList().size()) // count products
                ));

        System.out.println(mapOrders);

        ordersList.stream().collect(Collectors.groupingBy(Order::getCustomer)).entrySet().forEach(System.out::println);

        Map<Order,Double> orderSum = ordersList.stream().collect(Collectors.toMap(o->o, o->o.getProductsList().stream().mapToDouble(Product::getPrice).sum()));

        System.out.println(orderSum);

        Map<String, List<String>> mapData = prodlist.stream()
                .collect(Collectors.groupingBy(
                        Product::getCategory,
                        Collectors.mapping(Product::getName, Collectors.toList())
                ));

        System.out.println(mapData);

        Map<String, List<String>> productsByCategory =
                prodlist.stream()
                        .collect(Collectors.groupingBy(
                                Product::getCategory,
                                Collectors.mapping(Product::getName, Collectors.toList())
                        ));

        System.out.println(productsByCategory);

        Map<String, Product> mostExpensiveByCategory =
                prodlist.stream()
                        .collect(Collectors.groupingBy(
                                Product::getCategory,
                                Collectors.collectingAndThen(
                                        Collectors.maxBy(Comparator.comparing(Product::getPrice)),
                                        Optional::get
                                )
                        ));
        System.out.println(mostExpensiveByCategory);

        Map<String, Optional<Product>> mostExpensiveByCategoryOpt =
                prodlist.stream()
                        .collect(Collectors.groupingBy(
                                Product::getCategory,
                                Collectors.maxBy(Comparator.comparing(Product::getPrice))
                        ));
        System.out.println(mostExpensiveByCategoryOpt);

        Map<String, List<Product>> top3ByCategory =
                prodlist.stream()
                        .collect(Collectors.groupingBy(
                                Product::getCategory,
                                Collectors.collectingAndThen(
                                        Collectors.toList(),
                                        list -> list.stream()
                                                .sorted(Comparator.comparing(Product::getPrice).reversed())
                                                .limit(3)
                                                .toList()
                                )
                        ));

        System.out.println(top3ByCategory);


    }
}
