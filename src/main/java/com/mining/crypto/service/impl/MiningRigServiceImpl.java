package com.mining.crypto.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mining.crypto.mapper.MiningRigMapper;
import com.mining.crypto.service.IMiningRigService;
import com.mining.crypto.vo.MiningRig;
import org.springframework.stereotype.Service;

@Service
public class MiningRigServiceImpl extends ServiceImpl<MiningRigMapper, MiningRig> implements IMiningRigService {

    @Override
    public boolean updateStatusByName(String name, String status) {
        UpdateWrapper<MiningRig> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("name", name).set("status", status);
        Integer rows = baseMapper.update(updateWrapper);
        //根据影响行数判断是否成功
        return rows > 0;
    }
}

