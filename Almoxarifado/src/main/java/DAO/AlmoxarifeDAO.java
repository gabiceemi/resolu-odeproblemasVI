package DAO;

import Model.Almoxarife;
import java.sql.SQLException;

public class AlmoxarifeDAO extends Conexao {

    public Almoxarife select(String siape, String senha, int tipo) {
        try {
            conectar();
            String sql = "SELECT * FROM almoxarife WHERE siape = '" + siape + "'AND senha ='" + senha + "'AND tipo = '" + tipo + "'";
            rs = stm.executeQuery(sql);
            Almoxarife usuario = null;
            while (rs.next()) {
                usuario = new Almoxarife();
                usuario.setSiape(rs.getString("siape"));
                usuario.setEmail(rs.getString("email"));
                usuario.setSenha(rs.getString("senha"));
                usuario.setTipo(rs.getInt("tipo"));
            }
            fechar();
            return usuario;
        } catch (SQLException e) {
            System.out.println("Erro");
            fechar();
            return null;
        }
    }

    public int selectID(String siape) {
        int idalmoxarife = 0;
        try {
            conectar();
            String sql = "SELECT idalmoxarife FROM public.almoxarife WHERE almoxarife.siape = '" + siape + "'";
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                idalmoxarife = rs.getInt(1);
            }
            fechar();
            return idalmoxarife;
        } catch (SQLException e) {
            System.out.println("Erro");
            fechar();
            return 0;
        }
    }
    
    public int selectAlmoxarifado(int id) {
        int idalmoxarife = 0;
        try {
            conectar();
            String sql = "SELECT almoxarifado FROM public.almoxarife WHERE idalmoxarife = " + id + "";
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                idalmoxarife = rs.getInt(1);
            }
            fechar();
            return idalmoxarife;
        } catch (SQLException e) {
            System.out.println("Erro");
            fechar();
            return 0;
        }
    }

}
