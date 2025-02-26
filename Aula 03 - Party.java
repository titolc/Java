package pacote01;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class Party {
    public void buildInvite() {
        Frame f = new Frame("Party Invitation");
        
        // Criando componentes
        Label l = new Label("Party at Tim's");
        Button b = new Button("You bet");
        Button c = new Button("Shoot me");
        
        // Usando um Panel para organizar os componentes
        Panel p = new Panel();
        p.add(l);
        p.add(b);
        p.add(c);
        
        // Adicionando o Panel ao Frame
        f.add(p);
        
        // Configurando o Frame
        f.setSize(300, 200);   // Tamanho da janela
        f.setVisible(true);    // Tornando a janela visível
        
        // Adicionando comportamento para fechar a janela
        f.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                f.dispose();
            }
        });
    }
    
    public static void main(String[] args) {
        Party party = new Party();
        party.buildInvite();
    }
}
