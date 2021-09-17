package com.example.dbengin;

import com.example.dbengin.bean.po.UserInfoPO;
import com.example.dbengin.repository.UserInfoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
class DbEngineApplicationUserInfoTests {
    @Autowired
    private UserInfoRepository userInfoRepository;

    @Test
    void test() {
        UserInfoPO po = new UserInfoPO();
        po.setUsername("scot");
        po.setPassword("123456");
        po.setEnable(Boolean.TRUE);
        UserInfoPO save = userInfoRepository.save(po);
        System.out.printf("ID:%d",save.getId());
    }

    @Test
    void test2() {
        Optional<UserInfoPO> infoPO = userInfoRepository.findById(1);
        System.out.println("");
    }
}
