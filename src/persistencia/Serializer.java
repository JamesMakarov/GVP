package persistencia;

import guardaroupa.autenticacao.ControladorAutenticacao;

import java.io.*;

public class Serializer {

    public static boolean salvarCADat(ControladorAutenticacao controladorautenticacao) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("arquivos/controladorautenticacao.dat");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(controladorautenticacao);
            fileOutputStream.close();
            objectOutputStream.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static ControladorAutenticacao lerCADat() {
        try {
            File arquivo =  new File("arquivos/controladorautenticacao.dat");
            //Erro resolvido, ebaaaaaaa, arquivo
            if (arquivo.length() == 0) {
                return null;
            }
            FileInputStream fileInputStream = new FileInputStream("arquivos/controladorautenticacao.dat");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            ControladorAutenticacao controladorautenticacao = (ControladorAutenticacao) objectInputStream.readObject();
            objectInputStream.close();
            fileInputStream.close();
            return controladorautenticacao;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


}
