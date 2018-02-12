package Graphics;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class GridTest extends JFrame{

    JLabel label = new JLabel("on clique?");
    private int compteur = 0;
    private JButton activButton = new JButton("Clique ! ");
    private JButton activButton2 = new JButton("KABLA!");




    public GridTest(){


        activButton.addActionListener(new ActionListener1());

        activButton2.addActionListener(new ActionListener2());
        JPanel button_pannel = new JPanel();
        button_pannel.add(activButton);
        button_pannel.add(activButton2);
        activButton.setPreferredSize(new Dimension(120,60));



        this.setTitle("GridBagLayout");
        this.setSize(300, 160);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());
        this.getContentPane().add(label,BorderLayout.NORTH);
        this.getContentPane().add(button_pannel,BorderLayout.SOUTH);

        //Définition d'une police d'écriture

        Font police = new Font("Tahoma", Font.BOLD, 16);

        //On l'applique au JLabel

        label.setFont(police);

        //Changement de la couleur du texte

        label.setForeground(Color.blue);

        //On modifie l'alignement du texte grâce aux attributs statiques

        //de la classe JLabel

        label.setHorizontalAlignment(JLabel.CENTER);


        this.setVisible(true);

    }//fin constructeur


    public class ActionListener1 implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            compteur++;
            label.setText("Vous avez cliqué "+compteur+" fois");
        }
    }
    public class ActionListener2 implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            compteur = 0;
            label.setText("KKKKAAAAABBBLLLLAAAAAAA!!!!");
        }
    }
   /* public void actionPerformed(ActionEvent arg0) {
        if(arg0.getSource()== activButton)
        {
            this.compteur++;
            label.setText("Vous avez cliqué "+compteur+" fois");
        }
        else if(arg0.getSource()==activButton2)
        {
            this.compteur = 0;
            label.setText("KKKKAAAAABBBLLLLAAAAAAA!!!!");
        }
    }*/
}

/*
bouton.setEnabled(false); //Le bouton n'est plus cliquable

bouton.setEnabled(true); // Le bouton redevient cliquable
 */