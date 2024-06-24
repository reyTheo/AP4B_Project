package view;

import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.*;
import javax.swing.event.ChangeListener;

import model.Application;
import org.jdesktop.swingx.autocomplete.*;
import java.awt.image.BufferedImage;

// TODO: Auto-generated Javadoc
/**
 * The Class PanelControls.
 */
@SuppressWarnings("serial")
public class PanelControls extends JPanel {
	
	/** The HAUTEUR. */
	private final int HAUTEUR = 120;
	
	/** The jl depart. */
	private JLabel jlDepart;
	
	/** The jl arrivee. */
	private JLabel jlArrivee;
	
	/** The jl ville. */
	private JLabel jlVille;
	
	/** The jl rue. */
	private JLabel jlRue;
	
	/** The jl point. */
	private JLabel jlPoint;
	
	/** The jcb ville depart. */
	private JComboBox jcbVilleDepart;
	
	/** The jcb ville arrivee. */
	private JComboBox jcbVilleArrivee;
	//constantes de selection de comboBox
	/**
	 * The Enum jcbFlag.
	 */
	public enum jcbFlag {
/** The DEPART. */
DEPART, 
 /** The ARRIVEE. */
 ARRIVEE, 
 /** The BOTH. */
 BOTH};
	
	/** The jcb rue depart. */
	private JComboBox jcbRueDepart;
	
	/** The jcb rue arrivee. */
	private JComboBox jcbRueArrivee;
	
	/** The jcb point depart. */
	private JComboBox jcbPointDepart;
	
	/** The jcb point arrivee. */
	private JComboBox jcbPointArrivee;
	
	/** The jb ok. */
	private JButton jbOk;

	/** The jb couleur itinéraire. */	
	private JButton jbCouleur;

	private JButton jbPoint;

	private JButton jbRoute;

	private JButton jbMode;

	public static boolean modeEdition=false;

	private JButton jbMap;

	private Color itineraire_couleur = Color.BLUE;

	
	/** The jl zoom. */
	private JLabel jlZoom;
	
	/** The js zoom. */
	private JSlider jsZoom;
	
	/** The jb zoom plus. */
	private JButton jbZoomPlus;
	
	/** The jb zoom moins. */
	private JButton jbZoomMoins;
	
	/** The jb zoom global. */
	private JButton jbZoomGlobal;
	
	/** The jb zoom gros plan. */
	private JButton jbZoomGrosPlan;
	
	/** The jb zoom reel. */
	private JButton jbZoomReel;
	
	/** The jp conteneur est. */
	private JPanel jpConteneurEst;
	
	/** The jp conteneur ouest. */
	private JPanel jpConteneurOuest;
	
	/** The contraintes. */
	private GridBagConstraints contraintes;

	/**
	 * Instantiates a new panel controls.
	 */
	public PanelControls() {
		super();
		setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

		jpConteneurOuest = new JPanel(new GridBagLayout());
        jpConteneurOuest.setBorder(BorderFactory.createTitledBorder("Itinerary Controls"));
		jpConteneurOuest.setPreferredSize(new Dimension(1200, HAUTEUR)); 
        jpConteneurOuest.setMinimumSize(new Dimension(1200, HAUTEUR));
		
		contraintes = new GridBagConstraints();
		contraintes.insets = new Insets(5, 5, 5, 5);
		contraintes.anchor = GridBagConstraints.HORIZONTAL;
		contraintes.weightx = 0.0;

		contraintes.anchor = GridBagConstraints.CENTER;
		
		jlDepart = new JLabel("D\u00e9part :");
		jlDepart.setFont(jlDepart.getFont().deriveFont(Font.BOLD));
		
		
		jcbVilleDepart = new JComboBox();
		jcbVilleDepart.setName("jcbVilleDepart");
		jcbVilleDepart.setPreferredSize(new Dimension(175, 20));
		jcbVilleDepart.setEditable(true);

		jcbRueDepart = new JComboBox();
		jcbRueDepart.setName("jcbRueDepart");
		jcbRueDepart.setPreferredSize(new Dimension(175, 20));

		jcbPointDepart = new JComboBox();
		jcbPointDepart.setPreferredSize(new Dimension(175, 20));

		jlArrivee = new JLabel("Arriv\u00e9e :");
		jlArrivee.setFont(jlArrivee.getFont().deriveFont(Font.BOLD));
		
		jcbVilleArrivee = new JComboBox();
		jcbVilleArrivee.setName("jcbVilleArrivee");
		jcbVilleArrivee.setPreferredSize(new Dimension(175, 20));
		
		jcbRueArrivee = new JComboBox();
		jcbRueArrivee.setName("jcbRueArrivee");
		jcbRueArrivee.setPreferredSize(new Dimension(175, 20));
		
		jcbPointArrivee = new JComboBox();
		jcbPointArrivee.setPreferredSize(new Dimension(175, 20));

		jbOk = new JButton("Go");
		jbOk.setFont(new Font(jbOk.getFont().getFontName(), Font.BOLD, 15));
		jbOk.setName("jbOk");
		contraintes.gridx = 4;
		contraintes.gridy = 0;
		contraintes.gridheight = 2;
		contraintes.fill = GridBagConstraints.VERTICAL;
		contraintes.anchor = GridBagConstraints.LINE_START;
		
		jbCouleur = new JButton("Changer couleur du trac\u00e9");
		jbCouleur.setName("jbCouleur");
		contraintes.gridx = 5;
		contraintes.gridy = 0;
		setItineraireCouleur(itineraire_couleur);
		jpConteneurOuest.add(jbCouleur, contraintes);

		jbPoint = new JButton("Afficher Points");
		jbPoint.setName("jbPoint");
		contraintes.gridx = 6;
		contraintes.gridy = 0;

		jbRoute = new JButton("Afficher les routes");
		jbRoute.setName("jbRoute");
		contraintes.gridx = 7;
		contraintes.gridy = 0;

		jbMap = new JButton("Enlever la carte");
		jbMap.setName("jbMap");
		contraintes.gridx = 8;
		contraintes.gridy = 0;

		jbMode = new JButton("Changer Mode");
		jbMode.setName("jbMode");
		contraintes.gridx = 9;
		contraintes.gridy = 0;

		jpConteneurEst = new JPanel(new GridBagLayout());
		jpConteneurEst.setBorder(BorderFactory.createTitledBorder("Zoom Controls"));
		jpConteneurEst.setMaximumSize(new Dimension(400, HAUTEUR));

		contraintes.gridheight = 1;
		contraintes.weightx = 1.0;
		contraintes.fill = GridBagConstraints.NONE;

		jbZoomPlus = new JButton();
		jbZoomPlus.setName("jbZoomPlus");
		jbZoomPlus.setText("+");
		jbZoomPlus.setPreferredSize(new Dimension(18, 18));
		jbZoomPlus.setMargin(new Insets(0, 0, 0, 0));
		contraintes = new GridBagConstraints();
		contraintes.gridx = 4;
		contraintes.gridy = 0;
		contraintes.anchor = GridBagConstraints.WEST;
		jpConteneurEst.add(jbZoomPlus, contraintes);
		
		jbZoomMoins = new JButton();
		jbZoomMoins.setName("jbZoomMoins");
		jbZoomMoins.setText("-");
		jbZoomMoins.setPreferredSize(new Dimension(18, 18));
		jbZoomMoins.setMargin(new Insets(0, 0, 0, 0));
		contraintes = new GridBagConstraints();
		contraintes.gridx = 0;
		contraintes.gridy = 0;
		contraintes.anchor = GridBagConstraints.EAST;
		jpConteneurEst.add(jbZoomMoins, contraintes);

		jsZoom = new JSlider();
		jsZoom.setMinimum((int) (Application.ZOOM_MIN * 100));
		jsZoom.setMaximum((int) (Application.ZOOM_MAX * 100));
		jsZoom.setValue((int) (Application.ZOOM_INITIAL * 100));
		jsZoom.setMajorTickSpacing(10);
		jsZoom.setPaintTicks(false);
		jsZoom.setPaintLabels(false);
		contraintes = new GridBagConstraints();
		contraintes.gridx = 1;
		contraintes.gridy = 0;
		contraintes.gridwidth = 3;
		jpConteneurEst.add(jsZoom, contraintes);

		jbZoomGlobal = new JButton("Vue Globale");
		jbZoomGlobal.setName("jbZoomGlobal");
		jbZoomGlobal.setPreferredSize(new Dimension(100, 20));	
		contraintes = new GridBagConstraints();
		contraintes.gridx = 0;
		contraintes.gridy = 2;
		jpConteneurEst.add(jbZoomGlobal, contraintes);
		
		jbZoomReel = new JButton("R\u00e9initialiser");
		jbZoomReel.setName("jbZoomReel");
		jbZoomReel.setPreferredSize(new Dimension(100, 20));
		contraintes = new GridBagConstraints();
		contraintes.gridx = 3;
		contraintes.gridy = 2;
		jpConteneurEst.add(jbZoomReel, contraintes);
		
		jbZoomGrosPlan = new JButton("Gros plan");
		jbZoomGrosPlan.setName("jbZoomGrosPlan");
		jbZoomGrosPlan.setPreferredSize(new Dimension(100, 20));
		contraintes = new GridBagConstraints();
		contraintes.gridx = 4;
		contraintes.gridy = 2;
		jpConteneurEst.add(jbZoomGrosPlan, contraintes);

		add(jpConteneurOuest, BorderLayout.WEST);
        add(jpConteneurEst, BorderLayout.EAST);

		updateComponents();
	}

	private void updateComponents() {
		jpConteneurOuest.removeAll();
		
		if (modeEdition) {
			contraintes.gridheight = 1;
			jpConteneurOuest.setBorder(BorderFactory.createTitledBorder("Edition Mode"));

			Dimension buttonSize = new Dimension(150, 45); // Par exemple, 100 de largeur et 30 de hauteur

        	jbPoint.setPreferredSize(buttonSize);
        	jbRoute.setPreferredSize(buttonSize);
        	jbMap.setPreferredSize(buttonSize);

			contraintes.gridx = 6;
			contraintes.gridy = 0;
			jpConteneurOuest.add(jbPoint, contraintes);

			contraintes.gridx = 7;
			contraintes.gridy = 0;
			jpConteneurOuest.add(jbRoute, contraintes);

			contraintes.gridx = 8;
			contraintes.gridy = 0;
			jpConteneurOuest.add(jbMap, contraintes);
		} else {
			jpConteneurOuest.setBorder(BorderFactory.createTitledBorder("Itinerary Controls"));

			contraintes.weightx = 0.0;
			contraintes.gridheight = 1;
			contraintes.weightx = 1.0;
			contraintes.gridx = 0;
			contraintes.gridy = 0;
			jpConteneurOuest.add(jlDepart, contraintes);
			
			contraintes.gridx = 1;
			contraintes.gridy = 0;
			jpConteneurOuest.add(jcbVilleDepart, contraintes);

			contraintes.gridx = 2;
			contraintes.gridy = 0;
			jpConteneurOuest.add(jcbRueDepart, contraintes);

			contraintes.gridx = 3;
			contraintes.gridy = 0;
			jpConteneurOuest.add(jcbPointDepart, contraintes);

			contraintes.gridx = 0;
			contraintes.gridy = 1;
			jpConteneurOuest.add(jlArrivee, contraintes);

			contraintes.gridx = 1;
			contraintes.gridy = 1;
			jpConteneurOuest.add(jcbVilleArrivee, contraintes);

			contraintes.gridx = 2;
			contraintes.gridy = 1;
			jpConteneurOuest.add(jcbRueArrivee, contraintes);

			contraintes.gridx = 3;
			contraintes.gridy = 1;
			jpConteneurOuest.add(jcbPointArrivee, contraintes);

			contraintes.gridx = 4;
			contraintes.gridy = 0;
			contraintes.gridheight = 2;
			contraintes.fill = GridBagConstraints.VERTICAL;
			jpConteneurOuest.add(jbOk, contraintes);
		}
		
		contraintes.gridx = 5;
		contraintes.gridy = 0;
		jpConteneurOuest.add(jbCouleur, contraintes);
		contraintes.gridx = 9;
		contraintes.gridy = 0;
		jpConteneurOuest.add(jbMode, contraintes);
		
		jpConteneurOuest.revalidate();
		jpConteneurOuest.repaint();
	}
	
	/**
	 * Ajouter route dans combobox.
	 *
	 * @param route the route
	 * @param flag the flag
	 */
	public void ajouterRouteDansCombobox(String route, jcbFlag flag) {
		switch(flag){
		case DEPART:
			jcbRueDepart.addItem(route);
			break;
		
		case ARRIVEE:
			jcbRueArrivee.addItem(route);
			break;
			
		case BOTH:
			jcbRueDepart.addItem(route);
			jcbRueArrivee.addItem(route);
			break;
		}	
	}
	
	/**
	 * Ajouter ville dans combobox.
	 *
	 * @param ville the ville
	 */
	public void ajouterVilleDansCombobox(String ville){
		jcbVilleDepart.addItem(ville);
		AutoCompleteDecorator.decorate(jcbVilleDepart);
		jcbVilleArrivee.addItem(ville);
		AutoCompleteDecorator.decorate(jcbVilleArrivee);
	}
	
	/**
	 * Gets the nom ville.
	 *
	 * @param flag the flag
	 * @return the nom ville
	 */
	public String getNomVille(jcbFlag flag) {
		String ret = "";
		switch (flag) {
			case DEPART: ret = (String)jcbVilleDepart.getSelectedItem(); break;
			case ARRIVEE: ret = (String)jcbVilleArrivee.getSelectedItem(); break;
		}
		return ret;
	}
	
	/**
	 * Gets the nom route.
	 *
	 * @param flag the flag
	 * @return the nom route
	 */
	public String getNomRoute(jcbFlag flag) {
		String ret = "";
		switch (flag) {
			case DEPART: ret = (String)jcbRueDepart.getSelectedItem(); break;
			case ARRIVEE: ret = (String)jcbRueArrivee.getSelectedItem(); break;
		}
		return ret;
	}
	
	/**
	 * Gets the num point.
	 *
	 * @param flag the flag
	 * @return the num point
	 */
	public int getNumPoint(jcbFlag flag) {
		int ret = -1;
		switch (flag) {
			case DEPART: ret = (Integer)jcbPointDepart.getSelectedItem(); break;
			case ARRIVEE: ret = (Integer)jcbPointArrivee.getSelectedItem(); break;
		}
		return ret;
	}

	
	
	/**
	 * Sets the points.
	 *
	 * @param flag the flag
	 * @param liste the liste
	 */
	public void setPoints(jcbFlag flag, Vector<Integer> liste) {
		JComboBox cmb = new JComboBox();
		switch (flag) {
			case DEPART: cmb = jcbPointDepart; break;
			case ARRIVEE: cmb = jcbPointArrivee; break;
		}
		cmb.removeAllItems();
		if (liste.size() > 0) {
			for (Iterator it = liste.iterator(); it.hasNext();) {
				cmb.addItem(it.next());
			}
		}
	}
	
	/**
	 * Changer texte bouton ok.
	 *
	 * @param texte the texte
	 */
	public void changerTexteBoutonOk(String texte) {
		jbOk.setText(texte);
	}

	/**
	 * Ajouter ecouteur au bouton ok.
	 *
	 * @param ecouteur the ecouteur
	 */
	public void ajouterEcouteurAuBoutonOk(ActionListener ecouteur) {
		jbOk.addActionListener(ecouteur);
	}

	/**
	 * Ajouter ecouteur au bouton point.
	 *
	 * @param ecouteur the ecouteur
	 */
	public void ajouterEcouteurAuBoutonPoint(ActionListener ecouteur) {
		jbPoint.addActionListener(ecouteur);
	}

		/**
	 * Ajouter ecouteur au bouton route.
	 *
	 * @param ecouteur the ecouteur
	 */
	public void ajouterEcouteurAuBoutonRoute(ActionListener ecouteur) {
		jbRoute.addActionListener(ecouteur);
	}
	
	/**
	 * Ajouter ecouteur au bouton mode.
	 *
	 * @param ecouteur the ecouteur
	 */
	public void ajouterEcouteurAuBoutonMode(ActionListener ecouteur) {
		jbMode.addActionListener(ecouteur);
	}

		/**
	 * Ajouter ecouteur au bouton couleur.
	 *
	 * @param ecouteur the ecouteur
	 */
	public void ajouterEcouteurAuBoutonCouleur(ActionListener ecouteur) {
		jbCouleur.addActionListener(ecouteur);
	}
	

			/**
	 * Ajouter ecouteur au bouton enlever map.
	 *
	 * @param ecouteur the ecouteur
	 */
	public void ajouterEcouteurAuBoutonEnleverMap(ActionListener ecouteur) {
		jbMap.addActionListener(ecouteur);
	}
	
	/**
	 * Ajouter ecouteur au bouton zoom moins.
	 *
	 * @param ecouteur the ecouteur
	 */
	public void ajouterEcouteurAuBoutonZoomMoins(ActionListener ecouteur) {
		jbZoomMoins.addActionListener(ecouteur);
	}
	
	/**
	 * Ajouter ecouteur au bouton zoom plus.
	 *
	 * @param ecouteur the ecouteur
	 */
	public void ajouterEcouteurAuBoutonZoomPlus(ActionListener ecouteur) {
		jbZoomPlus.addActionListener(ecouteur);
	}

	/**
	 * Ajouter ecouteur au bouton zoom reel.
	 *
	 * @param ecouteur the ecouteur
	 */
	public void ajouterEcouteurAuBoutonZoomReel(ActionListener ecouteur) {
		jbZoomReel.addActionListener(ecouteur);
	}

	/**
	 * Ajouter ecouteur au bouton zoom global.
	 *
	 * @param ecouteur the ecouteur
	 */
	public void ajouterEcouteurAuBoutonZoomGlobal(ActionListener ecouteur) {
		jbZoomGlobal.addActionListener(ecouteur);	
	}
	
	/**
	 * Ajouter ecouteur au bouton zoom gros plan.
	 *
	 * @param ecouteur the ecouteur
	 */
	public void ajouterEcouteurAuBoutonZoomGrosPlan(ActionListener ecouteur) {
		jbZoomGrosPlan.addActionListener(ecouteur);	
	}
	
	/**
	 * Ajouter ecouteur au slider.
	 *
	 * @param ecouteur the ecouteur
	 */
	public void ajouterEcouteurAuSlider(ChangeListener ecouteur) {
		jsZoom.addChangeListener(ecouteur);
	}
	
	/**
	 * Ajouter ecouteur ville depart.
	 *
	 * @param ecouteur the ecouteur
	 */
	public void ajouterEcouteurVilleDepart(ActionListener ecouteur) {
		jcbVilleDepart.addActionListener(ecouteur);
	}
	
	/**
	 * Ajouter ecouteur rue depart.
	 *
	 * @param ecouteur the ecouteur
	 */
	public void ajouterEcouteurRueDepart(ActionListener ecouteur) {
		jcbRueDepart.addActionListener(ecouteur);
	}
	
	/**
	 * Ajouter ecouteur ville arrivee.
	 *
	 * @param ecouteur the ecouteur
	 */
	public void ajouterEcouteurVilleArrivee(ActionListener ecouteur) {
		jcbVilleArrivee.addActionListener(ecouteur);
	}
	
	/**
	 * Ajouter ecouteur rue arrivee.
	 *
	 * @param ecouteur the ecouteur
	 */
	public void ajouterEcouteurRueArrivee(ActionListener ecouteur) {
		jcbRueArrivee.addActionListener(ecouteur);
	}
	
	/**
	 * Ville deja presente.
	 *
	 * @param ville the ville
	 * @return true, if successful
	 */
	public boolean villeDejaPresente(String ville) {
		for(int i=0;i<jcbVilleDepart.getItemCount();i++){
			if(jcbVilleDepart.getItemAt(i).toString().equals(ville)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Vider rue combo box.
	 *
	 * @param flag the flag
	 */
	public void viderRueComboBox(jcbFlag flag) {
		switch(flag){
		case ARRIVEE:
			jcbRueArrivee.removeAllItems();
			break;
		
		case DEPART:
			jcbRueDepart.removeAllItems();
			break;
			
		case BOTH:
			jcbRueDepart.removeAllItems();
			jcbRueArrivee.removeAllItems();
			break;
		}	
	}
	
	/**
	 * Sets the slider value.
	 *
	 * @param val the new slider value
	 */
	public void setSliderValue(int val){
		jsZoom.setValue(val);
	}
	
	/**
	 * Sets the icon zoom moins.
	 *
	 * @param icon the new icon zoom moins
	 */
	public void setIconZoomMoins(ImageIcon icon) {
		jbZoomMoins.setIcon(icon);
	}
	
	/**
	 * Sets the icon zoom plus.
	 *
	 * @param icon the new icon zoom plus
	 */
	public void setIconZoomPlus(ImageIcon icon) {
		jbZoomPlus.setIcon(icon);
	}

	/**
	 * Sets the itineraire couleur.
	 *
	* @param couleur the new itineraire couleur
	*/
   public void setItineraireCouleur(Color couleur) {
	   itineraire_couleur = couleur;
	   BufferedImage dessin_couleur = new BufferedImage(15, 15, BufferedImage.TYPE_INT_RGB);
	   Graphics2D g2 = dessin_couleur.createGraphics();
	   g2.setColor(itineraire_couleur);
	   g2.fillRect(0, 0, 15, 15);
	   ImageIcon icone_couleur = new ImageIcon(dessin_couleur);
	   jbCouleur.setIcon(icone_couleur);
   }


   public void rafraichir(){
		System.out.println(modeEdition);
		updateComponents();
   }
	
}