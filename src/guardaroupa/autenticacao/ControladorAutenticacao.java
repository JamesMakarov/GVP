package guardaroupa.autenticacao;

import java.util.ArrayList;
import java.util.List;
import guardaroupa.GuardaRoupa;

public class ControladorAutenticacao {

    private static final ControladorAutenticacao instancia = new ControladorAutenticacao();
    private final List<GuardaRoupa> guardaRoupasCadastrados = new ArrayList<>();

    private ControladorAutenticacao() {}

    public static ControladorAutenticacao getInstancia() {
        return instancia;
    }

    public boolean Cadastro(String nome) {
        for (GuardaRoupa u : guardaRoupasCadastrados) {
            if (u.getNome().equals(nome)) {
                System.out.println("O seu nome já está em nosso banco");
                return false;
            }
        }
        GuardaRoupa guardaRoupa = new GuardaRoupa(nome);
        guardaRoupasCadastrados.add(guardaRoupa);
        SessaoGuardaRoupa.autenticarGuardaRoupaAtual(guardaRoupa);
        return true;
    }

    public boolean Login(String nome) {
        for(GuardaRoupa u : guardaRoupasCadastrados) {
            if (u.getNome().equals(nome)) {
                SessaoGuardaRoupa.autenticarGuardaRoupaAtual(u);
                return true;
            }
        }
        return false;
    }

    public GuardaRoupa getGuardaRoupaAtual() {
        return SessaoGuardaRoupa.getGuardaRoupaAtual();
    }

    public boolean Loggout() {
        if (SessaoGuardaRoupa.getGuardaRoupaAtual() == null) {
            System.out.println("Você não está logado para fazer loggout");
            return false;
        }
        SessaoGuardaRoupa.desligarGuardaRoupa();
        return true;
    }

    public boolean usuarioEstaLogado() {
        if (SessaoGuardaRoupa.temGuardaRoupa()) {
            return true;
        }
        return false;
    }

    public List<GuardaRoupa> getGuardaRoupasCadastrados() {
        return guardaRoupasCadastrados;
    }

    public boolean removerGuardaRoupa(GuardaRoupa guardaRoupa) {
        guardaRoupasCadastrados.remove(guardaRoupa);
        return true;
    }
  }
