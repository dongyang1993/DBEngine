package com.example.dbengin;

import com.example.dbengin.bean.po.AreaInfoPO;
import com.example.dbengin.storage.AreaInfoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.List;

@SpringBootTest
class DbEngineApplicationAreaInfoTests {
    @Autowired
    private AreaInfoRepository areaInfoRepository;
    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    @Test
    void test() {
        Page<AreaInfoPO> all = areaInfoRepository.findAll(Pageable.unpaged());
        System.out.println("");
    }

    @Test
    void test1() {
        List<AreaInfoPO> all = areaInfoRepository.findAllByAreaLevel(1);
        System.out.println("");
    }

    @Test
    void test2() {
        List<AreaInfoPO> all = areaInfoRepository.getAllByAreaLevel(1);
        System.out.println("");
    }

    @Test
    void test3() {
        List<AreaInfoPO> all = areaInfoRepository.findAllByAreaLevelWithAlias(1, "湖北");
        System.out.println("");
    }

    @Test
    void test4() {
        List<AreaInfoPO> all = areaInfoRepository.findAllByAreaLevel4(1);
        System.out.println("");
    }

}
