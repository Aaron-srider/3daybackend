package com.bistu.threeday.player.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bistu.threeday.player.model.CipherPlayer;
import com.bistu.threeday.player.model.Player;
import com.bistu.threeday.player.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.lang.management.LockInfo;
import java.util.List;

/**
 * @author Dx666
 * @Description
 * @Date 2021/11/7 - 13:58
 */
@RestController
@CrossOrigin
public class PlayerController {
	@Autowired
	private PlayerService playerService;
	
	/**
	 * 获取列表接口
	 * @param page
	 * @param limit
	 * @return
	 */
	@GetMapping("getInfo/{page}/{limit}")
	public IPage<Player> getInfo(@PathVariable Integer page, @PathVariable Integer limit) {
		IPage<Player> result = playerService.selectPage(page, limit);
		return result;
	}
	
	/**
	 * 获取详情信息接口
	 * @param id
	 * @return
	 */
	@GetMapping("getDetail/{id}")
	public Player getDetail(@PathVariable Integer id) {
		Player result = playerService.getOneDetail(id);
		return result;
	}
}
