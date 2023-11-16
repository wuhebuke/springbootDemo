package com.company.common.core.domain;

import lombok.Data;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * @author flk
 * @date 2023/10/26
 */
@Data
@XmlRootElement(name = "products")
public class Products {
    private List<Product> product;
}
