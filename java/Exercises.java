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
        return Stream.iterate(base, i -> (int)Math.pow(base, i));
    }

    class Say {
        String phrase;
        public Say(String word) {
            this.phrase = word;
        }
        public Say and(String word) {
            this.phrase += word;
            return this;
        }
        public String ok() {
            return this.phrase;
        }
    }
}