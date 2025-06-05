/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicoSuporte;

import com.mycompany.emprestimocorrijdo.interfaces.ImpressaoInterface;
import java.util.Date;

/**
 *
 * @author User
 */
public class ConsoleImpressao implements ImpressaoInterface {
    @Override
    public void logEmprestimo(int numeroLivros, Date dataEmprestimo, Date dataDevolucao) {
        System.out.println("Número de Livros Emprestados: " + numeroLivros);
        System.out.println("Data de Empréstimo: " + dataEmprestimo);
        System.out.println("Data de Devolução: " + dataDevolucao);
    }
}
