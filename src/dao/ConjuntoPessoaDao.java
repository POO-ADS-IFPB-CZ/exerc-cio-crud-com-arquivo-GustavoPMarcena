package dao;

import model.Pessoa;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class ConjuntoPessoaDao {
    private Set<Pessoa> pessoas;
    private File arquivo;

    public ConjuntoPessoaDao(){
        pessoas = new HashSet<>();
        arquivo = new File("pessoas.ser");
        checkFile();
        getPessoas();
    }

    private void checkFile() {
        try {
            arquivo.createNewFile();
        } catch (IOException e) {
            System.out.println("Falha ao criar arquivo!");
        }
    }

    public void getPessoas(){
        if(arquivo.length()>0){
            try{
                FileInputStream inputStream = new FileInputStream(arquivo);
                ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
                pessoas = (Set<Pessoa>) objectInputStream.readObject();

            } catch (FileNotFoundException e) {
                System.out.println("Arquivo não encontrado");
            } catch (IOException e) {
                System.out.println("Falha ao ler arquivo");
            } catch (ClassNotFoundException e) {
                System.out.println("Falha ao ler arquivo");
            }
        }
        //Caso não tenha nada no arquivo, o programa continua normalmente

    }

    public boolean adicionarPessoa(Pessoa pessoa){
        if(pessoas.add(pessoa)){
            try{
                FileOutputStream outputStream = new FileOutputStream(arquivo);
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
                objectOutputStream.writeObject(pessoas);
                return true;
            } catch (FileNotFoundException e) {
                System.out.println("Arquivo não encontrado");
            } catch (IOException e) {
                System.out.println("Falha ao escrever no arquivo");
            }
        }
        return false;
    }

    public boolean removerPessoa(Pessoa pessoa){
        if(pessoas.remove(pessoa)){
            try{
                FileOutputStream outputStream = new FileOutputStream(arquivo);
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
                objectOutputStream.writeObject(pessoas);
                return true;
            } catch (FileNotFoundException e) {
                System.out.println("Arquivo não encontrado");
            } catch (IOException e) {
                System.out.println("Falha ao escrever no arquivo");
            }
        }
        return false;
    }

    public void listarPessoas(){
        for(Pessoa p : pessoas){
            System.out.println(p);
        }
    }


}




