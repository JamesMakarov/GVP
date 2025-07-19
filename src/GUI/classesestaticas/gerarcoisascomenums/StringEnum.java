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
            lista.add(t.getNome());
        }
        return lista;
    }

    public static List<String> listaEnumStringChapelaria() {
        List<String> lista = new ArrayList<>();
        // vamos pegar os valores de dentro de Tipo, do calçado
        for (Chapelaria.Tipo t : Chapelaria.Tipo.values()) {
            lista.add(t.getNome());
        }
        return lista;
    }

    public static List<String> listaEnumStringRoupaInferior() {
        List<String> lista = new ArrayList<>();
        // vamos pegar os valores de dentro de Tipo, do calçado
        for (RoupaInferior.Tipo t : RoupaInferior.Tipo.values()) {
            lista.add(t.getNome());
        }
        return lista;
    }

    public static List<String> listaEnumStringRoupaSuperior() {
        List<String> lista = new ArrayList<>();
        // vamos pegar os valores de dentro de Tipo, do calçado
        for (RoupaSuperior.Tipo t : RoupaSuperior.Tipo.values()) {
            lista.add(t.getNome());
        }
        return lista;
    }

    public static List<String> listaEnumStringAcessorio() {
        List<String> lista = new ArrayList<>();
        // vamos pegar os valores de dentro de Tipo, do calçado
        for (Acessorio.Tipo t : Acessorio.Tipo.values()) {
            lista.add(t.getNome());
        }
        return lista;
    }

    public static List<String> listaEnumStringRoupaIntima() {
        List<String> lista = new ArrayList<>();
        // vamos pegar os valores de dentro de Tipo, do calçado
        for (RoupaIntima.Tipo t : RoupaIntima.Tipo.values()) {
            lista.add(t.getNome());
        }
        return lista;
    }

    public static RoupaSuperior.Tipo stringParaEnumRoupaSuperior (String string) {
        try {
            for (RoupaSuperior.Tipo t : RoupaSuperior.Tipo.values()) {
                if (t.getNome().equals(string)) {
                    return t;
                }
            }
            return RoupaSuperior.Tipo.valueOf(string);
        } catch (Exception e) {
            return null;
        }

    }

    public static RoupaInferior.Tipo stringParaEnumRoupaInferior (String string) {
        try {
            for (RoupaInferior.Tipo t : RoupaInferior.Tipo.values()) {
                if (t.getNome().equals(string)) {
                    return t;
                }
            }
            return RoupaInferior.Tipo.valueOf(string);
        } catch (Exception e) {
            return null;
        }
    }

    public static RoupaIntima.Tipo stringParaEnumRoupaIntima (String string) {
        try {
            for (RoupaIntima.Tipo t : RoupaIntima.Tipo.values()) {
                if (t.getNome().equals(string)) {
                    return t;
                }
            }
            return RoupaIntima.Tipo.valueOf(string);
        } catch (Exception e) {
            return null;
        }
    }

    public static Acessorio.Tipo stringParaEnumAcessorio (String string) {
        try {
            for (Acessorio.Tipo t : Acessorio.Tipo.values()) {
                if (t.getNome().equals(string)) {
                    return t;
                }
            }
            return Acessorio.Tipo.valueOf(string);
        } catch (Exception e) {
            return null;
        }
    }

    public static Chapelaria.Tipo stringParaEnumChapelaria (String string) {
        try {
            for (Chapelaria.Tipo t : Chapelaria.Tipo.values()) {
                if (t.getNome().equals(string)) {
                    return t;
                }
            }
            return Chapelaria.Tipo.valueOf(string);
        } catch (Exception e) {
            return null;
        }
    }

    public static Calcado.Tipo stringParaEnumCalcado (String string) {
        try {
            for (Calcado.Tipo t : Calcado.Tipo.values()) {
                if (t.getNome().equals(string)) {
                    return t;
                }
            }
            return Calcado.Tipo.valueOf(string);
        } catch (Exception e) {
            return null;
        }
    }



}
