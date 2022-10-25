import java.util.*;
import java.util.List;
import java.util.HashMap;
import java.util.Set;
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

    public static String stretched (String phrase){
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
<<<<<<< HEAD
    
    static ArrayList<String> TopTenScorers(HashMap<String, List<String>> stats){
=======
    public static ArrayList<String> topTenScorers (HashMap<String, List<String>> stats){
>>>>>>> e3c91d6955d3778a445f687029fd2506ea825775
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

    public static Object findFirstThenLower () {
        return null;
    }
}

