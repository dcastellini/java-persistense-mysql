package com.platzi;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class Inicio {

    private final static int EXIT_PROGRAM = 5;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int optionMenuProgram = 0;

        MensajeService mensajeService = new MensajeService();

        do{
            System.out.println("__________________________________");
            System.out.println("Aplicacion de mensajes");
            System.out.println("__________________________________");
            System.out.println("1. Crear mensaje");
            System.out.println("2. Listar mensaje");
            System.out.println("3. Editar mensaje");
            System.out.println("4. Eliminar mensaje");
            System.out.println("5. Salir");
            System.out.println("__________________________________");

            optionMenuProgram = scanner.nextInt();

            switch(optionMenuProgram){
                case 1:
                    mensajeService.createMessage();
                    break;
                case 2:
                    mensajeService.listMessage();
                    break;
                case 3:
                    mensajeService.updateMessage();
                    break;
                case 4:
                    mensajeService.deleteMessage();
                    break;
                default:
                    break;
            }

        } while (optionMenuProgram != EXIT_PROGRAM);

    }
}
