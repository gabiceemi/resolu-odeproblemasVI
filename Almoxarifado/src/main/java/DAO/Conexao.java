package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class Conexao {

    protected static final int MYDB = 0;
    protected static final String Driver = "org.postgresql.Driver";
    protected Connection con;
    protected Statement stm;
    protected ResultSet rs;

    public static Connection conexao(int banco) throws ClassNotFoundException, SQLException {

        String url = "jdbc:postgresql://localhost:5432/almoxarifado";
        String usuario = "postgres";
        String senha = "admin";

        switch (banco) {
            case MYDB:
                Class.forName(Driver);
                break;
        }
        return DriverManager.getConnection(url, usuario, senha);
    }

    protected void conectar() throws SQLException {
        try {
            con = Conexao.conexao(Conexao.MYDB);
            stm = con.createStatement();

        } catch (ClassNotFoundException e) {
            System.out.println("Erro ao carregar o driver");
        }
    }

    protected void fechar() {
        try {
            stm.close();
            con.close();
        } catch (SQLException e) {
            System.out.println("Erro ao fechar conexão");
        }
    }

}
