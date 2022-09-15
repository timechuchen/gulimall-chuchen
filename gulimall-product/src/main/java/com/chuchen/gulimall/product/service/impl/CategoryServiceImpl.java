package com.chuchen.gulimall.product.service.impl;

import com.chuchen.gulimall.product.service.CategoryBrandRelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chuchen.common.utils.PageUtils;
import com.chuchen.common.utils.Query;

import com.chuchen.gulimall.product.dao.CategoryDao;
import com.chuchen.gulimall.product.entity.CategoryEntity;
import com.chuchen.gulimall.product.service.CategoryService;
import org.springframework.transaction.annotation.Transactional;


@Service("categoryService")
public class CategoryServiceImpl extends ServiceImpl<CategoryDao, CategoryEntity> implements CategoryService {

    @Autowired
    CategoryBrandRelationService categoryBrandRelationService;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CategoryEntity> page = this.page(
                new Query<CategoryEntity>().getPage(params),
                new QueryWrapper<CategoryEntity>()
        );

        return new PageUtils(page);
    }

    @Override
    public List<CategoryEntity> listWithTree() {
        //查出所有的分类
        List<CategoryEntity> entities = baseMapper.selectList(null);

        //组装成父子的树形结构
        //查找所有的以及分类（父分类id为零）

        return entities.stream().filter(categoryEntity -> categoryEntity.getParentCid() == 0)
                .map(menu->{
                    menu.setChildren(getChildrens(menu,entities));
                    return menu;
                }).sorted((menu1,menu2)->{
                    return (menu1.getSort()==null?0:menu1.getSort()) - (menu2.getSort()==null?0:menu2.getSort());
                }).collect(Collectors.toList());
    }

    @Override
    public void removeMenuByIds(List<Long> asList) {
        //TODO 1、要先检查是否有其他的引用


        //一般真正的是做逻辑删除，不是真正的物理删除

        baseMapper.deleteBatchIds(asList);
    }

    /**
     * 找到 catelogId 的完整路径
     */
    @Override
    public Long[] findCatelogPath(Long catelogId) {
        List<Long> paths = new ArrayList<>();
        List<Long> parentPath = finParentPath(catelogId, paths);
        Collections.reverse(parentPath);
        return parentPath.toArray(new Long[0]);
    }

    /**
     * 级联更新所有关联的数据
     */
    @Transactional
    @Override
    public void updateCascade(CategoryEntity category) {
        this.updateById(category);
        categoryBrandRelationService.updateCategory(category.getCatId(),category.getName());
    }

    protected List<Long> finParentPath(Long catelogId,List<Long> paths) {
        //收集当前节点的id
        paths.add(catelogId);
        CategoryEntity byId = this.getById(catelogId);
        if(byId.getParentCid() != 0) {
            finParentPath(byId.getParentCid(),paths);
        }
        return paths;
    }

    /**
     * 递归查找所有的菜单的子菜单
     * @param root 根菜单
     * @param all 在所有的菜单中查找
     */
    private  List<CategoryEntity> getChildrens(CategoryEntity root,List<CategoryEntity> all) {

        return all.stream().filter(categoryEntity -> {
            return categoryEntity.getParentCid().equals(root.getCatId());
        }).map(categoryEntity -> {
            //找到子菜单（递归查找）
            categoryEntity.setChildren(getChildrens(categoryEntity,all));
            return categoryEntity;
        }).sorted((menu1,menu2)->{
            //菜单的排序
            return (menu1.getSort()==null?0:menu1.getSort()) - (menu2.getSort()==null?0:menu2.getSort());
        }).collect(Collectors.toList());
    }

}