    package organizadores;

    import java.util.ArrayList;
    import java.util.List;

    import modelos.Item;
    import modelos.Look;
    import modelos.interfaces.lavaveis.ILavavel;
    import modelos.interfaces.lavaveis.IOrganizadorDeLavagens;
    import usuarios.Usuario;

    public class OrganizadorDeLavagens implements IOrganizadorDeLavagens {
        
        private Usuario usuarioAtual;

        public OrganizadorDeLavagens(Usuario usuario) {
            this.usuarioAtual = usuario;
        }

        @Override
        public boolean Lavar(Item item) {
            if (item == null) return false;
            if (item instanceof ILavavel iLavavel) {
                if (iLavavel.isLavado()) {
                    System.out.println("Item já está lavado");
                    return false;
                }

                iLavavel.Lavar();
                System.out.println("Lavagem concluída");
                return true;
            } 
            System.out.println("Não é possivel lavar um item não lavável");
            return false;
        }

        @Override
        public void lavarLook(Look look) {
            for (Item i : look.listarItensDoLook()) {
                if (i instanceof ILavavel iLavavel) {
                    iLavavel.Lavar();
                }
            }
        }

        @Override
        public int diasDesdeUltimaLavagem(Item item) {
            return 0;
        }

        @Override
        public List<Item> listarItensLavaveis() {
            List<Item> lista = new ArrayList<>();
            for (Item i : usuarioAtual.listarItens()) {
                if (i instanceof ILavavel) lista.add(i);
            }
            return lista;
        }

        @Override
        public List<Item> listarItensLavados() {
            List<Item> lista = new ArrayList<>();
            for (Item i : listarItensLavaveis()) {
                ILavavel j = (ILavavel) i;
                if (j.isLavado()) {
                    lista.add(i);
                }
            }
            return lista;
        }
    }
