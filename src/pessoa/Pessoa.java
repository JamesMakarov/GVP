package pessoa;

import modelos.configdatahora.DataHora;

public class Pessoa {

    private final String nome;
    private DataHora dataNascimento;
    private String altura;

    public Pessoa(String nome, String altura, int dia, int mes, int ano, int hora, int minuto, int segundo) {
        this.nome = nome;
        DataHora dataNascimento = new DataHora(dia, mes, ano, hora, minuto, segundo);
    }

    public String getNome() {
        return nome;
    }

    public DataHora getDataNascimento() {
        return dataNascimento;
    }

    public String altura() {
        return altura;
    }

    public void setDataNascimento(int dia, int mes, int ano, int hora, int minuto, int segundo) {
        this.dataNascimento = new DataHora(dia, mes, ano, hora, minuto, segundo);
    }

    public void setAltura(String altura) {
        this.altura = altura;
    }

}
