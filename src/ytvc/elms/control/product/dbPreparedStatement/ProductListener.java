package ytvc.elms.control.product.dbPreparedStatement;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import util.Util;
import ytvc.elms.frame.basic.ProductFrame;
import ytvc.elms.model.entity.Product;

public class ProductListener implements ActionListener{
ProductFrame productFrame;
ProductManager pm=new ProductManager();


	public ProductListener(ProductFrame productframe) {
	super();
	this.productFrame=productframe;
	// TODO Auto-generated constructor stub
}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==productFrame.getBtNew()) {
			Product p=getProductFormFrame();
			if(p==null) {
				JOptionPane.showMessageDialog(productFrame,"前三项必填，不能为空");
			}else {
				if(pm.addProduct(p)) {
					Object[][] oo=pm.getProductArr();
					productFrame.setProductsData(oo);
					productFrame.refreshTable();
				}else {
					JOptionPane.showMessageDialog(productFrame, "商品新增失败","商品错误提示",JOptionPane.ERROR_MESSAGE);
				}
			}
			productFrame.clr();
		}
		if(e.getSource()==productFrame.getBtDelete()) {
			String no=productFrame.getTfNo().getText().trim();
			if(!Util.isEmpty(no)) {
				if(pm.delectProductByNo(no)) {
					Object [][] oo=pm.getProductArr();
					productFrame.setProductsData(oo);
					productFrame.refreshTable();
				}else {
					JOptionPane.showMessageDialog(productFrame, "商品删除失败","商品输出错误提示",JOptionPane.ERROR_MESSAGE);
				}
			}
			
		}
		if(e.getSource()==productFrame.getBtUpdate()) {
			productFrame.getBtNew().setEnabled(false);
			productFrame.getBtDelete().setEnabled(false);
			productFrame.getBtExit().setEnabled(false);
			productFrame.getBtSave().setEnabled(true);
			productFrame.getBtCancle().setEnabled(true);
			productFrame.getTfNo().setEditable(false);
			}
		if(e.getSource()==productFrame.getBtExit()) {
			productFrame.dispose();
		}
		}
		
		
	
	
	public Product getProductFormFrame(){
		String no=productFrame.getTfNo().getText().trim();
		String name=productFrame.getTfName().getText().trim();
		String ssafe=productFrame.getTfSafeStock().getText().trim();
		if(Util.isEmpty(no)||Util.isEmpty(name)||Util.isEmpty(ssafe)) {
			return null;
		}
		float safestock=0;
		safestock=Float.parseFloat(ssafe);
		String ssale=productFrame.getTfSuggestSalePrice().getText().trim();
		float suggestSalePrice=0;
		try {
			suggestSalePrice=Float.parseFloat(ssale);
		} catch (NumberFormatException e) {
			suggestSalePrice=0;
		}
		String sbuy=productFrame.getTfSuggestBuyPrice().getText().trim();
		float suggestBuyPrice=0;
		suggestBuyPrice=Float.parseFloat(sbuy);
		return new Product(name,no, safestock, suggestBuyPrice, suggestSalePrice);
	}
	public ProductManager getPm() {
		return pm;
	}
	
	

}
