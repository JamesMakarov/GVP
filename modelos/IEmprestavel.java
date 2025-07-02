package modelos;

interface IEmprestavel {
    void Emprestando(String Data);
    void Devolvendo();
    int quantidadeDeDiasDesdeOEmprestimo();
}
