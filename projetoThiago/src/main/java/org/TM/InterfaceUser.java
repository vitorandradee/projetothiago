package org.TM;

import java.io.IOException;
import java.util.Scanner;

public class InterfaceUser {

    public void start(Scanner reader, NotaFiscal nota, NotaManager manager) {
        boolean isRunning = true;
        while (isRunning) {
            System.out.println("Bem-Vindo,Selecione uma das opções abaixo:\n1-Comprar,\n2-Ver todas notas fiscal em seu nome,\n3-Ver Nota Fiscal,\n4-Sair");
            String text = reader.nextLine();
            boolean execute = true;

            switch (text) {
                case "1":
                    System.out.println("Começando processo de imprimir nota fiscal, para começar digite o nome do cliente ");
                    String clientName = reader.nextLine();

                    System.out.println("Digite os produtos comprados pelo cliente, quando encerrar envie um texto vazio.");
                    while (execute) {
                        System.out.println("Adicione um produto(Nome, preço e quantidade): ");
                        String name = reader.nextLine();
                        if (name.isEmpty()) {
                            execute = false;
                            break;
                        }
                        double price = Double.parseDouble(reader.nextLine());
                        int quantify = Integer.parseInt(reader.nextLine());
                        Item product = new Item(name, price, quantify);
                        nota.addItem(product);
                    }
                    nota.save(clientName);
                    System.out.println("Nota Fiscal emitida com sucesso");
                    break;

                case "2":
                    System.out.println("Digite seu nome:");
                    text = reader.nextLine();
                    try {
                        manager.show(text);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    break;

                case "3":
                    System.out.println("Escreva o nome da nota fiscal que deseja visualizar");
                    text = reader.nextLine();
                    try {
                        System.out.println(manager.write(text));
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                    break;

                case "4":
                    isRunning = false;
                    break;
            }

        }

    }
}

