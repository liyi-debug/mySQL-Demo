package ytvc.elms.model.entity;
import java.util.Date;
public class Product {
String name;
String no;
Date lastPurchaseDate;
Date lastDeliveryDate;
float safeStock;
float quantity;
float suggestBuyPrice;
float suggestSalePrice;
public Product(String name, String no, Date lastPurchaseDate, Date lastDeliveryDate, float safestock, float quantity,
		float suggestBuyPrice, float suggestSalePrice) {
	super();
	this.name = name;
	this.no = no;
	this.lastPurchaseDate = lastPurchaseDate;
	this.lastDeliveryDate = lastDeliveryDate;
	this.safeStock = safestock;
	this.quantity = quantity;
	this.suggestBuyPrice = suggestBuyPrice;
	this.suggestSalePrice = suggestSalePrice;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getNo() {
	return no;
}
public void setNo(String no) {
	this.no = no;
}
public Date getLastPurchaseDate() {
	return lastPurchaseDate;
}
public void setLastPurchaseDate(Date lastPurchaseDate) {
	this.lastPurchaseDate = lastPurchaseDate;
}
public Date getLastDeliveryDate() {
	return lastDeliveryDate;
}
public void setLastDeliveryDate(Date lastDeliveryDate) {
	this.lastDeliveryDate = lastDeliveryDate;
}
public float getSafeStock() {
	return safeStock;
}
public void setSafeStock(float safeStock) {
	this.safeStock = safeStock;
}
public float getQuantity() {
	return quantity;
}
public void setQuantity(float quantity) {
	this.quantity = quantity;
}
public float getSuggestBuyPrice() {
	return suggestBuyPrice;
}
public void setSuggestBuyPrice(float suggestBuyPrice) {
	this.suggestBuyPrice = suggestBuyPrice;
}
public float getSuggestSalePrice() {
	return suggestSalePrice;
}
public void setSuggestSalePrice() {
	this.suggestSalePrice = suggestSalePrice;
}
public Product() {
	super();
	this.no="p000";
	this.name="noname";
	this.lastDeliveryDate=new Date();
	this.lastPurchaseDate=new Date();
	this.quantity=0;
	this.safeStock=0;
	this.suggestBuyPrice=0;
	this.suggestSalePrice=0;
}
public Product(String no) {
	this();
	this.no=no;	
}
public Product(String name, String no, float safestock) {
	this();
	this.name = name;
	this.no = no;
	this.safeStock = safestock;
}
public Product(String name, String no, float safestock, float suggestBuyPrice, float suggestSalePrice) {
	this(); //this不匹配，可调用super
	this.name = name;
	this.no = no;
	this.safeStock = safestock;
	this.suggestBuyPrice = suggestBuyPrice;
	this.suggestSalePrice = suggestSalePrice;
}
@Override
public boolean equals(Object arg0) {
	if(arg0 instanceof Product) {
		Product p=(Product)arg0;
		if(p.no.equals(this.no))
		return true;		
	}return false;
}





}
