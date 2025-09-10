package org.TM;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

public class NotaFiscal {
    private String serieNumber;
    private Date emissionDate;
    private double totalValue;
    private ArrayList<Item> itens;
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    
    public NotaFiscal(){
        this.serieNumber = serieNumber();
        this.emissionDate = new Date();
        itens = new ArrayList<>();
        this.totalValue = 0.0;
    }


    public static String serieNumber(){
        return UUID.randomUUID().toString().substring(0,8).toUpperCase();
    }
    
    public void addItem(Item item){
        itens.add(item);
        this.totalValue += item.getValueTotal();
    }

    public boolean save(String clientBuyer){
        String fileName = "notaFiscal-" + this.serieNumber + ".txt";
        String filePath = "src/main/java/org/TM/notas/" + fileName;

        try(PrintWriter writer = new PrintWriter(new FileWriter(filePath))) {
            writer.println("Nota Fiscal");
            writer.println("Número de série: " + this.serieNumber);
            writer.println("Nome do Cliente: " + clientBuyer);
            writer.println("Itens comprados:");

            for (Item actualItem : itens) {
                writer.println(actualItem);
            }

            writer.println("Data de Emissão: " + DATE_FORMAT.format(this.emissionDate));
            writer.println("Valor total de compra: " + this.totalValue);
            return true;
        }
            catch(IOException e){
            System.err.println("Erro ao emitir nota fiscal.");
                return false;
            }
        }



}
