package com.xy.entity;

import java.io.Serializable;

/**
 * (EasyCodeTest)实体类
 *
 * @author xy
 * @since 2020-02-22 00:13:34
 */
public class EasyCodeTest implements Serializable {
    private static final long serialVersionUID = -32345660207444294L;
    
    private Integer id;
    
    private String abc;
    
    private String qwe;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAbc() {
        return abc;
    }

    public void setAbc(String abc) {
        this.abc = abc;
    }

    public String getQwe() {
        return qwe;
    }

    public void setQwe(String qwe) {
        this.qwe = qwe;
    }

}