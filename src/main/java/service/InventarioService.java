package service;

import connection.Conexao;
import model.Inventario;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class InventarioService {
  public void insereItemIventario(Inventario inventario) {
    String sql =
        "INSERT INTO inventario (rebelde_id, arma, municao, agua, comida) " +
            "VALUES ('" + inventario.getRebelde_id() + "', '" + inventario.getArma() + "', '" +
            inventario.getMunicao() + "', '" + inventario.getAgua() + "', '" + inventario.getComida() + "')";
    try {
      Statement statement = Conexao.getConnection().createStatement();
      statement.executeUpdate(sql);
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public void consultaInventario(Integer id) {
    String sql = "SELECT rebelde.id_rebelde, rebelde.nome, rebelde.localizacao, inventario.rebelde_id, " +
        "inventario" +
        ".arma, inventario.municao, inventario.agua, inventario.comida FROM rebelde INNER JOIN inventario" +
        " ON inventario.rebelde_id = rebelde.id_rebelde WHERE rebelde.id_rebelde = " + id;

    try {
      Statement statement = Conexao.getConnection().createStatement();
      ResultSet rs = statement.executeQuery(sql);
      while (rs.next()) {
        System.out.println("Nome: " + rs.getString("nome") +
            "\nLocalicação: " + rs.getString("localizacao"));
        System.out.println("Inventário: ");
        System.out.println("Arma: " + rs.getInt("arma") +
            "\nMunição: " + rs.getInt("municao") +
            "\nAgua: " + rs.getInt("agua") +
            "\nComida: " + rs.getInt("comida"));
        System.out.println();
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}
