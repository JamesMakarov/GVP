package modelos;

public class Camiseta extends RoupaComum {

    public Camiseta(String nome, String cor, String tamanho, String marca, String estado) {
        super(nome, cor, tamanho, marca, estado);
    }

    @Override
    public short getTipo() {
        return 1;
    }
}
