package com.mining.crypto.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mining.crypto.vo.UserWallet;

public interface UserWalletMapper extends BaseMapper<UserWallet> {

    IPage<UserWallet> selectByNameAndStatus(IPage<UserWallet> page, String name, String status);

}