import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

class CookieRecipe {

    /**
     * #2. Chocolate chip cookie recipe
     * <p>
     * Count unique words in an above-given string. Next, add the result to a number that is next in a
     * sequence of Fibonacci numbers.
     */

    private static String phrase = "Let us try to find an easy chocolate chip cookie recipe for soft biscuits with a squidgy " +
            "middle that will impress family and friends. You can serve it with coffee and tea or " +
            "any other beverage that your guests will find suited.";

    public static void main(String[] args) {
        System.out.println("*** Exercise 2 ***");

        System.out.println("There are " + countUniqueWords(phrase) + " unique words on a string. " +
                "The next Fibonacci number to " + countUniqueWords(phrase) + " is "
                + nextFibonacciNum(countUniqueWords(phrase)));

        System.out.println(countUniqueWords(phrase) + " + " + nextFibonacciNum(countUniqueWords(phrase)) + " = "
                + Integer.sum(countUniqueWords(phrase), nextFibonacciNum(countUniqueWords(phrase))));

        System.out.print("Result is " + Integer.sum(countUniqueWords(phrase), nextFibonacciNum(countUniqueWords(phrase))));

    }

    public static Integer countUniqueWords(String phrase) {
        Integer uniqueWordsCount = 0;

        //remove unwanted characters
        phrase = phrase.replace(",", "").replace(".", "").toLowerCase();
        final List<String> wordsList = Arrays.asList(phrase.split(" "));

        //group by repetition
        Map<String, Long> countRepetitions = wordsList.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        //System.out.println(countRepetitions);

        //count how many words only repite once
        for (Long value : countRepetitions.values()) {
            if (value == 1) {
                uniqueWordsCount++;
            }
        }
        return uniqueWordsCount;
    }

    public static Integer nextFibonacciNum(Integer num) {
        Integer nextNum = 0;

        for (Integer i = 0; getFibonacciNth(i) < num; i++) {
            nextNum = getFibonacciNth(i + 1);
        }
        return nextNum;
    }

    public static Integer getFibonacciNth(int num) {
        List<Integer> sequence = new ArrayList<>();
        sequence.add(0);
        sequence.add(1);

        for (Integer index = 2; index <= num; index++) {
            sequence.add(sequence.get(index - 1) + sequence.get(index - 2));
        }
        //System.out.println(sequence);

        return sequence.get(sequence.size() - 1);
    }
}