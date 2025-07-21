    package organizadores;

    import java.util.ArrayList;
    import java.util.List;

    import guardaroupa.autenticacao.ControladorAutenticacao;
    import modelos.Item;
    import modelos.Look;
    import modelos.interfaces.lavaveis.ILavavel;
    import modelos.interfaces.lavaveis.IOrganizadorDeLavagens;
    import guardaroupa.GuardaRoupa;
    import utils.CalculadoraDias;

    import static persistencia.Serializer.salvarCADat;

    public class OrganizadorDeLavagens implements IOrganizadorDeLavagens {
        
        private final GuardaRoupa guardaRoupaAtual;

        public OrganizadorDeLavagens() {
            this.guardaRoupaAtual = ControladorAutenticacao.getInstancia().getGuardaRoupaAtual();
        }

        @Override
        public boolean Lavar(Item item) {
            if (item == null) return false;
            if (item instanceof ILavavel iLavavel && !iLavavel.isLavado()) {
                boolean resultado = iLavavel.Lavar();
                System.out.println("Lavagem concluída");
                salvarCADat(ControladorAutenticacao.getInstancia());
                return resultado;
            } 
            System.out.println("Não é possivel lavar um item não lavável ou lavado");
            return false;
        }

        @Override
        public boolean lavarLook(Look look) {
            int cont = 0;
            for (Item i : look.listarItensDoLook()) {
                if (i instanceof ILavavel iLavavel && !iLavavel.isLavado()) {
                    iLavavel.Lavar();
                    cont++;
                }
            }
            salvarCADat(ControladorAutenticacao.getInstancia());
            return cont > 0;
        }

        @Override
        public int diasDesdeUltimaLavagem(Item item) {
            if (item instanceof ILavavel iLavavel) {
                return iLavavel.diasDesdeUltimaLavagem();
            }
            return -1;
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

        public GuardaRoupa getGuardaRoupaAtual() {
            return this.guardaRoupaAtual;
        }
    }
