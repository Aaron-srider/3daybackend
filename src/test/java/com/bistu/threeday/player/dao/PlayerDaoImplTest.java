package com.bistu.threeday.player.dao;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bistu.threeday.player.mapper.PlayerMapper;
import com.bistu.threeday.player.model.CipherPlayer;
import com.bistu.threeday.player.model.Player;
import com.bistu.threeday.utils.PlayerEncrypter;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PlayerDaoImplTest {

    @Autowired
    PlayerDao playerDao;

    @Autowired
    PlayerMapper playerMapper;

    @Test
    public void testGetPlayerPage() throws Exception {
        Page<Player> playerPage = playerDao.getPlayerPage(1, 10);
        System.out.println(playerPage);
    }

    @Test
    public void getOnePlayPage() {
    }

    @Test
    public void insertData() throws Exception {
        Player player = new Player();
        player.setName("小明");
        player.setSex("男");
        player.setAge("21");
        player.setCountry("中国");
        player.setItemPlay("射击");
        player.setPreResult("32");
        player.setFinalResult("33");
        player.setHealthStatus("良好");
        player.setComeTime("2021-02-30");

        PlayerEncrypter playerEncrypter = new PlayerEncrypter();
        CipherPlayer cipherPlayer = playerEncrypter.encryptPlayer(player);
        playerMapper.insert(cipherPlayer);
    }

    @Test
    void testGetOnePlayPage() throws Exception {
        Player playerPage = playerDao.getOnePlayPage(1);
        System.out.println(playerPage);
    }
}