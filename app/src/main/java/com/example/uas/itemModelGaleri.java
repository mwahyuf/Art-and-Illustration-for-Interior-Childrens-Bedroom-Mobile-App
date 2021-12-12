package com.example.uas;

public class itemModelGaleri {

    String name;
    String creator;
    String type;
    int image;

    public itemModelGaleri(String name, String creator, String type, int image) {
        this.name = name;
        this.creator = creator;
        this.type = type;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
