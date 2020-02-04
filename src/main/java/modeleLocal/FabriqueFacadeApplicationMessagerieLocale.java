package modeleLocal;

import facade.FabriqueFacadeApplicationMessagerie;
import facade.FacadeApplicationMessagerie;

public class FabriqueFacadeApplicationMessagerieLocale implements FabriqueFacadeApplicationMessagerie {
    @Override
    public FacadeApplicationMessagerie creer() {
        return new ModeleLocal();
    }
}
