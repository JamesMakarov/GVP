package guardaroupa.autenticacao;

import guardaroupa.GuardaRoupa;

public class SessaoGuardaRoupa {

    static private GuardaRoupa guardaRoupaAtual;

    private SessaoGuardaRoupa() {}

    public static void autenticarGuardaRoupaAtual(GuardaRoupa guardaRoupa) {
        guardaRoupaAtual = guardaRoupa; // acho que como estamos em static não pode this, dava erro com ele
    }

    public static GuardaRoupa getGuardaRoupaAtual() {
        return guardaRoupaAtual;
    }

    public static void desligarGuardaRoupa() {
        guardaRoupaAtual = null;
    }

    public static boolean temGuardaRoupa() {
        return guardaRoupaAtual != null;
    }
}
