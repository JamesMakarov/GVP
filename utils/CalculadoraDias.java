package utils;

import modelos.Config_DataHora.DataHora;

public class CalculadoraDias {
    private CalculadoraDias(){}
    public static int CalcularDias(DataHora dataHora) {
        if (dataHora == null) return -1; // erro, não há ultima data de Lavagem ou emprestimo

        int ano, mes, dia, anoNow, mesNow, diaNow;
        ano = dataHora.getAno();
        mes = dataHora.getMes();
        dia = dataHora.getDia();
        anoNow = DataUtils.anoNow();
        mesNow = DataUtils.mesNow();
        diaNow = DataUtils.diaNow();
        int difano, difmes, difdia;

        if (ano > anoNow) return -3; // erro -3, data inválida

        difano = anoNow - ano; // Ano recebe o ano atual menos ano
        if (mesNow < mes) {
            difano--;
            difmes = 12 - mes + mesNow;
        } else {
            difmes = mesNow - mes;
        } 
        
        if (diaNow < dia) {
            difmes--;
            difdia = DiasMes((mesNow == 1 ? 12 : mesNow - 1), anoNow) - dia + diaNow;
        } else {
            difdia = diaNow - dia;
        }

        int totaldias = difano*365 + DiasBissextosEntreOsAnos(ano, anoNow) + somaDiasDeMeses(mes, difmes, ano) + difdia;
        return totaldias;
    }

    public static boolean EBissexto(Integer ano) {
        if ((ano%4 == 0 && ano%100 != 0) || (ano%100 == 0 && ano%400 == 0) ) return true;
        return false;
    }

    public static int DiasMes(int mes, int ano) {
        int diasmes;
        switch (mes) {
            case 1:
                diasmes = 31;
                break;
            case 2:
                if (EBissexto(ano)) {diasmes = 29;} else {diasmes = 28;}
                break;
            case 3:
                diasmes = 31;
                break;
            case 4:
                diasmes = 30;
                break;
            case 5:
                diasmes = 31;
                break;
            case 6:
                diasmes = 30;
                break;
            case 7:
                diasmes = 31;
                break;
            case 8:
                diasmes = 31;
                break;
            case 9:
                diasmes = 30;
                break;
            case 10:
                diasmes = 31;
                break;
            case 11:
                diasmes = 30;
                break;
            case 12:
                diasmes = 31;
                break;
            default:
                diasmes = 30;
                break;

        }
        return diasmes;
    }

    public static int DiasBissextosEntreOsAnos(int anoInicial, int anoFinal) {
        // vamos contar quantos dias de anos bissextos tivemos
        int cont = 0;
        int a = anoInicial;
        while (a < anoFinal) {
            if(EBissexto(a)) {
                a++;
                cont++;
            } 
        }
        return cont;
    }

    public static int somaDiasDeMeses(int mesInicio, int quantidadeDeMeses, int ano) {
    int dias = 0;
    int mesAtual = mesInicio;
    int anoAtual = ano;

    for (int i = 0; i < quantidadeDeMeses; i++) {
        dias += DiasMes(mesAtual, anoAtual);
        mesAtual++;
        if (mesAtual > 12) {
            mesAtual = 1;
            anoAtual++;
        }
    }
    return dias;
    }

}
