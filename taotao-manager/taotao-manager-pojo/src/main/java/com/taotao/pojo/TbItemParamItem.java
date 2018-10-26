package com.taotao.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;
@Data
public class TbItemParamItem implements Serializable{
    private Long id;

    private Long itemId;

    private Date created;

    private Date updated;

    private String paramData;
}