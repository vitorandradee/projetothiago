package org.TM;

public class Transferencia {
    private String idTransferencia;
    private String idRecebe;
    private double value;


    public boolean transferir() {
        System.out.println("Id: " + idRecebe + "Recebe um valor de: " + value + " Do id: " + idTransferencia);
        if (value > 0) {
            return true;
        }
        return false;
    }
}
