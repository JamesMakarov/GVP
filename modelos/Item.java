package modelos;

public abstract class Item {
    private String nome;
    private String cor;
    private String tamanho;
    private String marca;
    private String estado;

    public Item(String nome, String cor, String tamanho, String marca, String estado) {
        this.nome = nome;
        this.cor = cor;
        this.tamanho = tamanho;
        this.marca = marca;
        this.estado = estado;
    }
    
    public String getNome() {
        return nome;
    }

    public String getCor() {
        return cor;
    }

    public String getTamanho() {
        return tamanho;
    }

    public String getMarca() {
        return marca;
    }

    public String getEstado() {
        return estado;
    }
}
