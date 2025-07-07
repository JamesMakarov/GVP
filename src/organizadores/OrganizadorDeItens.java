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

        public boolean adicionarItem(Item item) {
            if (item == null) {
                System.out.println("Não são permitidos itens nulos!");
                return false;
            } 
            for (Item i : usuario.listarItens()) {
                if ((i.getNome().equals(item.getNome())) &&
                    (i.getCor().equals(item.getCor())) && 
                    (i.getMarca().equals(item.getMarca())) &&
                    (i.getTamanho().equals(item.getTamanho()))) {
                    System.out.println("O item já existe na lista de itens");
                    return false;
                }
            }
            usuario.adicionarItem(item);
            System.out.println("Item adicionado!");
            return true;
        }
        
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
