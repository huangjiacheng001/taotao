package com.taotao.content.service;

import com.taotao.common.pojo.TaotaoResult;
import com.taotao.pojo.TbContent;

import java.util.List;

/**
 * 内容管理
 */
public interface ContentService {

	TaotaoResult addContent(TbContent content);

	List<TbContent> getContentByCid(long cid);
}
