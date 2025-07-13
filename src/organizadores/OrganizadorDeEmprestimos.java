package organizadores;

import java.util.ArrayList;
import java.util.List;

import modelos.Item;
import modelos.interfaces.emprestaveis.IEmprestavel;
import modelos.interfaces.emprestaveis.IOrganizadorDeEmprestimos;
import guardaroupa.GuardaRoupa;

public class OrganizadorDeEmprestimos implements IOrganizadorDeEmprestimos {
    
    private final GuardaRoupa guardaRoupaAtual;

    public OrganizadorDeEmprestimos(GuardaRoupa guardaRoupa) {
        this.guardaRoupaAtual = guardaRoupa;
    }

    public List<Item> itensEmprestados() {
        List<Item> listaEmprestados = new ArrayList<>();
        for (Item i : guardaRoupaAtual.listarItens()) {
            if (i instanceof IEmprestavel iEmprestavel) {
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

        if(!(item instanceof IEmprestavel iEmprestavel)) {
            System.out.println("Item não pode ser emprestado");
            return false;
        }
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
        if (!(item instanceof IEmprestavel iEmprestavel)) {
            System.err.println("Não é possível devolver um item que não é emprestável");
            return false;
        }
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

        if (!(item instanceof IEmprestavel iEmprestavel)) {
            System.out.println("O item não é emprestável");
            return -2;
        }

        if (!(iEmprestavel.isEmprestado())) {
            System.out.println("O objeto não está emprestado");
            return -3;
        }

        return iEmprestavel.quantidadeDeDiasDesdeOEmprestimo();
    }
}

