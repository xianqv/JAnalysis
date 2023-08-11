package com.audit.janalysis.service;

import com.audit.janalysis.entity.OBO_File;
import com.audit.janalysis.mapper.OBO_FileMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class OBO_FileService {


        @Autowired
        private OBO_FileMapper oboFileMapper;

        public int insert(OBO_File oboFile) {
            // 插入文件
            return oboFileMapper.insert(oboFile);
        }

        public int delete(OBO_File oboFile) {
            // 删除文件
            return oboFileMapper.deleteById(oboFile);
        }

        public int update(OBO_File oboFile) {
            // 更新文件
            return oboFileMapper.updateById(oboFile);
        }

        public OBO_File getFileById(int fileId) {
            return oboFileMapper.selectById(fileId);
        }

        public List<OBO_File> getAllFiles() {
            return oboFileMapper.selectList(null);
        }

}

