/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicoSuporte;

import com.mycompany.emprestimocorrijdo.interfaces.ValidacaoAluno;


/**
 *
 * @author User
 */
public class ValidadorAluno implements ValidacaoAluno {
   @Override
    public boolean validarAluno(String ra) {
        return !ra.equals("10");
    }
}
