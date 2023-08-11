package com.audit.janalysis.service;

import com.audit.janalysis.entity.OBO_Permission;
import com.audit.janalysis.mapper.OBO_PermissionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OBO_PermissionService {
    @Autowired
    OBO_PermissionMapper oboPermissionMapper;

    //获取所有权限
    public List<OBO_Permission> getPermissions() {
        return oboPermissionMapper.selectList(null);
    }

    //根据权限id获取权限
    public OBO_Permission getPermission(Integer id) {
        return oboPermissionMapper.selectById(id);
    }

    //添加权限
    public int addPermission(OBO_Permission oboPermission) {
        return oboPermissionMapper.insert(oboPermission);
    }

    //修改权限
    public int updatePermission(OBO_Permission oboPermission) {
        return oboPermissionMapper.updateById(oboPermission);
    }

    //删除权限
    public int deletePermission(Integer id) {
        return oboPermissionMapper.deleteById(id);
    }

}
