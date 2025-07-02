package modelos;

public abstract class Acessorio extends Item implements IEmprestavel {
    
    private boolean emprestado;
    private String dataDoEmprestimo;
    
    //#region Construtores:
    public Acessorio(String nome, String cor, String tamanho, String marca, String estado) {
        super(nome, cor, tamanho, marca, estado);
        this.emprestado = false;
    }
    //#endregion

    //#region Getters e Setters
    public boolean estaEmprestado() {
        return emprestado;
    }

    public String getDataDoEmprestimo() {
        return dataDoEmprestimo;
    }
    //#endregion

    //#region Métodos IEmprestavel
    @Override
    public void Emprestando(String data) {
        this.emprestado = true;
        this.dataDoEmprestimo = data;
    }

    @Override
    public void Devolvendo() {
        this.emprestado = false;
        this.dataDoEmprestimo = null;
    }

    @Override
    public int quantidadeDeDiasDesdeOEmprestimo() {
        return 0;
    }
    //#endregion

    //#region Métodos Abstratos

     public abstract short getTipo();

     //#endregion
}
