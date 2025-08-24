package com.mining.crypto.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.mining.crypto.vo.UserWallet;

public interface IUserWalletService extends IService<UserWallet> {

    IPage<UserWallet> getUserWallet(long current, long size, String name, String status);

}