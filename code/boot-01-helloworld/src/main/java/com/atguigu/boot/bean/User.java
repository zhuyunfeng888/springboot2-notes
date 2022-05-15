package com.atguigu.boot.bean;

import java.util.Objects;

/**
 * 用户
 */

public class User
{

    private String name;
    private Integer age;

    private Pet pet;

    public User()
    {
    }

    public User(String name, Integer age)
    {
        this.name = name;
        this.age = age;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Integer getAge()
    {
        return age;
    }

    public void setAge(Integer age)
    {
        this.age = age;
    }

    public Pet getPet()
    {
        return pet;
    }

    public void setPet(Pet pet)
    {
        this.pet = pet;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(name, user.name) &&
                Objects.equals(age, user.age) &&
                Objects.equals(pet, user.pet);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(name, age, pet);
    }

    @Override
    public String toString()
    {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", pet=" + pet +
                '}';
    }
}
