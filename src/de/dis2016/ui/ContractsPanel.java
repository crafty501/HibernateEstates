package de.dis2016.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import de.dis2011.data.IDB2;
import de.dis2016.model.Contract;
import de.dis2016.model.Purchase;
import de.dis2016.model.Tenancy;

public class ContractsPanel extends JPanel implements ActionListener,MouseListener{
	private static final long serialVersionUID = 1L;
	
	private IDB2 db;
	JButton _neu;
	JButton _speichern;
	JButton _ende;JCheckBox cbTenancy;
	JTextField tfID, tfDate, tfPlace, tfStartDate, tfDuration, tfAdditionalCosts, tfNoOfInstallments, tfIntrestRate;
	JList<String> _liste;
	List<Contract> _contract_list;
	DefaultListModel<String> _listModel;
	SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
	
	public ContractsPanel(IDB2 db){
		super();
		//this._contract_list = db.Gib_alle_Contracts();
		
		this.db = db;
		
		this.setLayout(new BorderLayout());
		JPanel Eingabe 	= this.Generate_Eingabefelder();
		JPanel Leiste 	= this.ButtonLeiste();
		JPanel Liste	= this.Generate_Liste();
		
		this.add(Eingabe,BorderLayout.CENTER);
		this.add(Leiste,BorderLayout.SOUTH);
		this.add(Liste,BorderLayout.EAST);
		this.setSize(800, 500);

        this.UpdateUI();
	}
	
	private void UpdateUI(){
		_listModel.clear();
		_contract_list = db.getContracts();
		if(_contract_list.size() == 0){
			// Die MarklerListe ist noch komplett leer	
			System.out.println("Contract ist noch komplett leer");
		}else{
			for(int i = 0 ; i < _contract_list.size(); i++){
				Contract c = _contract_list.get(i);
				int Contract_No = c.getId();
				_listModel.addElement("[" +Contract_No+"]");
			}
		}
	}
	
	private JPanel Generate_Eingabefelder(){	
		JPanel main = new JPanel();
		main.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createCompoundBorder(
            BorderFactory.createTitledBorder("Datensatz"),
            BorderFactory.createEmptyBorder(5,5,5,5)),
            main.getBorder()));
		main.setSize(500,600);
		main.setLayout(new GridLayout(9,1));
		
		JPanel box = new JPanel();
		box.setLayout(new BorderLayout());
		JLabel label = new JLabel();
		label.setText("Tenancy:");
		cbTenancy = new JCheckBox();
		box.add(label,BorderLayout.NORTH);
		box.add(cbTenancy,BorderLayout.CENTER);
		main.add(box);
		
		JPanel box_1 = new JPanel();
		box_1.setLayout(new BorderLayout());
		JLabel label_1 = new JLabel();
		label_1.setText("Date:");
		tfDate = new JTextField();
		tfDate.setSize(120,12);
		box_1.add(label_1,BorderLayout.NORTH);
		box_1.add(tfDate,BorderLayout.CENTER);
		main.add(box_1);
		
		JPanel box_2 = new JPanel();
		box_2.setLayout(new BorderLayout());
		JLabel label_2 = new JLabel();
		label_2.setText("Place:");
		tfPlace = new JTextField();
		tfPlace.setSize(120,12);
		box_2.add(label_2,BorderLayout.NORTH);
		box_2.add(tfPlace,BorderLayout.CENTER);
		main.add(box_2);
		
		JPanel box_4 = new JPanel();
		box_4.setLayout(new BorderLayout());
		JLabel label_4 = new JLabel();
		label_4.setText("Start date:");
		tfStartDate = new JTextField();
		tfStartDate.setEditable(false);
		box_4.add(label_4,BorderLayout.NORTH);
		box_4.add(tfStartDate,BorderLayout.CENTER);
		main.add(box_4);
		
		JPanel box_5 = new JPanel();
		box_5.setLayout(new BorderLayout());
		JLabel label_5 = new JLabel();
		label_5.setText("Duration:");
		tfDuration = new JTextField();
		tfDuration.setEditable(false);
		box_5.add(label_5,BorderLayout.NORTH);
		box_5.add(tfDuration,BorderLayout.CENTER);
		main.add(box_5);
		
		JPanel box_6 = new JPanel();
		box_6.setLayout(new BorderLayout());
		JLabel label_6 = new JLabel();
		label_6.setText("Additional Costs:");
		tfAdditionalCosts = new JTextField();
		tfAdditionalCosts.setEditable(false);
		box_6.add(label_6,BorderLayout.NORTH);
		box_6.add(tfAdditionalCosts,BorderLayout.CENTER);
		main.add(box_6);
		
		JPanel box_7 = new JPanel();
		box_7.setLayout(new BorderLayout());
		JLabel label_7 = new JLabel();
		label_7.setText("No of installments:");
		tfNoOfInstallments = new JTextField();
		box_7.add(label_7,BorderLayout.NORTH);
		box_7.add(tfNoOfInstallments,BorderLayout.CENTER);
		main.add(box_7);
		
		JPanel box_8 = new JPanel();
		box_8.setLayout(new BorderLayout());
		JLabel label_8 = new JLabel();
		label_8.setText("Interest Rate:");
		tfIntrestRate = new JTextField();
		box_8.add(label_8,BorderLayout.NORTH);
		box_8.add(tfIntrestRate,BorderLayout.CENTER);
		main.add(box_8);
		
		cbTenancy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (cbTenancy.isSelected()) {
					tfNoOfInstallments.setEditable(false);
					tfIntrestRate.setEditable(false);
					tfStartDate.setEditable(true);
					tfDuration.setEditable(true);
					tfAdditionalCosts.setEditable(true);
				}else{
					tfNoOfInstallments.setEditable(true);
					tfIntrestRate.setEditable(true);
					tfStartDate.setEditable(false);
					tfDuration.setEditable(false);
					tfAdditionalCosts.setEditable(false);
				}
		    }
		});
		return main;
	}
	
	private JPanel ButtonLeiste(){
		JPanel main = new JPanel();
		main.setLayout(new FlowLayout());
		
		//Neu
		_neu = new JButton();
		_neu.setText("Save as new");
		_neu.addActionListener(this);
		main.add(_neu);
		return main;
	}
	
	private JPanel Generate_Liste(){	
		JPanel main = new JPanel();
		main.setBorder(BorderFactory.createCompoundBorder(
			BorderFactory.createCompoundBorder(
            BorderFactory.createTitledBorder("Contracts"),
            BorderFactory.createEmptyBorder(5,5,5,5)),
			main.getBorder()));
		_listModel = new DefaultListModel<String>();
		_liste = new JList<String>(_listModel);
		_liste.addMouseListener(this);
		_liste.setLayoutOrientation(JList.HORIZONTAL_WRAP);
		
		JScrollPane listScroller = new JScrollPane(_liste);
		listScroller.setPreferredSize(new Dimension(400, 250));
		
		main.add(listScroller);
		return main;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {	
		Object source = arg0.getSource();
		System.out.println(source.toString());
		if(source.equals(_ende)){
			this.setVisible(false);
		}
		
		//Neuen Contract anlegen 
		if(source.equals(_neu)){
			Date Date = null;
			long timestamp = 0;
			try {
				timestamp = format.parse(tfDate.getText()).getTime();
				Date 						= new Date(timestamp);
				System.out.println(Date.toString());
			} catch (ParseException e) {
				System.out.println("Kein richtiges Format");
				e.printStackTrace();
			}
			String Place 			= tfPlace.getText();
			Contract c = null; 
			
			if(cbTenancy.isSelected()){			
				long time_stamp = 0L;
				try {
					time_stamp = format.parse(tfStartDate.getText()).getTime();
				} catch (ParseException e) {
					e.printStackTrace();
				}
				Date start_date 		= new Date(time_stamp);
				int duration			= Integer.parseInt(tfDuration.getText());
				int additional_costs 	= Integer.parseInt(tfAdditionalCosts.getText());
				
				c = new Tenancy(-1, Date, Place, start_date, duration, additional_costs);
			}else{
				int  No_of_installments 	= Integer.parseInt(tfNoOfInstallments.getText());
				int  intrest_rate			= Integer.parseInt(tfIntrestRate.getText());	 
				c = new Purchase(-1, Date, Place, No_of_installments, intrest_rate);
			}
			
			assert c !=  null : "Contract Objekt ist null!";
			db.addContract(c);
			this.UpdateUI();
		}
		if (source.equals(_liste)){
			int index = _liste.getSelectedIndex();
			System.out.println(index);
		}
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		Object source = e.getSource();
		if(source.equals(_liste)){
			
			//Alles leer
			tfDate.setText("");
			tfPlace.setText("");
			tfStartDate.setText("");
			tfDuration.setText("");
			tfAdditionalCosts.setText("");
			tfNoOfInstallments.setText("");
			tfIntrestRate.setText("");
			
			int index = _liste.getSelectedIndex();			
			System.out.println(index);
			Contract c = _contract_list.get(index);
			
			tfDate.setText(format.format(c.getDate()));
			tfPlace.setText(c.getPlace());
			
			if (c instanceof Tenancy) {
			
				tfStartDate.setEditable(true);
				tfDuration.setEditable(true);
				tfAdditionalCosts.setEditable(true);
				tfNoOfInstallments.setEditable(false);
				tfIntrestRate.setEditable(false);
				
				cbTenancy.setSelected(true);
				Tenancy t = (Tenancy)c;
				tfStartDate.setText(format.format(t.getStartDate()));
				tfDuration.setText(String.valueOf(t.getDuration()));
				tfAdditionalCosts.setText(String.valueOf(t.getAdditionalCosts()));
				
			}else{
				
				tfStartDate.setEditable(false);
				tfDuration.setEditable(false);
				tfAdditionalCosts.setEditable(false);
				tfNoOfInstallments.setEditable(true);
				tfIntrestRate.setEditable(true);
				
				cbTenancy.setSelected(false);
				Purchase p = (Purchase)c;
				tfNoOfInstallments.setText(String.valueOf(p.getNoOfInstallments()));
				tfIntrestRate.setText(String.valueOf(p.getIntrestRate()));
			}
		}
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


