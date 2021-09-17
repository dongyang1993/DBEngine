package com.example.dbengin.repository;

import com.example.dbengin.bean.po.UserInfoPO;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserInfoRepository extends PagingAndSortingRepository<UserInfoPO, Integer> {
}
