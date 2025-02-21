package com.sky.mapper;

import com.sky.entity.Setmeal;
import com.sky.entity.SetmealDish;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SetmealDishMapper {
    /**
     * 批量保存套餐和菜品的关联关系
     * @param setmealDishes
     */
    void insertBatch(List<SetmealDish> setmealDishes);

    /**
     * 根据菜品id查询对应的套餐id
     * @param dishIds
     * @return
     */
    //select setmeat_id from setmeal_dish where dish_id in (1,2,3,4)
    List<Long> getSetMealIdsByDishIds(List<Long> dishIds);

    /**
     *删除套餐菜品关系表中的数据
     * @param setmealId
     */
    @Delete("delete from setmeal_dish where id = #{seatmealId}")
    void deleteBySetmealId(Long setmealId);

    /**
     * 根据id查询套餐
     * @param id
     * @return
     */
    @Select("select * from setmeal where id = #{id}")
    Setmeal getById(Long id);
}
