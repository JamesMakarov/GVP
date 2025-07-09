package modelos.interfaces.estatisticas;

import java.util.List;

import modelos.Item;
import modelos.Look;

public interface IEstatisticas {
    // Verificação de montante
    public int totalDeItensCadastrados();
    public int totalDeLooksCriados();
    public int totalDeItensEmprestados();

    public double percentualDeItensLavados();

    // Verificação de itens mais alguma coisa
    public Item itemMaisEmprestado();
    public Look lookMaisUsado(); 
    public List<Item> itensMaisUsados();
}
