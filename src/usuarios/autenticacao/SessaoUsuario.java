package usuarios.autenticacao;

import usuarios.Usuario;

public class SessaoUsuario {
    static private Usuario usuarioAtual;

    private SessaoUsuario() {}

    public static void autenticarUsuarioAtual(Usuario usuario) {
        usuarioAtual = usuario; // acho que como estamos em static não pode this, tava dando erro com ele
    }

    public static Usuario getUsuarioAtual() {
        return usuarioAtual;
    }

    public static void desligarUsuario() {
        usuarioAtual = null;
    }

    public static boolean temUsuario() {
        if (usuarioAtual == null) {
            return false;
        }
        return true;
    }
}
