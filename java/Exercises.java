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

    @FunctionalInterface
    public interface Func<String>{
        String recurse(String blah);
    }

    public static String say(Optional<String> word) {
    if (word == null) return "";
    else
        return recurse -> {
            if (recurse == null) return word;
            else {
                return say(word + " " + recurse);
            }
        };
    }
    static ArrayList<String> TopTenScorers(HashMap<String, List<String>> stats){
        ArrayList<String> girlsAbove15 = new ArrayList<>();
        ArrayList<Double> girlsAverageScores = new ArrayList<>();
        ArrayList<String> girlsAverageScoresString = new ArrayList<>();
        ArrayList<String> TopTen = new ArrayList<>();
        Set<String> statsKeySet = stats.keySet();
        Stream<String> keysStream = statsKeySet.stream();
        keysStream.forEach(elemn -> {
           (stats.get(elemn)).stream().forEach(elem -> {
                int length = elem.length();
                if (!elem.substring(length - 6, length - 5).equals(",")){
                    if (Integer.parseInt(elem.substring(length - 6, length - 4)) >= 15) {
                        double Games = Double.parseDouble(elem.substring(length - 6, length - 4));
                        double Score = Double.parseDouble(elem.substring(length - 3, length));
                        double Average = ( Score / Games );
                        String gameAverage = String.format("%.2f", Average);
                        String girlToAdd = elem.substring(0, length - 7) + "|" + (gameAverage) + "|" + elemn;
                        girlsAbove15.add(girlToAdd);
                        girlsAverageScores.add(Average);
                    }
                }
            });
        });
        Collections.sort(girlsAverageScores, Collections.reverseOrder());
        for (int i = 0; i < girlsAverageScores.size(); i++){
            girlsAverageScoresString.add(String.format("%.2f",girlsAverageScores.get(i)));
        }
        while (girlsAverageScoresString.size() > 10){
            girlsAverageScoresString.remove(girlsAverageScoresString.size() - 1);
        }
        int currentSubstringIndex = 0;
        while (TopTen.size() < 10){
            for (int j = 0; j < girlsAbove15.size(); j++){
                if (girlsAbove15.get(j).contains(girlsAverageScoresString.get(currentSubstringIndex))) {
                    TopTen.add(girlsAbove15.get(j));
                }
            }
            currentSubstringIndex =  currentSubstringIndex + 1;
        }
        return(TopTen);
   }
}

