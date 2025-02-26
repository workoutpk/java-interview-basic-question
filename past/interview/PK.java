//package past.interview;
//
//import java.util.*;
//import java.util.stream.Collectors;
//import java.io.*;
//
//class Grocery {
//    String fruit;
//    double price, total;
//    Grocery(String fruit, double price, double total) {
//        this.fruit = fruit;
//        this.price = price;
//        this.total = total;
//    }
//}
//
//class Node{
//    String fruit;
//    int count;
//    Node(String fruit, int count){
//        this.fruit = fruit;
//        this.count = count;
//    }
//}
//abstract class GroceryReceiptBase {
//    protected Map<String, Double> prices;
//    private Map<String, Integer> discounts;
//
//    public GroceryReceiptBase(Map<String, Double> prices, Map<String, Integer> discounts) {
//        this.prices = prices;
//        this.discounts = discounts;
//    }
//
//    public abstract List<Grocery> Calculate(List<Node> shoppingList);
//
//    public Map<String, Double> getPrices() {
//        return prices;
//    }
//
//    public Map<String, Integer> getDiscounts() {
//        return discounts;
//    }
//}
//
////Create the 'GroceryReceipt' class that extends GroceryReceiptBase above.
//class GroceryReceipt  extends GroceryReceiptBase{
//
//    static int groceryPrice;
//    Map<String, Integer> discounts;
//    public GroceryReceipt(Map<String, Double> prices, Map<String, Integer> discounts) {
//        super(prices, discounts);
//        this.prices = prices;
//        this.discounts = discounts;
//
//    }
//
//    @Override
//    public List<Grocery> Calculate(List<Node> shoppingList) {
//
//        // for (int i = 0; i < shoppingList.size(); i++) {
//        //     System.out.println(shoppingList.get(i).fruit);
//        //     System.out.println(shoppingList.get(i).count);
//
//
//        // }
//
//        // System.out.println(prices);
//        // System.out.println(discounts);
//
//        List<Grocery>  listFinal = new LinkedList();
//        for (int i = 0; i < shoppingList.size(); i++) {
//
//            Double count =prices.get(shoppingList.get(i).fruit);
//
//            int discount = discounts.get(shoppingList.get(i).fruit);
//            Double totalPrice = (double) (shoppingList.get(i).count * count);
//
//            Double discountAmount = totalPrice * (discount * 0.01);
//
//            Double finaldiscounts = totalPrice - discountAmount;
//            listFinal.add(new Grocery(shoppingList.get(i).fruit, count, finaldiscounts));
//        }
//
//        return listFinal;
//
//    }
//}
//class Solution
//{
//    public static void main(String[] args) throws IOException
//    {
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        PrintWriter writer = new PrintWriter(System.getenv("OUTPUT_PATH"), "UTF-8");
//
//        List<Node> boughtItems = new ArrayList<>();
//        Map<String, Double> prices = new HashMap<>();
//        Map<String, Integer> discounts = new HashMap<>();
//
//        int n = Integer.parseInt(reader.readLine().trim());
//        for (int i = 0; i < n; i++)
//        {
//            String[] a = reader.readLine().trim().split(" ");
//            prices.put(a[0], Double.parseDouble(a[1]));
//        }
//        int m = Integer.parseInt(reader.readLine().trim());
//        for (int i = 0; i < m; i++)
//        {
//            String[] a = reader.readLine().trim().split(" ");
//            discounts.put(a[0], Integer.parseInt(a[1]));
//        }
//        int b = Integer.parseInt(reader.readLine().trim());
//        for (int i = 0; i < b; i++)
//        {
//            String[] a = reader.readLine().trim().split(" ");
//            boughtItems.add(new Node(a[0], Integer.parseInt(a[1])));
//        }
//
//        GroceryReceipt g = new GroceryReceipt(prices, discounts);
//        List<Grocery> result = g.Calculate(boughtItems);
//        for (Grocery x : result)
//        {
//            writer.printf("%s %.1f %.1f\n", x.fruit, x.price, x.total);
//        }
//
//        writer.flush();
//        writer.close();
//    }
//}
//
