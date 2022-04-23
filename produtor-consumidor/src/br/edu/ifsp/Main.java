package br.edu.ifsp;

import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        final ProdutorConsumidor produtorConsumidor = new ProdutorConsumidor();

        Thread produtor = new Thread(() -> {
            try {
                produtorConsumidor.produzir();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread consumidor = new Thread(() -> {
            try {
                produtorConsumidor.consumir();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        produtor.start();
        consumidor.start();

        produtor.join();
        consumidor.join();
    }
}

class ProdutorConsumidor {
    LinkedList<Integer> lista = new LinkedList<>();
    int capacidade = 2;

    public void produzir() throws InterruptedException {
        int valor = 0;
        while (true) {
            synchronized (this) {
                while (lista.size() == capacidade) wait();
                System.out.println("Produtor produziu: " + valor);
                lista.add(valor++);
                notify();
                Thread.sleep(1000);
            }
        }
    }

    public void consumir() throws InterruptedException {
        while (true) {
            synchronized (this) {
                while (lista.size() == 0) wait();
                int val = lista.removeFirst();
                System.out.println("Consumidor consumiu:" + val);
                notify();
                Thread.sleep(1000);
            }
        }
    }
}
