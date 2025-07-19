    package pessoa;

    public class SessaoPessoa {
        private static Pessoa pessoa;

        public static void setPessoa(Pessoa p) {
            pessoa = p;
        }

        public static Pessoa getPessoa() {
            return pessoa;
        }
    }
