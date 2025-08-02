package com.mining.crypto.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mining.crypto.vo.MiningRig;

public interface IMiningRigService extends IService<MiningRig> {
    boolean updateStatusByName(String name, String status);
}