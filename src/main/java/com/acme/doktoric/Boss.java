package com.acme.doktoric;

/**
 * Created with IntelliJ IDEA.
 * User: Ricsi
 * Date: 2013.07.24.
 * Time: 21:03
 * To change this template use File | Settings | File Templates.
 */
public class Boss {
    private String name;
    private Integer age;

    public Boss(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Boss{" + "name='" + name + '\'' + ", age=" + age + '}';
    }
}
