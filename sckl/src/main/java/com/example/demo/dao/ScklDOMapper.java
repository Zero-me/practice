package com.example.demo.dao;

import com.example.demo.dataobject.ScklDO;
import java.util.List;

public interface ScklDOMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sckl
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Long seckillId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sckl
     *
     * @mbg.generated
     */
    int insert(ScklDO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sckl
     *
     * @mbg.generated
     */
    ScklDO selectByPrimaryKey(Long seckillId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sckl
     *
     * @mbg.generated
     */
    List<ScklDO> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sckl
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(ScklDO record);
}