package com.mining.crypto.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mining.crypto.vo.MiningRig;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface MiningRigMapper extends BaseMapper<MiningRig> {
    List<String> getAll();

    Integer updateStatusByName(String name, String status);

    Integer addMiningRig(MiningRig miningRig);
}