package com.taotao.common.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * @author: 990014
 * @Date: 2018/4/23 19:08
 * @Description:
 */
@Data
public class EasyUITreeNode implements Serializable {
    private long id;
    private String text;
    private String state;
}
