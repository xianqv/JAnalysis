package com.audit.janalysis.service;

import com.audit.janalysis.entity.OBO_Role;
import com.audit.janalysis.entity.OBO_User;
import com.audit.janalysis.mapper.OBO_RoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OBO_RoleService {
    @Autowired
    private OBO_RoleMapper oboRoleMapper;


    public int insert(OBO_Role oboRole) {
        // 插入角色
       return oboRoleMapper.insert(oboRole);
    }

    public int delete(OBO_Role oboRole) {
        // 删除角色
       return oboRoleMapper.deleteById(oboRole);
    }

    public int update(OBO_Role oboRole) {
        // 更新角色
       return  oboRoleMapper.updateById(oboRole);
    }

    public  OBO_Role getRoleById(int  role_id){
        return oboRoleMapper.selectById(role_id);
    }

    public List<OBO_Role> getAllRole(){
        return oboRoleMapper.selectList(null);
    }


}
