package com.bistu.threeday.player.mapper;

import com.bistu.threeday.player.model.CipherPlayer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PlayerMapperTest {

    @Autowired
    PlayerMapper playerMapper;

    @Test
    public void select() {

        CipherPlayer cipherPlayer = playerMapper.selectById("1");
        System.out.println(cipherPlayer);

    }

    @Test
    public void selectPage() {
        CipherPlayer cipherPlayer = playerMapper.selectById("1");
        System.out.println(cipherPlayer);

    }



}