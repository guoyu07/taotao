package com.soul.portal.controller;

import javax.annotation.Resource;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.soul.pojo.TbItem;
import com.soul.portal.pojo.ItemInfo;
import com.soul.portal.service.ItemService;

@Controller
public class ItemController {

	@Resource
	private ItemService itemService;
	
	@RequestMapping("/item/{itemId}")
	public String showItem(@PathVariable Long itemId,Model model) {
		
		ItemInfo itemInfo = itemService.getItemById(itemId);
		model.addAttribute("item",itemInfo);
		
		return "item";
	}
	
	@RequestMapping(value="/item/desc/{itemId}",produces=MediaType.TEXT_HTML_VALUE+";charset=utf-8")
	@ResponseBody
	public String getItemDesc(@PathVariable Long itemId) {
		String itemDescById = itemService.getItemDescById(itemId);
		return itemDescById;
	}
	@RequestMapping(value="/item/param/{itemId}",produces=MediaType.TEXT_HTML_VALUE+";charset=utf-8")
	@ResponseBody
	public String getItemParam(@PathVariable Long itemId) {
		String itemDescById = itemService.getItemParam(itemId);
		return itemDescById;
	}
}
