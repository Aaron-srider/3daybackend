package com.bistu.threeday.player.dao;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bistu.threeday.player.model.Player;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerDao {
    public Page<Player> getPlayerPage(int current, int size) throws Exception;

    public Player getOnePlayPage(int id) throws Exception;
}
