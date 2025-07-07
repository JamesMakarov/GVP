package app;

import java.util.Scanner;

import usuarios.autenticacao.ControladorAutenticacao;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite seu nome:");
        String nome = scanner.nextLine();
        System.out.println("Digite seu gênero:");
        String genero = scanner.nextLine();
        System.out.println("Digite sua altura:");
        String altura = scanner.nextLine();
        ControladorAutenticacao controlador = new ControladorAutenticacao();
        boolean sucesso = controlador.Cadastro(nome, genero, altura);
        if (sucesso) {
            System.out.println("Usuário cadastrado com sucesso!");
        } else {
            System.out.println("Nome já existente.");
        }

    }
}
