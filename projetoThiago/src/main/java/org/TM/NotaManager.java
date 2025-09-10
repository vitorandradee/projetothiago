package org.TM;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class NotaManager{
    String path = "src/main/java/org/TM/notas";

    public void show(String name) throws IOException {
        Files.walk(Paths.get(path))
                .filter(path -> searchByClientName(path,name))
                .map(Path::getFileName)
                .forEach(System.out::println);
    }

    public boolean searchByClientName(Path path, String clientName) {
        try{
            String text = Files.readString(path, StandardCharsets.UTF_8);
            return text.toLowerCase().contains(clientName.toLowerCase());
        } catch (IOException e){
            System.err.println("Erro ao Ler o arquivo.");
            return false;
        }

    }

    public String write(String fileName) throws IOException{
        String path = "src/main/java/org/TM/notas/" + fileName + ".txt";
        StringBuilder sb = new StringBuilder();

        BufferedReader reader  = new BufferedReader(new FileReader(path));;

        String linha;

            while ((linha = reader.readLine()) != null) {
                sb.append(linha);
                sb.append(System.lineSeparator());
        }

        return sb.toString();
    }

}