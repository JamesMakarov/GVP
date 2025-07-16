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

    // Criadores de Itens, utilizamos sobrecarga para cada classe, e o tipo o usuário escolhe no GUI
    public RoupaSuperior criarItem(RoupaSuperior.Tipo tipo, String nome, String cor, String tamanho, String marca, String estado);
    public RoupaInferior criarItem(RoupaInferior.Tipo tipo, String nome, String cor, String tamanho, String marca, String estado);
    public RoupaIntima criarItem(RoupaIntima.Tipo tipo, String nome, String cor, String tamanho, String marca, String estado);
    public Acessorio criarItem(Acessorio.Tipo tipo, String nome, String cor, String tamanho, String marca, String estado);
    public Calcado criarItem(Calcado.Tipo tipo, String nome, String cor, String tamanho, String marca, String estado);
    public Chapelaria criarItem(Chapelaria.Tipo tipo, String nome, String cor, String tamanho, String marca, String estado);

    // Removedores de itens
    public boolean removerItem(Item item);
    public boolean removerItemPorNome(String nome);

    // Editores de Item (Tipo não é possível se editar, pois, uma blusa não pode se tornar uma calça, ou um sapato)
    public boolean editarItem(Item item, String nome, String cor, String tamanho, String marca, String estado);

    //  Listadores de Itens
    public List<Item> listarItensPorTipo(RoupaSuperior.Tipo tipo);
    public List<Item> listarItensPorTipo(RoupaInferior.Tipo tipo);
    public List<Item> listarItensPorTipo(RoupaIntima.Tipo tipo);
    public List<Item> listarItensPorTipo(Acessorio.Tipo tipo);
    public List<Item> listarItensPorTipo(Chapelaria.Tipo tipo);
    public List<Item> listarItensPorTipo(Calcado.Tipo tipo);
    public List<Item> listarTodosOsItens();

    // Buscas de Itens
    public List<Item> buscarItensPorNome(String nome);
}
