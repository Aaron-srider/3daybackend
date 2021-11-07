package com.bistu.threeday.player.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bistu.threeday.player.dao.PlayerDao;
import com.bistu.threeday.player.mapper.PlayerMapper;
import com.bistu.threeday.player.model.CipherPlayer;
import com.bistu.threeday.player.model.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Size;

/**
 * @author Dx666
 * @Description
 * @Date 2021/11/7 - 13:54
 */
@Service
public class PlayerServiceImpl extends ServiceImpl<PlayerMapper, CipherPlayer> implements PlayerService {
	
	@Autowired
	private PlayerDao playerDao;
	
	
	@Override
	public IPage<Player> selectPage(Integer page, Integer limit)   {
		Page<Player> playerPage = null;
		try {
			playerPage = playerDao.getPlayerPage(page, limit);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return playerPage;
	}
	
	@Override
	public Player getOneDetail(Integer id) {
		Player player = null;
		try {
			player = playerDao.getOnePlayer(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return player;
	}
}
