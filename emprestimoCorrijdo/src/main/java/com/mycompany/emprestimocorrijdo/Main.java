/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.emprestimocorrijdo;

import com.mycompany.emprestimocorrijdo.interfaces.CalculadoraDevolucaoInterface;
import com.mycompany.emprestimocorrijdo.interfaces.DebitoInterface;
import com.mycompany.emprestimocorrijdo.interfaces.EmprestimoInterface;
import com.mycompany.emprestimocorrijdo.interfaces.ImpressaoInterface;
import com.mycompany.emprestimocorrijdo.interfaces.ItemInterface;
import com.mycompany.emprestimocorrijdo.interfaces.ValidacaoAluno;
import com.mycompany.emprestimocorrijdo.interfaces.ValidacaoLivro;
import java.util.Scanner;
import servicoSuporte.CalculadoraDevolucao;
import servicoSuporte.ConsoleImpressao;
import servicoSuporte.DebitoSuporte;
import servicoSuporte.EmprestimoSuporte;
import servicoSuporte.ItemSuporte;
import servicoSuporte.ValidadorAluno;
import servicoSuporte.ValidadorLivro;

/**
 *
 * @author User
 */
public class Main {

	public static void main(String[] args) {
	// Criação dos serviços básicos
        CalculadoraDevolucaoInterface calculadora = new CalculadoraDevolucao();
        ImpressaoInterface logger = new ConsoleImpressao();
        ItemInterface itemFactory = new ItemSuporte(calculadora);
        
        // Criação dos serviços principais
        DebitoInterface debitoService = new DebitoSuporte();
        EmprestimoInterface emprestimoService = new EmprestimoSuporte(
            calculadora,
            logger,
            itemFactory
        );
        ValidacaoAluno alunoValidator = new ValidadorAluno();
        ValidacaoLivro livroValidator = new ValidadorLivro();
        
        // Criação do controle com suas dependências
        Controle controle = new Controle(
            debitoService,
            emprestimoService,
            alunoValidator,
            livroValidator
        );

        try (Scanner entrada = new Scanner(System.in)) {
            // Leitura do RA
            System.out.print("Digite o RA do Aluno: ");
            String aluno = entrada.nextLine();

            // Leitura do número de livros
            System.out.print("Digite o número de Livros a ser Emprestado: ");
            int num = entrada.nextInt();
            
            if (num <= 0 || num > 14) {
                System.out.println("Número de livros inválido");
                return;
            }

            // Leitura dos códigos dos livros
            int[] codigos = new int[num];
            for (int i = 0; i < num; i++) {
                System.out.print("Digite o código do livro " + (i + 1) + ": ");
                codigos[i] = entrada.nextInt();
            }

            // Realiza o empréstimo
            boolean resultado = controle.emprestar(aluno, codigos, num);
            
            if (resultado) {
                System.out.println("Empréstimo realizado com sucesso!");
            } else {
                System.out.println("Não foi possível realizar o empréstimo");
            }
        }
    }
}
