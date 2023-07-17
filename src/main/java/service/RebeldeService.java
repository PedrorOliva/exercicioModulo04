package service;

import connection.Conexao;
import model.Rebelde;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RebeldeService {
  public void consultaRebeldes() {
    String sql = "SELECT * FROM rebelde WHERE status = true";
    try {
      Statement statement = Conexao.getConnection().createStatement();
      ResultSet rs = statement.executeQuery(sql);
      while (rs.next()) {
        System.out.println("ID: " + rs.getInt("id_rebelde") +
            "\tNome: " + rs.getString("nome") +
            "\tIdade: " + rs.getInt("idade") +
            "\tGenero: " + rs.getString("genero") +
            "\tStatus: " + rs.getBoolean("status"));
        System.out.println();
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public void consultaPorID(Integer id) {
    String sql = "SELECT * FROM rebelde WHERE id_rebelde = " + id + " AND status = true";
    try {
      Statement statement = Conexao.getConnection().createStatement();
      ResultSet rs = statement.executeQuery(sql);
      while (rs.next()) {
        System.out.println("\nID: " + rs.getInt("id_rebelde") +
            "\nNome: " + rs.getString("nome") +
            "\nIdade: " + rs.getInt("idade") +
            "\nGenero: " + rs.getString("genero") +
            "\nLocalização: " + rs.getString("localizacao") +
            "\nStatus: " + rs.getBoolean("status"));
        System.out.println();
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public void insereRebelde(Rebelde rebelde) {
    String sql =
        "INSERT INTO rebelde (nome, idade, genero, localizacao, traidor, status) " +
            "VALUES ('" + rebelde.getNome() + "', '" + rebelde.getIdade() + "', '" +
            rebelde.getGenero() + "', '" + rebelde.getLocalizacao() +
            "', 0, true)";
    try {
      Statement statement = Conexao.getConnection().createStatement();
      statement.executeUpdate(sql);
      System.out.println("Rebelde cadastrado com sucesso!!\n");
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public void atualizaLocalizacaoRebelde(Integer id, String localizacao) {
    String sql = "UPDATE rebelde SET localizacao = '" + localizacao + "' WHERE id_rebelde = " + id;
    try {
      Statement statement = Conexao.getConnection().createStatement();
      statement.executeUpdate(sql);
      System.out.println("Localização atualizada com sucesso!!\n");
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public void marcarTraidor(Integer id) {
    String sql = "UPDATE rebelde SET traidor = traidor + 1 WHERE id_rebelde = " + id;
    try {
      Statement statement = Conexao.getConnection().createStatement();
      statement.executeUpdate(sql);
      desativaTraidor(id);
      System.out.println("Traidor denúnciado!!\n");
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public void desativaTraidor(Integer id) {
    String sql = "UPDATE rebelde SET status = false WHERE traidor >= 3";
    try {
      Statement statement = Conexao.getConnection().createStatement();
      statement.executeUpdate(sql);
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public void removeRebelde(Integer id) {
    String sql = "DELETE FROM rebelde WHERE id_rebelde = " + id;
    try {
      Statement statement = Conexao.getConnection().createStatement();
      statement.executeUpdate(sql);
      System.out.println("Removido com sucesso!!");
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public void consultaRelatorio() {
    String sql = "SELECT status FROM rebelde";
    int rebeldes = 0;
    int traidores = 0;
    int totalRebeldes = 0;
    try {
      Statement statement = Conexao.getConnection().createStatement();
      ResultSet rs = statement.executeQuery(sql);
      while (rs.next()) {
        if (rs.getString("status").equals("true")) {
          rebeldes = rebeldes + 1;
        } else {
          traidores = traidores + 1;
        }
      }
      totalRebeldes = rebeldes + traidores;
      int rebeldesTotal = (rebeldes * 100) / totalRebeldes;
      System.out.println("Rebeldes: " + rebeldesTotal + "%");
      int traidoresTotal = (traidores * 100) / totalRebeldes;
      System.out.println("Traidores: " + traidoresTotal + "%\n");
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}
