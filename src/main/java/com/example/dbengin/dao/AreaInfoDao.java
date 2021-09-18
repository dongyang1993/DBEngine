package com.example.dbengin.dao;

import com.example.dbengin.bean.po.AreaInfoPO;

import java.util.List;

public interface AreaInfoDao {

    List<AreaInfoPO> findByName(String name);

    List<AreaInfoPO> findByName2(String name);

    List<AreaInfoPO> findByCondition(AreaInfoPO po);

}
