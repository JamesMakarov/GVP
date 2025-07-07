package modelos.interfaces.emprestaveis;

import java.util.List;

import modelos.Item;

public interface IOrganizadorDeEmprestimos {
    public List<Item> itensEmprestados();
    public boolean emprestarItem(Item item);
    public boolean devolverItem(Item item);
    public int diasDesdeEmprestimo(Item item);
}
