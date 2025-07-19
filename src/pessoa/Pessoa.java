package pessoa;

import modelos.configdatahora.DataHora;

import java.io.Serial;
import java.io.Serializable;

public class Pessoa implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private final String nome;
    private String idade;
    private String altura;

    public Pessoa(String nome, String altura, String idade) {
        this.nome = nome;
        this.idade = idade;
        this.altura = altura;
    }

    public String getNome() {
        return nome;
    }

    public String getDataNascimento() {
        return idade;
    }

    public String altura() {
        return altura;
    }

    public void setDataNascimento(String idade) {
        this.idade = idade;
    }

    public void setAltura(String altura) {
        this.altura = altura;
    }

}
