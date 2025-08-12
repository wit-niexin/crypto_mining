package com.mining.crypto.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.mining.crypto.vo.Withdrawal;

public interface IWithdrawalService extends IService<Withdrawal> {

    IPage<Withdrawal> getAllWithdrawalsPage(long current, long size, String name, Integer status);

}