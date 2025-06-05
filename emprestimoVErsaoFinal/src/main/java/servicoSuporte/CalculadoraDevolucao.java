/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicoSuporte;

import com.mycompany.emprestimocorrijdo.Item;
import com.mycompany.emprestimocorrijdo.interfaces.CalculadoraDevolucaoInterface;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 *
 * @author User
 */
public class CalculadoraDevolucao implements CalculadoraDevolucaoInterface {
    @Override
    public Date calcularDataDevolucao(List<Item> itens, Date dataEmprestimo) {
        if (itens == null || itens.isEmpty() || dataEmprestimo == null) {
            throw new IllegalArgumentException("Parâmetros inválidos");
        }

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(dataEmprestimo);

        // Encontra o maior prazo entre os itens
        int prazoMaximo = itens.stream()
                             .mapToInt(Item::getPrazo)
                             .max()
                             .orElse(0);

        // Adiciona dias extras para mais de 2 itens
        if (itens.size() > 2) {
            prazoMaximo += (itens.size() - 2) * 2;
        }

        calendar.add(Calendar.DAY_OF_MONTH, prazoMaximo);
        return calendar.getTime();
    }
}
