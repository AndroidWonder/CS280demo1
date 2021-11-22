package com.example.demo1;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;
import java.net.URL;

/**
 *  HBox Demo
 */

public class HBoxDemoStylesCss extends Application
{
   public static void main(String[] args)
   {
      // Launch the application.
      launch(args);
   }
   
   @Override
   public void start(Stage primaryStage) throws Exception {
	   
	   //create imageview objects
	   Image image = new Image("file:src\\images\\smiley.gif");
	   ImageView smile = new ImageView(image);
	   Image image2 = new Image("file:src\\images\\sad.gif");
	   ImageView sad = new ImageView(image2);
	   
      // Create four Buttons and a label
      Button button1 = new Button("Button 1");
      Button button2 = new Button("Button 2", smile);
      Button button3 = new Button("Button 3");
      Button button4 = new Button("Button 4", sad);
      Label label = new Label("Click a button");

      //add styles to button
      button1.setId("single");

      //add handler to button
      button1.setOnAction((e) -> button1.setText("button 1 selected"));

      //set actions on remaining buttons using lambdas
      button2.setOnAction(e -> System.out.println("Start Converting..."));

      button3.setOnAction((e) ->{
         System.out.println("Stop Converting...");
      } );

      button4.setOnAction((e) ->{
         System.out.println("Remove File...");
      } );
     
      // Create an HBox.
      HBox hbox = new HBox(10, label, button1, button2, button3, button4);
      hbox.setPadding(new Insets(10));
      
      // Set the scene's alignment to center.
      hbox.setAlignment(Pos.CENTER);
      
      // Create a Scene with the HBox as its root node.
      Scene scene = new Scene(hbox, 600, 100);
      
      //add stylesheet to scene
      String pathName ="src/styles.css" ;
      File file = new File(pathName);
      if (file.exists()) {
         scene.getStylesheets().add(file.toURI().toURL().toExternalForm());
      } else {
         System.out.println("Could not find css file: "+pathName);
      }

      // Add the Scene to the Stage.
      primaryStage.setScene(scene);
      
      // Set the stage title.
      primaryStage.setTitle("HBox Demo");
      
      // Show the window.
      primaryStage.show();
   }
}