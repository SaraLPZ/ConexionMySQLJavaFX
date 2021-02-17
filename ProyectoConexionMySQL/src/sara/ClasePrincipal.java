/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sara;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Alexara
 */
public class ClasePrincipal extends Application{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        VBox v = new VBox(10);
        Label name=new Label("Nombre: ");
        TextField tfNombre = new TextField("");
        Label passwd1=new Label("Password: ");
        TextField tfPasswd = new TextField("");
        Button btnLogin=new Button("Entrar");
        Label mensaje = new Label("");
        btnLogin.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                String nombre = tfNombre.getText();
                String password = tfPasswd.getText();
                Usuario u=AccesoBD.logearUsuario(nombre,password);
                if(u==null)
       {
           System.out.println("Error");           
       }
       else
       {//Si etá bien logueado
           mensaje.setText("Se ha logeado correctamente "+nombre);
           
       }
            }
        });
        
        v.getChildren().addAll(name,tfNombre,passwd1,tfPasswd,btnLogin,mensaje);
        Scene sc=new Scene(v,200,200);
        stage.setScene(sc);
        stage.show();
    }
    
}
