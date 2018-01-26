package fr.unantes.unidirectional.collections;

import java.util.HashSet;
import java.util.Collection;

/**
 * Created on 18/01/2018.
 *
 * @author NaoMod team.
 */
public class HTMLFolder {

    private Collection<HTMLPage> pages = new PageCollection(new HashSet<HTMLPage>());

    public Collection<HTMLPage> getPages() {
        return pages;
    }
}
