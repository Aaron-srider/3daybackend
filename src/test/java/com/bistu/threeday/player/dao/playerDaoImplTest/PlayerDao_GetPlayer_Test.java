package com.bistu.threeday.player.dao.playerDaoImplTest;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bistu.threeday.player.dao.PlayerDao;
import com.bistu.threeday.player.mapper.PlayerMapper;
import com.bistu.threeday.player.model.Player;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PlayerDao_GetPlayer_Test {

    @Autowired
    PlayerDao playerDao;

    @Autowired
    PlayerMapper playerMapper;

    @Test
    public void testGetPlayerPage() throws Exception {
        Page<Player> playerPage = playerDao.getPlayerPage(3, 10);
        System.out.println(playerPage);
    }

    @Test
    public void testGetPlayerPage1() throws Exception {
        Page<Player> playerPage = playerDao.getPlayerPage(1, 5);
        System.out.println(playerPage);
    }


    @Test
    void testGetOnePlayer() throws Exception {
        Player playerPage = playerDao.getOnePlayer(1);
        System.out.println(playerPage);
    }

    @Test
    void testGetOnePlayer1() throws Exception {
        Player playerPage = playerDao.getOnePlayer(0);
        System.out.println(playerPage);
    }
}