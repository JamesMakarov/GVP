package GUI.classesestaticas.instanciasnecessias;

import guardaroupa.autenticacao.ControladorAutenticacao;
import organizadores.OrganizadorDeEmprestimos;
import organizadores.OrganizadorDeItens;
import organizadores.OrganizadorDeLavagens;
import organizadores.OrganizadorDeLooks;

public class Instancia {

    private Instancia() {}

    public static OrganizadorDeItens getInstanceOrgItens() {
        return new OrganizadorDeItens();
    }

    public static OrganizadorDeEmprestimos getInstanceOrgEmp() {
        return new OrganizadorDeEmprestimos();
    }

    public static OrganizadorDeLavagens getInstanceOrgLav() {
        return new OrganizadorDeLavagens();
    }

    public static OrganizadorDeLooks getInstanceOrgLoo() {
        return new OrganizadorDeLooks();
    }

}
