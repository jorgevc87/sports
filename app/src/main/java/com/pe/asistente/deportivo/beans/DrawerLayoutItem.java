package com.pe.asistente.deportivo.beans;

public class DrawerLayoutItem {

    private int iconOpcion;
    private String nomOpcion;
    private boolean isSelected;

    public DrawerLayoutItem(int iconOpcion, String nomOpcion, boolean isSelected) {
        this.iconOpcion(iconOpcion);
        this.nomOpcion(nomOpcion);
        this.isSelected(isSelected);
    }


    public int iconOpcion() {
        return iconOpcion;
    }

    public void iconOpcion(int iconOpcion) {
        this.iconOpcion = iconOpcion;
    }

    public String nomOpcion() {
        return nomOpcion;
    }

    public void nomOpcion(String nomOpcion) {
        this.nomOpcion = nomOpcion;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void isSelected(boolean isSelected) {
        this.isSelected = isSelected;
    }
}
