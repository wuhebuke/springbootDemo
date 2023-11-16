package com.company.common.core.domain;

import lombok.Data;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author flk
 * @date 2023/10/26
 */
@Data
@XmlRootElement(name = "product")
public class Product {

    private String skuCode;


    private Integer itemCount;

    /** 计划数量 */

    private Integer originalCount;


    private String remark;

    /** 批次号 */
    private String lotNumber;

    /** 唯一标识 */
    private String uniqueId;

    /**
     * 是否坏货
     * N 好货
     * Y 坏货
     */
    private String damage;
}
