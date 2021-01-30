package com.platzi;

import java.util.Scanner;

public class MensajeService {

    MensajeDao mensajeDao = new MensajeDao();

    public void createMessage(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("_____________________________");
        System.out.println("Escribe tu mensaje: ");
        System.out.println("_____________________________");
        String mensajeIngresado = scanner.nextLine();
        System.out.println("_____________________________");
        System.out.println("Escribe el nombre del autor");
        System.out.println("_____________________________");
        String autorIngresado = scanner.nextLine();

        Mensaje mensajeNuevo = new Mensaje();
        mensajeNuevo.setMensaje(mensajeIngresado);
        mensajeNuevo.setAutor_mensaje(autorIngresado);

        mensajeDao.createMessageBd(mensajeNuevo);

    }

    public void listMessage(){
        System.out.println(mensajeDao.readMessageBd());
    }

    public void deleteMessage(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("_____________________________");
        System.out.println("Indique el ID del mensaje a borrar: ");
        System.out.println("_____________________________");
        int id_mensaje = scanner.nextInt();
        mensajeDao.deleteMessageBd(id_mensaje);
    }

    public void updateMessage(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("_____________________________");
        System.out.println("Indique el id del mensaje a modificar: ");
        System.out.println("_____________________________");
        int id_mensaje = scanner.nextInt();
        System.out.println("_____________________________");
        System.out.println("Indique el nuevo mensaje:");
        System.out.println("_____________________________");
        String mensajeNuevo  = scanner.nextLine();

        Mensaje mensajeNuevoModificado = new Mensaje();
        mensajeNuevoModificado.setId_mensaje(id_mensaje);
        mensajeNuevoModificado.setMensaje(mensajeNuevo);

        mensajeDao.updateMessageBd(mensajeNuevoModificado);
    }

}
