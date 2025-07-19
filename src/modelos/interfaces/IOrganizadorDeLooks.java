package modelos.interfaces;

import java.util.List;

import modelos.Look;
import modelos.subgrupositens.Acessorio;
import modelos.subgrupositens.RoupaIntima;
import modelos.subgrupositens.tiposroupacomum.Calcado;
import modelos.subgrupositens.tiposroupacomum.Chapelaria;
import modelos.subgrupositens.tiposroupacomum.RoupaInferior;
import modelos.subgrupositens.tiposroupacomum.RoupaSuperior;

public interface IOrganizadorDeLooks {
    public boolean criarLook(String nome, RoupaSuperior roupaSuperior, RoupaInferior roupaInferior, Acessorio acessorio, Chapelaria chapeu, Calcado calcado, RoupaIntima roupaIntima);
    public boolean removerLook(Look look);
    public boolean setLook(Look look, RoupaSuperior roupaSuperior);
    public boolean setLook(Look look, RoupaInferior roupaInferior);
    public boolean setLook(Look look, Chapelaria chapeu);
    public boolean setLook(Look look, Calcado calcado);
    public boolean setLook(Look look, RoupaIntima roupaIntima);
    public boolean setLook(Look look, Acessorio acessorio);
    public List<Look> listarLooks();
    public List<Look> buscarLookPorNome(String nome);
}
