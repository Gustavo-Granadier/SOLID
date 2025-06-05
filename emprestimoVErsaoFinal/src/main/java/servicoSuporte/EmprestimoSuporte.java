/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicoSuporte;

import com.mycompany.emprestimocorrijdo.Emprestimo;
import com.mycompany.emprestimocorrijdo.Livro;
import com.mycompany.emprestimocorrijdo.interfaces.CalculadoraDevolucaoInterface;
import com.mycompany.emprestimocorrijdo.interfaces.EmprestimoInterface;
import com.mycompany.emprestimocorrijdo.interfaces.ImpressaoInterface;
import com.mycompany.emprestimocorrijdo.interfaces.ItemInterface;
import java.util.List;

/**
 *
 * @author User
 */
public class EmprestimoSuporte implements EmprestimoInterface{
   private final CalculadoraDevolucaoInterface calculadora;
   private final ImpressaoInterface logger;
   private final ItemInterface itemFactory;

    public EmprestimoSuporte(
        CalculadoraDevolucaoInterface calculadora,
        ImpressaoInterface logger,
        ItemInterface itemFactory) {
        
        this.calculadora = calculadora;
        this.logger = logger;
        this.itemFactory = itemFactory;
    }

    @Override
    public boolean emprestar(List<Livro> livros) {
        if (livros == null || livros.isEmpty()) {
            return false;
        }

        Emprestimo emprestimo = new Emprestimo(calculadora, logger, itemFactory);
        return emprestimo.emprestar(livros);
    }
}
