package edu.bjut.cs.gns.client;

import java.io.Serializable;

public class TestEntity implements Serializable {

    public String name;

    public int age;

    public TestEntity() {
    }

    public TestEntity(String name, int age) {
        this.name = name;
        this.age = age;
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

    @Override
    public String toString() {
        return "TestEntity{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
