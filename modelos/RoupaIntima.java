package modelos;

public abstract class RoupaIntima extends Item implements ILavavel {
    private boolean emprestado;
    private String dataDoEmprestimo;

    //#region Construtores:
    public RoupaIntima(String nome, String cor, String tamanho, String marca, String estado) {
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

    //#region Métodos Abstratos

    public abstract short getTipo();
    
    //#endregion
}
