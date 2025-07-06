package modelos.interfaces;

public interface IEmprestavel {
    public void Emprestar();
    public void Devolver();
    public long quantidadeDeDiasDesdeOEmprestimo();
    public boolean isEmprestado();
}
