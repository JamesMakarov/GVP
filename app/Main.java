package app;

import modelos.Look;
import modelos.subgrupositens.tiposroupacomum.Calcado;
import modelos.subgrupositens.tiposroupacomum.Chapelaria;
import modelos.subgrupositens.tiposroupacomum.RoupaInferior;
import modelos.subgrupositens.tiposroupacomum.RoupaSuperior;
import modelos.subgrupositens.Acessorio;
import modelos.subgrupositens.RoupaIntima;
import usuarios.Usuario;


public class Main {
    public static void main(String[] args) {
        // Criar usuário
        Usuario thiago = new Usuario("Thiago", "Masculino", "1.75m");

        // Criar itens concretos com classes anônimas (já que são abstratas)
        RoupaSuperior camiseta = new RoupaSuperior("Camiseta Preta", "Preto", "M", "Nike", "Nova") {
            public String getTipo() { return "Camiseta"; }
        };

        RoupaInferior calca = new RoupaInferior("Calça Jeans", "Azul", "40", "Levi's", "Usada") {
            public String getTipo() { return "Calça"; }
        };

        RoupaIntima cueca = new RoupaIntima("Cueca Boxer", "Preta", "G", "Lupo", "Nova") {
            public String getTipo() { return "Cueca"; }
        };

        Acessorio relogio = new Acessorio("Relógio de Pulso", "Prata", "Único", "Casio", "Usado") {
            public String getTipo() { return "Relógio"; }
        };

        Calcado tenis = new Calcado("Tênis Esportivo", "Branco", "42", "Adidas", "Semi-novo") {
            public String getTipo() { return "Tênis"; }
        };

        Chapelaria boné = new Chapelaria("Boné Preto", "Preto", "M", "Nike", "Novo") {
            public String getTipo() { return "Boné"; }
        };

        // Adicionar itens ao usuário
        thiago.adicionarItem(camiseta);
        thiago.adicionarItem(calca);
        thiago.adicionarItem(cueca);
        thiago.adicionarItem(relogio);
        thiago.adicionarItem(tenis);
        thiago.adicionarItem(boné);

        // Simular empréstimos e lavagens
        camiseta.Emprestando();
        cueca.Lavar();
        relogio.Emprestando();

        // Criar look
        Look lookDia = new Look("Look Casual");
        lookDia.setRoupaSuperior(camiseta);
        lookDia.setRoupaInferior(calca);
        lookDia.setRoupaIntima(cueca);
        lookDia.setAcessorio(relogio);
        lookDia.setCalcado(tenis);
        lookDia.setChapeu(boné);

        thiago.adicionarLook(lookDia);
        
        // Exibir informações
        System.out.println("Usuário: " + thiago.getNome());
        System.out.println("Look criado: " + lookDia.getNome());
        System.out.println("Roupa superior: " + lookDia.getRoupaSuperior().getNome());
        System.out.println("Dias desde empréstimo da camiseta: " + camiseta.quantidadeDeDiasDesdeOEmprestimo());
        System.out.println("Dias desde lavagem da cueca: " + cueca.diasDesdeUltimaLavagem());
        System.out.println("Dias desde empréstimo do relógio: " + relogio.quantidadeDeDiasDesdeOEmprestimo());
    }

}
