package org.example.collections;

//Pokemon Model Class - we'll use Pokemon objects in our various Collections examples

public class Pokemon {

    //Keeping these private for Encapsulation (private vars with public getters/setters)
    private String name;
    private int level;

    //Let's add a method for some spice
    public void fight(Pokemon opponent){
        if(this.level > opponent.level){
            System.out.println(this.name + " wins against " + opponent.name);
        } else {
            System.out.println(opponent.name + " wins against " + this.name);
        }
    }

    //Boilerplate code ----------------------/
    //I only care about an all-args constructor, getters/setters, and toString

    //In Intellij, you can right click + generate + your entity of choice

    public Pokemon(String name, int level) {
        this.name = name;
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "Pokemon{" +
                "name='" + name + '\'' +
                ", level=" + level +
                '}';
    }
}
