package com.mining.crypto.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mining.crypto.mapper.MiningRigMapper;
import com.mining.crypto.service.IMiningRigService;
import com.mining.crypto.vo.MiningRig;
import org.springframework.stereotype.Service;

@Service
public class MiningRigServiceImpl extends ServiceImpl<MiningRigMapper, MiningRig> implements IMiningRigService {

    @Override
    public IPage<MiningRig> getAllMiningRigsPage(long current, long size, String name, Integer status) {
        return baseMapper.selectAllMiningRigsPage(new Page<>(current, size), name, status);
    }
}

