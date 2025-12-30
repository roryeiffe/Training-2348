package org.example.ooppillars.encapsulation;

public class State {
    private String name;
    private String capital;
    private int population;
    private String governor;
    private int area;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCapital() {
        // we can access capital (and other private fields) here because this method resides in the same class
        return this.capital;
    }

    public void setCapital(String capital) {
        this.capital = this.capital;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public String getGovernor() {
        return governor;
    }

    public void setGovernor(String governor) {
        this.governor = governor;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }
}
