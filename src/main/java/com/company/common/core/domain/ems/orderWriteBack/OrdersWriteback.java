package com.company.common.core.domain.ems.orderWriteBack;

import com.company.common.core.domain.Product;
import lombok.Data;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;
import java.util.List;


/**
 * 出库反馈接口<OrdersWriteback>
 *
 * 仓库将 ERP 系统发送过来的出库单出库后，将出库通知返回给 ERP 系统
 *
 * @author flk
 * @date 2023/10/26
 */
@Data
@XmlRootElement(name = "OrdersWriteback")
public class OrdersWriteback {

    private String orderCode;

    private String orderType;

    private String ownerCode;

    private String warehouseCode;

    /**
     *  出库单状态
     *  New（新增）、Cancelled(取消)、
     *  Picked(拣货)、Reviewed(复核)、Closed(发货）
     *  */
    private String status;

    private String logisticProviderId;

    private Date operatorTime;

    /** 主单号 */
    private String mainWaybillNo;

    /** 邮寄单号 */
    private String mailNo;

    private String note;

    private List<Product> products;

}
