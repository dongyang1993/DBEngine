package com.example.dbengin.bean.po;


import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("area_info")         //标明表名
public class AreaInfoPO {

    @Id                     //标明主键ID
    private Integer id;
    private String name;
    @Column("area_level")   //默认会把下划线形式和小驼峰形式的自动映射起来，如果有特殊情况的可以用@Column注解设置数据库字段名
    private Integer areaLevel;
    private Integer parentId;
    private String pinyin;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAreaLevel() {
        return areaLevel;
    }

    public void setAreaLevel(Integer areaLevel) {
        this.areaLevel = areaLevel;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getPinyin() {
        return pinyin;
    }

    public void setPinyin(String pinyin) {
        this.pinyin = pinyin;
    }
}
