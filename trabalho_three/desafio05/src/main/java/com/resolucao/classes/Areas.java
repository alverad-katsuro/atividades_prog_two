package com.resolucao.classes;

import java.util.ArrayList;

public class Areas {
    private ArrayList<String[]> areas = new ArrayList<>();

    public ArrayList<String[]> getAreas() {
        return areas;
    }

    public String getAreas_comp(String area) {
        for (String[] strings : getAreas()) {
            if (strings[0].equals(area)) {
                return strings[1];
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "Areas [areas=" + areas + "]";
    }

    public void setAreas(ArrayList<String[]> areas) {
        this.areas = areas;
    }

    public void addAreas(String[] areas) {
        getAreas().add(areas);
    }

}
