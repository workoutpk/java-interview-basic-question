package hakerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(System.getenv("OUTPUT_PATH"), "UTF-8");

        List<Node> boughtItems = new ArrayList<>();
        Map<String, Double> prices = new HashMap<>();
        Map<String, Integer> discounts = new HashMap<>();

        int n = Integer.parseInt(reader.readLine().trim());
        for (int i = 0; i < n; i++)
        {
            String[] a = reader.readLine().trim().split(" ");
            prices.put(a[0], Double.parseDouble(a[1]));
        }
        int m = Integer.parseInt(reader.readLine().trim());
        for (int i = 0; i < m; i++)
        {
            String[] a = reader.readLine().trim().split(" ");
            discounts.put(a[0], Integer.parseInt(a[1]));
        }
        int b = Integer.parseInt(reader.readLine().trim());
        for (int i = 0; i < b; i++)
        {
            String[] a = reader.readLine().trim().split(" ");
            boughtItems.add(new Node(a[0], Integer.parseInt(a[1])));
        }

        GroceryReceipt g = new GroceryReceipt(prices, discounts);
        List<Grocery> result = g.Calculate(boughtItems);
        for (Grocery x : result)
        {
            writer.printf("%s %.1f %.1f\n", x.fruit, x.price, x.total);
        }

        writer.flush();
        writer.close();
    }
}

