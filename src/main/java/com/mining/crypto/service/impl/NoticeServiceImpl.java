package com.mining.crypto.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mining.crypto.mapper.NoticeMapper;
import com.mining.crypto.service.INoticeService;
import com.mining.crypto.vo.Notice;
import org.springframework.stereotype.Service;

@Service
public class NoticeServiceImpl extends ServiceImpl<NoticeMapper, Notice> implements INoticeService {

    @Override
    public IPage<Notice> getAllNoticesPage(long current, long size, String name, Integer status) {
        return baseMapper.selectAllNoticesPage(new Page<>(current, size), name, status);
    }

}