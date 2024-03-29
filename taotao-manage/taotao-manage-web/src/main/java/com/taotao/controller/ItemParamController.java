package com.taotao.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.common.pojo.TaotaoResult;
import com.taotao.pojo.TbItemParam;
import com.taotao.service.ItemParamService;

@Controller
@RequestMapping("/item/param")
public class ItemParamController {

    @Autowired
    private ItemParamService itemParamService;
    
    @RequestMapping("/query/itemcatid/{itemCatId}")
    @ResponseBody
    public TaotaoResult getItemPatamByCid(@PathVariable Long itemCatId) {
        TaotaoResult result = itemParamService.getItemParamByCid(itemCatId);
        return result;
    }
    
    @RequestMapping("/save/{cid}")
    @ResponseBody
    public TaotaoResult insertItemParam(@PathVariable Long cid,String paramData) {
        TbItemParam itemParam = new TbItemParam();
        itemParam.setItemCatId(cid);
        itemParam.setParamData(paramData);
        itemParamService.insertItemParam(itemParam);
        return TaotaoResult.ok();
    }
    
}
