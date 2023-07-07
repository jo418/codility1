import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;

class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] arrays = solution.readArraysFromFile("./src/main/resources/test-input.txt");
        for (int[] A : arrays) {
            int result = solution.solution(A);
            System.out.println("Smallest missing positive integer: " + result);
        }
    }

    public int[][] readArraysFromFile(String fileName) {
        try {
            File file = new File(fileName);
            Scanner scanner = new Scanner(file);
            int numArrays = countLines(fileName);
            int[][] arrays = new int[numArrays][];
            for (int i = 0; i < numArrays; i++) {
                String line = scanner.nextLine();
                String[] elements = line.trim().split(" ");
                int[] A = new int[elements.length];
                for (int j = 0; j < elements.length; j++) {
                    A[j] = Integer.parseInt(elements[j]);
                }
                arrays[i] = A;
            }
            scanner.close();
            return arrays;
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + fileName);
            return new int[0][];
        }
    }

    public int countLines(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        Scanner scanner = new Scanner(file);
        int count = 0;
        while (scanner.hasNextLine()) {
            scanner.nextLine();
            count++;
        }
        scanner.close();
        return count;
    }

    public int solution(int[] A) {
        int n = A.length;
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            if (A[i] > 0) {
                set.add(A[i]);
            }
        }

        for (int i = 1; i <= n + 1; i++) {
            if (!set.contains(i)) {
                return i;
            }
        }

        return -1;
    }
}
