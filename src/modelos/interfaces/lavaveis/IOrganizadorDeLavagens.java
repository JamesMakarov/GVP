package modelos.interfaces.lavaveis;

import java.util.List;

import modelos.Item;
import modelos.Look;

public interface IOrganizadorDeLavagens {
    public boolean Lavar(Item item);
    public boolean lavarLook(Look look);
    public int diasDesdeUltimaLavagem(Item item);
    public List<Item> listarItensLavaveis();
    public List<Item> listarItensLavados();

    List<Item> listaItensSujos();
}
