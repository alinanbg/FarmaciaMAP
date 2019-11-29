/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.map.farmacia.util;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 *
 * @author alina
 */
public class MenssagensUtil {
    
    public static final Locale PT_BR = new Locale("pt", "BR");
    public static final Locale EN_US = new Locale("en", "US");
    public static final Locale ES_ES = new Locale("es", "ES");
    
    private static ResourceBundle resource = ResourceBundle.getBundle("mensagens", PT_BR);
    

    //public static final String MSG_VALIDACAO_NOME = "msg.validacao.nome";
    
    
    public static String getMensagem(String key){
        return resource.getString(key);
    }
    
    public static void setLocale(Locale local){
        resource = ResourceBundle.getBundle("mensagens", local);
    }
}
