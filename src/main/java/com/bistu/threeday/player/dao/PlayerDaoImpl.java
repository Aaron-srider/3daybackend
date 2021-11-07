package com.bistu.threeday.player.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bistu.threeday.player.mapper.PlayerMapper;
import com.bistu.threeday.player.model.CipherPlayer;
import com.bistu.threeday.player.model.Player;
import com.bistu.threeday.utils.PlayerEncrypter;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
public class PlayerDaoImpl implements PlayerDao {

    @Autowired
    PlayerMapper playerMapper;

    @Override
    public Page<Player> getPlayerPage(int current, int size) throws Exception {
        Page<CipherPlayer> page = new Page<>();
        page.setCurrent(current);
        page.setSize(size);

        playerMapper.selectPage(page, null);
        List<Player> players=null;
        Page<Player> page1 = new Page<>();
        BeanUtils.copyProperties(page, page1);
        if(page.getRecords().size() > 0) {
            PlayerEncrypter playerEncrypter = new PlayerEncrypter();
            players = playerEncrypter.decryptBatchPlayer(page.getRecords());
            page1.setRecords(players);
        }
        return page1;
    }

    @Override
    public Player getOnePlayer(int id) throws Exception {
        CipherPlayer cipherPlayer = playerMapper.selectById(id);
        if(cipherPlayer!=null) {
            PlayerEncrypter playerEncrypter = new PlayerEncrypter();
            return playerEncrypter.decryptCipherPlayer(cipherPlayer);
        } else {
            return null;
        }

    }

    @Override
    public void insertBatch(List<Player> players) throws Exception {
        PlayerEncrypter playerEncrypter = new PlayerEncrypter();
        List<CipherPlayer> cipherPlayerList = playerEncrypter.encryptBatchPlayer(players);
        for (CipherPlayer cipherPlayer : cipherPlayerList) {
            playerMapper.insert(cipherPlayer);
        }
    }
}
