package com.example.dbengin.storage;

import com.example.dbengin.bean.po.AreaInfoPO;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AreaInfoRepository extends PagingAndSortingRepository<AreaInfoPO, Integer> {

    List<AreaInfoPO> findAllByAreaLevel(int areaLevel);

    List<AreaInfoPO> findByAreaLevel(int areaLevel);

    List<AreaInfoPO> getAllByAreaLevel(@Param("areaLevel") int areaLevel);

    @Query(value = """
            select * 
            from area_info 
            where area_level = :areaLevel 
            and name like concat(:name, '%')
            """)
    List<AreaInfoPO> findAllByAreaLevel3(@Param("areaLevel") int a, @Param("namex") String b);

    @Query("""
            select * 
            from area_info 
            where area_level = :areaLevel
            """)
    List<AreaInfoPO> findAllByAreaLevel4(int areaLevel);
}
