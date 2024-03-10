package model;

import java.io.*;
import java.util.ArrayList;

public class PessoaJuridicaRepo {
    private ArrayList<PessoaJuridica> pessoasJuridicas = new ArrayList<PessoaJuridica>();

    public void inserir(PessoaJuridica pessoaJuridica) {
        pessoasJuridicas.add(pessoaJuridica);
    }

    public void alterar(int index, PessoaJuridica pessoaJuridica) {
        pessoasJuridicas.set(index, pessoaJuridica);
    }

    public void excluir(Integer id) {
        PessoaJuridica pessoaJuridica = obter(id);
        pessoasJuridicas.remove(pessoaJuridica);
    }

    public PessoaJuridica obter(Integer id) {
        for(PessoaJuridica pessoaJuridica: pessoasJuridicas) {
            if(pessoaJuridica.getId() == id) {
                return pessoaJuridica;
            }
        }
        return null;
    }

    public ArrayList<PessoaJuridica> obterTodos() {
        return pessoasJuridicas;
    }

    public void persistir(String nomeArquivo) {
        try (FileOutputStream fileOut = new FileOutputStream(nomeArquivo); ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(pessoasJuridicas);

            System.out.println("Dados de Pessoa Juridica Armazenados.");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void recuperar(String nomeArquivo) {
        try (FileInputStream fileIn = new FileInputStream(nomeArquivo); ObjectInputStream in = new ObjectInputStream(fileIn)) {
            pessoasJuridicas = (ArrayList<PessoaJuridica>) in.readObject();
            System.out.println("Dados de Pessoa Juridica Recuperados.");
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
