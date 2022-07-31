package com.example.bottomsheet;

public class Model {
    String language1;
    String language2;
    private boolean isSelected;

    public Model(boolean isSelected) {
        this.isSelected = isSelected;
    }

    public Model(String language1, String language2) {
        this.language1 = language1;
        this.language2 = language2;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public String getLanguage1() {
        return language1;
    }

    public void setLanguage1(String language1) {
        this.language1 = language1;
    }

    public String getLanguage2() {
        return language2;
    }

    public void setLanguage2(String language2) {
        this.language2 = language2;
    }

    @Override
    public String toString() {
        return "Model{" +
                "language1='" + language1 + '\'' +
                ", language2='" + language2 + '\'' +
                ", isSelected=" + isSelected +
                '}';
    }

}
