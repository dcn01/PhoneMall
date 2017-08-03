package com.zhiji.phonemall.data.network.model.bean;


/**
 * <pre>
 *     author : llj
 *     time   : 2017/08/3
 *     desc   : 商品属性这里以手机为例，目前上架这一种产品
 * </pre>
 */

public class Product {
    private int productId;//商品id
    private String productName;//商品名称
    private String productSmallImg;//商品小图
    private String productBigImg;//商品大图
    private double productPrice;//商品价格
    private String productColor;//商品颜色
    private String productStorage;//商品内存，例如(3G+32G、4G+64G)
    private String productNetType;//商品网络类型，例如(移动4G、电信4G、全网通)
    private int productSaleVolume;//商品销量
    private int productInventory;//商品库存
    private double productPromotionPrice;//商品促销价
    private int productClickVolume;//商品点击量
}
