package br.com.thiago.db;

import br.com.thiago.Cidade;
import br.com.thiago.CidadeEstado;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by thiago on 8/27/18.
 */
public class DBCidade {

    public List<Cidade> retornarCapitais(){
        DBConnection con = new DBConnection();
        con.connect();
        try {
            PreparedStatement stat = con.executeSQL("select name from cidade where capital=1 order by name");
            ResultSet rs =  stat.executeQuery();
            try{
                List<Cidade> lista = new ArrayList<Cidade>();
                while(rs.next()){
                    lista.add(new Cidade(rs.getString("name")));
                }
                return lista;
            }finally {
                rs.close();
                stat.close();
            }
        }catch (Exception e){
            throw new RuntimeException("Erro ao retornar as capitais. Erro: "+e.getMessage());
        }finally {
            con.disconnect();
        }
    }

    public int retornarTotalCidades(){
        DBConnection con = new DBConnection();
        con.connect();
        try {
            PreparedStatement stat = con.executeSQL("select count(*) as total from cidade");
            ResultSet rs =  stat.executeQuery();
            try{
                int total=0;
                while(rs.next()){
                    total = rs.getInt("total");
                }
                return total;
            }finally {
                rs.close();
                stat.close();
            }
        }catch (Exception e){
            throw new RuntimeException("Erro ao retornar a quantidade total de cidades. Erro: "+e.getMessage());
        }finally {
            con.disconnect();
        }
    }

    public Cidade consultarCidade(int codIbge) {
        DBConnection con = new DBConnection();
        con.connect();
        try {
            PreparedStatement stat = con.executeSQL("select name from cidade where ibge_id=?");
            stat.setInt(1,codIbge);
            ResultSet rs =  stat.executeQuery();
            try{
                Cidade  cidade = new Cidade();
                while(rs.next()){
                    cidade.setNome(rs.getString("name"));
                }
                return cidade;
            }finally {
                rs.close();
                stat.close();
            }
        }catch (Exception e){
            throw new RuntimeException("Erro ao retornar as cidade pelo codigo ibge. Erro: "+e.getMessage());
        }finally {
            con.disconnect();
        }
    }

    public void excluirCidade(int id) {
        DBConnection con = new DBConnection();
        con.connect();
        try {
            PreparedStatement stat = con.executeSQL("delete from cidade where ibge_id=?");
            stat.setInt(1,id);
            stat.execute();
            stat.close();
        }catch (Exception e){
            throw new RuntimeException("Erro ao excluir a cidade pelo codigo ibge. Erro: "+e.getMessage());
        }finally {
            con.disconnect();
        }
    }

    public void cadastrarCidade(Cidade cidade) {
        DBConnection con = new DBConnection();
        con.connect();
        try {
            PreparedStatement stat = con.executeSQL("insert into cidade (ibge_id,uf,name,capital,lon,lat,no_accents,alternative_names,microregion,mesoregion) values(?,?,?,?,?,?,?,?,?,?)");
            stat.setInt(1,cidade.getIbge());
            stat.setString(2, cidade.getUF());
            stat.setString(3, cidade.getNome());
            stat.setInt(4,cidade.isCapital()?1:0);
            stat.setFloat(5, cidade.getLongitude());
            stat.setFloat(6, cidade.getLatitude());
            stat.setString(7, cidade.getNomeCompleto());
            stat.setString(8, cidade.getNomeAlternativo());
            stat.setString(9,cidade.getMicroregiao());
            stat.setString(10,cidade.getMesoregiao());
            stat.execute();
            stat.close();
        }catch (Exception e){
            throw new RuntimeException("Erro ao cadastrar a cidade. Erro: "+e.getMessage());
        }finally {
            con.disconnect();
        }
    }

    public List<CidadeEstado> retornarCidadesEstado() {
        DBConnection con = new DBConnection();
        con.connect();
        try {
            PreparedStatement stat = con.executeSQL("select count(*) as qtd,uf from cidade group by uf order by uf");
            ResultSet rs =  stat.executeQuery();
            try{
                List<CidadeEstado> lista = new ArrayList<CidadeEstado>();
                while(rs.next()){
                    lista.add(new CidadeEstado(rs.getInt("qtd"),rs.getString("uf")));
                }
                return lista;
            }finally {
                rs.close();
                stat.close();
            }
        }catch (Exception e){
            throw new RuntimeException("Erro ao retornar o total de cidades por estado. Erro: "+e.getMessage());
        }finally {
            con.disconnect();
        }
    }

    public List<Cidade> consultarCidadePorEstado(String estado) {
        DBConnection con = new DBConnection();
        con.connect();
        try {
            PreparedStatement stat = con.executeSQL("select name from cidade where uf=? order by name");
            stat.setString(1,estado);
            ResultSet rs =  stat.executeQuery();
            try{
                List<Cidade> lista = new ArrayList<Cidade>();
                while(rs.next()){
                    lista.add(new Cidade(rs.getString("name")));
                }
                return lista;
            }finally {
                rs.close();
                stat.close();
            }
        }catch (Exception e){
            throw new RuntimeException("Erro ao retornar as cidades por estado. Erro: "+e.getMessage());
        }finally {
            con.disconnect();
        }
    }
}
