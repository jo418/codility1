import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    public static final String TEST_INPUT_FILE = "./src/main/resources/test-input.txt";
    private Solution solution = new Solution();

    @BeforeEach
    void setUp() {
        solution = new Solution();
    }

    @Test
    void readArraysFromFile() {
        int[][] minInts = solution.readArraysFromFile(TEST_INPUT_FILE);
        assertNotNull(minInts);
        assertEquals(3, minInts.length);
    }

    @Test
    void countLines() {
        try {
            int count = solution.countLines(TEST_INPUT_FILE);
            assertEquals(3, count);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            assertTrue(false, "Error when reading file");
        }
    }

    @Test
    void solution() {
        int[] intArray = new int[]{1, 2, 4, 3, 20};
        int minInt = solution.solution(intArray);
        assertEquals(5, minInt);
    }
}