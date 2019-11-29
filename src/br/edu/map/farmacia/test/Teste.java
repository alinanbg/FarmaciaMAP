/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.map.farmacia.test;

import br.edu.map.farmacia.dao.FarmaciaDAO;
import br.edu.map.farmacia.model.Farmacia;

/**
 *
 * @author alina
 */
public class Teste {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        
        Farmacia f = new Farmacia();
        
        f.setNome("Gilvanilsson");
        f.setCnpj("12345678");
        f.setTelefone("98765000");
        f.setEmail("nilsson@gmail");
        f.getId_endereco().setCidade("Patos");
        f.getId_endereco().setEstado("PB");
        f.getId_endereco().setCep("2");
        f.getId_endereco().setRua("lalala");
        f.getId_endereco().setNumero("78");
        f.getId_endereco().setBairro("1");
        
        FarmaciaDAO d = new FarmaciaDAO();
        
        d.inserir(f);
    }
    
}
