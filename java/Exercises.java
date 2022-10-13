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

    public Stream PowerStream (int base) {
        int power = 0;
        Stream out = Stream.iterate(base, i -> (int)Math.pow(i, power + 1));
        return out;
    }
    public static void main (String[] args) {

    }
}
