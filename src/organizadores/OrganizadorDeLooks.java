package organizadores;

import java.util.ArrayList;
import java.util.List;

import guardaroupa.autenticacao.ControladorAutenticacao;
import modelos.Look;
import modelos.interfaces.IOrganizadorDeLooks;
import modelos.subgrupositens.Acessorio;
import modelos.subgrupositens.RoupaIntima;
import modelos.subgrupositens.tiposroupacomum.Calcado;
import modelos.subgrupositens.tiposroupacomum.Chapelaria;
import modelos.subgrupositens.tiposroupacomum.RoupaInferior;
import modelos.subgrupositens.tiposroupacomum.RoupaSuperior;
import guardaroupa.GuardaRoupa;

import static persistencia.Serializer.salvarCADat;

public class OrganizadorDeLooks implements IOrganizadorDeLooks {

    private final GuardaRoupa guardaRoupa;
    private static Look lookAtual;

    public OrganizadorDeLooks() {
        this.guardaRoupa = ControladorAutenticacao.getInstancia().getGuardaRoupaAtual();
    }

    @Override
    public boolean criarLook(String nome, RoupaSuperior roupaSuperior, RoupaInferior roupaInferior, Acessorio acessorio,
            Chapelaria chapeu, Calcado calcado, RoupaIntima roupaIntima) {
        if (nome == null || roupaSuperior == null || roupaInferior == null ||
            acessorio == null || chapeu == null || calcado == null || roupaIntima == null) {
            System.out.println("Nenhum nome ou item deve ser nulo");
            return false;
        }
        Look look = new Look(nome, roupaSuperior, roupaInferior, acessorio, chapeu, calcado, roupaIntima);
        guardaRoupa.adicionarLook(look);
        System.out.println("Look criado com sucesso");
        salvarCADat(ControladorAutenticacao.getInstancia());
        return true;
    }

    @Override
    public boolean removerLook(Look look) {
        if (look == null) {
            System.out.println("Erro, look nulo");
            return false;
        }
        guardaRoupa.removerLook(look);
        salvarCADat(ControladorAutenticacao.getInstancia());
        return true;
    }

    @Override
    public boolean setLook(Look look, RoupaSuperior roupaSuperior) {
        if (look == null || roupaSuperior == null) {
            System.out.println("Look ou roupa não podem ser nulos");
            return false;
        }

        look.setLook(roupaSuperior);
        System.out.println("Roupa superior alterada com sucesso no look: " + look.getNome());
        salvarCADat(ControladorAutenticacao.getInstancia());
        return true;
    }

    @Override
    public boolean setLook(Look look, RoupaInferior roupaInferior) {
        if (look == null || roupaInferior == null) {
            System.out.println("Look ou roupa não podem ser nulos");
            return false;
        }

        look.setLook(roupaInferior);
        System.out.println("Roupa superior alterada com sucesso no look: " + look.getNome());
        salvarCADat(ControladorAutenticacao.getInstancia());
        return true;
    }

    @Override
    public boolean setLook(Look look, Chapelaria chapeu) {
        if (look == null || chapeu == null) {
            System.out.println("Look ou roupa não podem ser nulos");
            return false;
        }

        look.setLook(chapeu);
        System.out.println("Roupa superior alterada com sucesso no look: " + look.getNome());
        salvarCADat(ControladorAutenticacao.getInstancia());
        return true;
    }

    @Override
    public boolean setLook(Look look, Calcado calcado) {
        if (look == null || calcado == null) {
            System.out.println("Look ou roupa não podem ser nulos");
            return false;
        }

        look.setLook(calcado);
        System.out.println("Roupa superior alterada com sucesso no look: " + look.getNome());
        salvarCADat(ControladorAutenticacao.getInstancia());
        return true;
    }

    @Override
    public boolean setLook(Look look, RoupaIntima roupaIntima) {
        if (look == null || roupaIntima == null) {
            System.out.println("Look ou roupa não podem ser nulos");
            return false;
        }

        look.setLook(roupaIntima);
        System.out.println("Roupa superior alterada com sucesso no look: " + look.getNome());
        salvarCADat(ControladorAutenticacao.getInstancia());
        return true;
    }
    
    @Override
    public boolean setLook(Look look, Acessorio acessorio) {
        if (look == null || acessorio == null) {
            System.out.println("Look ou roupa não podem ser nulos");
            return false;
        }

        look.setLook(acessorio);
        System.out.println("Roupa superior alterada com sucesso no look: " + look.getNome());
        salvarCADat(ControladorAutenticacao.getInstancia());
        return true;
    }

    @Override
    public List<Look> listarLooks() {
        return guardaRoupa.listarLooks();
    }

    @Override
    public List<Look> buscarLookPorNome(String nome) {
        if (nome == null) {
            return null;
        }
        List<Look> lista = new ArrayList<>();
        for (Look look : guardaRoupa.listarLooks()) {
            if (look.getNome().toLowerCase().contains(nome.toLowerCase())) lista.add(look);
        }
        return lista;
    }

    public Look getLookAtual() {
        return lookAtual;
    }

    public void setLookAtual(Look look) {
        lookAtual = look;
    }

    public void setLookParaNull(Look look) {
        lookAtual = null;
    }

    public boolean setNome(Look look, String nome) {
        if (nome != null && !(nome.trim().isEmpty())) {
            look.setNome(nome);
            salvarCADat(ControladorAutenticacao.getInstancia());
            return true;
        }
        return false;
    }
}
