package br.edu.ifsp;

import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        String nome = getNome();
        System.out.println(nome);
    }

    public static String getNome() {
        // excecao sera disparada caso eu retorne nomeVazio, mas nomePreenchido funcionara normalmente
        Optional<String> nomeVazio = Optional.empty();
        Optional<String> nomePreenchido = Optional.of("Marcelo");
        return nomeVazio.orElseThrow(() -> new OptionalVazioException("Optional está vazio!"));
    }
}
