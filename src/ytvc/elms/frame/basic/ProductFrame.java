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
	Object[] title={"��Ʒ���","��Ʒ����","��ȫ����","���²ɹ�����","������������","�����","���鹺���","�������ۼ�"};
	Object[][] productsData=new Object[20][8];
	
	ProductListener productListener;//������Ʒ����
	ProductTableListener tableListener;//�������������
	public ProductFrame(){
		initComp();
		addEvent();
		basicSet();
	} 
	public void initComp(){
		tableListener=new ProductTableListener(this);
		productListener=new ProductListener(this);
		//����ֵӦ����Դ�����ݿ�
		productsData=productListener.getPm().getProductArr();
		tbProductShow=new JTable(productsData,title);
		tfNo=new JTextField(8);
		tfName=new JTextField(10);
		tfSafeStock=new JTextField(5);
		tfSuggestBuyPrice=new JTextField(5);
		tfSuggestSalePrice=new JTextField(5);
		btNew=new JButton("����");
		btDelete=new JButton("ɾ��");
		btUpdate=new JButton("�޸�");
		btSave=new JButton("����");
		btCancle=new JButton("ȡ��");
		btExit=new JButton("�˳�");
		
		jpInput=new JPanel();
		JLabel lbno=new JLabel("��Ʒ��ţ�");
		lbno.setForeground(Color.red);
		jpInput.add(lbno);
		jpInput.add(tfNo);
		
		JLabel lbname=new JLabel("��Ʒ���ƣ�");
		lbname.setForeground(Color.red);
		jpInput.add(lbname);
		jpInput.add(tfName);
		
		JLabel lbsafe=new JLabel("��ȫ������");
		lbsafe.setForeground(Color.red);
		jpInput.add(lbsafe);
		jpInput.add(tfSafeStock);
		
		jpInput.add(new JLabel("����ɹ��۸�"));
		jpInput.add(tfSuggestBuyPrice);
		jpInput.add(new JLabel("�������ۼ۸�"));
		jpInput.add(tfSuggestSalePrice);
		
		jpButton=new JPanel();
		JLabel lbmsg=new JLabel("ע�⣺ǰ������������");
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
		tbProductShow.addMouseListener(tableListener);//��ӱ��������
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



