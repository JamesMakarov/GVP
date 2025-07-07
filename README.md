public void criarLook(String nome, List<Item> itens);
public void removerLook(Look look);
public void editarLook(Look look, String novoNome, List<Item> novosItens);
public List<Look> listarLooks();
public Look buscarLookPorNome(String nome);

public boolean emprestarItem(Item item);
public boolean devolverItem(Item item);
public long diasDesdeEmprestimo(Item item);
public List<Item> listarItensEmprestados();

public boolean lavarItem(Item item);
public long diasDesdeUltimaLavagem(Item item);
public List<Item> listarItensLavaveis();

