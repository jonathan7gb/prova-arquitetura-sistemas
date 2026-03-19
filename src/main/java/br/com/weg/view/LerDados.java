package br.com.weg.view;

import java.math.BigDecimal;
import java.util.Scanner;

public class LerDados {

    static Scanner scNum = new Scanner(System.in);
    static Scanner scStr = new Scanner(System.in);

    public static String lerString(String mensagem){
        System.out.println(mensagem);
        return scStr.nextLine();
    }

    public static int lerInteger(String mensagem){
        System.out.println(mensagem);
        return scNum.nextInt();
    }

    public static Double lerDouble(String mensagem){
        System.out.println(mensagem);
        return scNum.nextDouble();
    }

}
