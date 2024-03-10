import model.*;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        PessoaFisicaRepo repo1 = new PessoaFisicaRepo();
        repo1.inserir(new PessoaFisica(1, "Darir", "96449802049", 20));
        repo1.inserir(new PessoaFisica(2, "Liapa", "44839498024", 19));
        repo1.persistir("repo1.bin");

        PessoaFisicaRepo repo2 = new PessoaFisicaRepo();
        repo2.recuperar("repo1.bin");
        ArrayList<PessoaFisica> listaPessoasFisicas = repo2.obterTodos();
        listaPessoasFisicas.forEach(PessoaFisica::exibir);

        PessoaJuridicaRepo repo3 = new PessoaJuridicaRepo();
        repo3.inserir(new PessoaJuridica(1, "Empresa Um LTDA", "21822871000160"));
        repo3.inserir(new PessoaJuridica(2, "Empresa Dois LTDA", "30586279000106"));
        repo3.persistir("repo3.bin");

        PessoaJuridicaRepo repo4 = new PessoaJuridicaRepo();
        repo4.recuperar("repo3.bin");
        ArrayList<PessoaJuridica> listaPessoasJuridicas = repo4.obterTodos();
        listaPessoasJuridicas.forEach(PessoaJuridica::exibir);
    }
}
