package app;

import modelos.Look;
import modelos.subgrupositens.Acessorio;
import modelos.subgrupositens.RoupaIntima;
import modelos.subgrupositens.tiposroupacomum.*;
import organizadores.OrganizadorDeLooks;
import usuarios.Usuario;

public class Main {
    public static void main(String[] args) {
        // Criar usuário
        Usuario usuario = new Usuario("Thiago", "Masculino", "1.75");

        // Criar itens
        RoupaSuperior camiseta = new RoupaSuperior(RoupaSuperior.Tipo.CAMISETA, "Camiseta", "Preta", "M", "Nike", "Nova");
        RoupaInferior calca = new RoupaInferior(RoupaInferior.Tipo.SHORT, "Calça Jeans", "Azul", "40", "Levis", "Usada");
        Calcado tenis = new Calcado(Calcado.Tipo.TENIS, "Tênis Esportivo", "Branco", "42", "Adidas", "Usado");
        Chapelaria bone = new Chapelaria(Chapelaria.Tipo.BONE, "Boné", "Preto", "M", "Puma", "Novo");
        RoupaIntima cueca = new RoupaIntima(RoupaIntima.Tipo.CUECA, "Cueca Boxer", "Cinza", "M", "Zara", "Usada");
        Acessorio relogio = new Acessorio(Acessorio.Tipo.RELOGIO, "Relógio", "Prata", "Único", "Casio", "Usado");

        // Instanciar o organizador
        OrganizadorDeLooks organizador = new OrganizadorDeLooks(usuario);

        // Criar look
        System.out.println("=== Criando look ===");
        organizador.criarLook("Look Casual", camiseta, calca, relogio, bone, tenis, cueca);

        // Listar looks
        System.out.println("\n=== Looks do usuário ===");
        for (Look l : organizador.listarLooks()) {
            System.out.println("- " + l.getNome());
        }

        // Buscar look por nome
        System.out.println("\n=== Buscando look por nome ===");
        Look lookEncontrado = organizador.buscarLookPorNome("Look Casual");
        if (lookEncontrado != null) {
            System.out.println("Look encontrado: " + lookEncontrado.getNome());
        }

        // Alterar uma peça do look
        System.out.println("\n=== Mudando Roupa Superior do Look ===");
        RoupaSuperior novaCamiseta = new RoupaSuperior(RoupaSuperior.Tipo.CAMISETA, "Camiseta Nova", "Branca", "M", "Hering", "Nova");
        organizador.mudarLook(lookEncontrado, novaCamiseta);

        // Remover o look
        System.out.println("\n=== Removendo o look ===");
        organizador.removerLook(lookEncontrado);

        // Verificar lista de looks após remoção
        System.out.println("\n=== Looks após remoção ===");
        for (Look l : organizador.listarLooks()) {
            System.out.println("- " + l.getNome());
        }
    }
}

