
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.stream.IntStream;

public class SolutionStream {

    public int[] processInputFromFile(String fileName) {
        try {
            File file = new File(fileName);
            Scanner scanner = new Scanner(file);
            scanner.useDelimiter("\n");
            int[] results = scanner.tokens()
                    .map(String::trim)
                    .map(line -> line.split(" "))
                    .map(this::parseArray)
                    .mapToInt(this::solution)
                    .toArray();
            scanner.close();
            return results;
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + fileName);
            return new int[0];
        }
    }

    public int[] parseArray(String[] values) {
        int[] ints = Arrays.stream(values)
                .mapToInt(Integer::parseInt)
                .toArray();
        return ints;
    }

    public int solution(int[] A) {
        int n = A.length;
        HashSet<Integer> set = new HashSet<>();

        Arrays.stream(A)
                .filter(num -> num > 0)
                .forEach(set::add);

        return (int) IntStream.rangeClosed(1, n + 1)
                .filter(num -> !set.contains(num))
                .findFirst()
                .orElse(-1);
    }
}
