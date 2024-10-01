package br.ryan;

import javax.swing.SwingUtilities;

import br.ryan.View.MainFrame;

public class Main {
    public static void main(String[] args) {
       SwingUtilities.invokeLater(new Runnable() {

        @Override
        public void run() {
            new MainFrame();
        }
        
       });
    }
}