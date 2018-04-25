package com.taotao.service;

import com.taotao.common.pojo.EasyUITreeNode;

import java.util.List;

/**
 * @author: 990014
 * @Date: 2018/4/23 19:16
 * @Description:
 */
public interface ItemCatService {
    List<EasyUITreeNode> getItemCatList(long parentId);
}
