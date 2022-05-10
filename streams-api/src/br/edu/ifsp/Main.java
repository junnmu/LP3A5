package br.edu.ifsp;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // Exemplo de utilização do mapToDouble com filter
        List<String> strings = Arrays.asList("10", "6.548", "9.12", "11", "15");
        strings.stream()
            .mapToDouble(Double::parseDouble)
            .filter(num -> (num * num) * 2 == 450)
            .forEach(System.out::println);

        // Exemplo de utilização do distinct
        List<Integer> numbers = Arrays.asList(1, 1, 2, 3, 3, 4, 5, 5);
        System.out.println("Os elementos distintos são: ");
        numbers.stream().distinct().forEach(System.out::println);
    }
}
