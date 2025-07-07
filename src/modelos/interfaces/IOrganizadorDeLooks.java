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
    public void mudarLook(Look look, RoupaSuperior roupaSuperior);
    public void mudarLook(Look look, RoupaInferior roupaInferior);
    public void mudarLook(Look look, Chapelaria chapeu);
    public void mudarLook(Look look, Calcado calcado);
    public void mudarLook(Look look, RoupaIntima roupaIntima);
    public void mudarLook(Look look, Acessorio acessorio);
    public List<Look> listarLooks();
    public Look buscarLookPorNome(String nome);
}
