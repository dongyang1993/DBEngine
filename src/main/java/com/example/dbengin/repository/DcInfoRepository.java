package com.example.dbengin.repository;

import com.example.dbengin.bean.po.DcInfoPO;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DcInfoRepository extends CrudRepository<DcInfoPO, Integer> {

    List<DcInfoPO> getAllByProvinceCode(String provinceCode);

    @Query("select * from dc_info where province_code = :code")
    List<DcInfoPO> getAllByProvince(String code);
}
