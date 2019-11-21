/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.SQLException;

public class AlmoxarifadoDAO extends Conexao {

    public int select(String siape) {
        int almoxarifado = 0;
        try {
            conectar();
            String sql = "SELECT idalmoxarifado FROM public.almoxarifado INNER JOIN almoxarife ON almoxarifado.idalmoxarifado = almoxarife.almoxarifado WHERE almoxarife.siape = '" + siape + "'";
            rs = stm.executeQuery(sql);

            while (rs.next()) {
                almoxarifado = rs.getInt(1);
            }
            fechar();
            return almoxarifado;
        } catch (SQLException e) {
            System.out.println("Erro");
            fechar();
            return 0;
        }
    }

    public int selectID(String campus) {
        int idalmoxarifado = 0;
        try {
            conectar();
            String sql = "SELECT idalmoxarifado FROM public.almoxarifado WHERE almoxarifado.campus = '" + campus + "'";
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                idalmoxarifado = rs.getInt(1);
            }
            fechar();
            return idalmoxarifado;
        } catch (SQLException e) {
            System.out.println("Erro");
            fechar();
            return 0;
        }
    }

    public int selectAlmoxarifadoPorSiape(String siape) {
        int idalmoxarifado = 0;
        try {
            conectar();
            String sql = "SELECT idalmoxarifado FROM public.almoxarifado INNER JOIN almoxarife ON almoxarife.almoxarifado = idalmoxarifado WHERE almoxarife.siape = '" + siape + "'";
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                idalmoxarifado = rs.getInt(1);
            }
            fechar();
            return idalmoxarifado;
        } catch (SQLException e) {
            System.out.println("Erro");
            fechar();
            return 0;
        }
    }
}
