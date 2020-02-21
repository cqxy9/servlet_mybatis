package com.xy.mapper;

import com.xy.entity.EasyCodeTest;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (EasyCodeTest)表数据库访问层
 *
 * @author xy
 * @since 2020-02-22 00:29:11
 */
public interface EasyCodeTestMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    EasyCodeTest queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<EasyCodeTest> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param easyCodeTest 实例对象
     * @return 对象列表
     */
    List<EasyCodeTest> queryAll(EasyCodeTest easyCodeTest);

    /**
     * 新增数据
     *
     * @param easyCodeTest 实例对象
     * @return 影响行数
     */
    int insert(EasyCodeTest easyCodeTest);

    /**
     * 修改数据
     *
     * @param easyCodeTest 实例对象
     * @return 影响行数
     */
    int update(EasyCodeTest easyCodeTest);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}