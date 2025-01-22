package com.rafaelmaia.anagrams;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

// Classe java para gerar anagramas a partir de uma determinada string
public class AnagramsGenerator {

    /**
     * Método principal para gerar e retornar anagramas.
     * @param input String de entrada.
     * @return Conjunto de anagramas únicos.
     */
    public static Set<String> generateAnagrams(String input) {
        // Validação de entrada
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("A entrada não pode ser vazia ou nula.");
        }
        if (!input.matches("[a-zA-Z]+")) {
            throw new IllegalArgumentException("A entrada deve conter apenas letras.");
        }

        Set<String> result = new HashSet<>();
        permute(input, "", result);
        return result;
    }

    /**
     * Método recursivo para gerar anagramas.
     * @param input Letras restantes para permutar.
     * @param current Combinação atual.
     * @param result Conjunto onde os anagramas serão armazenados.
     */
    private static void permute(String input, String current, Set<String> result) {
        if (input.isEmpty()) {
            result.add(current); // Armazena apenas combinações únicas
            return;
        }
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            String left = input.substring(0, i);
            String right = input.substring(i + 1);
            permute(left + right, current + ch, result);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite uma string: ");
        String input = scanner.nextLine();

        try {
            Set<String> anagrams = generateAnagrams(input);
            System.out.println("Todos os anagramas únicos possíveis:");
            for (String anagram : anagrams) {
                System.out.println(anagram);
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
