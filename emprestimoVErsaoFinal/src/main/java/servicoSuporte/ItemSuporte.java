/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicoSuporte;

import com.mycompany.emprestimocorrijdo.Item;
import com.mycompany.emprestimocorrijdo.Livro;
import com.mycompany.emprestimocorrijdo.interfaces.CalculadoraDevolucaoInterface;
import com.mycompany.emprestimocorrijdo.interfaces.ItemInterface;

/**
 *
 * @author User
 */
public class ItemSuporte implements ItemInterface{
     private final CalculadoraDevolucaoInterface calculadora;

    public ItemSuporte(CalculadoraDevolucaoInterface calculadora) {
        if (calculadora == null) {
            throw new IllegalArgumentException("Calculadora não pode ser nula");
        }
        this.calculadora = calculadora;
    }

    @Override
    public Item criarItem(Livro livro) {
        if (livro == null) {
            throw new IllegalArgumentException("Livro não pode ser nulo");
        }
        return new Item(livro, calculadora);
    }
}
