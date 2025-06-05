/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.emprestimocorrijdo;

import com.mycompany.emprestimocorrijdo.interfaces.LivroInterface;

/**
 *
 * @author User
 */
public class Livro implements LivroInterface {
	private final Titulo titulo;
    private final int codigo;

    public Livro(int codigo) {
        if (codigo < 0) {
            throw new IllegalArgumentException("Código do livro não pode ser negativo");
        }
        this.codigo = codigo;
        this.titulo = new Titulo(codigo);
    }

    @Override
    public int verPrazo() {
        return titulo.getPrazo();
    }

    public int getCodigo() {
        return codigo;
    }

    public Titulo getTitulo() {
        return titulo;
    }

    public boolean verificaLivro() {
        return this.codigo == 3;
    }
    	
}


