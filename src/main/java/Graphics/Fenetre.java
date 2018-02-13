package Graphics;




import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class Fenetre extends JFrame implements MouseListener{

    public int compteur = 0;
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


    JPanel main_content;
    JPanel main_content2;
    JPanel recherche;



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
        menu_all.addMouseListener(this);

        JButton menu_film = new JButton("Films");



        menu_categorie.add(menu_all);
        menu_categorie.add(menu_film);
        menu_categorie.add(new JButton("Livres"));
        menu_categorie.add(new JButton("Musique"));
        menu_categorie.add(new JButton("Jeux-Video"));


        input.setPreferredSize(new Dimension(150,25));
        recherche = new JPanel();

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

        tab_result_search = new JTable(data,title);


        main_content = new JPanel();
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

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {

        test();
        this.getContentPane().remove(main_content);
        test();
        this.main_content2 = new JPanel();
        this.main_content2.setLayout(new BorderLayout());
        test();
        this.main_content2.add(this.recherche,BorderLayout.NORTH);
        test();
        Object[][] pouet = {{"sblah","meh","kibetilini"}};
        String title2[] = {"Titre","Genre","Note"};
        test();
        JTable temporary = new JTable(pouet,title2);
        test();
        this.main_content2.add(new JScrollPane(temporary),BorderLayout.SOUTH);
        test();
        this.getContentPane().add(this.main_content2,BorderLayout.EAST);

    }
    public void test(){
        System.out.println("jusqu'ici tout va bien"+compteur);
        compteur++;
    }
    @Override
    public void mousePressed(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {

    }


    /*
    public class actionListener1 implements ActionListener {


        @Override
        public void actionPerformed(ActionEvent actionEvent) {

         /*Object[][] data = {
                 {"test","test1","test2"}
                };
            System.out.println("pouet");

         //Fenetre.this.getContentPane().add(new JLabel("pouet"),2);
        }
    }
*/
}