package modelos.subgrupositens.tiposroupacomum.chapelaria;

import modelos.subgrupositens.tiposroupacomum.Chapelaria;

public class Chapeu extends Chapelaria {
    
    public Chapeu(String nome, String cor, String tamanho, String marca, String estado) {
        super(nome, cor, tamanho, marca, estado);
    }

    @Override
    public String getTipo() {
        return "Blusa";
    }
}

