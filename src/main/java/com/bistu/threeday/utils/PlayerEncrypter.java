package com.bistu.threeday.utils;

import com.bistu.threeday.player.model.CipherPlayer;
import com.bistu.threeday.player.model.Player;
import org.apache.commons.codec.binary.Base64;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class PlayerEncrypter {

    public Player decryptCipherPlayer(CipherPlayer cipherPlayer) throws Exception {
        Player player = new Player();
        player.setId(cipherPlayer.getId());
        player.setName(EncryptUtils.decrypt(Base64.decodeBase64(cipherPlayer.getName())));
        player.setSex(EncryptUtils.decrypt(Base64.decodeBase64(cipherPlayer.getSex())));
        player.setAge(EncryptUtils.decrypt(Base64.decodeBase64(cipherPlayer.getAge())));
        player.setCountry(EncryptUtils.decrypt(Base64.decodeBase64(cipherPlayer.getCountry())));
        player.setItemPlay(EncryptUtils.decrypt(Base64.decodeBase64(cipherPlayer.getItemPlay())));
        player.setPreResult(EncryptUtils.decrypt(Base64.decodeBase64(cipherPlayer.getPreResult())));
        player.setFinalResult(EncryptUtils.decrypt(Base64.decodeBase64(cipherPlayer.getFinalResult())));
        player.setHealthStatus(EncryptUtils.decrypt(Base64.decodeBase64(cipherPlayer.getHealthStatus())));
        player.setComeTime(EncryptUtils.decrypt(Base64.decodeBase64(cipherPlayer.getComeTime())));
        return player;
    }

    public CipherPlayer encryptPlayer(Player player) throws Exception {
        CipherPlayer cipherPlayer = new CipherPlayer();
        cipherPlayer.setId(cipherPlayer.getId());
        cipherPlayer.setName(Base64.encodeBase64URLSafeString(EncryptUtils.encrypt(player.getName())));
        cipherPlayer.setSex(Base64.encodeBase64URLSafeString(EncryptUtils.encrypt(player.getSex())));
        cipherPlayer.setAge(Base64.encodeBase64URLSafeString(EncryptUtils.encrypt(player.getAge())));
        cipherPlayer.setCountry(Base64.encodeBase64URLSafeString(EncryptUtils.encrypt(player.getCountry())));
        cipherPlayer.setItemPlay(Base64.encodeBase64URLSafeString(EncryptUtils.encrypt(player.getItemPlay())));
        cipherPlayer.setPreResult(Base64.encodeBase64URLSafeString(EncryptUtils.encrypt(player.getPreResult())));
        cipherPlayer.setFinalResult(Base64.encodeBase64URLSafeString(EncryptUtils.encrypt(player.getFinalResult())));
        cipherPlayer.setHealthStatus(Base64.encodeBase64URLSafeString(EncryptUtils.encrypt(player.getHealthStatus())));
        cipherPlayer.setComeTime(Base64.encodeBase64URLSafeString(EncryptUtils.encrypt(player.getComeTime())));
        return cipherPlayer;
    }

    public List<Player> decryptBatchPlayer(List<CipherPlayer> cipherPlayerList) throws Exception {
        List<Player> players = new ArrayList<>();

        for (CipherPlayer cipherPlayer : cipherPlayerList) {
            Player player = decryptCipherPlayer(cipherPlayer);
            players.add(player);
        }

        return players;
    }

    public List<CipherPlayer> encryptBatchPlayer(List<Player> playerList) throws Exception {
        List<CipherPlayer> cipherPlayerList = new ArrayList<>();

        for (Player players : playerList) {
            CipherPlayer cipherPlayer = encryptPlayer(players);
            cipherPlayerList.add(cipherPlayer);
        }

        return cipherPlayerList;
    }

    public static void main(String[] args) throws Exception {
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
        System.out.println(cipherPlayer);
        Player player1 = playerEncrypter.decryptCipherPlayer(cipherPlayer);
        System.out.println(player1);
    }
}
