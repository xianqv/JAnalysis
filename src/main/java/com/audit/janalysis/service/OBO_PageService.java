package com.audit.janalysis.service;

import com.audit.janalysis.entity.OBO_Page;
import com.audit.janalysis.mapper.OBO_PageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class OBO_PageService  {

        @Autowired
        private OBO_PageMapper oboPageMapper;

        public int insert(OBO_Page oboPage) {
            // 插入页面
            return oboPageMapper.insert(oboPage);
        }

        public int delete(OBO_Page oboPage) {
            // 删除页面
            return oboPageMapper.deleteById(oboPage);
        }

        public int update(OBO_Page oboPage) {
            // 更新页面
            return oboPageMapper.updateById(oboPage);
        }

        public OBO_Page getPageById(int pageId) {
            return oboPageMapper.selectById(pageId);
        }

        public List<OBO_Page> getAllPages() {
            return oboPageMapper.selectList(null);
        }



}
