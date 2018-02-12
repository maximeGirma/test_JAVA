package Graphics;




import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Fenetre extends JFrame{


    //declaration des variables necessaires au menu et recherche
    private JMenu fichiers = new JMenu("Fichier");//JMenu pour les... menus
    private JMenu prererences = new JMenu("Preferences");
    private JMenu aide = new JMenu("Aide");
    private JMenuItem item1 = new JMenuItem("Importer");//Menu item pour les sous-menus
    private JMenuItem item2 = new JMenuItem("Exporter");
    private JMenuItem item3 = new JMenuItem("Imprimer");
    private JMenuItem item4 = new JMenuItem("Fermer");

    private JTextField input = new JTextField("");//champs text "interactif"
    private JLabel label = new JLabel("Recherche:");

    private Object[][] data;

    private JTable tab_result_search;
    private String[] title;

    public Fenetre() {


        this.setTitle("Biblio 3000");

        this.setSize(610, 520);
        //Permet à la croix de fonctionner
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setLocationRelativeTo(null);//centré
        this.setVisible(true);//fenetre visible

        //création du menu du haut
        this.fichiers.add(item1);
        this.fichiers.add(item2);
        this.fichiers.add(item3);
        this.fichiers.add(item4);
        JMenuBar menuBar = new JMenuBar();
        menuBar.setPreferredSize(new Dimension (600,50));
        menuBar.add(fichiers);
        menuBar.add(prererences);
        menuBar.add(aide);

        //panneau de "mise en page"
        JPanel decallage_panel = new JPanel();
        decallage_panel.setPreferredSize(new Dimension(220,0));

        //menu de selection des categorie
        JPanel menu_categorie = new JPanel();
        menu_categorie.setPreferredSize(new Dimension (100,350));
        GridLayout gl = new GridLayout(5,0);
        //gridLyout pour un affichage en colonne
        menu_categorie.setLayout(gl);
        gl.setVgap(10);// de l'espace entre les boutons du menu

        JButton menu_all = new JButton("Tout");
        menu_all.addActionListener(new actionListener1());

        JButton menu_film = new JButton("Films");



        menu_categorie.add(menu_all);
        menu_categorie.add(menu_film);
        menu_categorie.add(new JButton("Livres"));
        menu_categorie.add(new JButton("Musique"));
        menu_categorie.add(new JButton("Jeux-Video"));


        input.setPreferredSize(new Dimension(150,25));
        JPanel recherche = new JPanel();

        recherche.setPreferredSize(new Dimension (500,40));
        recherche.setLayout(new BorderLayout());
        JButton search_buton = new JButton("GO!");

        //BorderLayout sert à positionner sommairement les elements, assez limité
        recherche.add(label,BorderLayout.WEST);
        recherche.add(input,BorderLayout.CENTER);
        recherche.add(search_buton,BorderLayout.EAST);


        JPanel affichage_resultat = new JPanel();
        affichage_resultat.setBackground(Color.PINK);
        affichage_resultat.setPreferredSize(new Dimension (500,300));


        //le tableau d'affichage de la recherche
        String title[] = {"Titre","Genre","Note"};

        Object[][] data = {
                {"nom_random","genre_random","1/4"},
                {"nom_random","genre_random","1/4"},
                {"nom_random","genre_random","1/4"},
                {"nom_random","genre_random","1/4"},
                {"nom_random","genre_random","1/4"},
                {"nom_random","genre_random","1/4"},
                {"nom_random","genre_random","1/4"},
                {"nom_random","genre_random","1/4"},
                {"nom_random","genre_random","1/4"},
                {"nom_random","genre_random","1/4"},
                {"nom_random","genre_random","1/4"},
                {"nom_random","genre_random","1/4"},
                {"nom_random","genre_random","1/4"},
                {"nom_random","genre_random","1/4"},
                {"nom_random","genre_random","1/4"},
                {"nom_random","genre_random","1/4"},
                {"nom_random","genre_random","1/4"},
                {"nom_random","genre_random","1/4"},
                {"nom_random","genre_random","1/4"},
                {"nom_random","genre_random","1/4"},
                {"nom_random","genre_random","1/4"},
                {"nom_random","genre_random","1/4"},
                {"nom_random","genre_random","1/4"},
                {"nom_random","genre_random","1/4"},
                {"nom_random","genre_random","1/4"},
                {"nom_random","genre_random","1/4"},
                {"nom_random","genre_random","1/4"},
                {"nom_random","genre_random","1/4"},
                {"nom_random","genre_random","1/4"},
                {"nom_random","genre_random","1/4"},
                {"nom_random","genre_random","1/4"},
                {"nom_random","genre_random","1/4"},
                {"nom_random","genre_random","1/4"},
                {"nom_random","genre_random","1/4"},
                {"nom_random","genre_random","1/4"},
                {"nom_random","genre_random","1/4"},
                {"nom_random","genre_random","1/4"},
                {"nom_random","genre_random","1/4"},
                {"nom_random","genre_random","1/4"},
                {"nom_random","genre_random","1/4"},
                {"nom_random","genre_random","1/4"},
                {"nom_random","genre_random","1/4"},
                {"nom_random","genre_random","1/4"},
                {"nom_random","genre_random","1/4"},
                {"nom_random","genre_random","1/4"},
                {"nom_random","genre_random","1/4"},
                {"nom_random","genre_random","1/4"},
                {"nom_random","genre_random","1/4"},
                {"nom_random","genre_random","1/4"},
                {"nom_random","genre_random","1/4"},
                {"nom_random","genre_random","1/4"},
                {"nom_random","genre_random","1/4"},
                {"nom_random","genre_random","1/4"},
                {"nom_random","genre_random","1/4"},
                {"nom_random","genre_random","1/4"},
                {"nom_random","genre_random","1/4"},
                {"nom_random","genre_random","1/4"},
                {"nom_random","genre_random","1/4"},
                {"nom_random","genre_random","1/4"},
                {"nom_random","genre_random","1/4"},
                {"nom_random","genre_random","1/4"},
                {"nom_random","genre_random","1/4"},
                {"nom_random","genre_random","1/4"},
                {"nom_random","genre_random","1/4"}
        };

        JTable tab_result_search = new JTable(data,title);


        JPanel main_content = new JPanel();
        main_content.setLayout(new BorderLayout());
        main_content.add(recherche,BorderLayout.NORTH);
        main_content.add(new JScrollPane(tab_result_search),BorderLayout.SOUTH);

        JPanel content = new JPanel();
        content.setPreferredSize(new Dimension(600,400));

        //On place tous les panneaux dans la fenetre et on est bon

        this.setLayout( new BorderLayout());
        this.getContentPane().add(menuBar,BorderLayout.NORTH);
        this.getContentPane().add(menu_categorie,BorderLayout.WEST);
        this.getContentPane().add(main_content,BorderLayout.EAST);


    }


    public class actionListener1 implements ActionListener {


        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            Object[][] temp = {{"pouet1","pouet2","pouet3"}};
            tab_result_search = new JTable(temp,title);
        }
    }

}
