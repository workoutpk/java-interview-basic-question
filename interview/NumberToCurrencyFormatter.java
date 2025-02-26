package interview;


import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;

public class NumberToCurrencyFormatter {

    public static void main(String[] args) {
        double amount = 1234567.89;

        NumberFormat numberFormat = NumberFormat.getCurrencyInstance(Locale.US);
        System.out.println("numberFormat ::: " + numberFormat.format(45344.89));
        // Format currency for US Dollars
        System.out.println("US Dollars: " + formatCurrency(amount, Locale.US));

        // Format currency for Euros (Germany)
        System.out.println("Euros (Germany): " + formatCurrency(amount, Locale.GERMANY));

        // Format currency for Japanese Yen
        System.out.println("Japanese Yen: " + formatCurrency(amount, Locale.JAPAN));

        // Format currency for Indian Rupees
        System.out.println("Indian Rupees: " + formatCurrency(amount, new Locale("en", "IN")));

        // Format currency for British Pounds
        System.out.println("British Pounds: " + formatCurrency(amount, Locale.UK));

        // Custom formatting example
        System.out.println("Custom USD: " + formatCurrencyCustom(amount, Locale.US));
    }

    public static String formatCurrency(double amount, Locale locale) {
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(locale);
        return currencyFormatter.format(amount);
    }

    public static String formatCurrencyCustom(double amount, Locale locale) {
        NumberFormat customFormatter = NumberFormat.getCurrencyInstance(locale);
        customFormatter.setMinimumFractionDigits(2);
        customFormatter.setMaximumFractionDigits(2);
        Currency currency = Currency.getInstance(locale);
        customFormatter.setCurrency(currency);
        return customFormatter.format(amount);
    }
}

