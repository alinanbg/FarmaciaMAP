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
    public static final String MSG_VALIDACAO_NOME = "msg.validacao.nome";
    
    public static final String MSG_ERRO_SALVAR = "msg.erro.salvar";
    public static final String MSG_ERRO_EXCLUIR = "msg.erro.excluir";
    public static final String MSG_CONFIRMACAO_EXCLUIR = "msg.confirmacao.excluir";
    public static final String MSG_ERRO_SELECIONAR = "msg.erro.selecionar";
    public static final String MSG_BUTTON_NOVO = "msg.button.novo";
    public static final String MSG_BUTTON_EDITAR = "msg.button.editar";
    public static final String MSG_BUTTON_EXCLUIR = "msg.button.editar";
    public static final String MSG_BUTTON_SAIR = "msg.button.sair";
    public static final String MSG_TITULO_FARMACIA = "msg.titulo.farmacia";
    public static final String MSG_TITULO_EDITARFARMACIA = "mag.titulo.editarfarmacia";
    public static final String MSG_TABELA_CODIGO = "msg.tabela.codigo";
    public static final String MSG_TABELA_NOME = "msg.tabela.nome";
    public static final String MSG_TABELA_CNPJ = "msg.tabela.cnpj";
    public static final String MSG_TABELA_TELEFONE = "msg.tabela.telefone";
    public static final String MSG_TABELA_EMAIL = "msg.tabela.email";
    public static final String MSG_TABELA_RUA = "msg.tabela.rua";
    public static final String MSG_TABELA_NUMERO = "msg.tabela.numero";
    public static final String MSG_TABELA_BAIRRO = "msg.tabela.bairro";
    public static final String MSG_TABELA_CIDADE = "msg.tabela.cidade";
    public static final String MSG_TABELA_ESTADO = "msg.tabela.estado";
    public static final String MSG_TABELA_CEP = "msg.tabela.cep";
    public static final String MSG_TABELA_DATANASCIMENTO = "msg.tabela.datanascimento";
    public static final String MSG_MENU_IDIOMA = "msg.menu.idioma";
        
    
    public static String getMensagem(String key){
        return resource.getString(key);
    }
    
    public static void setLocale(Locale local){
        resource = ResourceBundle.getBundle("mensagens", local);
    }
}
