package modelos.interfaces.lavaveis;


public interface ILavavel {
  public boolean Lavar();
  public boolean isLavado();
  public int diasDesdeUltimaLavagem();
  public boolean Usar(String Ocasiao);
}