package com.mining.crypto.service.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.NumberUtil;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mining.crypto.mapper.UserBenefitMapper;
import com.mining.crypto.mapper.UserWalletMapper;
import com.mining.crypto.service.IUserBenefitService;
import com.mining.crypto.vo.UserBenefit;
import com.mining.crypto.vo.UserWallet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Transactional(rollbackFor = Exception.class)
public class UserBenefitServiceImpl extends ServiceImpl<UserBenefitMapper, UserBenefit> implements IUserBenefitService {

    @Autowired
    public UserWalletMapper userWalletMapper;

    @Override
    public IPage<UserBenefit> getAllUserBenefitsPage(long current, long size, String name) {
        return baseMapper.selectAllUserBenefitsPage(new Page<>(current, size), name);
    }

    @Override
    public void incrDaysAndRefreshCumulative() {
        LambdaUpdateWrapper<UserBenefit> uw = new LambdaUpdateWrapper<>();
        uw.eq(UserBenefit::getDel, 0)
          .setSql("days_running = days_running + 1")
          .setSql("cumulative_return = days_running * daily_average_return")
          .setSql("modify_date = NOW()");
        this.update(uw);
    }

    @Override
    public void pushDailyReturnToWallet(LocalDate localDate) {
        String day = localDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        List<Map<String, Object>> list = baseMapper.sumDailyReturnByDate(day);

        if (CollUtil.isEmpty(list)) {
            return;
        }

        // 构造新记录
        List<UserWallet> toSave = list.stream()
                .map(m -> {
                    UserWallet w = new UserWallet();
                    w.setUsername((String) m.get("userName"));
                    w.setMoney(NumberUtil.round((Double) m.get("sumDailyReturn"), 8).doubleValue());
                    w.setStatus(0);
                    w.setTime(new Date());
                    w.setCommonValue("admin");
                    return w;
                })
                .collect(Collectors.toList());

        userWalletMapper.insert(toSave);
    }
}