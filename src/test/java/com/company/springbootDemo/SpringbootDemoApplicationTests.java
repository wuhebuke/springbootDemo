package com.company.springbootDemo;

import com.company.common.utils.emsUtils.XmlParser;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.Map;

@SpringBootTest
class SpringbootDemoApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    public static void main(String[] args) {

        String xml1 = "<?xml version=\"1.0\" encoding=\"utf-8\" ?><ReceiptsWriteback><orderCode>S2023111517000348122049</orderCode><ownerCode>CSCF</ownerCode><receiptDate>2023/11/15 16:01:13</receiptDate><warehouseCode>wh2yyc</warehouseCode><receiptType>Return</receiptType><logisticProviderId></logisticProviderId><operator></operator><note>做工粗糙有瑕疵</note><products><product><skuCode>159</skuCode><itemName>中秋大礼包</itemName><itemCount>3</itemCount><lotNumber></lotNumber><remark></remark></product></products></ReceiptsWriteback>" ;

        String xml2 = "<?xml version=\"1.0\" encoding=\"utf-8\" ?><OrdersWriteback><ownerCode>CSCF</ownerCode><orderType>Sales</orderType><warehouseCode>wh2yyc</warehouseCode><orderCode>202311141047208287</orderCode><status>Closed</status><logisticProviderId>1016</logisticProviderId><mailNo>cs1</mailNo><Weight>0</Weight><products><product><skuCode>77</skuCode><lotNumber></lotNumber><itemCount>3</itemCount></product></products></OrdersWriteback> ";

        String xml3 = "<?xml version=\"1.0\" encoding=\"utf-8\" ?>\n" +
                "<OrdersWriteback><ownerCode>CSCF</ownerCode>\n" +
                "    <orderType>Sales</orderType>\n" +
                "    <warehouseCode>wh2yyc</warehouseCode>\n" +
                "    <orderCode>202311141047208287</orderCode>\n" +
                "    <status>Closed</status>\n" +
                "    <logisticProviderId>1016</logisticProviderId>\n" +
                "    <mailNo>cs1</mailNo>\n" +
                "    <Weight>0</Weight>\n" +
                "    <products>\n" +
                "        <product>\n" +
                "            <skuCode>77</skuCode>\n" +
                "            <lotNumber></lotNumber>\n" +
                "            <itemCount>3</itemCount>\n" +
                "        </product>\n" +
                "    </products>\n" +
                "</OrdersWriteback>\n";

        String s = XmlParser.requestParse(xml1);
        System.out.println(s);


    }
}
