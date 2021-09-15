package com.example.dbengin.bean.po;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.io.Serializable;

@Table("dc_info")
public class DcInfoPO implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @Id
    private Long id;

    /**
     * 省份
     */
    @Column("province_name")
    private String provinceName;

    /**
     * 省编码
     */
    private String provinceCode;

    /**
     * 地市
     */
    private String cityName;

    /**
     * 地市编码
     */
    private String cityCode;

    /**
     * DC名称
     */
    private String dcName;

    /**
     * DC编码
     */
    private String dcCode;

    private String uniqueDcCode;

    private String areaCode;

    /**
     * 网元省份编码
     */
    private String nodeCode;

    /**
     * 是否可见 0:不可见  1:可见
     */
    private Boolean visible;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public String getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getDcName() {
        return dcName;
    }

    public void setDcName(String dcName) {
        this.dcName = dcName;
    }

    public String getDcCode() {
        return dcCode;
    }

    public void setDcCode(String dcCode) {
        this.dcCode = dcCode;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getNodeCode() {
        return nodeCode;
    }

    public void setNodeCode(String nodeCode) {
        this.nodeCode = nodeCode;
    }

    public Boolean getVisible() {
        return visible;
    }

    public void setVisible(Boolean visible) {
        this.visible = visible;
    }

    public String getUniqueDcCode() {
        return uniqueDcCode;
    }

    public void setUniqueDcCode(String uniqueDcCode) {
        this.uniqueDcCode = uniqueDcCode;
    }
}
