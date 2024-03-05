package com.abhi.springjdbcdemo.model;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
/* For different request we want different objects. So, we need to use the prototype scope.
By default the scope is singleton.
 */
@Scope("prototype")
public class Alien {

    private int id;
    private String name;
    private int age;
    private String technology;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getTechnology() {
        return technology;
    }

    public void setTechnology(String technology) {
        this.technology = technology;
    }

    @Override
    public String toString() {
        return "Alien [id=" + id + ", name=" + name + ", age=" + age + ", technology=" + technology + "]";
    }

}
