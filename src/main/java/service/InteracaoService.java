package service;

import model.Inventario;
import model.Rebelde;

import java.util.Scanner;

public class InteracaoService {
  Scanner inputUsuario = new Scanner(System.in);
  Rebelde novoRebelde = new Rebelde();
  RebeldeService servicoRebelde = new RebeldeService();
  Inventario novoItem = new Inventario();
  InventarioService servicoInventario = new InventarioService();

  public void criaRebelde(){
    System.out.println("--- Cadastrando novo rebelde ---\n");
    System.out.println("Nome: ");
    String nome = inputUsuario.nextLine();
    novoRebelde.setNome(nome);
    System.out.println("Idade: ");
    int idade = inputUsuario.nextInt();
    novoRebelde.setIdade(idade);
    System.out.println("Generio: ");
    String genero = inputUsuario.next();
    novoRebelde.setGenero(genero);
    System.out.println("Localização: ");
    String localizacao = inputUsuario.next();
    novoRebelde.setLocalizacao(localizacao);
    servicoRebelde.insereRebelde(novoRebelde);
  }

  public void consultarRebeldes(){
    System.out.println("--- Todos os rebeldes cadastrados ---");
    servicoRebelde.consultaRebeldes();
  }

  public void consultarRebeldePorID(){
    System.out.println("--- Encontre um rebelde pelo seu ID ---");
    System.out.println("\nInforme o ID do rebelde: ");
    int id = inputUsuario.nextInt();
    servicoRebelde.consultaPorID(id);
  }

  public void alterarLocalizacaoRebelde(){
    System.out.println("--- Altere a sua localização atual ---");
    System.out.println("\nInforme o seu ID: ");
    int id = inputUsuario.nextInt();
    System.out.println("Informe o nome da base atual: ");
    String base = inputUsuario.next();
    servicoRebelde.atualizaLocalizacaoRebelde(id, base);
  }

  public void denunciarRebelde(){
    System.out.println("--- Denúncie anonimamente um rebelde traidor ---");
    System.out.println("\nInforme o ID do traidor: ");
    int id = inputUsuario.nextInt();
    servicoRebelde.marcarTraidor(id);
  }

  public void removerRebelde(){
    System.out.println("--- Remover rebeldes ---");
    System.out.println("\nInforme o ID do rebelde que deseja remover: ");
    int id = inputUsuario.nextInt();
    servicoRebelde.removeRebelde(id);
  }

  public void adicionarItensInventario(){
    System.out.println("--- Adicione itens ao seu inventário ---");
    System.out.println("\nInforme o seu id: ");
    int id = inputUsuario.nextInt();
    novoItem.setRebelde_id(id);
    System.out.println("Quantas armas? ");
    int armas = inputUsuario.nextInt();
    novoItem.setArma(armas);
    System.out.println("Quantas munições? ");
    int municao = inputUsuario.nextInt();
    novoItem.setMunicao(municao);
    System.out.println("Água: ");
    int agua = inputUsuario.nextInt();
    novoItem.setAgua(agua);
    System.out.println("Comida: ");
    int comida = inputUsuario.nextInt();
    novoItem.setComida(comida);
    servicoInventario.insereItemIventario(novoItem);
  }

  public void consultarInvenraio(){
    System.out.println("--- Consulte o seu inventário ---");
    System.out.println("\nInforme o seu ID: ");
    int id = inputUsuario.nextInt();
    servicoInventario.consultaInventario(id);
  }

  public void relatorios(){
    System.out.println("--- Relatórios sobre a porcetagem de rebeldes e de traidores ---");
    servicoRebelde.consultaRelatorio();
  }

}
