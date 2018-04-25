package com.taotao.service.impl;

import com.taotao.common.pojo.EasyUITreeNode;
import com.taotao.mapper.TbItemCatMapper;
import com.taotao.pojo.TbItemCat;
import com.taotao.pojo.TbItemCatExample;
import com.taotao.pojo.TbItemExample;
import com.taotao.service.ItemCatService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: 990014
 * @Date: 2018/4/23 19:18
 * @Description:
 */
@Service
@Slf4j
public class ItemCatServiceImpl implements ItemCatService {
    @Autowired
    private TbItemCatMapper tbItemCatMapper;

    @Override
    public List<EasyUITreeNode> getItemCatList(long parentId) {
        TbItemCatExample example = new TbItemCatExample();
        example.createCriteria().andParentIdEqualTo(parentId);
        List <TbItemCat> tbItemCats = tbItemCatMapper.selectByExample(example);
        List<EasyUITreeNode> notes = new ArrayList <>();
        tbItemCats.forEach(o->{
            EasyUITreeNode node = new EasyUITreeNode();
            node.setId(o.getId());
            node.setText(o.getName());
            //如果节点下有节点“closed”,如果没有就“open”
            node.setState(o.getIsParent()?"closed":"open");
            notes.add(node);
        });
        return notes;
    }
}
