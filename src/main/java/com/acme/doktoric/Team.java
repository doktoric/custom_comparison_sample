package com.acme.doktoric;

/**
 * Created with IntelliJ IDEA.
 * User: Ricsi
 * Date: 2013.07.24.
 * Time: 21:03
 * To change this template use File | Settings | File Templates.
 */
public class Team {

    private Boss boss;
    private Integer countOfMembers;
    private String name;
    private Type type;

    public Team() {
    }

    public Team(Boss boss, Integer countOfMembers, String name, Type type) {

        this.boss = boss;
        this.countOfMembers = countOfMembers;
        this.name = name;
        this.type = type;
    }

    @Override
    public String toString() {
        return "Team{" + "boss=" + boss + ", countOfMembers=" + countOfMembers + ", name='" + name + '\'' + '}';
    }

    public void setBoss(Boss boss) {
        this.boss = boss;
    }

    public void setCountOfMembers(Integer countOfMembers) {
        this.countOfMembers = countOfMembers;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boss getBoss() {

        return boss;
    }

    public Integer getCountOfMembers() {
        return countOfMembers;
    }

    public String getName() {
        return name;
    }

    public Type getType(){
        return type;
    }

}
