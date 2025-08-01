package com.mining.crypto.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mining.crypto.vo.MiningRig;

public interface IMiningRigService extends IService<MiningRig> {
    //更改矿机状态
    boolean updateStatusByName(String name, String status);
}