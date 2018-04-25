package com.taotao.controller;

import com.taotao.common.pojo.EasyUITreeNode;
import com.taotao.service.ItemCatService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author: 990014
 * @Date: 2018/4/23 19:29
 * @Description:查询商品类目
 */
@Controller
@Slf4j
public class ItemCatController {
    @Autowired
    ItemCatService itemCatService;


    @RequestMapping("/item/cat/list")
    @ResponseBody
    public List<EasyUITreeNode> getItemCatList(@RequestParam(name="id",defaultValue = "0") Long parentId){
        List <EasyUITreeNode> result = itemCatService.getItemCatList(parentId);
        return result;
    }
}
