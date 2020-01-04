package ytvc.elms.control.product.dbPreparedStatement;

import java.util.Date;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import util.DBconn;
import ytvc.elms.model.entity.Product;

public class ProductManager {
ArrayList<Product> products=new ArrayList<Product>();
DBconn dbconn;
public ProductManager() {
	this.products=getAllProductFromDB();
	
}
public boolean addProduct(Product p) {
	if(products.contains(p))
		return false;
	dbconn= new DBconn();
	Connection conn= dbconn.getConn();
		String sql="insert into product(ProductID,ProductName,SafeStock,LastPurchaseDate,lastDeliveryDate,Quantity,SuggestBuyPrice,SuggestSalePrice)"
				+"VALUES(?,?,?,?,?,?,?,?)";
		PreparedStatement psm;
		try {
			psm=conn.prepareStatement(sql);
			int i=0;
			psm.setString(1, p.getNo());
			psm.setString(2, p.getName());
			psm.setFloat(3, p.getSafeStock());
			long times=p.getLastPurchaseDate().getTime();
//			System.out.println(times);
			java.sql.Date d=new java.sql.Date(times);
			psm.setDate(4, d);
			psm.setDate(5, new java.sql.Date(p.getLastDeliveryDate().getTime()));
			psm.setFloat(6, p.getQuantity());
			psm.setFloat(7, p.getSuggestBuyPrice());
			psm.setFloat(8, p.getSuggestSalePrice());
			i=psm.executeUpdate();
			if(i!=0) {
				products.add(p);
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	return false;
}

public boolean delectProductByNo(String no) {
	dbconn=new DBconn();
	String sql="delete from product where ProductID=?";
	PreparedStatement psm;
	try {
		psm=dbconn.getConn().prepareStatement(sql);
		psm.setString(1, no);
		int i=0;
		i=psm.executeUpdate();
		if(i!=0) {
			Product p=new Product(no);
			products.remove(p);
			return true;
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}return false;
}
public boolean updateProductByNo(Product p) {
	dbconn=new DBconn();
	String sql="update product set productName=?,safeStock=?SugggestBuyPrice=? SuggestSalePrice=? where productID=?";
	PreparedStatement psm=null;
	try {
		psm=dbconn.getConn().prepareStatement(sql);
		psm.setString(1,p.getName());
		psm.setFloat(2, p.getSafeStock());
		psm.setFloat(3, p.getSuggestBuyPrice());
		psm.setFloat(4, p.getSuggestSalePrice());
		psm.setString(5, p.getNo());
		int i=0;
		if(i!=0) {
			int index=products.indexOf(p);
			products.set(index,p);
			return true;
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return false;
}
public ArrayList<Product> getAllProductFromDB(){
	ArrayList<Product> products=new ArrayList<Product>();
	dbconn=new DBconn();
	String sql="select * from product";
	PreparedStatement sm=null;
	try {
		sm=dbconn.getConn().prepareStatement(sql);
		ResultSet rs=sm.executeQuery();
		while(rs.next()) {
			String no=rs.getString(1);
			String name=rs.getString(2);
			float safeStock=rs.getFloat(3);
			Date lastPurchaseDate=rs.getDate(4);
			Date lastDeliveryDate=rs.getDate(5);
			float quantity=rs.getFloat(6);
			float suggestBuyPrice=rs.getFloat(7);
			float suggestSalePrice=rs.getFloat(8);
			Product p=new Product(name, no, lastPurchaseDate, lastDeliveryDate, safeStock, quantity, suggestBuyPrice, suggestSalePrice);
			products.add(p);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		dbconn.closeConn();
	}
	return products;
}

public Object[][] getProductArr(){
	Object[][] arrproducts=new Object[20][8];
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
	int i=0;
	for(Product p:products) {
		arrproducts[i][0]=p.getNo();
		arrproducts[i][1]=p.getName();
		arrproducts[i][2]=p.getSafeStock();
		arrproducts[i][3]=sdf.format(p.getLastPurchaseDate());
		arrproducts[i][4]=sdf.format(p.getLastDeliveryDate());
		arrproducts[i][5]=p.getQuantity();
		arrproducts[i][6]=p.getSuggestBuyPrice();
		arrproducts[i][7]=p.getSuggestSalePrice();
		i++;
		
	}
	return arrproducts;
	
}

}
