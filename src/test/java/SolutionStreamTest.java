import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionStreamTest {
    private SolutionStream stream;

    @BeforeEach
    void setUp() {
        stream = new SolutionStream();
    }

    @Test
    void processInputFromFile() {
        int[] smallestInts = stream.processInputFromFile("./src/main/resources/test-input.txt");
        assertEquals(5, smallestInts[0]);
        assertEquals(4, smallestInts[1]);
        assertEquals(1, smallestInts[2]);
    }

    @Test
    void parseArray() {
        int[] intArray = makeSampleArray();
        assertEquals(4, intArray.length);
    }

    private int[] makeSampleArray() {
        String[] values = new String[]{"1", "2", "5", "6"};
        int[] intArray = stream.parseArray(values);
        return intArray;
    }

    @Test
    void solution() {
        int[] intArray = makeSampleArray();
        int solution = stream.solution(intArray);
        assertEquals(3, solution);
    }
}