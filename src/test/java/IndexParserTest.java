import org.example.CombinationGenerator;
import org.example.IndexParser;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class IndexParserTest {

    @Test
    public void testParseAndGenerateCombinations() {

        String[] indexes = {"1,3-5", "2", "3-4"};


        List<List<Integer>> parsedIndexes = IndexParser.parseIndexes(indexes);

        // Проверка, что строка корректно парсится в списки
        assertEquals(3, parsedIndexes.size());
        assertEquals(List.of(1, 3, 4, 5), parsedIndexes.get(0));
        assertEquals(List.of(2), parsedIndexes.get(1));
        assertEquals(List.of(3, 4), parsedIndexes.get(2));

        // Генерация всех возможных комбинаций
        List<List<Integer>> combinations = CombinationGenerator.generateCombinations(parsedIndexes);

        // Проверка, что сгенерировано 8 комбинаций
        assertEquals(8, combinations.size());

        // Проверка всех комбинаций
        assertTrue(combinations.contains(List.of(1, 2, 3)));
        assertTrue(combinations.contains(List.of(1, 2, 4)));
        assertTrue(combinations.contains(List.of(3, 2, 3)));
        assertTrue(combinations.contains(List.of(3, 2, 4)));
        assertTrue(combinations.contains(List.of(4, 2, 3)));
        assertTrue(combinations.contains(List.of(4, 2, 4)));
        assertTrue(combinations.contains(List.of(5, 2, 3)));
        assertTrue(combinations.contains(List.of(5, 2, 4)));
    }


    @Test
    public void testEmptyInput() {
        String[] indexes = {};
        List<List<Integer>> parsed = IndexParser.parseIndexes(indexes);
        assertTrue(parsed.isEmpty());
    }
}
