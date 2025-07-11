package estatisticas;

import java.util.ArrayList;
import java.util.List;

import modelos.Item;
import modelos.Look;
import modelos.interfaces.emprestaveis.IEmprestavel;
import modelos.interfaces.estatisticas.IEstatisticas;
import modelos.interfaces.lavaveis.ILavavel;
import guardaroupa.GuardaRoupa;

public class Estatisticas implements IEstatisticas {

    private final GuardaRoupa guardaRoupaAtual;

    public Estatisticas(GuardaRoupa guardaRoupa) {
        this.guardaRoupaAtual = guardaRoupa;
    }

    @Override
    public int totalDeItensCadastrados() {
        return guardaRoupaAtual.listarItens().size();
    }
    
    @Override
    public double percentualDeItensLavados() {
        double contLavados = 0;
        double contTotal = 0;
        for (Item i : guardaRoupaAtual.listarItens()) {
            contTotal++;
            if (i instanceof ILavavel iLavavel) {
                if (iLavavel.isLavado()) {
                    contLavados++;
                }
            }
        }
        return ((contLavados/contTotal)*100);
        
    }
    
    // O erro que tava dando tava vindo daqui, não de remover item, essa lista tava removendo os itens, agora, vamos fazer só uma copia
    @Override
    public List<Item> itensMaisUsados() {
        // vamos utilizar Selection Sort que é a que eu me lembro
        List<Item> listaOriginalCopia = new ArrayList<>(guardaRoupaAtual.listarItens());
        List<Item> listaOrdenada = new ArrayList<>();
        while (!(listaOriginalCopia.isEmpty())) {
            Item maior = listaOriginalCopia.getFirst();
            for (Item item : listaOriginalCopia) { 
                if (item.getNumeroDeUsos() > maior.getNumeroDeUsos()) {
                    maior = item;
                }
            }  
            listaOrdenada.add(maior);
            listaOriginalCopia.remove(maior);
        }
        return listaOrdenada;
    }
    
    // vendo agora, poderíamos sempre retornar um valor assim direto, não sabia que dava certo, vou adicionar ao Descobertas.txt
    @Override
    public int totalDeLooksCriados() {
        return guardaRoupaAtual.listarLooks().size();
    }
    
    @Override
    public int totalDeItensEmprestados() {
        int cont = 0;
        for (Item item : guardaRoupaAtual.listarItens()) {
            if (item instanceof IEmprestavel iEmprestavel) {
                if (iEmprestavel.isEmprestado()) {
                    cont++;
                }
            }
        }
        return cont;
    }

    @Override
    public Item itemMaisEmprestado() {
        Item maisEmprestado = null;
        int numeroDeEmprestimo = 0;
        for (Item item : guardaRoupaAtual.listarItens()) {
            if (item.getListaDataHoraDeUso().size() > numeroDeEmprestimo) {
                numeroDeEmprestimo = item.getListaDataHoraDeUso().size();
                maisEmprestado = item;
            }
        }  
        return maisEmprestado;
    }
    
    @Override
    public Look lookMaisUsado() {
        Look maisUsado = null;
        int numeroDeUsos = 0;
        for (Look look : guardaRoupaAtual.listarLooks()) {
            if (look.getNumeroDeUsos() > numeroDeUsos) {
                numeroDeUsos = look.getNumeroDeUsos();
                maisUsado = look;
            }
        }  
        return maisUsado;
    }

}
