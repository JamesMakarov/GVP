package estatisticas;

import java.util.ArrayList;
import java.util.List;

import guardaroupa.autenticacao.ControladorAutenticacao;
import modelos.Item;
import modelos.Look;
import modelos.interfaces.emprestaveis.IEmprestavel;
import modelos.interfaces.lavaveis.ILavavel;

public class Estatisticas{

    private Estatisticas() {}

    public static int totalDeItensCadastrados() {
        return ControladorAutenticacao.getInstancia().getGuardaRoupaAtual().listarItens().size();
    }

    public static double percentualDeItensLavados() {
        if (totalDeItensCadastrados() == 0) {
            return -1;
        }
        double contLavados = 0;
        double contTotal = 0;
        for (Item i : ControladorAutenticacao.getInstancia().getGuardaRoupaAtual().listarItens()) {
            if (i instanceof ILavavel iLavavel) {
                contTotal++;
                if (iLavavel.isLavado()) {
                    contLavados++;
                }
            }
        }
        return ((contLavados/contTotal)*100);
        
    }
    
    // O erro que tava dando tava vindo daqui, não de remover item, essa lista tava removendo os itens, agora, vamos fazer só uma copia
    public static List<Item> itensMaisUsados() {
        // vamos utilizar Selection Sort que é a que eu me lembro
        List<Item> listaOriginalCopia = new ArrayList<>(ControladorAutenticacao.getInstancia().getGuardaRoupaAtual().listarItens());
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

    public static List<Look> looksMaisUsados() {
        List<Look> listaOriginalCopia = new ArrayList<>(ControladorAutenticacao.getInstancia().getGuardaRoupaAtual().listarLooks());
        List<Look> listaOrdenada = new ArrayList<>();
        while (!(listaOriginalCopia.isEmpty())) {
            Look maior = listaOriginalCopia.getFirst();
            for (Look look : listaOriginalCopia) {
                if (look.getNumeroDeUsos() > maior.getNumeroDeUsos()) {
                    maior = look;
                }
            }
            listaOrdenada.add(maior);
            listaOriginalCopia.remove(maior);
        }
        return listaOrdenada;
    }
    
    // vendo agora, poderíamos sempre retornar um valor assim direto, não sabia que dava certo, vou adicionar ao Descobertas.txt
    public static int totalDeLooksCriados() {
        return ControladorAutenticacao.getInstancia().getGuardaRoupaAtual().listarLooks().size();
    }

    public static int totalDeItensEmprestados() {
        int cont = 0;
        for (Item item : ControladorAutenticacao.getInstancia().getGuardaRoupaAtual().listarItens()) {
            if (item instanceof IEmprestavel iEmprestavel) {
                if (iEmprestavel.isEmprestado()) {
                    cont++;
                }
            }
        }
        return cont;
    }

    public static Item itemMaisEmprestado() {
        Item maisEmprestado = null;
        int numeroDeEmprestimo = 0;
        for (Item item : ControladorAutenticacao.getInstancia().getGuardaRoupaAtual().listarItens()) {
            if (item.getListaDataHoraDeUso().size() > numeroDeEmprestimo) {
                numeroDeEmprestimo = item.getListaDataHoraDeUso().size();
                maisEmprestado = item;
            }
        }  
        return maisEmprestado;
    }

    public static Look lookMaisUsado() {
        Look maisUsado = null;
        int numeroDeUsos = 0;
        for (Look look : ControladorAutenticacao.getInstancia().getGuardaRoupaAtual().listarLooks()) {
            if (look.getNumeroDeUsos() > numeroDeUsos) {
                numeroDeUsos = look.getNumeroDeUsos();
                maisUsado = look;
            }
        }  
        return maisUsado;
    }

}
