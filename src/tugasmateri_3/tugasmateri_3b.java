/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugasmateri_3;


import java.awt.Button;
import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 *
 * @author TUAN MUDA PULANGMAGANG 
 */

public class tugasmateri_3b extends java.applet.Applet implements ActionListener {
    TextField input1, input2;
    Button tambah;
    Label hasilp, Label1, Label2;
    int a, b, hasil;
  
    @Override
    public void init() {
        Label input1Label = new Label (" ",Label.RIGHT);
        Label input2Label = new Label (" ",Label.RIGHT);
        
        input1 = new TextField(12);
        input2 = new TextField(12);
        tambah = new Button ("Tambah");
        
        add(input1Label);
        add(input1);
   
        add(input2Label);
        add(input2);
     
        add (tambah);
        tambah.addActionListener(this);
    }
    @Override
       public void actionPerformed(ActionEvent ae) {
       a= Integer.parseInt(input1.getText());
       b= Integer.parseInt(input2.getText());
       
       hasil= a+b;
        
    repaint();
    }
    @Override
    public void paint (Graphics g){
    input1.setLocation(40,50);
    input2.setLocation(40,100);
    tambah.setLocation(40,150);
    g.drawString("HASIL: " + hasil, 200, 100);
    }    
    

    /**
     * This method is called from within the init() method to initialize the
     * form. WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setLayout(new java.awt.BorderLayout());
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}