package usuarios;

import modelos.Item;
import modelos.Look;
import java.util.List;
import java.util.ArrayList;

public class Usuario {
    private String nome;
    private String genero;
    private String altura;
    private List<Item> itens;
    private List<Look> looks; 

    //#region Construtores

    public Usuario(String nome, String genero, String altura) {
        this.nome = nome;
        this.genero = genero;
        this.altura = altura;
        this.itens = new ArrayList<>();
        this.looks = new ArrayList<>();
    }

    //#endregion

   //#region Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getAltura() {
        return altura;
    }

    public void setAltura(String altura) {
        this.altura = altura;
    }

    //#endregion

    public List<Item> getItens() {
        return itens;
    }

    public void adicionarItem(Item item) {
        this.itens.add(item);
    }

    public void removerItem(Item item) {
        this.itens.remove(item);
    }

    public List<Look> getLooks() {
        return looks;
    }

    public void adicionarLook(Look look) {
        this.looks.add(look);
    }

    public void removerLook(Look look) {
        this.looks.remove(look);
    }

    
}
