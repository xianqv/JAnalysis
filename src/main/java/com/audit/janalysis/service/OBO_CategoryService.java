package com.audit.janalysis.service;

import com.audit.janalysis.entity.OBO_Category;
import com.audit.janalysis.mapper.OBO_CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class OBO_CategoryService {


        @Autowired
        private OBO_CategoryMapper oboCategoryMapper;

        public int insert(OBO_Category oboCategory) {
            // 插入分类
            return oboCategoryMapper.insert(oboCategory);
        }

        public int delete(OBO_Category oboCategory) {
            // 删除分类
            return oboCategoryMapper.deleteById(oboCategory);
        }

        public int update(OBO_Category oboCategory) {
            // 更新分类
            return oboCategoryMapper.updateById(oboCategory);
        }

        public OBO_Category getCategoryById(int categoryId) {
            return oboCategoryMapper.selectById(categoryId);
        }

        public List<OBO_Category> getAllCategories() {
            return oboCategoryMapper.selectList(null);
        }
}

