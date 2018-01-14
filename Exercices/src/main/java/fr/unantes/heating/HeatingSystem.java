package fr.unantes.heating;

/**
 * Created by sunye on 21/11/2016.
 */
public interface HeatingSystem {
    void tooCool();
    void ok();
    void cleared();
    void failure();
}
