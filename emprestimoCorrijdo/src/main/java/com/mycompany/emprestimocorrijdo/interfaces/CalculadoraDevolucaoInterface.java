/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.emprestimocorrijdo.interfaces;

import com.mycompany.emprestimocorrijdo.Item;
import java.util.Date;
import java.util.List;

/**
 *
 * @author User
 */
public interface CalculadoraDevolucaoInterface {
    Date calcularDataDevolucao(List<Item> itens, Date dataBase);
}
