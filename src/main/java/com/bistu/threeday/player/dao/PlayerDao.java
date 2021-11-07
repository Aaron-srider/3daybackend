package com.bistu.threeday.player.dao;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bistu.threeday.player.model.Player;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerDao {

    /**
     * 查询分页的Player（属性已经是明文）
     * @param current 查询的当前页码
     * @param size 查询的每页大小
     * @return Page对象，其中包含了目标页的Player明文对象；没有结果则Page的records属性为大小为0的List；
     */
    public Page<Player> getPlayerPage(int current, int size) throws Exception;

    /**
     * 根据查询单个Player（属性已经是明文）
     * @param id 待查询的Player的id
     * @return 目标Player明文对象；没有结果则返回空；
     */
    public Player getOnePlayer(int id) throws Exception;

    /**
     * 用于插入测试数据
     * @param players 待插入的Player列表
     */
    public void insertBatch(List<Player> players) throws Exception;
}
