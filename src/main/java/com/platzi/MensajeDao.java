package com.platzi;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MensajeDao {

    public void createMessageBd(Mensaje mensaje){
        Conexion dbConnect = new Conexion();

        try(Connection connection = dbConnect.getConnection()){
            PreparedStatement sql = null;
            try{
               String query = "INSERT INTO `mensajes` ( `mensaje`, `autor_mensaje`) VALUES (? , ?)";
               sql = connection.prepareStatement(query);
               sql.setString(1, mensaje.getMensaje());
               sql.setString(2, mensaje.getAutor_mensaje());
               sql.executeUpdate();
               System.out.println("Mensaje creado correctamente!");
            } catch (SQLException ex){
                System.out.println(ex);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }


    public String readMessageBd(){
        String listadoDeMensajes = "";
        Conexion dbConnect = new Conexion();
        PreparedStatement sql = null;
        ResultSet rs = null;

        try(Connection connection = dbConnect.getConnection()){
            String query = "SELECT * FROM mensajes";
            sql = connection.prepareStatement(query);
            rs = sql.executeQuery();

            while(rs.next()){
                listadoDeMensajes += "-----------------------------\n"+
                        "ID: "+ rs.getInt("id_mensaje") +
                        " - Mensaje: " + rs.getString("mensaje") +
                        " - Autor : " + rs.getString("autor_mensaje") +
                        " - Fecha: " + rs.getString("fecha_mensaje") + "\n";
            }
            return listadoDeMensajes;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return "No se pudieron obtener los mensajes";
        }
    }

    public void deleteMessageBd(int id_mensaje){
        Conexion dbConnect = new Conexion();
        PreparedStatement sql = null;

        try(Connection connection = dbConnect.getConnection()){
            try{
                String query = "DELETE FROM mensajes WHERE ID_MENSAJE = ?";
                sql = connection.prepareStatement(query);
                sql.setInt(1,id_mensaje);
                sql.executeUpdate();
                System.out.println("Mensaje Eliminado");

            }catch(SQLException e){
                System.out.println(e.getMessage());
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    public void updateMessageBd(Mensaje mensaje){
        Conexion dbConnect = new Conexion();
        PreparedStatement sql = null;

        try(Connection connection = dbConnect.getConnection()){
            try{
                String query = "UPDATE mensajes SET mensaje = ? WHERE id_mensaje = ?";
                sql = connection.prepareStatement(query);
                sql.setString(1,mensaje.getMensaje());
                sql.setInt(2, mensaje.getId_mensaje());
                sql.executeUpdate();
                System.out.println("El mensaje " + mensaje.getId_mensaje() + " fue actualizado correctamente.");

            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

}
