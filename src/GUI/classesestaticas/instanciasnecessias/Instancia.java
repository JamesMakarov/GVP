package GUI.classesestaticas.instanciasnecessias;

import guardaroupa.GuardaRoupa;
import guardaroupa.autenticacao.ControladorAutenticacao;
import organizadores.OrganizadorDeEmprestimos;
import organizadores.OrganizadorDeItens;
import organizadores.OrganizadorDeLavagens;
import organizadores.OrganizadorDeLooks;

public class Instancia {

    private static OrganizadorDeEmprestimos organizadorDeEmprestimos;
    private static OrganizadorDeLavagens organizadorDeLavagens;
    private static OrganizadorDeLooks organizadorDeLooks;
    private static OrganizadorDeItens organizadorDeItens;

    private Instancia() {}

    public static GuardaRoupa guardaRoupaAtual() {
        return ControladorAutenticacao.getInstancia().getGuardaRoupaAtual();
    }

    // Os métodos estão verificando assim, pra que não sejam criadas infinitas instancias
    // e quando muda o guarda roupa ele também verifica, pra que não utilizemos instancias de outro
    public static OrganizadorDeItens getInstanceOrgItens() {
        if (organizadorDeItens == null || guardaRoupaAtual() == null || organizadorDeItens.getGuardaRoupaAtual() != guardaRoupaAtual()) {
            organizadorDeItens = new OrganizadorDeItens();
        }
        return organizadorDeItens;
    }

    public static OrganizadorDeEmprestimos getInstanceOrgEmp() {
        if (organizadorDeEmprestimos == null ||guardaRoupaAtual() == null || organizadorDeEmprestimos.getGuardaRoupaAtual() != guardaRoupaAtual()) {
            organizadorDeEmprestimos = new OrganizadorDeEmprestimos();
        }
        return organizadorDeEmprestimos;
    }

    public static OrganizadorDeLavagens getInstanceOrgLav() {
        if (organizadorDeLavagens == null || guardaRoupaAtual() == null || organizadorDeLavagens.getGuardaRoupaAtual() != guardaRoupaAtual()) {
            organizadorDeLavagens = new OrganizadorDeLavagens();
        }
        return organizadorDeLavagens;
    }

    public static OrganizadorDeLooks getInstanceOrgLoo() {
        if (organizadorDeLooks == null || guardaRoupaAtual() == null || organizadorDeLooks.getGuardaRoupaAtual() != guardaRoupaAtual()) {
            organizadorDeLooks = new OrganizadorDeLooks();
        }
        return organizadorDeLooks;
    }

}
