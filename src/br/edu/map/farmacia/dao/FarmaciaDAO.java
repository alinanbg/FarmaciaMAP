/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.map.farmacia.dao;

import br.edu.map.farmacia.model.Farmacia;
import br.edu.map.farmacia.util.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alina
 */
public class FarmaciaDAO {
    
    private Connection con;
    private PreparedStatement st;
    private String sql;
    
    public void inserir(Farmacia farmacia) throws Exception{
        
        sql = "insert into endereco (rua, numero, bairro, cidade, estado, cep) values (?,?,?,?,?,?)";
        
        con = ConnectionFactory.getConnection();
        
        st = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

        st.setString(1, farmacia.getId_endereco().getRua());
        st.setString(2, farmacia.getId_endereco().getNumero());
        st.setString(3, farmacia.getId_endereco().getBairro());
        st.setString(4, farmacia.getId_endereco().getCidade());
        st.setString(5, farmacia.getId_endereco().getEstado());
        st.setString(6, farmacia.getId_endereco().getCep());

        st.executeUpdate();
        
        ResultSet rs = st.getGeneratedKeys();
        int codigoEndereco = 0;
        if (rs.next()) {
            codigoEndereco = rs.getInt(1);
        }
        
        sql = "insert into farmacia (nome, cnpj, telefone, email, id_endereco) values (?,?,?,?,?)";

        st = con.prepareStatement(sql);

        st.setString(1, farmacia.getNome());
        st.setString(2, farmacia.getCnpj());
        st.setString(3, farmacia.getTelefone());
        st.setString(4, farmacia.getEmail());
        st.setInt(5, codigoEndereco);

        st.executeUpdate();

        con.close();
        
    }
    
    public void editar(Farmacia farmacia) throws Exception {
        
        sql = "update farmacia set nome = ?, cnpj = ?"
                // telefone = ?, email = ? adicionar ao JFrame editar todas as colunas
                + "where codigo = ?";

        con = ConnectionFactory.getConnection();

        st = con.prepareStatement(sql);

        st.setString(1, farmacia.getNome());
        st.setString(2, farmacia.getCnpj());
        //st.setString(3, farmacia.getTelefone());
        //st.setString(4, farmacia.getEmail());
        
        st.setInt(3, farmacia.getCodigo());

        st.executeUpdate();

        con.close();
    }
    
    public void excluir(Farmacia farmacia) throws Exception {
        sql = "delete from farmacia where codigo = ?";

        con = ConnectionFactory.getConnection();

        st = con.prepareStatement(sql);

        st.setInt(1, farmacia.getCodigo());

        st.executeUpdate();

        con.close();
    }
    
    public List<Farmacia> buscar(String query) throws Exception {
        sql = "select f.*, e.*  "
                + "from farmacia f, endereco e "
                + "where f.id_endereco = e.codigo and f.nome ilike ?";
        
        con = ConnectionFactory.getConnection();
        st = con.prepareStatement(sql);
        
        st.setString(1, query + "%");
        
        ResultSet rs = st.executeQuery();
        List<Farmacia> farmacias = new ArrayList<>();
        while (rs.next()) {
            int codigo = rs.getInt("codigo");
            String nome = rs.getString("nome");
            String cnpj = rs.getString("cnpj");
            String telefone = rs.getString("telefone");
            String email = rs.getString("email");
            int codigoEndereco = rs.getInt("id_endereco");
            String rua = rs.getString("rua");
            String numero = rs.getString("numero");
            String bairro = rs.getString("bairro");
            String cidade = rs.getString("cidade");
            String estado = rs.getString("estado");
            String cep = rs.getString("cep");
            
            Farmacia f = new Farmacia();
            f.setCodigo(codigo);
            f.setNome(nome);
            f.setCnpj(cnpj);
            f.setTelefone(telefone);
            f.setEmail(email);
            f.getId_endereco().setCodigo(codigoEndereco);
            f.getId_endereco().setRua(rua);
            f.getId_endereco().setNumero(numero);
            f.getId_endereco().setBairro(bairro);
            f.getId_endereco().setCidade(cidade);
            f.getId_endereco().setEstado(estado);
            f.getId_endereco().setCep(cep);
            
            farmacias.add(f);
        }
        con.close();
        return farmacias;
    }
    
    public List<Farmacia> listar() throws Exception {
        sql = "select f.*, e.*  "
                + "from farmacia f, endereco e "
                + "where f.id_endereco = e.codigo";
        
        con = ConnectionFactory.getConnection();
        st = con.prepareStatement(sql);
        ResultSet rs = st.executeQuery();
        List<Farmacia> farmacias = new ArrayList<>();
        while (rs.next()) {
            int codigo = rs.getInt("codigo");
            String nome = rs.getString("nome");
            String cnpj = rs.getString("cnpj");
            String telefone = rs.getString("telefone");
            String email = rs.getString("email");
            int codigoEndereco = rs.getInt("id_endereco");
            String rua = rs.getString("rua");
            String numero = rs.getString("numero");
            String bairro = rs.getString("bairro");
            String cidade = rs.getString("cidade");
            String estado = rs.getString("estado");
            String cep = rs.getString("cep");
            
            
            Farmacia f = new Farmacia();
            f.setCodigo(codigo);
            f.setNome(nome);
            f.setCnpj(cnpj);
            f.setTelefone(telefone);
            f.setEmail(email);
            f.getId_endereco().setCodigo(codigoEndereco);
            f.getId_endereco().setRua(rua);
            f.getId_endereco().setNumero(numero);
            f.getId_endereco().setBairro(bairro);
            f.getId_endereco().setCidade(cidade);
            f.getId_endereco().setEstado(estado);
            f.getId_endereco().setCep(cep);
            
            farmacias.add(f);
        }
        con.close();
        return farmacias;
    }
    
    public Farmacia buscarPorCodigo(int codigo) throws Exception {
        
        sql = "select f.*, e.*  "
                + "from farmacia f, endereco e "
                + "where f.id_endereco = e.codigo "
                + "and f.codigo = ?";
        con = ConnectionFactory.getConnection();
        st = con.prepareStatement(sql);
        st.setInt(1, codigo);
        ResultSet rs = st.executeQuery();
        Farmacia f = null;
        if (rs.next()) {
            String nome = rs.getString("nome");
            String cnpj = rs.getString("cnpj");
            String telefone = rs.getString("telefone");
            String email = rs.getString("email");
            int codigoEndereco = rs.getInt("id_endereco");
            String rua = rs.getString("rua");
            String numero = rs.getString("numero");
            String bairro = rs.getString("bairro");
            String cidade = rs.getString("cidade");
            String estado = rs.getString("estado");
            String cep = rs.getString("cep");

            f = new Farmacia();
            f.setCodigo(codigo);
            f.setNome(nome);
            f.setCnpj(cnpj);
            f.setTelefone(telefone);
            f.setEmail(email);
            f.getId_endereco().setCodigo(codigoEndereco);
            f.getId_endereco().setRua(rua);
            f.getId_endereco().setNumero(numero);
            f.getId_endereco().setBairro(bairro);
            f.getId_endereco().setCidade(cidade);
            f.getId_endereco().setEstado(estado);
            f.getId_endereco().setCep(cep);
            
        }
        con.close();
        return f;
    }
    
}
