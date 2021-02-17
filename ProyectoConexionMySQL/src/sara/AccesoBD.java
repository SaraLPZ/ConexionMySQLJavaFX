/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sara;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alexara
 */
public class AccesoBD {    

    public static Usuario logearUsuario(String nombre, String password) {
        try {
            //"jdbc:mysql://localhost:3306/tienda", "root", ""
            //Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/sara", "root", "");
            
            Connection conexion = DriverManager.getConnection("jdbc:mysql://remotemysql.com:3306/RBZ856FQZu","RBZ856FQZu","WHyUN6pd20");
            String sql="SELECT id, nombre from Usuarios where nombre='"+nombre+"' AND password='"+password+"'";
            //SELECT * FROM Usuarios WHERE `nombre`="sara" AND `password`="sara"
            Statement stmt=conexion.createStatement();
            ResultSet rs=stmt.executeQuery(sql);
            if(rs.next()){
                String nombre_bd=rs.getString("nombre");
                int id_bd=rs.getInt("id");
                Usuario u=new Usuario(id_bd, nombre);
                return u;
            }
        } catch (SQLException ex) {
            Logger.getLogger(AccesoBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
