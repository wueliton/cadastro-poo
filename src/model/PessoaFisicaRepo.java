package model;

import java.io.*;
import java.util.ArrayList;

public class PessoaFisicaRepo {
    private ArrayList<PessoaFisica> pessoasFisicas = new ArrayList<PessoaFisica>();

    public void inserir(PessoaFisica pessoaFisica) {
        pessoasFisicas.add(pessoaFisica);
    }

    public void alterar(int index, PessoaFisica pessoaFisica) {

        pessoasFisicas.set(index, pessoaFisica);
    }

    public void excluir(Integer id) {
        PessoaFisica pessoaFisica = obter(id);
        pessoasFisicas.remove(pessoaFisica);
    }

    public PessoaFisica obter(int id) {
        for(PessoaFisica pessoaFisica: pessoasFisicas) {
            if(pessoaFisica.getId() == id) {
                return pessoaFisica;
            }
        }

        return null;
    }

    public ArrayList<PessoaFisica> obterTodos() {
        return pessoasFisicas;
    }

    public void persistir(String nomeArquivo) {
        try (FileOutputStream fileOut = new FileOutputStream(nomeArquivo); ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(pessoasFisicas);

            System.out.println("Dados de Pessoa Física Armazenados.");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void recuperar(String nomeArquivo) {
        try (FileInputStream fileIn = new FileInputStream(nomeArquivo); ObjectInputStream in = new ObjectInputStream(fileIn)) {
            pessoasFisicas = (ArrayList<PessoaFisica>) in.readObject();
            System.out.println("Dados de Pessoa Física Recuperados.");
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
