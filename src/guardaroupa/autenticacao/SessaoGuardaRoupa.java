package guardaroupa.autenticacao;

import guardaroupa.GuardaRoupa;

public class SessaoGuardaRoupa {
    static private GuardaRoupa guardaRoupaAtual;

    private SessaoGuardaRoupa() {}

    public static void autenticarUsuarioAtual(GuardaRoupa guardaRoupa) {
        guardaRoupaAtual = guardaRoupa; // acho que como estamos em static não pode this, tava dando erro com ele
    }

    public static GuardaRoupa getUsuarioAtual() {
        return guardaRoupaAtual;
    }

    public static void desligarUsuario() {
        guardaRoupaAtual = null;
    }

    public static boolean temUsuario() {
        if (guardaRoupaAtual == null) {
            return false;
        }
        return true;
    }
}
