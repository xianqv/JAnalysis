package com.audit.janalysis.service;

import com.audit.janalysis.entity.OBO_Log;
import com.audit.janalysis.mapper.OBO_LogMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class OBO_LogService  {

        @Autowired
        private OBO_LogMapper oboLogMapper;

        public int insert(OBO_Log oboLog) {
            // 插入日志
            return oboLogMapper.insert(oboLog);
        }

        public int delete(OBO_Log oboLog) {
            // 删除日志
            return oboLogMapper.deleteById(oboLog);
        }

        public int update(OBO_Log oboLog) {
            // 更新日志
            return oboLogMapper.updateById(oboLog);
        }

        public OBO_Log getLogById(int logId) {
            return oboLogMapper.selectById(logId);
        }

        public List<OBO_Log> getAllLogs() {
            return oboLogMapper.selectList(null);
        }


}
