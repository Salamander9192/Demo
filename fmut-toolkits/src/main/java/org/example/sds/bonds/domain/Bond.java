package org.example.sds.bonds.domain;

import java.io.Serializable;

/**
 * @classname: Bond
 * @description:
 * @author: jiadongrui
 * @create: 2021-07-16 11:13
 **/
public class Bond implements Serializable {

    private String bondCode;

    private String term;

    public Bond(String bondCode, String term) {
        this.bondCode = bondCode;
        this.term = term;
    }

    public String getBondCode() {
        return bondCode;
    }

    public void setBondCode(String bondCode) {
        this.bondCode = bondCode;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    @Override
    public String toString() {
        return "Bond{" +
                "bondCode='" + bondCode + '\'' +
                ", term='" + term + '\'' +
                '}';
    }
}
