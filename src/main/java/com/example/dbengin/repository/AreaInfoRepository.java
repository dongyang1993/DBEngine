package com.example.dbengin.repository;

import com.example.dbengin.bean.po.AreaInfoPO;
import com.example.dbengin.dao.AreaInfoDao;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AreaInfoRepository extends PagingAndSortingRepository<AreaInfoPO, Integer>, AreaInfoDao {

    List<AreaInfoPO> findAllByAreaLevel(int areaLevel);

    List<AreaInfoPO> findByNameLike(String name);

    List<AreaInfoPO> getAllByAreaLevelAndParentId(int areaLevel, int name);

    @Query(value = """
            select * \
            from area_info \
            where area_level = :areaLevel \
            and name like concat(:nameAlias, '%')
            """)
    List<AreaInfoPO> findAllByAreaLevelWithAlias(@Param("areaLevel") int level, @Param("nameAlias") String name);

    @Query("""
            select *
            from area_info
            where area_level = :areaLevel
            """)
    List<AreaInfoPO> findAllByAreaLevelWithoutAlias(int areaLevel);

//    @Query(value = "", rowMapperClass = BeanPropertyRowMapper.class)
//    AreaInfoPO findById();

}
