package com.mining.crypto.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mining.crypto.mapper.MiningRigMapper;
import com.mining.crypto.service.IMiningRigService;
import com.mining.crypto.vo.MiningRig;
import org.springframework.stereotype.Service;

@Service
public class MiningRigServiceImpl extends ServiceImpl<MiningRigMapper, MiningRig> implements IMiningRigService {

    @Override
    public boolean updateStatusByName(String name, String status) {
        //参数校验
        if(name.isEmpty() || status == null){
            return false;
        }
        Integer rows = baseMapper.updateStatusByName(name,status);
        //根据影响行数判断是否成功
        return rows > 0;
    }
}

