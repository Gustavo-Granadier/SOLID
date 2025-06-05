/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.emprestimocorrijdo;

import com.mycompany.emprestimocorrijdo.interfaces.DebitoInterface;
import com.mycompany.emprestimocorrijdo.interfaces.EmprestimoInterface;
import com.mycompany.emprestimocorrijdo.interfaces.ValidacaoAluno;
import java.util.List;

/**
 *
 * @author User
 */
public class Aluno {
    private String RA;
    private final DebitoInterface debitoService;
    private final EmprestimoInterface emprestimoService;
    private final ValidacaoAluno alunoValidator;

    public Aluno(String ra, 
                 ValidacaoAluno alunoValidator,
                 DebitoInterface debitoService, 
                 EmprestimoInterface emprestimoService) {
        this.RA = ra;
        this.alunoValidator = alunoValidator;
        this.debitoService = debitoService;
        this.emprestimoService = emprestimoService;
    }

    public String getRA() {
        return RA;
    }

    public void setRA(String ra) {
        this.RA = ra;
    }

    public boolean verficaAluno() {
        return alunoValidator.validarAluno(this.RA);
    }

    public boolean verificaDebito() {
        return debitoService.verificarDebito(this.RA);
    }

    public boolean emprestar(List<Livro> livros) {
        return emprestimoService.emprestar(livros);
    }
}

