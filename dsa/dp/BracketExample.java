package dsa.dp;

public class BracketExample {
    public static void main(String[] args) {
        String input = "(()(()(";
        Long leftBracket = input.chars().filter( ele -> ele == '(').count();
        Long rightBracket = input.chars().filter( ele -> ele == ')').count();
        System.out.println("leftBracket ::: " + leftBracket);
        System.out.println("rightBracket ::: " + rightBracket);
    }
}
