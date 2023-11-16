package com.company.common.utils.emsUtils;

import com.company.common.core.domain.Product;
import com.company.common.core.domain.ems.orderWriteBack.OrdersWriteback;
import com.company.common.core.domain.ems.receiptsWriteback.ReceiptsWriteback;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.ByteArrayInputStream;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author flk
 * @date 2023/11/1
 */
public class XmlParser {
    public static Map<String, String> parse(String xml) {
        Map<String, String> map = new HashMap<>();

        // 创建DocumentBuilderFactory实例
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        try {
            // 创建DocumentBuilder实例
            DocumentBuilder builder = factory.newDocumentBuilder();
            // 将XML字符串解析为Document对象
            Document document = builder.parse(new ByteArrayInputStream(xml.getBytes()));

            // 获取根节点
            Element rootElement = document.getDocumentElement();

            // 获取根元素下的子元素
            NodeList childNodes = rootElement.getChildNodes();

            // 遍历子元素
            for (int i = 0; i < childNodes.getLength(); i++) {
                Node childNode = childNodes.item(i);
                // 处理子元素
                if (childNode.getNodeType() == Node.ELEMENT_NODE) {
                    if ("success".equals(childNode.getNodeName())) {
                        map.put("success", childNode.getTextContent());
                    }else if ("reason".equals(childNode.getNodeName())) {
                        map.put("reason", childNode.getTextContent());
                    }else if ("sourceWaybillNo".equals(childNode.getNodeName())) {
                        map.put("sourceWaybillNo", childNode.getTextContent());
                    }
                }
            }
            return map;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage(),e);
        }

    }


        /**
         * 入库反馈订单xml解析
         * @param xml xml内容
         * @return 对象
         */
        public static ReceiptsWriteback receiptsWritebackParser(String xml) {

        ReceiptsWriteback receiptsWritebackDTO = new ReceiptsWriteback();


        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db;
        Document doc;
        try {
            db = dbf.newDocumentBuilder();
            doc = db.parse(new ByteArrayInputStream(xml.getBytes()));
            doc.getDocumentElement().normalize();

            //xml头节点
//            Element rootElement = doc.getDocumentElement();
//            System.out.println("Root Element: " + rootElement.getNodeName());

            //ordercode
            NodeList orderNode = doc.getElementsByTagName("orderCode");
            String oc = orderNode.item(0).getNodeName();
            String orderCode = orderNode.item(0).getTextContent();
            receiptsWritebackDTO.setOrderCode(orderCode);

            //ownerCode
            NodeList ownerNode = doc.getElementsByTagName("ownerCode");
            String ownerCode = ownerNode.item(0).getTextContent();
            receiptsWritebackDTO.setOwnerCode(ownerCode);

            //warehouseCode
            NodeList warehouseCodeContentNode = doc.getElementsByTagName("warehouseCode");
            String warehouseCode= warehouseCodeContentNode.item(0).getTextContent();
            receiptsWritebackDTO.setWarehouseCode(warehouseCode);

            //receiptType
            NodeList receiptTypeNode = doc.getElementsByTagName("receiptType");
            String receiptType = receiptTypeNode.item(0).getTextContent();
            receiptsWritebackDTO.setReceiptType(receiptType);

            //receiptDate
            NodeList receiptDateNode = doc.getElementsByTagName("receiptDate");
            if (receiptDateNode.getLength() == 0){
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Date date = new Date();
                String rptime = format.format(date);
                receiptsWritebackDTO.setReceiptDate(rptime);
            }else {
                String receiptDate = receiptDateNode.item(0).getTextContent();
                receiptsWritebackDTO.setReceiptDate(receiptDate);
            }

            //status
            NodeList statusNode = doc.getElementsByTagName("status");
            if (statusNode.getLength() == 0){
                receiptsWritebackDTO.setStatus("Recevied");
            }else {
                String status = statusNode.item(0).getTextContent();
                receiptsWritebackDTO.setStatus(status);
            }

            //logisticProviderId
            NodeList logisticProviderIdNode = doc.getElementsByTagName("logisticProviderId");
            String logisticProviderId = logisticProviderIdNode.item(0).getTextContent();
            receiptsWritebackDTO.setLogisticProviderId(logisticProviderId);

            //mailNo
            NodeList mailNoNode = doc.getElementsByTagName("mailNo");
            if (mailNoNode.getLength() == 0){
                receiptsWritebackDTO.setMailNo("1016");
            }else {
                String mailNo = mailNoNode.item(0).getTextContent();
                receiptsWritebackDTO.setMailNo(mailNo);
            }

            NodeList nodeList = doc.getElementsByTagName("products");
            Element productsElement = (Element) nodeList.item(0);
            nodeList = productsElement.getElementsByTagName("product");

            List<Product> list = new ArrayList<>();
            for (int i = 0; i < nodeList.getLength(); i++) {
                Product product = new Product();
                Element productElement = (Element) nodeList.item(i);
                String skuCode = productElement.getElementsByTagName("skuCode").item(0).getTextContent();
                product.setSkuCode(skuCode);

                //lotNumber
                if (productElement.getElementsByTagName("lotNumber").getLength() == 0){
                    product.setLotNumber(null);
                }else {
                    String lotNumber = productElement.getElementsByTagName("lotNumber").item(0).getTextContent();
                    product.setLotNumber(lotNumber);
                }

                //originalCount
                if (productElement.getElementsByTagName("originalCount").getLength() == 0){
                    product.setOriginalCount(0);
                }else {
                    String originalCnt = productElement.getElementsByTagName("originalCount").item(0).getTextContent();
                    int originalCount = Integer.parseInt(originalCnt);
                    product.setOriginalCount(originalCount);
                }

                //itemCount
                if (productElement.getElementsByTagName("itemCount").getLength() == 0){
                    product.setItemCount(0);
                }else {
                    String itemCnt = productElement.getElementsByTagName("itemCount").item(0).getTextContent();
                    int itemCount = Integer.parseInt(itemCnt);
                    product.setItemCount(itemCount);
                }

                //remark
                if (productElement.getElementsByTagName("remark").getLength() == 0){
                    product.setRemark("无");
                }else {
                    String remark = productElement.getElementsByTagName("remark").item(0).getTextContent();
                    product.setRemark(remark);
                }


                list.add(product);
            }
            receiptsWritebackDTO.setProducts(list);

            return receiptsWritebackDTO;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage(),e);
        }

    }
        /**
         * 出库反馈订单xml解析
         * @param xml xml内容
         * @return 对象
         */
        public static OrdersWriteback ordersWritebackParser(String xml) {

        OrdersWriteback ordersWriteback = new OrdersWriteback();

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db;
        Document doc;
        try {
            db = dbf.newDocumentBuilder();
            doc = db.parse(new ByteArrayInputStream(xml.getBytes()));
            doc.getDocumentElement().normalize();

            //xml头节点
//            Element rootElement = doc.getDocumentElement();
//            System.out.println("Root Element: " + rootElement.getNodeName());

            //ordercode
            NodeList orderNode = doc.getElementsByTagName("orderCode");
            String oc = orderNode.item(0).getNodeName();
            String orderCode = orderNode.item(0).getTextContent();
            ordersWriteback.setOrderCode(orderCode);

            //orderType
            NodeList receiptTypeNode = doc.getElementsByTagName("orderType");
            String orderType = receiptTypeNode.item(0).getTextContent();
            ordersWriteback.setOrderType(orderType);

            //ownerCode
            NodeList ownerNode = doc.getElementsByTagName("ownerCode");
            String ownerCode = ownerNode.item(0).getTextContent();
            ordersWriteback.setOwnerCode(ownerCode);

            //warehouseCode
            NodeList warehouseCodeContentNode = doc.getElementsByTagName("warehouseCode");
            String warehouseCode= warehouseCodeContentNode.item(0).getTextContent();
            ordersWriteback.setWarehouseCode(warehouseCode);

            //status
            NodeList statusNode = doc.getElementsByTagName("status");

            String status = statusNode.item(0).getTextContent();
            ordersWriteback.setStatus(status);

            //logisticProviderId
            NodeList logisticProviderIdNode = doc.getElementsByTagName("logisticProviderId");
            String logisticProviderId = logisticProviderIdNode.item(0).getTextContent();
            ordersWriteback.setLogisticProviderId(logisticProviderId);

            //operateTime
            NodeList operateTimeNode = doc.getElementsByTagName("operateTime");
            if (operateTimeNode.getLength() == 0){
                ordersWriteback.setOperatorTime(new Date());
            }else {
                String operateTime = operateTimeNode.item(0).getTextContent();
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Date date = format.parse(operateTime);
                ordersWriteback.setOperatorTime(date);
            }

            //mainWaybillNo
            NodeList mainWaybillNoNode = doc.getElementsByTagName("mainWaybillNo");
            if (mainWaybillNoNode.getLength() == 0){
                ordersWriteback.setMainWaybillNo(null);
            }else {
                String mainWaybillNo = mainWaybillNoNode.item(0).getTextContent();
                ordersWriteback.setMainWaybillNo(mainWaybillNo);
            }

            //mailNo
            NodeList mailNoNode = doc.getElementsByTagName("mailNo");
            String mailNo = mailNoNode.item(0).getTextContent();
            ordersWriteback.setMailNo(mailNo);

            //remark
            NodeList noteNode = doc.getElementsByTagName("remark");
            if(noteNode.getLength() == 0){
                ordersWriteback.setNote(null);
            }else {
                String note = noteNode.item(0).getTextContent();
                ordersWriteback.setNote(note);
            }


            NodeList nodeList = doc.getElementsByTagName("products");
            Element productsElement = (Element) nodeList.item(0);
            nodeList = productsElement.getElementsByTagName("product");

            List<Product> list = new ArrayList<>();
            for (int i = 0; i < nodeList.getLength(); i++) {
                Product product = new Product();
                Element productElement = (Element) nodeList.item(i);
                //skuCode
                String skuCode = productElement.getElementsByTagName("skuCode").item(0).getTextContent();
                product.setSkuCode(skuCode);

                //lotNumber
                if (productElement.getElementsByTagName("lotNumber").getLength() == 0){
                    product.setLotNumber("无");
                }else {
                    String lotNumber = productElement.getElementsByTagName("lotNumber").item(0).getTextContent();
                    product.setLotNumber(lotNumber);
                }

                //originalCount
                if (productElement.getElementsByTagName("originalCount").getLength() == 0){
                    product.setOriginalCount(0);
                }else {
                    String originalCnt = productElement.getElementsByTagName("originalCount").item(0).getTextContent();
                    int originalCount = Integer.parseInt(originalCnt);
                    product.setOriginalCount(originalCount);
                }

                //itemCount
                if (productElement.getElementsByTagName("itemCount").getLength() == 0){
                    product.setItemCount(0);
                }else {
                    String itemCnt = productElement.getElementsByTagName("itemCount").item(0).getTextContent();
                    int itemCount = Integer.parseInt(itemCnt);
                    product.setItemCount(itemCount);
                }

                if(productElement.getElementsByTagName("remark").getLength() == 0){
                    product.setRemark("无");
                }else {
                    String remark = productElement.getElementsByTagName("remark").item(0).getTextContent();
                    product.setRemark(remark);
                }


                list.add(product);
            }
            ordersWriteback.setProducts(list);

            return ordersWriteback;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage(),e);
        }
    }

    /**
     * 获取请求报头
     *
     * @param xml 请求报文
     * @return 报头
     */
    public static String requestParse(String xml){

        String result ;

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db;
        Document doc;

        try {
            db = dbf.newDocumentBuilder();
            doc = db.parse(new ByteArrayInputStream(xml.getBytes()));
            doc.getDocumentElement().normalize();

            //xml头节点
            Element rootElement = doc.getDocumentElement();
            result = rootElement.getNodeName();

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage(),e);
        }
        return result;
    }

}
