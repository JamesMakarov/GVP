package modelos.interfaces;

import java.util.List;

import modelos.Item;
import modelos.subgrupositens.Acessorio;
import modelos.subgrupositens.RoupaIntima;
import modelos.subgrupositens.tiposroupacomum.Calcado;
import modelos.subgrupositens.tiposroupacomum.Chapelaria;
import modelos.subgrupositens.tiposroupacomum.RoupaInferior;
import modelos.subgrupositens.tiposroupacomum.RoupaSuperior;

public interface IOrganizadorDeItens {
    public boolean adicionarItem(Item item);
    public boolean removerItem(Item item);
    public void removerItemPorNome(String nome);
    public boolean editarItem(Item item, String nome, String cor, String tamanho, String marca, String estado);
    public List<Item> listarItensPorTipo(RoupaSuperior.Tipo tipo);
    public List<Item> listarItensPorTipo(RoupaInferior.Tipo tipo);
    public List<Item> listarItensPorTipo(RoupaIntima.Tipo tipo);
    public List<Item> listarItensPorTipo(Acessorio.Tipo tipo);
    public List<Item> listarItensPorTipo(Chapelaria.Tipo tipo);
    public List<Item> listarItensPorTipo(Calcado.Tipo tipo);
    public List<Item> listarTodosOsItens();
    public Item buscarItemPorNome(String nome);
}
