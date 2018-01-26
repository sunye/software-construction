package fr.unantes.unidirectional.cursors;

/**
 * Created on 18/01/2018.
 *
 * @author NaoMod team.
 */
public interface Folder {

    String getName();
    void setName(String aName);

    FileCursor files();
}
