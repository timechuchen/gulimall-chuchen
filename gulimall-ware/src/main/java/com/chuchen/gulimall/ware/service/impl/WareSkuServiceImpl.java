package com.chuchen.gulimall.ware.service.impl;

import com.chuchen.common.utils.R;
import com.chuchen.gulimall.ware.fegin.ProductFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chuchen.common.utils.PageUtils;
import com.chuchen.common.utils.Query;

import com.chuchen.gulimall.ware.dao.WareSkuDao;
import com.chuchen.gulimall.ware.entity.WareSkuEntity;
import com.chuchen.gulimall.ware.service.WareSkuService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;


@Service("wareSkuService")
public class WareSkuServiceImpl extends ServiceImpl<WareSkuDao, WareSkuEntity> implements WareSkuService {

    @Autowired
    WareSkuDao wareSkuDao;
    @Autowired
    ProductFeignService productFeignService;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {

        QueryWrapper<WareSkuEntity> queryWrapper = new QueryWrapper<>();

        String skuId = (String)params.get("skuId");
        if(!StringUtils.isEmpty(skuId)) {
            queryWrapper.eq("sku_id",skuId);
        }

        String wareId = (String)params.get("wareId");
        if(!StringUtils.isEmpty(skuId)) {
            queryWrapper.eq("ware_id",wareId);
        }


        IPage<WareSkuEntity> page = this.page(
                new Query<WareSkuEntity>().getPage(params),
                queryWrapper
        );

        return new PageUtils(page);
    }

    @Transactional
    @Override
    public void addStock(Long skuId, Long wareId, Integer skuNum) {
        //判断如果还没有这个库存记录就是新增，否则就是查询
        List<WareSkuEntity> entities = wareSkuDao.selectList(new QueryWrapper<WareSkuEntity>().eq("sku_id", skuId).eq("ware_id", wareId));
        if(entities.size() == 0) {
            WareSkuEntity wareSkuEntity = new WareSkuEntity();
            wareSkuEntity.setSkuId(skuId);
            wareSkuEntity.setStock(skuNum);
            wareSkuEntity.setWareId(wareId);
            wareSkuEntity.setStockLocked(0);
            //远程查询sku名字，如果失败也不需要回滚，除了下面的这种自己解决异常的方式之外还有高级办法，TODO 后面高级篇再说
            try{
                R info = productFeignService.info(skuId);
                if(info.getCode() == 0) {
                    Map<String,Object> data = (Map<String,Object>)info.get("skuInfo");
                    wareSkuEntity.setSkuName((String)data.get("skuName"));
                }
            }catch (Exception ignored){
            }

            wareSkuDao.insert(wareSkuEntity);
        }else {
            wareSkuDao.addStock(skuId,wareId,skuNum);
        }
    }

}