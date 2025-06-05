/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicoSuporte;

import com.mycompany.emprestimocorrijdo.Debito;
import com.mycompany.emprestimocorrijdo.interfaces.VerificacaoDebito;

/**
 *
 * @author User
 */
public class VerificadorDebito implements VerificacaoDebito {
    @Override
    public boolean verificarDebito(String ra) {
        try {
            int codigoAluno = Integer.parseInt(ra);
            return new Debito(codigoAluno).verificaDebito();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("RA inválido");
        }
    }
}
