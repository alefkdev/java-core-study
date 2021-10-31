package strings_numbers_and_math;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.stream.Collectors;

/***
 * The main method of it's class counts the duplicate characters from a given string
 */
public class CountingDuplicateCharactersClass {

    public static Map<Character, Integer> mySolution(String str){

        //I use a treemap to represent the counters of each character of the string.
        //The treemap is useful in this case because it doesn't allow duplicate keys (like any other map implementation) and it keeps the entries sorted;
        Map<Character, Integer> countTable = new TreeMap<>();

        //For each character present on the given string, I check if the character have been already inserted into the map.
        //If it's already there, I just increment it's counter. otherwise, I insert it with the counter = 1;
        for(Character c : str.toCharArray()){

            if(countTable.containsKey(c)){
                countTable.put(c, countTable.get(c) + 1);
            }
            else{
                countTable.put(c, 1);
            }

        }

        return countTable;

    }

    public static Map<Character, Integer> solutionUsingMapCompute(String str){

        Map<Character, Integer> result = new HashMap<>();

        for(char ch : str.toCharArray()){
            result.compute(ch, (k, v) -> (v == null) ? 1 : ++v);
        }

        return result;

    }

    private static Map<Character, Long> solutionUsingStream(String str) {

        Map<Character, Long> result = str.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));

        return result;

    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Write the string that should have it's characters counted: ");
        String line = scanner.nextLine();

        System.out.println(line.chars().mapToObj(c -> (char) c));

        Map<Character, Integer> mySolutionResult = CountingDuplicateCharactersClass.mySolution(line);
        Map<Character, Integer> solutionUsingMapComputeResult = CountingDuplicateCharactersClass.solutionUsingMapCompute(line);
        Map<Character, Long> solutionUsingStreamResult = CountingDuplicateCharactersClass.solutionUsingStream(line);

        System.out.println("My solution = " + mySolutionResult);
        System.out.println("Solution using map.compute = " + solutionUsingMapComputeResult);
        System.out.println("Solution using stream = " + solutionUsingStreamResult);

    }

}
