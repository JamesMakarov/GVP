    package organizadores;

    import java.util.ArrayList;
    import java.util.List;

    import modelos.Item;
    import modelos.Look;
    import modelos.interfaces.lavaveis.ILavavel;
    import modelos.interfaces.lavaveis.IOrganizadorDeLavagens;
    import guardaroupa.GuardaRoupa;

    public class OrganizadorDeLavagens implements IOrganizadorDeLavagens {
        
        private GuardaRoupa guardaRoupaAtual;

        public OrganizadorDeLavagens(GuardaRoupa guardaRoupa) {
            this.guardaRoupaAtual = guardaRoupa;
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
        public boolean lavarLook(Look look) {
            int cont = 0;
            for (Item i : look.listarItensDoLook()) {
                if (i instanceof ILavavel iLavavel) {
                    if (iLavavel.Lavar()) {
                        cont++;
                    }
                }
            }
            return cont > 0;
        }

        @Override
        public int diasDesdeUltimaLavagem(Item item) {
            return 0;
        }

        @Override
        public List<Item> listarItensLavaveis() {
            List<Item> lista = new ArrayList<>();
            for (Item i : guardaRoupaAtual.listarItens()) {
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

        @Override
        public List<Item> listaItensSujos() {
            List<Item> lista = new ArrayList<>();
            for (Item i : listarItensLavaveis()) {
                ILavavel j = (ILavavel) i;
                if (!j.isLavado()) lista.add(i);
            }
            return lista;
        }


    }
