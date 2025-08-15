package com.mining.crypto.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.mining.crypto.vo.Notice;

public interface INoticeService extends IService<Notice> {

    IPage<Notice> getAllNoticesPage(long current, long size, String title, Integer status);

}