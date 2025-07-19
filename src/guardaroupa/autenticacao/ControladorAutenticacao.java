package guardaroupa.autenticacao;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import guardaroupa.GuardaRoupa;

import static persistencia.Serializer.salvarCADat;

public class ControladorAutenticacao implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

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
        salvarCADat(ControladorAutenticacao.getInstancia());
        return true;
    }

    public boolean Login(String nome) {
        for(GuardaRoupa u : guardaRoupasCadastrados) {
            if (u.getNome().equals(nome)) {
                SessaoGuardaRoupa.autenticarGuardaRoupaAtual(u);
                salvarCADat(ControladorAutenticacao.getInstancia());
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
        salvarCADat(ControladorAutenticacao.getInstancia());
        return true;
    }

    public boolean usuarioEstaLogado() {
        if (SessaoGuardaRoupa.temGuardaRoupa()) {
            return true;
        }
        return false;
    }

    public List<GuardaRoupa> getGuardaRoupasCadastrados() {
        salvarCADat(ControladorAutenticacao.getInstancia());
        return guardaRoupasCadastrados;
    }

    public boolean removerGuardaRoupa(GuardaRoupa guardaRoupa) {
        salvarCADat(ControladorAutenticacao.getInstancia());
        guardaRoupasCadastrados.remove(guardaRoupa);
        return true;
    }
  }
