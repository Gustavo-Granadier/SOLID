/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servicoSuporte;

import com.mycompany.emprestimocorrijdo.Debito;
import com.mycompany.emprestimocorrijdo.interfaces.DebitoInterface;

/**
 *
 * @author User
 */
public class DebitoSuporte implements DebitoInterface{
    @Override
    public boolean verificarDebito(String ra) {
        Debito debito = new Debito(Integer.parseInt(ra));
        return debito.verificaDebito();
    }
}
