package com.bistu.threeday.player.dao.playerDaoImplTest;

import com.bistu.threeday.player.dao.PlayerDao;
import com.bistu.threeday.player.mapper.PlayerMapper;
import com.wc.ExcelReader;
import org.junit.jupiter.api.Test;
import com.bistu.threeday.player.model.CipherPlayer;
import com.bistu.threeday.player.model.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class PlayerDao_InsertPlayer_Test {

    @Autowired
    PlayerDao playerDao;

    @Autowired
    PlayerMapper playerMapper;

    @Test
    public void insertDataTest() throws Exception {
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
        ArrayList<Player> add = new ArrayList<Player>();
        add.add(player);
        playerDao.insertBatch(add);
    }

    //@Transactional
    @Test
    public void insertData() throws Exception {
        String fileName = "C:\\Users\\wc\\Documents\\A-MyDocument\\处理中\\运动员.xlsx";

        ExcelReader excelReader = new ExcelReader();
        List<Player> list = excelReader.read(Player.class, fileName);

        System.out.println(list);

        List<CipherPlayer> cipherPlayerList = playerMapper.selectList(null);
        for (CipherPlayer cipherPlayer : cipherPlayerList) {
            int id = cipherPlayer.getId();
            playerMapper.deleteById(id);
        }

        playerDao.insertBatch(list);
    }

}