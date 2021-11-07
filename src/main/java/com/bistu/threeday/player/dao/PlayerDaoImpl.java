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
        PlayerEncrypter playerEncrypter = new PlayerEncrypter();
        List<Player> players = playerEncrypter.decryptBatchPlayer(page.getRecords());
        Page<Player> page1 = new Page<>();
        BeanUtils.copyProperties(page, page1);
        page1.setRecords(players);
        return page1;
    }

    @Override
    public Player getOnePlayPage(int id) throws Exception {
        CipherPlayer cipherPlayer = playerMapper.selectById(id);
        PlayerEncrypter playerEncrypter = new PlayerEncrypter();
        return playerEncrypter.decryptCipherPlayer(cipherPlayer);
    }
}
