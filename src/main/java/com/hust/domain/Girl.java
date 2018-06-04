package com.hust.domain;

import javax.persistence.*;
import javax.validation.constraints.Min;

/**
 * Created by HYLJ on 2018/6/1 0001.
 */
@Entity
public class Girl {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String cupSize;

    @Min(value = 18,message = "禁止未成年人入内")
    private Integer age;

    public Girl() {

    }

    public Girl(Integer age, String cupSize) {
        this.age = age;
        this.cupSize = cupSize;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCupSize() {
        return cupSize;
    }

    public void setCupSize(String cupSize) {
        this.cupSize = cupSize;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Girl{" +
                "id=" + id +
                ", cupSize='" + cupSize + '\'' +
                ", age=" + age +
                '}';
    }
}
