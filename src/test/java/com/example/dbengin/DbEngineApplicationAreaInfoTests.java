package com.example.dbengin;

import com.example.dbengin.bean.po.AreaInfoPO;
import com.example.dbengin.repository.AreaInfoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.List;
import java.util.Optional;

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
        List<AreaInfoPO> all = areaInfoRepository.getAllByAreaLevelAndParentId(2, 110000);
        System.out.println("");
    }

    @Test
    void test3() {
        List<AreaInfoPO> all = areaInfoRepository.findAllByAreaLevelWithAlias(1, "湖北");
        System.out.println("");
    }

    @Test
    void test4() {
        List<AreaInfoPO> all = areaInfoRepository.findAllByAreaLevelWithoutAlias(1);
        System.out.println("");
    }

    @Test
    void test5() {
        Optional<AreaInfoPO> infoPO = areaInfoRepository.findById(1);
        System.out.println("");
    }


    @Test
    void test7() {
        List<AreaInfoPO> pos = areaInfoRepository.findByName("湖");
        System.out.println("");
    }

    @Test
    void test8() {
        List<AreaInfoPO> pos = areaInfoRepository.findByName2("湖");
        System.out.println("");
    }

    @Test
    void test9() {
        List<AreaInfoPO> pos = areaInfoRepository.findByName10("湖");
        System.out.println("");
    }

    @Test
    void test10() {
        AreaInfoPO po = new AreaInfoPO();
        po.setName("湖北省");
        List<AreaInfoPO> pos = areaInfoRepository.findByCondition(po);
        System.out.println("");
    }

}
