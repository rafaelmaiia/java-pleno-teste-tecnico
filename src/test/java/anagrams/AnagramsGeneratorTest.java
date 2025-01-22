package anagrams;

import com.rafaelmaia.anagrams.AnagramsGenerator;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AnagramsGeneratorTest {

    @Test
    public void testSingleLetter() {
        // Teste com uma única letra
        Set<String> result = AnagramsGenerator.generateAnagrams("a");
        assertEquals(Set.of("a"), result, "Anagrama de uma única letra deveria ser ele mesmo.");
    }

    @Test
    public void testTwoLetters() {
        // Teste com duas letras
        Set<String> result = AnagramsGenerator.generateAnagrams("ab");
        assertEquals(Set.of("ab", "ba"), result, "Deveria gerar todos os anagramas únicos de duas letras.");
    }

    @Test
    public void testDuplicateLetters() {
        // Teste com letras duplicadas
        Set<String> result = AnagramsGenerator.generateAnagrams("aab");
        assertEquals(Set.of("aab", "aba", "baa"), result, "Deveria gerar anagramas únicos mesmo com letras duplicadas.");
    }

    @Test
    public void testEmptyInput() {
        // Teste com string vazia
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            AnagramsGenerator.generateAnagrams("");
        });
        assertEquals("A entrada não pode ser vazia ou nula.", exception.getMessage());
    }

    @Test
    public void testInvalidCharacters() {
        // Teste com caracteres inválidos
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            AnagramsGenerator.generateAnagrams("abc123");
        });
        assertEquals("A entrada deve conter apenas letras.", exception.getMessage());
    }
}
