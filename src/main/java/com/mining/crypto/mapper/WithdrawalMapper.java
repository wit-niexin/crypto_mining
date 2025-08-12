package com.mining.crypto.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mining.crypto.vo.Withdrawal;

public interface WithdrawalMapper extends BaseMapper<Withdrawal> {

    IPage<Withdrawal> selectAllWithdrawalsPage(IPage<Withdrawal> page, String name, Integer status);

}