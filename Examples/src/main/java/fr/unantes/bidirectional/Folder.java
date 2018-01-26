package fr.unantes.bidirectional;

import java.util.ArrayList;

/**
 * Created on 18/01/2018.
 *
 * @author NaoMod team.
 */
public class Folder {

    private FileCollection files = new FileCollection(new ArrayList<File>());

    public FileCollection getFiles() {
        return files;
    }
}
