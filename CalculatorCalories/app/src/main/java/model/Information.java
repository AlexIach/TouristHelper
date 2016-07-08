package model;

/**
 * Created by Alex Iachimov on 5/12/2016.
 */
public class Information {
    int id;
    String about;
    String infromation;

    public int getId() {
        return id;
    }

    public String getAbout() {
        return about;
    }

    public String getInfromation() {
        return infromation;
    }

    public Information(int id, String about, String infromation) {
        this.id = id;
        this.about = about;
        this.infromation = infromation;


    }
}
