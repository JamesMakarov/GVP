package organizadores;

import java.util.ArrayList;
import java.util.List;

import guardaroupa.autenticacao.ControladorAutenticacao;
import modelos.Item;
import modelos.Look;
import modelos.interfaces.IOrganizadorDeItens;
import modelos.subgrupositens.Acessorio;
import modelos.subgrupositens.RoupaComum;
import modelos.subgrupositens.RoupaIntima;
import modelos.subgrupositens.tiposroupacomum.Calcado;
import modelos.subgrupositens.tiposroupacomum.Chapelaria;
import modelos.subgrupositens.tiposroupacomum.RoupaInferior;
import modelos.subgrupositens.tiposroupacomum.RoupaSuperior;
import guardaroupa.GuardaRoupa;

import static GUI.classesestaticas.instanciasnecessias.Instancia.getInstanceOrgLoo;
import static persistencia.Serializer.salvarCADat;


public class OrganizadorDeItens implements IOrganizadorDeItens{

    private final GuardaRoupa guardaRoupa;
    private static Item itemAtual;

    public OrganizadorDeItens() {
        this.guardaRoupa = ControladorAutenticacao.getInstancia().getGuardaRoupaAtual();
    }

            //#region Criadores de Itens (Sobrecarregados)
            @Override
            public RoupaSuperior criarItem(RoupaSuperior.Tipo tipo, String nome, String cor, String tamanho, String marca, String estado) {
                for (Item i : listarTodosOsItens()) {
                    if (i instanceof RoupaSuperior roupaSuperior) {
                        if (roupaSuperior.getTipo().equals(tipo)       &&
                            roupaSuperior.getNome().equals(nome)       &&
                            roupaSuperior.getCor().equals(cor)         &&
                            roupaSuperior.getTamanho().equals(tamanho) &&
                            roupaSuperior.getMarca().equals(marca)     &&
                            roupaSuperior.getEstado().equals(estado) ) {
                                System.out.println("Já existe uma roupa com essas especificações");
                                return null;
                        }
                    }
                }
                RoupaSuperior roupaSuperior = new RoupaSuperior(tipo, nome, cor, tamanho, marca, estado);
                guardaRoupa.adicionarItem(roupaSuperior);
                salvarCADat(ControladorAutenticacao.getInstancia());
                return roupaSuperior;
            }
            @Override
            public RoupaInferior criarItem(RoupaInferior.Tipo tipo, String nome, String cor, String tamanho, String marca, String estado) {
                for (Item i : listarTodosOsItens()) {
                    if (i instanceof RoupaInferior roupaInferior) {
                        if (roupaInferior.getTipo().equals(tipo)       &&
                            roupaInferior.getNome().equals(nome)       &&
                            roupaInferior.getCor().equals(cor)         &&
                            roupaInferior.getTamanho().equals(tamanho) &&
                            roupaInferior.getMarca().equals(marca)     &&
                            roupaInferior.getEstado().equals(estado) ) {
                                System.out.println("Já existe uma roupa com essas especificações");
                                return null;
                        }
                    }
                }
                RoupaInferior roupaInferior = new RoupaInferior(tipo, nome, cor, tamanho, marca, estado);
                guardaRoupa.adicionarItem(roupaInferior);
                salvarCADat(ControladorAutenticacao.getInstancia());
                return roupaInferior;
            }
            @Override
            public RoupaIntima criarItem(RoupaIntima.Tipo tipo, String nome, String cor, String tamanho, String marca, String estado) {
                for (Item i : listarTodosOsItens()) {
                    if (i instanceof RoupaIntima roupaIntima) {
                        if (roupaIntima.getTipo().equals(tipo)       &&
                            roupaIntima.getNome().equals(nome)       &&
                            roupaIntima.getCor().equals(cor)         &&
                            roupaIntima.getTamanho().equals(tamanho) &&
                            roupaIntima.getMarca().equals(marca)     &&
                            roupaIntima.getEstado().equals(estado) ) {
                                System.out.println("Já existe uma roupa com essas especificações");
                                return null;
                        }
                    }
                }
                RoupaIntima roupaIntima = new RoupaIntima(tipo, nome, cor, tamanho, marca, estado);
                guardaRoupa.adicionarItem(roupaIntima);
                salvarCADat(ControladorAutenticacao.getInstancia());
                return roupaIntima;
            }
            @Override
            public Acessorio criarItem(Acessorio.Tipo tipo, String nome, String cor, String tamanho, String marca, String estado) {
                for (Item i : listarTodosOsItens()) {
                    if (i instanceof Acessorio acessorio) {
                        if (acessorio.getTipo().equals(tipo)       &&
                            acessorio.getNome().equals(nome)       &&
                            acessorio.getCor().equals(cor)         &&
                            acessorio.getTamanho().equals(tamanho) &&
                            acessorio.getMarca().equals(marca)     &&
                            acessorio.getEstado().equals(estado) ) {
                                System.out.println("Já existe uma roupa com essas especificações");
                                return null;
                        }
                    }
                }
                Acessorio acessorio = new Acessorio(tipo, nome, cor, tamanho, marca, estado);
                guardaRoupa.adicionarItem(acessorio);
                salvarCADat(ControladorAutenticacao.getInstancia());
                return acessorio;
            }
            @Override
            public Calcado criarItem(Calcado.Tipo tipo, String nome, String cor, String tamanho, String marca, String estado) {
                for (Item i : listarTodosOsItens()) {
                    if (i instanceof Calcado calcado) {
                        if (calcado.getTipo().equals(tipo)       &&
                            calcado.getNome().equals(nome)       &&
                            calcado.getCor().equals(cor)         &&
                            calcado.getTamanho().equals(tamanho) &&
                            calcado.getMarca().equals(marca)     &&
                            calcado.getEstado().equals(estado) ) {
                                System.out.println("Já existe uma roupa com essas especificações");
                                return null;
                        }
                    }
                }
                Calcado calcado = new Calcado(tipo, nome, cor, tamanho, marca, estado);
                guardaRoupa.adicionarItem(calcado);
                salvarCADat(ControladorAutenticacao.getInstancia());
                return calcado;
            }
            @Override
            public Chapelaria criarItem(Chapelaria.Tipo tipo, String nome, String cor, String tamanho, String marca, String estado) {
                for (Item i : listarTodosOsItens()) {
                    if (i instanceof Chapelaria chapelaria) {
                        if (chapelaria.getTipo().equals(tipo)       &&
                            chapelaria.getNome().equals(nome)       &&
                            chapelaria.getCor().equals(cor)         &&
                            chapelaria.getTamanho().equals(tamanho) &&
                            chapelaria.getMarca().equals(marca)     &&
                            chapelaria.getEstado().equals(estado) ) {
                                System.out.println("Já existe uma roupa com essas especificações");
                                return null;
                        }
                    }
                }
                Chapelaria chapelaria = new Chapelaria(tipo, nome, cor, tamanho, marca, estado);
                guardaRoupa.adicionarItem(chapelaria);
                salvarCADat(ControladorAutenticacao.getInstancia());
                return chapelaria;
            }

            //#endregion
            @Override
            public boolean removerItem(Item item) {
                if (item == null) {
                    System.out.println("Não é possível remover um item nulo");
                    return false;
                }
                List<Look> looksRemover = new ArrayList<>();
                for (Look look : guardaRoupa.listarLooks()) {
                    for (Item item1 : look.listarItensDoLook()) {
                        if (item1.getNome().equals(item.getNome()) &&
                                item1.getCor().equals(item.getCor()) &&
                                item1.getMarca().equals(item.getMarca()) &&
                                item1.getTamanho().equals(item.getTamanho()) &&
                                item1.getEstado().equals(item.getEstado())) {
                            looksRemover.add(look);
                            break;
                        }
                    }
                }

                for (Look look : looksRemover) {
                    getInstanceOrgLoo().removerLook(look);
                }

                for (Item i: guardaRoupa.listarItens()) {
                    if (i.getNome().equals(item.getNome()) &&
                        i.getCor().equals(item.getCor()) &&
                        i.getMarca().equals(item.getMarca()) &&
                        i.getTamanho().equals(item.getTamanho()) &&
                        i.getEstado().equals(item.getEstado())) {
                        guardaRoupa.removerItem(i);
                        System.out.println("Item removido");
                        salvarCADat(ControladorAutenticacao.getInstancia());
                        return true;
                    }
                }
                System.out.println("Item não removido, erro!");
                return false;
            }
            @Override
            public boolean editarItem(Item item, String nome, String cor, String tamanho, String marca, String estado) {
                if (item == null) {
                    System.out.println("Não é permitido item nulo!");
                    return false;
                }
                item.setNome(nome);
                item.setCor(cor);
                item.setTamanho(tamanho);
                item.setMarca(marca);
                item.setEstado(estado);
                salvarCADat(ControladorAutenticacao.getInstancia());
                return true;
            }
            @Override
            public List<Item> listarItensPorTipo(RoupaSuperior.Tipo tipo) {
                List<Item> listaRoupaSuperiorPorTipo = new ArrayList<>();
                for (Item i : guardaRoupa.listarItens()) {
                    if (i instanceof RoupaSuperior roupaSuperior) {
                        if (roupaSuperior.getTipo().equals(tipo)){
                            listaRoupaSuperiorPorTipo.add(i);
                        }
                    }
                }

                return listaRoupaSuperiorPorTipo;

            }

            @Override
            public List<Item> listarItensPorTipo(RoupaInferior.Tipo tipo) {
                List<Item> listaRoupaInferiorPorTipo = new ArrayList<>();
                for (Item i : guardaRoupa.listarItens()) {
                    if (i instanceof RoupaInferior roupaInferior) {
                        if (roupaInferior.getTipo().equals(tipo)){
                            listaRoupaInferiorPorTipo.add(i);
                        }
                    }
                }
                return listaRoupaInferiorPorTipo;
            }

            @Override
            public List<Item> listarItensPorTipo(RoupaIntima.Tipo tipo) {
                List<Item> listaRoupaIntimaPorTipo = new ArrayList<>();
                for (Item i : guardaRoupa.listarItens()) {
                    if (i instanceof RoupaIntima roupaIntima) {
                        if (roupaIntima.getTipo().equals(tipo)){
                            listaRoupaIntimaPorTipo.add(i);
                        }
                    }
                }
                return listaRoupaIntimaPorTipo;
            }

            @Override
            public List<Item> listarItensPorTipo(Acessorio.Tipo tipo) {
                List<Item> listaAcessorioPorTipo = new ArrayList<>();
                for (Item i : guardaRoupa.listarItens()) {
                    if (i instanceof Acessorio Acessorio) {
                        if (Acessorio.getTipo().equals(tipo)){
                            listaAcessorioPorTipo.add(i);
                        }
                    }
                }
                return listaAcessorioPorTipo;
            }

            @Override
            public List<Item> listarItensPorTipo(Chapelaria.Tipo tipo) {
                List<Item> listaChapelariaPorTipo = new ArrayList<>();
                for (Item i : guardaRoupa.listarItens()) {
                    if (i instanceof Chapelaria Chapelaria) {
                        if (Chapelaria.getTipo().equals(tipo)){
                            listaChapelariaPorTipo.add(i);
                        }
                    }
                }
                return listaChapelariaPorTipo;
            }

            @Override
            public List<Item> listarItensPorTipo(Calcado.Tipo tipo) {
                List<Item> listaCalcadoPorTipo = new ArrayList<>();
                for (Item i : guardaRoupa.listarItens()) {
                    if (i instanceof Calcado Calcado) {
                        if (Calcado.getTipo().equals(tipo)){
                            listaCalcadoPorTipo.add(i);
                        }
                    }
                }
                return listaCalcadoPorTipo;
            }

            @Override
            public List<Item> listarTodosOsItens() {
                return guardaRoupa.listarItens();
            }

            @Override
            public List<Item> buscarItensPorNome(String nome) {
                List<Item> resultado = new ArrayList<>();
                for (Item i : guardaRoupa.listarItens()) {
                    if (i.getNome().toLowerCase().contains(nome.toLowerCase())) resultado.add(i);
                }
                return resultado;
            }
            @Override
            public boolean removerItemPorNome(String nome) {
                for (Item i : guardaRoupa.listarItens()) {
                    if (i.getNome().equals(nome)) if (removerItem(i)) {
                        salvarCADat(ControladorAutenticacao.getInstancia());
                        return true;
                    }

                }
                return false;
            }

            public Item getItemAtual() {
                return itemAtual;
            }

            public void setItemAtual(Item item) {
                itemAtual = item;
            }

            public void setItemAtualParaNull() {
                itemAtual = null;
            }

            public boolean usarItem(Item item, String ocasiao) {
                if (item instanceof RoupaIntima roupaIntima) {
                    return roupaIntima.Usar(ocasiao);
                } else if (item instanceof RoupaComum roupaComum) {
                    return roupaComum.Usar(ocasiao);
                } else if (item instanceof Acessorio acessorio) {
                    return acessorio.Usar(ocasiao);
                }
                return false;
            }

            public List<RoupaSuperior> listaDeRoupaSuperior() {
                List<RoupaSuperior> listaTodos = new  ArrayList<>();
                for (Item i : listarTodosOsItens()) {
                    if ( i instanceof RoupaSuperior roupaSuperior) {
                        listaTodos.add(roupaSuperior);
                    }
                }
                return listaTodos;
            }

            public List<RoupaInferior> listaDeRoupaInferior() {
                List<RoupaInferior> listaTodos = new  ArrayList<>();
                for (Item i : listarTodosOsItens()) {
                    if ( i instanceof RoupaInferior roupaInferior) {
                        listaTodos.add(roupaInferior);
                    }
                }
                return listaTodos;
            }

            public List<RoupaIntima> listaDeRoupaIntima() {
                List<RoupaIntima> listaTodos = new  ArrayList<>();
                for (Item i : listarTodosOsItens()) {
                    if ( i instanceof RoupaIntima roupaIntima) {
                        listaTodos.add(roupaIntima);
                    }
                }
                return listaTodos;
            }

            public List<Acessorio> listaDeAcessorio() {
                List<Acessorio> listaTodos = new  ArrayList<>();
                for (Item i : listarTodosOsItens()) {
                    if ( i instanceof Acessorio acessorio) {
                        listaTodos.add(acessorio);
                    }
                }
                return listaTodos;
            }

            public List<Chapelaria> listaDeChapelaria() {
                List<Chapelaria> listaTodos = new  ArrayList<>();
                for (Item i : listarTodosOsItens()) {
                    if ( i instanceof Chapelaria chapelaria) {
                        listaTodos.add(chapelaria);
                    }
                }
                return listaTodos;
            }

            public List<Calcado> listaDeCalcado() {
                List<Calcado> listaTodos = new  ArrayList<>();
                for (Item i : listarTodosOsItens()) {
                    if ( i instanceof Calcado calcado) {
                        listaTodos.add(calcado);
                    }
                }
                return listaTodos;
            }

        public GuardaRoupa getGuardaRoupaAtual() {
            return this.guardaRoupa;
        }


        }
