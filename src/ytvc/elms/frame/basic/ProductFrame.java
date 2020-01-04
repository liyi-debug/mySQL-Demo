package ytvc.elms.frame.basic;

import java.awt.Color;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import ytvc.elms.control.product.dbPreparedStatement.ProductListener;
import ytvc.elms.control.product.dbPreparedStatement.ProductTableListener;

public class ProductFrame extends JFrame {
	JTextField tfNo,tfName,tfSafeStock,tfSuggestBuyPrice,tfSuggestSalePrice;
	JButton btNew,btDelete,btUpdate,btSave,btCancle,btExit;
	JPanel jpInput,jpButton;
	JTable tbProductShow;
	Object[] title={"商品编号","商品名称","安全存量","最新采购日期","最新销售日期","库存量","建议购买价","建议销售价"};
	Object[][] productsData=new Object[20][8];
	
	ProductListener productListener;//创建商品监听
	ProductTableListener tableListener;//创建表格鼠标监听
	public ProductFrame(){
		initComp();
		addEvent();
		basicSet();
	} 
	public void initComp(){
		tableListener=new ProductTableListener(this);
		productListener=new ProductListener(this);
		//表格的值应该来源于数据库
		productsData=productListener.getPm().getProductArr();
		tbProductShow=new JTable(productsData,title);
		tfNo=new JTextField(8);
		tfName=new JTextField(10);
		tfSafeStock=new JTextField(5);
		tfSuggestBuyPrice=new JTextField(5);
		tfSuggestSalePrice=new JTextField(5);
		btNew=new JButton("新增");
		btDelete=new JButton("删除");
		btUpdate=new JButton("修改");
		btSave=new JButton("保持");
		btCancle=new JButton("取消");
		btExit=new JButton("退出");
		
		jpInput=new JPanel();
		JLabel lbno=new JLabel("商品编号：");
		lbno.setForeground(Color.red);
		jpInput.add(lbno);
		jpInput.add(tfNo);
		
		JLabel lbname=new JLabel("商品名称：");
		lbname.setForeground(Color.red);
		jpInput.add(lbname);
		jpInput.add(tfName);
		
		JLabel lbsafe=new JLabel("安全存量：");
		lbsafe.setForeground(Color.red);
		jpInput.add(lbsafe);
		jpInput.add(tfSafeStock);
		
		jpInput.add(new JLabel("建议采购价格："));
		jpInput.add(tfSuggestBuyPrice);
		jpInput.add(new JLabel("建议销售价格："));
		jpInput.add(tfSuggestSalePrice);
		
		jpButton=new JPanel();
		JLabel lbmsg=new JLabel("注意：前三项必填！！！！");
		lbmsg.setForeground(Color.red);
		jpButton.add(lbmsg);
		
		jpButton.add(btNew);
		jpButton.add(btDelete);
		jpButton.add(btUpdate);
		jpButton.add(btSave);
		jpButton.add(btCancle);
		jpButton.add(btExit);
		
		Box box=Box.createVerticalBox();
		box.add(new JScrollPane(tbProductShow));
		box.add(jpInput);
		box.add(jpButton);
		add(box);
	}
	public void basicSet(){
		this.setVisible(true);
		this.setBounds(100, 100, 860, 600);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	public void addEvent(){
		btNew.addActionListener(productListener);
		btDelete.addActionListener(productListener);
		btUpdate.addActionListener(productListener);
		btSave.addActionListener(productListener);
		btCancle.addActionListener(productListener);
		btExit.addActionListener(productListener);
		tbProductShow.addMouseListener(tableListener);//添加表格鼠标监听
	}
	public JButton getBtNew() {
		return btNew;
	}
	public JButton getBtDelete() {
		return btDelete;
	}
	public JButton getBtUpdate() {
		return btUpdate;
	}
	public JButton getBtSave() {
		return btSave;
	}
	public JButton getBtCancle() {
		return btCancle;
	}
	public JButton getBtExit() {
		return btExit;
	}
	public JTextField getTfNo() {
		return tfNo;
	}
	public JTextField getTfName() {
		return tfName;
	}
	public JTextField getTfSafeStock() {
		return tfSafeStock;
	}
	public JTextField getTfSuggestBuyPrice() {
		return tfSuggestBuyPrice;
	}
	public JTextField getTfSuggestSalePrice() {
		return tfSuggestSalePrice;
	}
	
	public JTable getTbProductShow() {
		return tbProductShow;
	}
	public void setProductsData(Object[][] productsData) {
		this.productsData = productsData;
	}
	public void refreshTable(){
		DefaultTableModel dtm=new DefaultTableModel(productsData, title);
		tbProductShow.setModel(dtm);
		tbProductShow.repaint();
	}
	
	public void clr(){
		this.tfNo.setText("");
		this.tfName.setText("");
		this.tfSafeStock.setText("");
		this.tfSuggestBuyPrice.setText("");
		this.tfSuggestSalePrice.setText("");
	}
	
}



