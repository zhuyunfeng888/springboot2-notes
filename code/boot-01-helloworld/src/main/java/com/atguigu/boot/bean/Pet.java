package com.atguigu.boot.bean;


import java.util.Objects;

/**
 * 宠物
 */
public class Pet
{

    private String name;

    public Pet()
    {
    }

    public Pet(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    @Override
    public String toString()
    {
        return "Pet{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pet pet = (Pet) o;
        return Objects.equals(name, pet.name);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(name);
    }
}
