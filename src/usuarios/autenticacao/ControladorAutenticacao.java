package usuarios.autenticacao;

import java.util.ArrayList;
import java.util.List;
import usuarios.Usuario;

public class ControladorAutenticacao {

    private List<Usuario> usuariosCadastrados = new ArrayList<>();

    public boolean Cadastro(String nome, String genero, String altura) {
        for (Usuario u : usuariosCadastrados) {
            if (u.getNome().equals(nome)) {
                System.out.println("O seu nome já está em nosso banco");
                return false;
            }
        }
        Usuario usuario = new Usuario(nome, genero, altura);
        usuariosCadastrados.add(usuario);
        SessaoUsuario.autenticarUsuarioAtual(usuario);
        return true;
    }

    public boolean Login(String nome) {
        for(Usuario u : usuariosCadastrados) {
            if (u.getNome().equals(nome)) {
                SessaoUsuario.autenticarUsuarioAtual(u);
                return true;
            }
        }
        return false;
    }

    public Usuario getUsuarioAtual() {
        return SessaoUsuario.getUsuarioAtual();
    }

    public boolean Loggout() {
        if (SessaoUsuario.getUsuarioAtual() == null) {
            System.out.println("Você não está logado para fazer loggout");
            return false;
        }
        SessaoUsuario.desligarUsuario();
        return true;
    }

    public boolean usuarioEstaLogado() {
        if (SessaoUsuario.temUsuario()) {
            return true;
        }
        return false;
    }
  }
