package organizadores;

import modelos.Item;
import usuarios.Usuario;

public class OrganizadorDeItens {
    
    private Usuario usuario;

    public OrganizadorDeItens(Usuario usuario) {
        this.usuario = usuario;
    }

    public boolean adicionarItem(Item item) {
        if (item == null) {
            System.out.println("Não são permitidos itens nulos!");
            return false;
        } 
        for (Item i : usuario.listarItens()) {
            if ((i.getNome().equals(item.getNome())) &&
                (i.getCor().equals(item.getCor())) && 
                (i.getMarca().equals(item.getMarca())) &&
                (i.getTamanho().equals(item.getTamanho()))) {
                System.out.println("O item já existe na lista de itens");
                return false;
            }
        }
        usuario.adicionarItem(item);
        System.out.println("Item adicionado!");
        return true;
    }
    
    public boolean removerItem(Item item) {
        if (item == null) {
            System.out.println("Não é possível remover um item nulo");
        }
        for (Item i: usuario.listarItens()) {
            if (i.getNome().equals(item.getNome()) &&
                i.getCor().equals(item.getCor()) &&
                i.getMarca().equals(item.getMarca()) &&
                i.getTamanho().equals(item.getTamanho())) {
                usuario.removerItem(i);
                System.out.println("Item removido");
                return true;
            }
        }
        System.out.println("Item não removido, erro!");
        return false;
    }

    public boolean editarItem(Item item, String nome, String cor, String tamanho, String marca, String estado) {
        if (item == null) {
            System.out.println("Não é permitido item nulo!");
            return false;
        }
        item.setNome(nome);
        item.setCor(cor);
        item.setTamanho(tamanho);
        item.setMarca(marca);
        item.setEstado(estado);
        return true;
    }

}
