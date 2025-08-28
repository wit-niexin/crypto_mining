package com.mining.crypto.service.impl;

import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mining.crypto.mapper.UserWalletMapper;
import com.mining.crypto.service.IUserWalletService;
import com.mining.crypto.vo.UserWallet;
import org.springframework.stereotype.Service;
import java.util.Date;

@Service
public class UserWalletServiceImpl extends ServiceImpl<UserWalletMapper, UserWallet> implements IUserWalletService {

    @Override
    public IPage<UserWallet> getUserWallet(long current, long size, String name, String status) {
        return baseMapper.selectByNameAndStatus(new Page<>(current, size), name, status);
    }

    @Override
    public double sumInMoneyByDate(Date start, Date end) {
        return baseMapper.sumInMoneyByDate(DateUtil.beginOfDay(start), DateUtil.endOfDay(end));
    }

}