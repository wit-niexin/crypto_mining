package com.mining.crypto.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mining.crypto.mapper.WithdrawalMapper;
import com.mining.crypto.service.IWithdrawalService;
import com.mining.crypto.vo.Withdrawal;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class WithdrawalServiceImpl extends ServiceImpl<WithdrawalMapper, Withdrawal> implements IWithdrawalService {

    @Override
    public IPage<Withdrawal> getAllWithdrawalsPage(long current, long size, String name, Integer status) {
        return baseMapper.selectAllWithdrawalsPage(new Page<>(current, size), name, status);
    }

    @Override
    public boolean updateStatus(Withdrawal withdrawal) {
        withdrawal.setApprovalTime(new Date());
        withdrawal.setCommonValue("admin");
        return this.updateById(withdrawal);
    }
}