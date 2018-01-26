package fr.unantes.bidirectional;

/**
 * Created on 18/01/2018.
 *
 * @author NaoMod team.
 */
public class File {
    private Folder folder;

    public File(Folder aFolder) {
        folder = aFolder;
    }

    public Folder getFolder() {
        return folder;
    }
}
