package br.edu.ifsp;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
       Class<Usuario> classe = Usuario.class;

       Constructor<Usuario> construtorSemArgumentos = classe.getConstructor();
       Constructor<Usuario> construtorComArgumentos = classe.getConstructor(int.class, String.class, String.class);

       // instancias com e sem parametros
       Usuario usuarioSemArgumentos = construtorSemArgumentos.newInstance();
       Usuario usuarioComArgumentos = construtorComArgumentos.newInstance(1, "Marcelo", "marcelo@email.com");

       // listando metodos e atributos
       System.out.println(Arrays.toString(classe.getMethods()));
       System.out.println(Arrays.toString(classe.getDeclaredFields()));

       // alterando a visibilidade de um metodo
        classe.getDeclaredMethod("cumprimenta").setAccessible(true);
    }
}
