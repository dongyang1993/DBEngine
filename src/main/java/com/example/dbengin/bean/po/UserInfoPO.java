package com.example.dbengin.bean.po;


import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("user_info")
public class UserInfoPO {

    @Id
    private Integer id;
    private String username;
    private String password;
    private Boolean enable;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }
}
