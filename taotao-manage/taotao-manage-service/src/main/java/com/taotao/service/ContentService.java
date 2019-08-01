package com.taotao.service;

import java.util.List;

import com.taotao.common.pojo.EUDataGridResult;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.pojo.TbContent;

public interface ContentService {

    EUDataGridResult getContentList(int page, int rows, long categoryId);
 
    TaotaoResult insertContent(TbContent content);
    
}
