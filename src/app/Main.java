package app;

import modelos.Config_DataHora.DataHora;
import utils.CalculadoraDias;


public class Main {
    public static void main(String[] args) {
        DataHora dataHora = new DataHora(15, 6, 2023, 12, 5, 21);
        int dias = CalculadoraDias.CalcularDias(dataHora);
        System.out.println(dias);
        
    }

}
