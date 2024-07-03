package CourseWork;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.util.LinkedList;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.JSplitPane;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.util.regex.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class GUI extends JFrame{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Transaction transferObject=new Transaction();
	private StringBuilder sbAllData=new StringBuilder();
	private LinkedList<Account> globalAccounts=new LinkedList<>();
	private JTextField accDeposit;
	private JTextField accWithdraw;
	private JTextField acc1Transfer;
	private JTextField acc2Transfer;
	private JTextField depositInput;
	private JTextField withdrawInput;
	private JTextField transferAmount;
	private JLabel showAllData;
	private JButton showAllButton;
	private JButton depositButton;
	private JButton withdrawButton;
	private JButton transferButton;
	private JPanel panel_1;
	private JPanel panel_2;
	public void writeintofile(String line) {
		try {
			BufferedWriter filewrite=new BufferedWriter(new FileWriter("account.csv"));
			filewrite.write(line);
			filewrite.close();
		}
		catch(IOException err) {
			err.printStackTrace();
		}
	}
	//this is the method for updating the showAllData JLabel on each operations
	private void updatedata() {
		//We need to empty the StringBuilder each time to remove the previous data
		sbAllData.setLength(0);
		//Using HTML to manipulate JLabel display
		sbAllData.append("<html><table border='1'><tr><th>First Name</th><th>Last Name</th><th>Account Number</th><th>Balance</th></tr>");
		StringBuilder writeline=new StringBuilder();
		for(int i=0;i<globalAccounts.size();i++) {
			sbAllData.append("<tr><td>"+globalAccounts.get(i).getFirstName()+"</td><td>"+globalAccounts.get(i).getLastName()+"</td><td>"+globalAccounts.get(i).getAccountNum()+"</td><td>"+globalAccounts.get(i).getBalance()+"</td></tr>");
			writeline.append(globalAccounts.get(i).getFirstName()+","+globalAccounts.get(i).getLastName()+","+globalAccounts.get(i).getAccountNum()+","+globalAccounts.get(i).getBalance()+"\n");
		}
		writeintofile(writeline.toString());
		sbAllData.append("</table></html>");
		showAllData.setText(sbAllData.toString());
	}
	/**
	 * Create the frame.
	 */
	public GUI(LinkedList<Account> accounts) {
		super("Banking System");
		getContentPane().setLayout(null);
		this.globalAccounts=accounts;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1350, 947);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		showAllData = new JLabel("");
		showAllData.setHorizontalAlignment(SwingConstants.CENTER);
		showAllData.setFont(new Font("Tahoma", Font.PLAIN, 20));
		showAllData.setBounds(590, 0, 727, 328);
		contentPane.add(showAllData);
		
		showAllButton = new JButton("Show all data");
		showAllButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updatedata();
			}
		});
		showAllButton.setFont(new Font("Tahoma", Font.PLAIN, 25));
		showAllButton.setBounds(893, 334, 210, 60);
		contentPane.add(showAllButton);
		
		accDeposit = new JTextField();
		accDeposit.setFont(new Font("Tahoma", Font.PLAIN, 15));
		accDeposit.setBounds(285, 129, 231, 47);
		contentPane.add(accDeposit);
		accDeposit.setColumns(10);
		
		accWithdraw = new JTextField();
		accWithdraw.setFont(new Font("Tahoma", Font.PLAIN, 15));
		accWithdraw.setColumns(10);
		accWithdraw.setBounds(285, 580, 231, 47);
		contentPane.add(accWithdraw);
		
		depositInput = new JTextField();
		depositInput.setFont(new Font("Tahoma", Font.PLAIN, 15));
		depositInput.setColumns(10);
		depositInput.setBounds(285, 209, 231, 47);
		contentPane.add(depositInput);
		
		withdrawInput = new JTextField();
		withdrawInput.setFont(new Font("Tahoma", Font.PLAIN, 15));
		withdrawInput.setColumns(10);
		withdrawInput.setBounds(285, 659, 231, 47);
		contentPane.add(withdrawInput);
		
		JLabel lblNewLabel_1 = new JLabel("Account Number");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(10, 129, 231, 47);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Amount to Deposit");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(10, 209, 231, 47);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Account Number");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_2.setBounds(10, 580, 231, 47);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Amount to Withdraw");
		lblNewLabel_1_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_2_1.setBounds(10, 659, 231, 47);
		contentPane.add(lblNewLabel_1_2_1);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(10, 11, 552, 391);
		contentPane.add(panel);
		panel.setLayout(null);
		
		depositButton = new JButton("Deposit");
		depositButton.setBounds(160, 300, 210, 60);
		panel.add(depositButton);
		depositButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String accnum=accDeposit.getText();
				String accbal=depositInput.getText();
				if(accnum.isEmpty()||accbal.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please fill all the fields");
				}
				else {
					//Checking if numeric values or not using regex
					String check="[0-9]+";
					Pattern p=Pattern.compile(check);
					Matcher a=p.matcher(accnum);
					Matcher b=p.matcher(accbal);
					if(a.matches()==true && b.matches()==true) {
						int accno=Integer.parseInt(accnum);
						int bal=Integer.parseInt(accbal);
						if(bal<=0) {
							JOptionPane.showMessageDialog(null, "Please enter appropriate amount to deposit");
						}
						else {
							int c=0;//To check if account exists or not
							for(int i=0;i<globalAccounts.size();i++) {
								if(globalAccounts.get(i).getAccountNum()==accno) {
									globalAccounts.get(i).deposit(bal);
									c+=1;
								}
							}
							if(c==0) {
								JOptionPane.showMessageDialog(null, "Sorry, the account doesnot exist");
							}
							else {
								JOptionPane.showMessageDialog(null, "Deposited into account successfully");
								updatedata();
							}
						}						
					}
					else {
						JOptionPane.showMessageDialog(null, "Please enter integer only");
					}
				}
			}
		});
		depositButton.setFont(new Font("Tahoma", Font.PLAIN, 25));
		
		JLabel lblNewLabel = new JLabel("Deposit Feature");
		lblNewLabel.setBounds(63, 28, 385, 67);
		panel.add(lblNewLabel);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		
		panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(10, 445, 552, 380);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblTransferFeature = new JLabel("Withdraw Feature");
		lblTransferFeature.setBounds(87, 34, 385, 67);
		panel_1.add(lblTransferFeature);
		lblTransferFeature.setHorizontalAlignment(SwingConstants.CENTER);
		lblTransferFeature.setFont(new Font("Tahoma", Font.BOLD, 25));
		
		withdrawButton = new JButton("Withdraw");
		withdrawButton.setBounds(167, 297, 210, 60);
		panel_1.add(withdrawButton);
		withdrawButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String accnum=accWithdraw.getText();
				String amount=withdrawInput.getText();
				if(accnum.isEmpty()||amount.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please fill all the fields");
				}
				else {
					//checking if numeric or not using regex
					String check="[0-9]+";
					Pattern p=Pattern.compile(check);
					Matcher a=p.matcher(accnum);
					Matcher b=p.matcher(amount);
					if(a.matches()==true && b.matches()==true) {
						int accno=Integer.parseInt(accnum);
						int wamount=Integer.parseInt(amount);
						if(wamount<=0) {
							JOptionPane.showMessageDialog(null, "Please enter appropriate amount to withdraw");
						}
						else {
							int c=0;//To check if account has sufficient amount to withdraw
							int ac=0;//To check if account exists or not
							for(int i=0;i<globalAccounts.size();i++) {
								if(globalAccounts.get(i).getAccountNum()==accno) {
									ac+=1;
									if(wamount<=globalAccounts.get(i).getBalance()) {
										c+=1;
										globalAccounts.get(i).withdraw(wamount);
									}
								}
							}
							if(ac==0) {
								JOptionPane.showMessageDialog(null, "Sorry, the account doesnot exist");
							}
							else {
								if(c==0) {
									JOptionPane.showMessageDialog(null, "Insufficient amount to withdraw");
								}
								else {
									JOptionPane.showMessageDialog(null, "Withdrawn from account successfully");
									updatedata();
								}							
							}
						}	
					}
					else {
						JOptionPane.showMessageDialog(null, "Please enter integer only");
					}
				}
			}
		});
		withdrawButton.setFont(new Font("Tahoma", Font.PLAIN, 25));
		
		panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2.setBounds(682, 419, 552, 406);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblTransferFeature_2 = new JLabel("Transfer Feature");
		lblTransferFeature_2.setBounds(121, 11, 385, 67);
		panel_2.add(lblTransferFeature_2);
		lblTransferFeature_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblTransferFeature_2.setFont(new Font("Tahoma", Font.BOLD, 25));
		
		acc1Transfer = new JTextField();
		acc1Transfer.setBounds(275, 89, 231, 47);
		panel_2.add(acc1Transfer);
		acc1Transfer.setFont(new Font("Tahoma", Font.PLAIN, 15));
		acc1Transfer.setColumns(10);
		
		JLabel lblNewLabel_1_2_2 = new JLabel("Source Account");
		lblNewLabel_1_2_2.setBounds(10, 89, 231, 47);
		panel_2.add(lblNewLabel_1_2_2);
		lblNewLabel_1_2_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		acc2Transfer = new JTextField();
		acc2Transfer.setBounds(275, 167, 231, 47);
		panel_2.add(acc2Transfer);
		acc2Transfer.setFont(new Font("Tahoma", Font.PLAIN, 15));
		acc2Transfer.setColumns(10);
		
		JLabel lblNewLabel_1_2_2_1 = new JLabel("Destination Account");
		lblNewLabel_1_2_2_1.setBounds(10, 165, 231, 47);
		panel_2.add(lblNewLabel_1_2_2_1);
		lblNewLabel_1_2_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2_2_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		transferAmount = new JTextField();
		transferAmount.setBounds(275, 246, 231, 47);
		panel_2.add(transferAmount);
		transferAmount.setFont(new Font("Tahoma", Font.PLAIN, 15));
		transferAmount.setColumns(10);
		
		JLabel lblNewLabel_1_2_1_1 = new JLabel("Amount to Transfer");
		lblNewLabel_1_2_1_1.setBounds(0, 244, 231, 47);
		panel_2.add(lblNewLabel_1_2_1_1);
		lblNewLabel_1_2_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		transferButton = new JButton("Transfer");
		transferButton.setBounds(173, 315, 210, 60);
		panel_2.add(transferButton);
		transferButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String acc1=acc1Transfer.getText();
				String acc2=acc2Transfer.getText();
				String transfer=transferAmount.getText();
				if(acc1.isEmpty()||acc2.isEmpty()||transfer.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please fill all the fields");
				}
				else {
					//checking if numeric or not using regex
					String check="[0-9]+";
					Pattern p=Pattern.compile(check);
					Matcher a=p.matcher(acc1);
					Matcher b=p.matcher(acc2);
					Matcher c=p.matcher(transfer);
					if(a.matches()==true && b.matches()==true) {
						int source=Integer.parseInt(acc1);
						int dest=Integer.parseInt(acc2);
						int amount=Integer.parseInt(transfer);
						if(amount<=0) {
							JOptionPane.showMessageDialog(null, "Please enter appropriate amount to transfer");
						}
						else {
							int sourceacc=0;//to store the source account index
							int destacc=0;//to store the destination account index 
							int sc=0;//to check if source account exists
							int dc=0;//to check if destination account exists
							for(int i=0;i<globalAccounts.size();i++) {
								if(globalAccounts.get(i).getAccountNum()==source) {
									sc+=1;
									sourceacc=i;
								}
								if(globalAccounts.get(i).getAccountNum()==dest) {
									destacc=i;
									dc+=1;
								}
							}
							if(sc==0||dc==0) {
								JOptionPane.showMessageDialog(null, "Source/Destination Account/s donot exist");
							}
							else {
								if(globalAccounts.get(sourceacc).getBalance()>=amount) {
									transferObject.Transfer(globalAccounts.get(sourceacc), globalAccounts.get(destacc), amount);
									JOptionPane.showMessageDialog(null, "Transfer successful");
									updatedata();
								}
								else {
									JOptionPane.showMessageDialog(null, "Insufficient amount in source account");
								}
							}
						}					
					}
					else {
						JOptionPane.showMessageDialog(null, "Please enter integer only");
					}
				}
			}
		});
		transferButton.setFont(new Font("Tahoma", Font.PLAIN, 25));
	}
}


