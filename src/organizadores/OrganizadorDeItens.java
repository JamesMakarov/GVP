    package organizadores;

    import java.util.ArrayList;
    import java.util.List;

    import modelos.Item;
    import modelos.interfaces.IOrganizadorDeItens;
    import modelos.subgrupositens.Acessorio;
    import modelos.subgrupositens.RoupaIntima;
    import modelos.subgrupositens.tiposroupacomum.Calcado;
    import modelos.subgrupositens.tiposroupacomum.Chapelaria;
    import modelos.subgrupositens.tiposroupacomum.RoupaInferior;
    import modelos.subgrupositens.tiposroupacomum.RoupaSuperior;
    import usuarios.Usuario;

    public class OrganizadorDeItens implements IOrganizadorDeItens{
        
        private Usuario usuario;

        public OrganizadorDeItens(Usuario usuario) {
            this.usuario = usuario;
        }

        //#region Criadores de Itens (Sobrecarregados)

        public RoupaSuperior criarItem(RoupaSuperior.Tipo tipo, String nome, String cor, String tamanho, String marca, String estado) {
            for (Item i : listarTodosOsItens()) {
                if (i instanceof RoupaSuperior) {
                    RoupaSuperior roupaSuperior = (RoupaSuperior) i;
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
            usuario.adicionarItem(roupaSuperior);
            return roupaSuperior;
        }

        public RoupaInferior criarItem(RoupaInferior.Tipo tipo, String nome, String cor, String tamanho, String marca, String estado) {
            for (Item i : listarTodosOsItens()) {
                if (i instanceof RoupaInferior) {
                    RoupaInferior roupaInferior = (RoupaInferior) i;
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
            usuario.adicionarItem(roupaInferior);
            return roupaInferior;
        }
        public RoupaIntima criarItem(RoupaIntima.Tipo tipo, String nome, String cor, String tamanho, String marca, String estado) {
            for (Item i : listarTodosOsItens()) {
                if (i instanceof RoupaIntima) {
                    RoupaIntima roupaIntima = (RoupaIntima) i;
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
            usuario.adicionarItem(roupaIntima);
            return roupaIntima;
        }
        public Acessorio criarItem(Acessorio.Tipo tipo, String nome, String cor, String tamanho, String marca, String estado) {
            for (Item i : listarTodosOsItens()) {
                if (i instanceof Acessorio) {
                    Acessorio acessorio = (Acessorio) i;
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
            usuario.adicionarItem(acessorio);
            return acessorio;
        }
        public Calcado criarItem(Calcado.Tipo tipo, String nome, String cor, String tamanho, String marca, String estado) {
            for (Item i : listarTodosOsItens()) {
                if (i instanceof Calcado) {
                    Calcado calcado = (Calcado) i;
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
            usuario.adicionarItem(calcado);
            return calcado;
        }
        public Chapelaria criarItem(Chapelaria.Tipo tipo, String nome, String cor, String tamanho, String marca, String estado) {
            for (Item i : listarTodosOsItens()) {
                if (i instanceof Chapelaria) {
                    Chapelaria chapelaria = (Chapelaria) i;
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
            usuario.adicionarItem(chapelaria);
            return chapelaria;
        }

        //#endregion
        
        public boolean removerItem(Item item) {
            if (item == null) {
                System.out.println("Não é possível remover um item nulo");
                return false;
            }
            for (Item i: usuario.listarItens()) {
                if (i.getNome().equals(item.getNome()) &&
                    i.getCor().equals(item.getCor()) &&
                    i.getMarca().equals(item.getMarca()) &&
                    i.getTamanho().equals(item.getTamanho())) {
                    usuario.removerItem(i);
                    System.out.println("Item removido");
                    return true;
                }
            }
            System.out.println("Item não removido, erro!");
            return false;
        }

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
            return true;
        }

        public List<Item> listarItensPorTipo(RoupaSuperior.Tipo tipo) {
            List<Item> listaRoupaSuperiorPorTipo = new ArrayList<>();
            for (Item i : usuario.listarItens()) {
                if (i instanceof RoupaSuperior) {
                    RoupaSuperior roupaSuperior = (RoupaSuperior)i;
                    if (roupaSuperior.getTipo().equals(tipo)){
                        listaRoupaSuperiorPorTipo.add(i);
                    }
                }
            }
            return listaRoupaSuperiorPorTipo;
            
        }

        public List<Item> listarItensPorTipo(RoupaInferior.Tipo tipo) {
            List<Item> listaRoupaInferiorPorTipo = new ArrayList<>();
            for (Item i : usuario.listarItens()) {
                if (i instanceof RoupaInferior) {
                    RoupaInferior roupaInferior = (RoupaInferior)i;
                    if (roupaInferior.getTipo().equals(tipo)){
                        listaRoupaInferiorPorTipo.add(i);
                    }
                }
            }
            return listaRoupaInferiorPorTipo;
        }

        public List<Item> listarItensPorTipo(RoupaIntima.Tipo tipo) {
            List<Item> listaRoupaIntimaPorTipo = new ArrayList<>();
            for (Item i : usuario.listarItens()) {
                if (i instanceof RoupaIntima) {
                    RoupaIntima roupaIntima = (RoupaIntima)i;
                    if (roupaIntima.getTipo().equals(tipo)){
                        listaRoupaIntimaPorTipo.add(i);
                    }
                }
            }
            return listaRoupaIntimaPorTipo;
        }

        public List<Item> listarItensPorTipo(Acessorio.Tipo tipo) {
            List<Item> listaAcessorioPorTipo = new ArrayList<>();
            for (Item i : usuario.listarItens()) {
                if (i instanceof Acessorio) {
                    Acessorio Acessorio = (Acessorio)i;
                    if (Acessorio.getTipo().equals(tipo)){
                        listaAcessorioPorTipo.add(i);
                    }
                }
            }
            return listaAcessorioPorTipo;
        }

        public List<Item> listarItensPorTipo(Chapelaria.Tipo tipo) {
            List<Item> listaChapelariaPorTipo = new ArrayList<>();
            for (Item i : usuario.listarItens()) {
                if (i instanceof Chapelaria) {
                    Chapelaria Chapelaria = (Chapelaria)i;
                    if (Chapelaria.getTipo().equals(tipo)){
                        listaChapelariaPorTipo.add(i);
                    }
                }
            }
            return listaChapelariaPorTipo;
        }

        public List<Item> listarItensPorTipo(Calcado.Tipo tipo) {
            List<Item> listaCalcadoPorTipo = new ArrayList<>();
            for (Item i : usuario.listarItens()) {
                if (i instanceof Calcado) {
                    Calcado Calcado = (Calcado)i;
                    if (Calcado.getTipo().equals(tipo)){
                        listaCalcadoPorTipo.add(i);
                    }
                }
            }
            return listaCalcadoPorTipo;
        }

        public List<Item> listarTodosOsItens() {
            return usuario.listarItens();
        }

        public Item buscarItemPorNome(String nome) {
            for (Item i : usuario.listarItens()) {
                if (i.getNome().equals(nome)) return i;
            }
            return null;
        }
        
        public void removerItemPorNome(String nome) {
            for (Item i : usuario.listarItens()) {
                if (i.getNome().equals(nome)) removerItem(i);
            }
        }

    }
