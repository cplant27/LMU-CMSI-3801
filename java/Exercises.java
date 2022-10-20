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

    public static Stream powers (int base) {
        int power = 0;
        Stream out = Stream.iterate(base, i -> (int)Math.pow(i, power + 1));
        return out;
    }
    public static void main (String[] args) {

    }


    public class Quaternion {
        public Quaternion(int a, int b, int c, int d) {
            this.co1 = a;
            this.co2 = b;
            this.co3 = c;
            this.co4 = d;
        }

        public Quaternion plus(int q) {
            Quaternion answer = new Quaternion(
            this.co1 + q.co1,
            this.co2 + q.co2,
            this.co3 + q.co3,
            this.co4 + q.co4
            );
            return answer;
        }

        public Quaternion times(int q) {
            int ans1 =
            this.co1 * q.co1 - this.co2 * q.co2 - this.co3 * q.co3 - this.co4 * q.co4;
            int ans2 =
            this.co1 * q.co2 + this.co2 * q.co1 + this.co3 * q.co4 - this.co4 * q.co3;
            int ans3 =
            this.co1 * q.co3 - this.co2 * q.co4 + this.co3 * q.co1 + this.co4 * q.co2;
            int ans4 =
            this.co1 * q.co4 + this.co2 * q.co3 - this.co3 * q.co2 + this.co4 * q.co1;
            return new Quaternion(ans1, ans2, ans3, ans4);
        }

        public ArrayList coefficients() {
            List coefficients = new ArrayList;
            coefficients.add(Double.valueOf(this.co1));
            coefficients.add(Double.valueOf(this.co2));
            coefficients.add(Double.valueOf(this.co3));
            coefficients.add(Double.valueOf(this.co4));
            return coefficients;
        }

        public string toString() {

            return "Quaternion[a="+Double.valueOf(this.co1)+", b="+Double.valueOf(this.co2)+", c="+Double.valueOf(this.co3)+", d="+Double.valueOf(this.co4)+"]";
        }

    } 

}
