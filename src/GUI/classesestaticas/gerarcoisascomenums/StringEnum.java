package GUI.classesestaticas.gerarcoisascomenums;

import modelos.subgrupositens.Acessorio;
import modelos.subgrupositens.RoupaIntima;
import modelos.subgrupositens.tiposroupacomum.Calcado;
import modelos.subgrupositens.tiposroupacomum.Chapelaria;
import modelos.subgrupositens.tiposroupacomum.RoupaInferior;
import modelos.subgrupositens.tiposroupacomum.RoupaSuperior;

import java.util.ArrayList;
import java.util.List;

public class StringEnum {

    public static List<String> listaEnumStringCalcado() {
        List<String> lista = new ArrayList<>();
        // vamos pegar os valores de dentro de Tipo, do calçado
        for (Calcado.Tipo t : Calcado.Tipo.values()) {
            lista.add(t.name());
        }
        return lista;
    }

    public static List<String> listaEnumStringChapelaria() {
        List<String> lista = new ArrayList<>();
        // vamos pegar os valores de dentro de Tipo, do calçado
        for (Chapelaria.Tipo t : Chapelaria.Tipo.values()) {
            lista.add(t.name());
        }
        return lista;
    }

    public static List<String> listaEnumStringRoupaInferior() {
        List<String> lista = new ArrayList<>();
        // vamos pegar os valores de dentro de Tipo, do calçado
        for (RoupaInferior.Tipo t : RoupaInferior.Tipo.values()) {
            lista.add(t.name());
        }
        return lista;
    }

    public static List<String> listaEnumStringRoupaSuperior() {
        List<String> lista = new ArrayList<>();
        // vamos pegar os valores de dentro de Tipo, do calçado
        for (RoupaSuperior.Tipo t : RoupaSuperior.Tipo.values()) {
            lista.add(t.name());
        }
        return lista;
    }

    public static List<String> listaEnumStringAcessorio() {
        List<String> lista = new ArrayList<>();
        // vamos pegar os valores de dentro de Tipo, do calçado
        for (Acessorio.Tipo t : Acessorio.Tipo.values()) {
            lista.add(t.name());
        }
        return lista;
    }

    public static List<String> listaEnumStringRoupaIntima() {
        List<String> lista = new ArrayList<>();
        // vamos pegar os valores de dentro de Tipo, do calçado
        for (RoupaIntima.Tipo t : RoupaIntima.Tipo.values()) {
            lista.add(t.name());
        }
        return lista;
    }

    public static RoupaSuperior.Tipo stringParaEnumRoupaSuperior (String string) {
        return RoupaSuperior.Tipo.valueOf(string);
    }

    public static RoupaInferior.Tipo stringParaEnumRoupaInferior (String string) {
        return RoupaInferior.Tipo.valueOf(string);
    }

    public static RoupaIntima.Tipo stringParaEnumRoupaIntima (String string) {
        return RoupaIntima.Tipo.valueOf(string);
    }

    public static Acessorio.Tipo stringParaEnumAcessorio (String string) {
        return Acessorio.Tipo.valueOf(string);
    }

    public static Chapelaria.Tipo stringParaEnumChapelaria (String string) {
        return Chapelaria.Tipo.valueOf(string);
    }

    public static Calcado.Tipo stringParaEnumCalcado (String string) {
        return Calcado.Tipo.valueOf(string);
    }



}
