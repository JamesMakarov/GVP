    package guardaroupa;

    import modelos.Item;
    import modelos.Look;

    import java.io.Serial;
    import java.io.Serializable;
    import java.util.List;
    import java.util.ArrayList;

    public class GuardaRoupa implements Serializable {

        @Serial
        private static final long serialVersionUID = 1L;

        private String nome;
        private final List<Item> itens;
        private final List<Look> looks;

        //#region Construtores

        public GuardaRoupa(String nome) {
            this.nome = nome;
            this.itens = new ArrayList<>();
            this.looks = new ArrayList<>();
        }

        //#endregion

       //#region Getters e Setters
        public String getNome() {

            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        //#endregion

        public List<Item> listarItens() {
            return itens;
        }

        public void adicionarItem(Item item) {
            this.itens.add(item);
        }

        public void removerItem(Item item) {
            this.itens.remove(item);
        }

        public List<Look> listarLooks() {
            return looks;
        }

        public void adicionarLook(Look look) {
            this.looks.add(look);
        }

        public void removerLook(Look look) {
            this.looks.remove(look);
        }

        @Override
        public String toString() {
            return nome;
        }
    }
