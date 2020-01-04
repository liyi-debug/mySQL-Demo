package ytvc.elms.control.product.dbPreparedStatement;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

import javax.swing.JTable;

import util.Util;
import ytvc.elms.frame.basic.ProductFrame;

public class ProductTableListener implements MouseListener {
ProductFrame frame;

	public ProductTableListener(ProductFrame frame) {
	super();
	this.frame=frame;
}

	@Override
	public void mouseClicked(MouseEvent e) {
		JTable table= frame.getTbProductShow();
		int row=table.getSelectedRow();//行索引从0开始
		Vector<Object> rowData=new Vector<Object>();
		for(int i=0; i<table.getColumnModel().getColumnCount();i++){
			Object o=table.getValueAt(row, i);
			if(Util.isEmpty(o)){
				rowData.add("");
			}else{
				rowData.add(o);
			}
			
	}
		frame.getTfNo().setText(rowData.get(0).toString());
			frame.getTfName().setText(rowData.get(1).toString());
			frame.getTfSafeStock().setText(rowData.get(2).toString());
			frame.getTfSuggestBuyPrice().setText(rowData.get(6).toString());
			frame.getTfSuggestSalePrice().setText(rowData.get(7).toString());

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
