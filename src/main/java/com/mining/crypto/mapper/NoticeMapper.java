package com.mining.crypto.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mining.crypto.vo.Notice;

public interface NoticeMapper extends BaseMapper<Notice> {

    IPage<Notice> selectAllNoticesPage(IPage<Notice> page, String title, Integer status);

}