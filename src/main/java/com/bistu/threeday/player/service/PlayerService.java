package com.bistu.threeday.player.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.bistu.threeday.player.model.CipherPlayer;
import com.bistu.threeday.player.model.Player;

/**
 * @author Dx666
 * @Description
 * @Date 2021/11/7 - 13:53
 */

public interface PlayerService extends IService<CipherPlayer>  {
	
	/**
	 * 分页查询运动员信息
	 * @return
	 */
	IPage<Player> selectPage(Integer page, Integer limit) ;
	
	/**
	 * 获取一个运动员的详情信息
	 * @param id
	 * @return
	 */
	Player getOneDetail(Integer id);
}
