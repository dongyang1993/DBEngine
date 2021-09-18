package com.example.dbengin.repository;

import com.example.dbengin.bean.po.UserInfoPO;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserInfoRepository extends PagingAndSortingRepository<UserInfoPO, Integer> {

    @Query(value = """
            select * from user_info where username = :username
            """)
    List<UserInfoPO> findByUsername(String username);


    //试验后发现这种形式的目前还不能通过对象传参
    @Query(value = """
            select * from user_info where username = :#{#po.username}
            """)
    List<UserInfoPO> findByCondition(@Param("po") UserInfoPO po);


    @Modifying
    @Query(value = """
            update user_info set password = :password where username = :username
            """)
    boolean updatePasswordByUsername(String username, String password);
}
