package com.example.dbengin;

import com.example.dbengin.bean.po.DcInfoPO;
import com.example.dbengin.repository.DcInfoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.*;

import java.util.List;
import java.util.Map;

@SpringBootTest
class DbEngineApplicationTests {
    @Autowired
    private DcInfoRepository dcInfoRepository;
    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    @Test
    void contextLoads() {
        String sql = "select * from dc_info where province_name like concat('%', :provinceName, '%')";
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("provinceName", "京");

        DcInfoPO dcInfoPO = new DcInfoPO();
        dcInfoPO.setProvinceName("京");
        BeanPropertySqlParameterSource beanProperty = new BeanPropertySqlParameterSource(dcInfoPO);

        BeanPropertyRowMapper<DcInfoPO> rowMapper = new BeanPropertyRowMapper<>(DcInfoPO.class);
        List<DcInfoPO> poList = jdbcTemplate.query(sql, parameterSource, rowMapper);
        List<DcInfoPO> poBeanList = jdbcTemplate.query(sql, beanProperty, rowMapper);
        Iterable<DcInfoPO> all = dcInfoRepository.findAll();
        System.out.println("");
    }

    @Test
    void fillData() {
        String sql = "select * from dc_info";
        List<DcInfoPO> infoPOList = jdbcTemplate.query(sql, new EmptySqlParameterSource(), new BeanPropertyRowMapper<>(DcInfoPO.class));

        String updateSql = "update dc_info set unique_dc_code = :uniqueDcCode where id = :id";
        for (DcInfoPO po : infoPOList) {
            po.setUniqueDcCode(po.getProvinceCode() + "_" + po.getCityCode() + "_" + po.getDcCode());
            jdbcTemplate.update(updateSql, new BeanPropertySqlParameterSource(po));
        }
    }

    @Test
    void fillAreaData() {
        String sql = "select * from dc_info";
        List<DcInfoPO> infoPOList = jdbcTemplate.query(sql, new EmptySqlParameterSource(), new BeanPropertyRowMapper<>(DcInfoPO.class));

        String updateSql = "update dc_info set area_code = :areaCode where id = :id";
        for (DcInfoPO po : infoPOList) {
            try {
                String idSql = "select id from device_ip_area_info where name like concat(:cityName, '市')";
                String code = jdbcTemplate.queryForObject(idSql, new MapSqlParameterSource(Map.of("cityName", po.getCityName())), String.class);
                po.setAreaCode(code);
                jdbcTemplate.update(updateSql, new BeanPropertySqlParameterSource(po));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    void getAllByProvince() {
        List<DcInfoPO> he = dcInfoRepository.getAllByProvinceCode("HE");
        List<DcInfoPO> hes = dcInfoRepository.getAllByProvince("HE");
        System.out.println("");
    }

}
