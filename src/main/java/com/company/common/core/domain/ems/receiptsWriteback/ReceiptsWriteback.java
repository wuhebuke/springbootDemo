package com.company.common.core.domain.ems.receiptsWriteback;

import com.company.common.core.domain.Product;
import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * 入库反馈接口<ReceiptsWriteback>
 *
 * WMS系统将 ERP 系统发送过来的入库订单入库后，将入库订单信息返回给 ERP 系统
 *
 * @author flk
 * @date 2023/10/26
 */
@Data
@XmlRootElement(name = "ReceiptsWriteback")
public class ReceiptsWriteback {
    /** 入库单编号 */
    @NotNull(message = "入库单编号不能为空")
    private String orderCode;

    private String ownerCode;

    private String warehouseCode;

    /** 入库类型
     *  Normal：采购入库单
     *  INConsortiumPO：批发退货入库单
     *  Return：销售退货入库单
     *  Switch：调拨入库单
     *  Others：其他入库单
     *  等等（类型多少根据客户具体业务情况而定，这里仅列出常见的几种）
     */
    @NotNull(message = "入库类型不能为空(Normal/INConsortiumPO/Return/Switch/Others)")
    private String receiptType;

    @NotNull
    private String receiptDate;

    private String status;

    /** 物流供应商ID */
    private String logisticProviderId;

    /** 运单号 */
    private String mailNo;

    private List<Product> products;

}
