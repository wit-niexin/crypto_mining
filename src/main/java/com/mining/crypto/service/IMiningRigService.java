package com.mining.crypto.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mining.crypto.vo.MiningRig;

import java.util.List;

public interface IMiningRigService extends IService<MiningRig> {
    //获得全部矿机列表
    List<String> getAll();

    //更改矿机状态
    boolean updateStatusByName(String name, String status);

    //新增矿机
    boolean addMiningRig(MiningRig miningRig);
}