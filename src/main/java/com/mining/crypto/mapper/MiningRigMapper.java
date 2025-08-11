package com.mining.crypto.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mining.crypto.vo.MiningRig;

public interface MiningRigMapper extends BaseMapper<MiningRig> {

    IPage<MiningRig> selectAllMiningRigsPage(IPage<MiningRig> page, String name, Integer status);

}