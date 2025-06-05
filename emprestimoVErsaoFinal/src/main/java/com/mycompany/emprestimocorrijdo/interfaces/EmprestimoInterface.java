/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.emprestimocorrijdo.interfaces;

import com.mycompany.emprestimocorrijdo.Livro;
import java.util.List;

/**
 *
 * @author User
 */
public interface EmprestimoInterface {
    boolean emprestar(List<Livro> livros);
}
