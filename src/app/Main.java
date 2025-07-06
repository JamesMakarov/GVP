package app;

import modelos.Item;
import modelos.subgrupositens.tiposacessorio.*;
import modelos.subgrupositens.tiposroupaintima.*;
import modelos.subgrupositens.tiposroupacomum.calcado.*;
import modelos.subgrupositens.tiposroupacomum.chapelaria.*;
import modelos.subgrupositens.tiposroupacomum.roupainferior.*;
import modelos.subgrupositens.tiposroupacomum.roupasuperior.*;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Class<? extends Item>> classesInstanciaveis = Arrays.asList(
            // Acessórios
            Anel.class, Brinco.class, Colar.class, Relogio.class,

            // Roupas íntimas
            CalcinhaeSutia.class, Cueca.class,

            // Calçados
            Chinelo.class, Sapato.class,

            // Chapelaria
            Bone.class, Chapeu.class,

            // Roupa inferior
            Calca.class, Saia.class,

            // Roupa superior
            Blusa.class, Camiseta.class
        );

        // Testando a lista
        System.out.println("Lista de classes instanciáveis:");
        for (Class<? extends Item> classe : classesInstanciaveis) {
            System.out.println("→ " + classe.getSimpleName());
        }
    }
}
