import java.util.*;
import java.util.stream.Stream;

public class Exercises {
    public static List<Integer> change (int coins) {
        int quarters = 0;
        int dimes = 0;
        int nickels = 0;
        int q = 25;
        int d = 10;
        int n = 5;
        List<Integer> numCoins = new ArrayList<Integer>();
        if (coins < 0) {
            throw new IllegalArgumentException("Coins must be positive!");
        }
        if (coins >= q) {
            quarters = (int) Math.floor(coins / q);
            coins = coins % q;
            numCoins.add(quarters);
        }
        if (coins >= d) {
            nickels = (int) Math.floor(coins / d);
            coins = coins % d;
            numCoins.add(dimes);
        }
        if (coins >= n) {
            dimes = (int) Math.floor(coins / n);
            coins = coins % n;
            numCoins.add(nickels);
        }
        numCoins.add(coins);
        return Collections.unmodifiableList(numCoins);
    }

    public static String stretched(String phrase){
        phrase = phrase.replace(" ", "").toLowerCase();
        String[] letters = phrase.split("");
        for (int i = 0; i < letters.length; i++){
            int j = i;
            String l = letters[i];
            while (j > 0){
                letters[i] += l;
                j--;
            }
        } 
        return String.join("", letters);
    }

    public static Stream<Integer> powers (int base) {
        int power = 0;
        Stream<Integer> out = Stream.iterate(base, i -> (int)Math.pow(i, power + 1));
        return out;
    }

    public static String say(String word) {
        return say(word);
    }
}
