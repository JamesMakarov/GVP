package modelos.Config_DataHora;

import java.time.LocalDate;

public class DataHora {
    private int dia, mes, ano, hora, minuto, segundo;

    public DataHora(int dia, int mes, int ano, int hora, int minuto, int segundo) {
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
        this.hora = hora;
        this.minuto = minuto;
        this.segundo = segundo;
    }

    public int getDia() {
        return dia;
    }

    public int getMes() {
        return mes;
    }

    public int getAno() {
        return ano;
    }

    public int getHora() {
        return hora;
    }

    public int getMinuto() {
        return minuto;
    }

    public int getSegundo() {
        return segundo;
    }

    public LocalDate paraLocalDate() {
        return LocalDate.of(ano, mes, dia);
    }

    public String toString() {
    return String.format("%02d/%02d/%04d %02d:%02d:%02d",
        dia, mes, ano, hora, minuto, segundo);
    }

}
