package com.learn.demo.Service;

import com.learn.demo.Entity.CasClientLogEntity;
import com.learn.demo.Repository.CasClientLogRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author demo
 * @date 2019/9/16 14:24
 * @description
 */
@Service
public class CasClientLogService {
    @Resource
    private CasClientLogRepository casClientLogRepository;

    public CasClientLogEntity getOne(String s) {
        return casClientLogRepository.getOne(s);
    }

    public void delete(CasClientLogEntity casClientLogEntity) {
        casClientLogRepository.delete(casClientLogEntity);
    }

    public List<CasClientLogEntity> findAll() {
        return casClientLogRepository.findAll();
    }

    public <S extends CasClientLogEntity> S saveAndFlush(S s) {
        return casClientLogRepository.saveAndFlush(s);
    }
}
