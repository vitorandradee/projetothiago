package org.TM;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
    Scanner reader = new Scanner(System.in);
    NotaManager manager = new NotaManager();
    NotaFiscal nota = new NotaFiscal();

    InterfaceUser user = new InterfaceUser();
    user.start(reader,nota,manager);
    }
}