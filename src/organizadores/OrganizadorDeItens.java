package organizadores;

import modelos.Item;
import usuarios.Usuario;

public class OrganizadorDeItens {
    private Usuario usuario;
    public OrganizadorDeItens(Usuario usuario) {
        this.usuario = usuario;
    }
    public void adicionarItem(Item item) {
        if (item == null) {
            System.out.println("Não são permitidos itens nulos!");
            return;
        } 
        for (Item i : usuario.listarItens()) {
            if ((i.getNome() == item.getNome()) &&
                (i.getCor() == item.getCor()) && 
                (i.getMarca() == item.getMarca()) &&
                (i.getTamanho()==item.getTamanho())) {
                System.out.println("O item já existe na lista de itens");
                return;
            }
        }
        usuario.adicionarItem(item);
        System.out.println("Item adicionado!");
    }
    
    public void removerItem(Item item) {
        if (item == null) {
            System.out.println("Não é possível remover um item nulo");
        }
        for (Item i: usuario.listarItens()) {
            if (i.getNome() == item.getNome()) {
                usuario.removerItem(item);
                return;
            }
        }
        System.out.println("Item não adicionado, erro!");
    }

    public void editarItem(Item item, String nome, String cor, String tamanho, String marca, String estado) {
        if (item == null) {
            System.err.println("Não é permitido item nulo!");
            return;
        }
        item.setNome(nome);
        item.setCor(cor);
        item.setTamanho(tamanho);
        item.setMarca(marca);
        item.setEstado(estado);
    }

}
