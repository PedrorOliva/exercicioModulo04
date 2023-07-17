package service;

import java.util.Scanner;

public class MenuService {
  Scanner inputUsuario = new Scanner(System.in);
  InteracaoService interacao = new InteracaoService();
  boolean menu = true;

  public void interacaoUsuario() {
    do {
      menuUsuario();
      int opcao = inputUsuario.nextInt();
      switch (opcao) {
        case 1:
          interacao.criaRebelde();
          break;
        case 2:
          interacao.consultarRebeldes();
          break;
        case 3:
          interacao.consultarRebeldePorID();
          break;
        case 4:
          interacao.alterarLocalizacaoRebelde();
          break;
        case 5:
          interacao.denunciarRebelde();
          break;
        case 6:
          interacao.removerRebelde();
          break;
        case 7:
          interacao.adicionarItensInventario();
          break;
        case 8:
          interacao.consultarInvenraio();
          break;
        case 9:
          interacao.relatorios();
          break;
        case 10:
          menu = false;
          System.out.println("Encerrando aplicação....");
          break;
        default:
          System.out.println("Opção inválida!!");
      }
    } while (menu);

  }
  public static void menuUsuario() {
    System.out.println("Qual operação deseja realizar? " +
        "\n1 - Cadastrar rebelde " +
        "\n2 - Consultar Rebeldes " +
        "\n3 - Buscar rebelde por ID " +
        "\n4 - Alterar sua localização " +
        "\n5 - Denunciar um traidor" +
        "\n6 - Remover rebelde" +
        "\n7 - Adicionar itens ao seu inventário" +
        "\n8 - Consultar seu inventário" +
        "\n9 - Relatórios" +
        "\n10 - Encerrar programa");
  }
}
