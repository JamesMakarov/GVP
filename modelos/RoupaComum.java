package modelos;

public abstract class RoupaComum extends Item implements ILavavel, IEmprestavel {
    //#region Atributos

    private boolean emprestado;
    private String dataDoEmprestimo;
    private String dataLavagem;
    
    //#endregion

    //#region Getters e Setters

    public boolean estaEmprestado() {
        return emprestado;
    }

    public String getDataDoEmprestimo() {
        return dataDoEmprestimo;
    }

    public String getDataLavagem() {
        return dataLavagem;
    }

    //#endregion

    //#region Construtores:

    public RoupaComum(String nome, String cor, String tamanho, String marca, String estado) {
        super(nome, cor, tamanho, marca, estado);
        this.emprestado = false;
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

    //#region Métodos ILavavel

    public void dataDeLavagem(String data){
        this.dataLavagem = data;
    }
    
    //#endregion
    
    //#region Métodos Abstratos

    public abstract short getTipo();

    //#endregion

}
