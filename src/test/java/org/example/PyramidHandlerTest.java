package org.example;

import org.example.pyramid.Pyramid;
import org.example.pyramid.PyramidFactory;
import org.example.pyramid.path.Path;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Unit test for simple App.
 */
public class PyramidHandlerTest {

    @Test
    public void shouldAnswerWithTrue() throws FileNotFoundException {

        List<List<Integer>> numbers = readNumbersFromFile();

        Pyramid pyramid = PyramidFactory.createPyramid(numbers);

        Path pathHasMaxSum = new PyramidHandler().findPathHasMaxSum(pyramid);
        System.out.println(pathHasMaxSum.getSum());
    }

    private static List<List<Integer>> readNumbersFromFile() throws FileNotFoundException {
        List<List<Integer>> numbers = new ArrayList<>();

        File file = new File("C:\\Users\\Hamza\\Desktop\\pyramid.txt"); // resource'dan oku
        try (Scanner scanner = new Scanner(file).useDelimiter("\\n")) {
            while (scanner.hasNext()) {
                String line = scanner.next();
                if (line.isBlank()) continue;

                List<Integer> lineNumbers = new ArrayList<>();
                for (String number : line.trim().split("\\s+")) {
                    lineNumbers.add(Integer.valueOf(number));
                }
                numbers.add(lineNumbers);
            }
        }

        return numbers;
    }
}
