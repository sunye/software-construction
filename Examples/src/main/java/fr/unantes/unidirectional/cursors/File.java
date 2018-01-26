package fr.unantes.unidirectional.cursors;

/**
 * Created on 18/01/2018.
 *
 * @author NaoMod team.
 */
public interface File {

    Integer getSize();
    void setSize(Integer aSize);

    String getName();
    void setName(String aName);
}
