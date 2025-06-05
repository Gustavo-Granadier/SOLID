/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.emprestimocorrijdo;

import com.mycompany.emprestimocorrijdo.interfaces.CalculadoraDevolucaoInterface;
import java.util.Date;

/**
 *
 * @author User
 */
public class Item {
   private final Livro livro;
    private Date dataDevolucao;
    private final CalculadoraDevolucaoInterface calculadora;

    public Item(Livro livro, CalculadoraDevolucaoInterface calculadora) {
        if (livro == null || calculadora == null) {
            throw new IllegalArgumentException("Parâmetros não podem ser nulos");
        }
        this.livro = livro;
        this.calculadora = calculadora;
    }

    public Livro getLivro() {
        return livro;
    }

    public Date getDataDevolucao() {
        return dataDevolucao != null ? new Date(dataDevolucao.getTime()) : null;
    }

    public void setDataDevolucao(Date data) {
        this.dataDevolucao = data != null ? new Date(data.getTime()) : null;
    }

    public int getPrazo() {
        return livro.verPrazo();
    }
}

