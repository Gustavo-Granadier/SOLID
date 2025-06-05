/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.emprestimocorrijdo;

/**
 *
 * @author User
 */

public class Titulo {
    int prazo;
    public Titulo(int codigo){
        this.prazo = codigo+1;
    }
    
    public int getPrazo() {
      return prazo;
    }

    public void setPrazo(int prazo) {
        this.prazo = prazo;
    }

}
