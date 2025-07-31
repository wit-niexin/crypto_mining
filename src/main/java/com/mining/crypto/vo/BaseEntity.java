package com.mining.crypto.vo;

import cn.hutool.core.lang.UUID;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import lombok.Data;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

@Data
public class BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    protected String id;
    protected String createDate;                                // 创建日期
    protected String modifier;                                  // 更新者
    protected String modifyDate;                                // 更新日期
    protected Integer del = 0;                                  // 删除标记 0:正常1:删除
    @TableField(exist = false)
    protected boolean isNewRecord;                              // 是否为新记录

    /**
     * 是否为新记录
     *
     * @return boolean
     */
    public boolean isNewRecord() {
        return this.isNewRecord || StringUtils.isBlank(this.getId());
    }

    /**
     * 设置基本属性
     *
     * @param username 用户名
     */
    public void setCommonValue(String username) {
        if (this.isNewRecord()) {
            this.setId(UUID.randomUUID().toString(true));
            this.setNewRecord(true);
            this.createDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        }
        this.modifier = username;
        this.modifyDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    }

}