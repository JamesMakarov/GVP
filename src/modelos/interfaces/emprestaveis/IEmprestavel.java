package modelos.interfaces.emprestaveis;

public interface IEmprestavel {
    public void Emprestar();
    public void Devolver();
    public int quantidadeDeDiasDesdeOEmprestimo();
    public boolean isEmprestado();
}
