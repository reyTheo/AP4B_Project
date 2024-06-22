package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import model.Application;


public class ButtonsController implements ActionListener {
	
	private Application app;
	
	public ButtonsController(Application app) {
		this.app = app;
	}

	
	public void actionPerformed(ActionEvent evt) {
		JButton buttonClicked = (JButton) evt.getSource();
		String nom_bouton = buttonClicked.getName();
		if (nom_bouton.equals("jbOk")) {
			//app.readComboBoxForItinerarySearch();
			app.afficherMap();
		}
		else if (nom_bouton.equals("jbRoute")) {
			app.showRoute();
		}
		else if (nom_bouton.equals("jbPoint")) {
			app.showPoint();

		}
		else if (nom_bouton.equals("jbCouleur")) {
			System.out.println("appuie sur bouton couleur");
			app.choixCouleur();
		}
		else if (nom_bouton.equals("jbZoomPlus")) {
			app.modifyZoom((float)Application.CRAN_ZOOM_PLUS);
		}
		else if (nom_bouton.equals("jbZoomMoins")) {
			app.modifyZoom((float)Application.CRAN_ZOOM_MOINS);
		}
		else if (nom_bouton.equals("jbZoomReel")) {
			app.modifyZoom(Application.RETOUR_ZOOM_INITIAL);
		}
		else if (nom_bouton.equals("jbZoomGlobal")) {
			app.determinerZoomGlobal();
		}
		else if (nom_bouton.equals("jbZoomGrosPlan")) {
			app.modifyZoom((float)Application.ZOOM_MAX);
		}
	}
	
}
