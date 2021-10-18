package com.reapal.domain;

import cn.hutool.core.date.DateTime;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 服务单
 * </p>
 *
 * @author Auto-generator
 * @since 2021-10-14
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("ls_service_form")
public class LsServiceForm extends Model<LsServiceForm> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键Id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 用户Id
     */
    private Long userId;
    /**
     * 服务单号
     */
    private String serviceOrderId;
    /**
     * 公司名称
     */
    private String companyName;
    /**
     * 公司电话（服务热线）
     */
    private String companyPhone;
    /**
     * 受理时间
     */
    private LocalDateTime  handleDate;
    /**
     * 工程师
     */
    private String engineer;
    /**
     * 客户名称
     */
    private String customerName;
    /**
     * 客户联系人（报修人）
     */
    private String linkman;
    /**
     * 服务类型（0：普通客户服务；1：VIP客户服务）
     */
    private Integer serviceType;
    /**
     * 服务方式（0：上门服务；1：远程服务）
     */
    private Integer serviceMode;
    /**
     * 品牌规格
     */
    private String brandSpecs;
    /**
     * 序列号
     */
    private String serialNumber;
    /**
     * 数量
     */
    private Integer count;
    /**
     * 故障描述（故障现象）
     */
    private String faultDescribe;
    /**
     * 上门时间
     */
    private LocalDateTime vistDate;
    /**
     * 完成时间
     */
    private LocalDateTime completDate;
    /**
     * 维修结果
     */
    private String repairResult;
    /**
     * 服务质量（0：非常满意；1：满意；2：一般；3：不满意）
     */
    private Integer serviceQuality;
    /**
     * 客户意见
     */
    private String customerAdvise;
    /**
     * 客户签字的图片地址
     */
    private String customerSignImage;
    /**
     * 创建人Id
     */
    private Long createrId;
    /**
     * 创建人名字
     */
    private String createrName;
    /**
     * 创建时间
     */
    private LocalDateTime  createDate;
    /**
     * 更新人Id
     */
    private Long updaterId;
    /**
     * 更新人名字
     */
    private String updaterName;
    /**
     * 更新时间
     */
    private LocalDateTime updateDate;
    /**
     * 是否删除（0未删除，1已删除）
     */
    private Integer isDeleted;

    @Override
    public Serializable pkVal() {
        return this.id;
    }

}
