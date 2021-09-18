package com.example.dbengin.dao.impl;

import com.example.dbengin.bean.po.AreaInfoPO;
import com.example.dbengin.dao.AreaInfoDao;
import com.example.dbengin.dao.BaseDao;
import org.springframework.data.jdbc.core.convert.EntityRowMapper;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;

import java.util.List;
import java.util.Objects;

/**
 * 不需要加@Repository注解，Spring data jdbc会将其自动创建为Bean
 */
public class AreaInfoDaoImpl extends BaseDao implements AreaInfoDao {

    @Override
    public List<AreaInfoPO> findByName(String name) {
        String sql = """
                select * from area_info where name like concat(:name, '%')
                """;
        AreaInfoPO po = new AreaInfoPO();
        po.setName(name);
        //通过对象中的属性值传参
        return namedParameterJdbcTemplate.query(sql, new BeanPropertySqlParameterSource(po), new BeanPropertyRowMapper<>(AreaInfoPO.class));
    }

    @Override
    public List<AreaInfoPO> findByName2(String name) {
        String sql = """
                select * from area_info where name like concat(:name, '%')
                """;
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("name", name);
        return namedParameterJdbcTemplate.query(sql, parameterSource, new BeanPropertyRowMapper<>(AreaInfoPO.class));
    }

    @Override
    public List<AreaInfoPO> findByCondition(AreaInfoPO po) {
        StringBuilder sql = new StringBuilder("select * from area_info where true ");
        if (Objects.nonNull(po)) {
            if (Objects.nonNull(po.getName())) {
                sql.append("and name = :name");
            }
        }
        return namedParameterJdbcTemplate.query(sql.toString(), new BeanPropertySqlParameterSource(po), new BeanPropertyRowMapper<>(AreaInfoPO.class));
    }
}
