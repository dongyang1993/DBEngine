package com.example.dbengin.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jdbc.core.JdbcAggregateTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class BaseDao {

    @Autowired
    protected NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    protected JdbcAggregateTemplate aggregateTemplate;
}
