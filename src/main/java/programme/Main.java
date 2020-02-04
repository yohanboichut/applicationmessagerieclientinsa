package programme;

import controleur.Controleur;
import facade.FabriqueFacadeApplicationMessagerie;
import facade.FabriqueFacadeApplicationMessagerieImpl;
import modeleLocal.FabriqueFacadeApplicationMessagerieLocale;
import vues.FabriqueVues;
import vues.terminal.FabriqueVuesTerminalImpl;

public class Main {
    public static void main(String[] args) {

        FabriqueVues fabriqueVues = new FabriqueVuesTerminalImpl();
        FabriqueFacadeApplicationMessagerie facadeApplicationMessagerie = new FabriqueFacadeApplicationMessagerieLocale();

        Controleur controleur = new Controleur(facadeApplicationMessagerie,fabriqueVues);

        try {
            controleur.run();
        }
        catch (RuntimeException e) {
            System.err.println("Probleme de connexion... Client down");
        }

    }
}
