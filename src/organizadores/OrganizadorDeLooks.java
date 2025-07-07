package organizadores;

import java.util.List;

import modelos.Look;
import modelos.interfaces.IOrganizadorDeLooks;
import modelos.subgrupositens.Acessorio;
import modelos.subgrupositens.RoupaIntima;
import modelos.subgrupositens.tiposroupacomum.Calcado;
import modelos.subgrupositens.tiposroupacomum.Chapelaria;
import modelos.subgrupositens.tiposroupacomum.RoupaInferior;
import modelos.subgrupositens.tiposroupacomum.RoupaSuperior;
import usuarios.Usuario;

public class OrganizadorDeLooks implements IOrganizadorDeLooks {
    private Usuario usuario;

    public OrganizadorDeLooks(Usuario usuario) {
        this.usuario = usuario;
    }

    public boolean criarLook(String nome, RoupaSuperior roupaSuperior, RoupaInferior roupaInferior, Acessorio acessorio,
            Chapelaria chapeu, Calcado calcado, RoupaIntima roupaIntima) {
        if (nome == null || roupaSuperior == null || roupaInferior == null ||
            acessorio == null || chapeu == null || calcado == null || roupaIntima == null) {
                System.out.println("Nenhum nome ou item deve ser nulo");
                return false;
        }
        Look look = new Look(nome, roupaSuperior, roupaInferior, acessorio, chapeu, calcado, roupaIntima);
        usuario.adicionarLook(look);
        System.out.println("Look criado com sucesso");
        return true;
    }

    public boolean removerLook(Look look) {
        if (look == null) {
            System.out.println("Erro, look nulo");
            return false;
        }
        usuario.removerLook(look);
        return true;
    }

    public void mudarLook(Look look, RoupaSuperior roupaSuperior) {
        if (look == null || roupaSuperior == null) {
            System.out.println("Look ou roupa não podem ser nulos");
            return;
        }

        look.mudarLook(roupaSuperior);
        System.out.println("Roupa superior alterada com sucesso no look: " + look.getNome());
    }


    public void mudarLook(Look look, RoupaInferior roupaInferior) {
        if (look == null || roupaInferior == null) {
            System.out.println("Look ou roupa não podem ser nulos");
            return;
        }

        look.mudarLook(roupaInferior);
        System.out.println("Roupa superior alterada com sucesso no look: " + look.getNome());
    }

    public void mudarLook(Look look, Chapelaria chapeu) {
        if (look == null || chapeu == null) {
            System.out.println("Look ou roupa não podem ser nulos");
            return;
        }

        look.mudarLook(chapeu);
        System.out.println("Roupa superior alterada com sucesso no look: " + look.getNome());
    }

    public void mudarLook(Look look, Calcado calcado) {
        if (look == null || calcado == null) {
            System.out.println("Look ou roupa não podem ser nulos");
            return;
        }

        look.mudarLook(calcado);
        System.out.println("Roupa superior alterada com sucesso no look: " + look.getNome());
    }

    public void mudarLook(Look look, RoupaIntima roupaIntima) {
        if (look == null || roupaIntima == null) {
            System.out.println("Look ou roupa não podem ser nulos");
            return;
        }

        look.mudarLook(roupaIntima);
        System.out.println("Roupa superior alterada com sucesso no look: " + look.getNome());
    }
    
    public void mudarLook(Look look, Acessorio acessorio) {
        if (look == null || acessorio == null) {
            System.out.println("Look ou roupa não podem ser nulos");
            return;
        }

        look.mudarLook(acessorio);
        System.out.println("Roupa superior alterada com sucesso no look: " + look.getNome());
    }

    public List<Look> listarLooks() {
        List<Look> lista = usuario.listarLooks();
        return lista;
    }

    public Look buscarLookPorNome(String nome) {
        if (nome == null) {
            return null;
        }
        List<Look> lista = usuario.listarLooks();
        for (Look look : lista) {
            if (look.getNome().equals(nome)) {
                return look;
            }
        }
        return null;
    }
    
}
