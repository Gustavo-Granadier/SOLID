/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.emprestimocorrijdo;

import com.mycompany.emprestimocorrijdo.interfaces.CalculadoraDevolucaoInterface;
import com.mycompany.emprestimocorrijdo.interfaces.ImpressaoInterface;
import com.mycompany.emprestimocorrijdo.interfaces.ItemInterface;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author User
 */
public class Emprestimo {
    private final Date dataEmprestimo;
    private Date dataPrevista;
    private final List<Item> itens;
    private final CalculadoraDevolucaoInterface calculadora;
    private final ImpressaoInterface logger;
    private final ItemInterface itemFactory;

    public Emprestimo(CalculadoraDevolucaoInterface calculadora, 
                     ImpressaoInterface logger,
                     ItemInterface itemFactory) {
        this.dataEmprestimo = new Date();
        this.itens = new ArrayList<>();
        this.calculadora = calculadora;
        this.logger = logger;
        this.itemFactory = itemFactory;
    }

    public Date getDataEmprestimo() {
        return new Date(dataEmprestimo.getTime());
    }

    public Date getDataPrevista() {
        return new Date(dataPrevista.getTime());
    }

    public boolean emprestar(List<Livro> livros) {
        if (livros == null || livros.isEmpty()) {
            return false;
        }

        for (Livro livro : livros) {
            itens.add(itemFactory.criarItem(livro));
        }

        dataPrevista = calculadora.calcularDataDevolucao(itens, dataEmprestimo);
        atualizarDataDevolucaoItens();
        
        logger.logEmprestimo(livros.size(), dataEmprestimo, dataPrevista);
        return true;
    }

    private void atualizarDataDevolucaoItens() {
        for (Item item : itens) {
            item.setDataDevolucao(dataPrevista);
        }
    }
}

