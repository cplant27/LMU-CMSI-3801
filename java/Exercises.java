import java.util.*;

public class Exercises {
    public List<Integer> Change (int coins) {
        int quarters = 0;
        int dimes = 0;
        int nickels = 0;
        int pennies = 0;
        List<Integer> coinList = new ArrayList<Integer>();

        if (coins < 0) {
            throw new IllegalArgumentException("Coins must be positive!");
        } else if (coins >= 25) {
            quarters = (int) Math.floor(coins / 25);
            coins = coins % 25;
        }

        while (coins >= 10) {
            dimes += 1;
            coins = coins - 10;
        }

        while (coins >= 5) {
            nickels += 1;
            coins = coins - 5;
        }

        pennies = coins;

        coinList.add(quarters);
        coinList.add(dimes);
        coinList.add(nickels);
        coinList.add(pennies);

        List<Integer> immutablelist = Collections.unmodifiableList(coinList);
        return immutablelist;
    }
    public static void main (String[] args) {

    }
}
