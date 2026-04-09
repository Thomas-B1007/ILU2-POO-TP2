package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlLibererEtalTest {
	private Village village;
	private Chef abraracourcix;
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	
	@BeforeEach
	public void initialiserSituation() {
		System.out.println("Initialisation...");
		village = new Village("le village des irréductibles", 10, 5);
		abraracourcix = new Chef("Abraracourcix", 10, village);
		village.setChef(abraracourcix);
		controlTrouverEtalVendeur = new ControlTrouverEtalVendeur(village);
	}

	@Test
	void testControlLibererEtal() {
		ControlLibererEtal controlLibererEtal = new ControlLibererEtal(controlTrouverEtalVendeur);
		assertNotNull(controlLibererEtal,"Constructeur ne renvoie pas null");
	}

	@Test
	void testIsVendeur() {
		ControlLibererEtal controlLibererEtal = new ControlLibererEtal(controlTrouverEtalVendeur);
		Gaulois asterix = new Gaulois("Asterix", 5);
		village.ajouterHabitant(asterix);
		assertFalse(controlLibererEtal.isVendeur("Existe pas"),"Existe pas n'est pas vendeur");
		assertFalse(controlLibererEtal.isVendeur("Asterix"),"Villageois normal n'est pas vendeur");
		village.installerVendeur(asterix, "sangliers", 3);
		assertTrue(controlLibererEtal.isVendeur("Asterix"),"Vendeur est bien vendeur");
	}

	@Test
	void testLibererEtal() {
		//TODO
		fail("Not yet implemented");
	}

}
