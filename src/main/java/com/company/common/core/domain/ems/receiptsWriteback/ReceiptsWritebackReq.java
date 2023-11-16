package com.company.common.core.domain.ems.receiptsWriteback;

import com.company.common.core.domain.Products;
import lombok.Data;

import javax.validation.constraints.NotNull;

import static com.company.common.utils.emsUtils.Constants.DESCR;


/**
 * 入库反馈接口<ReceiptsWriteback>
 *
 * @author flk
 * @date 2023/10/26
 */
@Data
public class ReceiptsWritebackReq {
    /** 入库单编号 */
    @NotNull(message = "入库单编号不能为空")
    private String orderId;

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

    private String note=DESCR;

    /** 入库日期 */
    @NotNull
    private String receiptDate;

    @NotNull
    private Products products;


}
