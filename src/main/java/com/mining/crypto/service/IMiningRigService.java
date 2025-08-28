package com.mining.crypto.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.mining.crypto.vo.MiningRig;

public interface IMiningRigService extends IService<MiningRig> {

    IPage<MiningRig> getAllMiningRigsPage(long current, long size, String name, Integer status);

    int getMiningRigsCount();
}