package organizadores;

import java.util.ArrayList;
import java.util.List;

import modelos.Item;
import modelos.interfaces.emprestaveis.IEmprestavel;
import modelos.interfaces.emprestaveis.IOrganizadorDeEmprestimos;
import usuarios.Usuario;

public class OrganizadorDeEmprestimos implements IOrganizadorDeEmprestimos {
    
    private Usuario usuarioAtual;

    public OrganizadorDeEmprestimos(Usuario usuario) {
        this.usuarioAtual = usuario;
    }

    public List<Item> itensEmprestados() {
        List<Item> listaEmprestados = new ArrayList<>();
        for (Item i : usuarioAtual.listarItens()) {
            if (i instanceof IEmprestavel) {
                IEmprestavel iEmprestavel = (IEmprestavel) i;
                if (iEmprestavel.isEmprestado()) {
                    listaEmprestados.add(i);
                }
            }
        }
        return listaEmprestados;
    }

    public boolean emprestarItem(Item item) {
        if (item == null) {
            System.out.println("Item nulo");
            return false;
        }

        if(!(item instanceof IEmprestavel)) {
            System.out.println("Item não pode ser emprestado");
            return false;
        }
        IEmprestavel iEmprestavel = (IEmprestavel) item;
        if (iEmprestavel.isEmprestado()) {
                System.out.println("O item já está emprestado");
                return false;
        }
        
        iEmprestavel.Emprestar();
        System.out.println("Item emprestado");
        return true;
    }

    public boolean devolverItem(Item item) {
        if (item == null) {
            System.err.println("Não é possível devolver um item nulo");
            return false;
        }
        if (!(item instanceof IEmprestavel)) {
            System.err.println("Não é possível devolver um item que não é emprestável");
            return false;
        }
        IEmprestavel iEmprestavel = (IEmprestavel) item;
        if ((!iEmprestavel.isEmprestado())) {
            System.out.println("Não é possível devolver um item que não está emprestado");
            return false;
        }
        iEmprestavel.Devolver();
        System.out.println("Item devolvido, obrigado!");
        return true;
    }

    public int diasDesdeEmprestimo(Item item) {
        if (item == null) {
            System.out.println("Objeto nulo");
            return -1;
        }

        if (!(item instanceof IEmprestavel)) {
            System.out.println("O item não é emprestável");
            return -2;
        }

        IEmprestavel iEmprestavel = (IEmprestavel) item;

        if (!(iEmprestavel.isEmprestado())) {
            System.out.println("O objeto não está emprestado");
            return -3;
        }

        return iEmprestavel.quantidadeDeDiasDesdeOEmprestimo();
    }
}

