package com.company.common.core.domain.ems.orderWriteBack;

import lombok.Data;

/**
 * @author flk
 * @date 2023/10/31
 */
@Data
public class ItemsOrderBackReq {
    private String sku;

    private Integer quantity;
}
