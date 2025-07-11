package guardaroupa.autenticacao;

import java.util.ArrayList;
import java.util.List;
import guardaroupa.GuardaRoupa;

public class ControladorAutenticacao {

    private final List<GuardaRoupa> guardaRoupasCadastrados = new ArrayList<>();

    public boolean Cadastro(String nome, String genero, String altura) {
        for (GuardaRoupa u : guardaRoupasCadastrados) {
            if (u.getNome().equals(nome)) {
                System.out.println("O seu nome já está em nosso banco");
                return false;
            }
        }
        GuardaRoupa guardaRoupa = new GuardaRoupa(nome, genero, altura);
        guardaRoupasCadastrados.add(guardaRoupa);
        SessaoGuardaRoupa.autenticarUsuarioAtual(guardaRoupa);
        return true;
    }

    public boolean Login(String nome) {
        for(GuardaRoupa u : guardaRoupasCadastrados) {
            if (u.getNome().equals(nome)) {
                SessaoGuardaRoupa.autenticarUsuarioAtual(u);
                return true;
            }
        }
        return false;
    }

    public GuardaRoupa getUsuarioAtual() {
        return SessaoGuardaRoupa.getUsuarioAtual();
    }

    public boolean Loggout() {
        if (SessaoGuardaRoupa.getUsuarioAtual() == null) {
            System.out.println("Você não está logado para fazer loggout");
            return false;
        }
        SessaoGuardaRoupa.desligarUsuario();
        return true;
    }

    public boolean usuarioEstaLogado() {
        if (SessaoGuardaRoupa.temUsuario()) {
            return true;
        }
        return false;
    }

    public List<GuardaRoupa> getGuardaRoupasCadastrados() {
        return guardaRoupasCadastrados;
    }
  }
