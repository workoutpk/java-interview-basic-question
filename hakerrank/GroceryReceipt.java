package hakerrank;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

//Create the 'GroceryReceipt' class that extends GroceryReceiptBase above.
class GroceryReceipt  extends GroceryReceiptBase {

    static int groceryPrice;
    Map<String, Integer> discounts;
    public GroceryReceipt(Map<String, Double> prices, Map<String, Integer> discounts) {
        super(prices, discounts);
        this.prices = prices;
        this.discounts = discounts;
        System.out.println("prices :: "+this.prices);
        System.out.println("discounts ::: "+this.discounts);

    }

    public List<Grocery> Calculate(List<Node> shoppingList) {


        List<Grocery>  listFinal = new LinkedList<>();
        for (Node node : shoppingList) {
            Double count = prices.get(node.fruit);
            int discount = discounts.get(node.fruit);
            double totalPrice = (double) (node.count * count);
            double discountAmount = totalPrice * (discount * 0.01);
            double finaldiscounts = totalPrice - discountAmount;
            listFinal.add(new Grocery(node.fruit, count, finaldiscounts));
        }

        return listFinal.stream().sorted(Comparator.comparing(Grocery::getFruit)).toList();

    }

    public static void main(String[] args) {
        List<Grocery> groceryList = Collections.synchronizedList(Arrays.asList(
                new Grocery("Banana", 90.90, 78) ,
                new Grocery("Apple", 90.90, 78),
                new Grocery("Orange", 90.90, 78)
        ));


        System.out.println();
//        for (int i = 0; i < groceryList.size(); i++) {
//            System.out.println(groceryList.get(i).fruit);
//        }
        // Sort by name
        groceryList.sort(Comparator.comparing(Grocery::getFruit));
        System.out.println("Sorted by Name:");
        groceryList.forEach(System.out::println);

        // Sort by price (if you want to sort by price instead)
        Collections.sort(groceryList, Comparator.comparingDouble(Grocery::getPrice));
        System.out.println("\nSorted by Price:");
        groceryList.forEach(System.out::println);
        int[] arr1= {1,2,3,4, 10, 9, 8};
        //Arrays.sort(arr1);
        //Arrays.sort(arr1, Collections.reverseOrder());
        System.out.println(Arrays.toString(arr1));

        // Sort grocery list by name using Stream API
//        List<Grocery> sortedGroceryList = groceryList.stream()
//                .sorted((g1, g2) -> g1.getFruit().compareTo(g2.getFruit())) // Sorting by name
//                .collect(Collectors.toList());
        List<Grocery> sortedGroceryList = groceryList.stream()
                .sorted(Comparator.comparing(Grocery::getFruit)) // Sorting by name
                .toList();
        // Print sorted grocery list

        sortedGroceryList.forEach(System.out::println);
    }


}
