package com.audit.janalysis.service;

import com.audit.janalysis.entity.OboToken;
import com.audit.janalysis.mapper.OboTokenMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OboTokenService {
    @Autowired
    OboTokenMapper oboTokenMapper;

    public int createToken(OboToken oboToken) {
        return oboTokenMapper.insert(oboToken);
    }

    public OboToken getToken() {
        return oboTokenMapper.selectOne(null);
    }

    public void deleteToken(String token) {
        oboTokenMapper.deleteById(token);
    }

    public void updateToken(OboToken oboToken) {
        oboTokenMapper.updateById(oboToken);
    }
}
