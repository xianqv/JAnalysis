package com.audit.janalysis.service;

import com.audit.janalysis.entity.OBO_Tag;
import com.audit.janalysis.mapper.OBO_TagMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class OBO_TagService  {

        @Autowired
        private OBO_TagMapper oboTagMapper;

        public int insert(OBO_Tag oboTag) {
            // 插入标签
            return oboTagMapper.insert(oboTag);
        }

        public int delete(OBO_Tag oboTag) {
            // 删除标签
            return oboTagMapper.deleteById(oboTag);
        }

        public int update(OBO_Tag oboTag) {
            // 更新标签
            return oboTagMapper.updateById(oboTag);
        }

        public OBO_Tag getTagById(int tagId) {
            return oboTagMapper.selectById(tagId);
        }

        public List<OBO_Tag> getAllTags() {
            return oboTagMapper.selectList(null);
        }



}
