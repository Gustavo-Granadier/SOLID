/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.emprestimocorrijdo;

import com.mycompany.emprestimocorrijdo.interfaces.DebitoInterface;
import com.mycompany.emprestimocorrijdo.interfaces.EmprestimoInterface;
import com.mycompany.emprestimocorrijdo.interfaces.ValidacaoAluno;
import com.mycompany.emprestimocorrijdo.interfaces.ValidacaoLivro;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 */
public class Controle {

  private final DebitoInterface debitoService;
    private final EmprestimoInterface emprestimoService;
    private final ValidacaoAluno alunoValidator;
    private final ValidacaoLivro livroValidator;

    public Controle(
            DebitoInterface debitoService,
            EmprestimoInterface emprestimoService,
            ValidacaoAluno alunoValidator,
            ValidacaoLivro livroValidator) {
        this.debitoService = debitoService;
        this.emprestimoService = emprestimoService;
        this.alunoValidator = alunoValidator;
        this.livroValidator = livroValidator;
    }

    public boolean emprestar(String ra, int[] prazos, int num) {
        if (ra == null || prazos == null || num <= 0) {
            return false;
        }

        // Criar aluno com suas dependências
        Aluno aluno = new Aluno(ra, alunoValidator, debitoService, emprestimoService);

        // Verificar aluno
        if (!aluno.verficaAluno()) {
            System.out.println("Aluno Inexistente");
            return false;
        }

        // Verificar débitos
        if (!aluno.verificaDebito()) {
            System.out.println("Aluno em Débito");
            return false;
        }

        // Processar livros
        List<Livro> livrosDisponiveis = processarLivros(prazos, num);
        if (livrosDisponiveis.isEmpty()) {
            System.out.println("Nenhum livro disponível para empréstimo");
            return false;
        }

        // Realizar empréstimo
        return aluno.emprestar(livrosDisponiveis);
    }

    private List<Livro> processarLivros(int[] prazos, int num) {
        List<Livro> livrosDisponiveis = new ArrayList<>();
        
        for (int i = 0; i < num; i++) {
            Livro livro = new Livro(prazos[i]);
            if (!livroValidator.isExemplarBiblioteca(livro)) {
                livrosDisponiveis.add(livro);
            }
        }
        
        return livrosDisponiveis;
    }
}

