/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicoSuporte;

import com.mycompany.emprestimocorrijdo.Livro;
import com.mycompany.emprestimocorrijdo.interfaces.ValidacaoLivro;

/**
 *
 * @author User
 */
public class ValidadorLivro implements ValidacaoLivro {
    @Override
    public boolean isExemplarBiblioteca(Livro livro) {
       return livro.getCodigo() == 3;
    }
}
