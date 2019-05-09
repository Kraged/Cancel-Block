import java.applet.AudioClip;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import javax.sound.sampled.*;
import javax.swing.*;
import javax.swing.table.*;
import javax.imageio.*;

public class CandyCrush  extends JFrame implements ActionListener, MouseListener {

	public static AudioClip loadSound(String filename) 
	{
		URL url = null;
		try {
			url = new URL("file:" + filename);
		} catch (MalformedURLException e) 
		{
			e.getStackTrace();
		}
		return JApplet.newAudioClip(url);
	}	
	
	private static final long serialVersionUID = 1L;
	
	static CandyCrush Cy = new CandyCrush();
	static Container cr = Cy.getContentPane();
	static JPanel a15 = new JPanel(new GridLayout(10,10,100,100));
	static JPanel a16 = new JPanel(new GridLayout(11,11,110,110));
	static JPanel a17 = new JPanel(new GridLayout(12,12,120,120));
	static JFrame ranking = new JFrame("排行榜");
	 static String[] title = new String[] {"排名","姓名","分數"};
	 static Object[][] data = new Object[][] {
			 {new Integer(1),"Peter",new Integer(14500)},
			 {new Integer(2),"John",new Integer(9500)},
			 {new Integer(3),"Mary",new Integer(9000)},
			 {new Integer(4),"Thomas",new Integer(8500)},
			 {new Integer(5),"Victoria",new Integer(8000)},
			 {new Integer(6),"Tracy",new Integer(7500)},
			 {new Integer(7),"Timmy",new Integer(7000)},
			 {new Integer(8),"Finn",new Integer(6500)},
			 {new Integer(9),"Queenie",new Integer(6000)},
			 {new Integer(10),"Olivia",new Integer(5000)},
			 };
	public int getRowCount() {return data.length;}
	public int getColumCount() {return data[0].length;}
	public Object getValueAt(int row,int colum){
		return data[row][colum];
	}
      public Class getColumnClass(int Column){
        return data[0][Column].getClass();
      }
      public boolean isCellEditable(int row,int col) {return true;}
		 static JTable rkg = new JTable(data,title);
	static Label mk = new Label("目前分數");
	static Label tgmk = new Label("目標分數");
	static Label place = new Label("目前位置");
	static Label ll = new Label("您的等級");
	static Label me = new Label("移動次數");
	static Label te = new Label("限定時間");
	static JLabel about = new JLabel("關於");
	static JLabel aboutc = new JLabel();
	static JLabel sl = new JLabel();
	static JLabel s = new JLabel("遊戲說明");
	static TextField m1 = new TextField();
	static TextField m2 = new TextField("2000");
	static TextField m3 = new TextField("1");
	static TextField m4 = new TextField();
	static TextField m5 = new TextField("5");
	static TextField m6 = new TextField();
	static JButton b1 = new JButton("遊戲開始");
	static JButton b2 = new JButton("重新整理");
	static JButton b3 = new JButton("退出遊戲");
	static JButton b4 = new JButton("下一關");
	static int k;
	static int y;
	static int[] p;
	static MyJButton[][] B = new MyJButton[10][10];
	static MyJButton[][] C = new MyJButton[11][11];
	static MyJButton[][] D = new MyJButton[12][12];	
	
	static ImageIcon[] imgs;
	static int counter=0;
	static int ex=0;
	static int xe=0;
	static int fu=0;
	static int ck=0;
	static int mark = 0;
	static int r1=0,c1=0;
	static int r2=0,c2=0;
	static int Red = 0;
	static int Blue = 1;
	static int Yellow = 2;
	static int Green = 3;	
	static int Black = 4;
	static int White = 5;
	static int Purple = 6;
	static int Orange = 7;	
	static int Shadow = 8;
	static int Dark = 9;		
	 static int ti;
	 static AudioClip fpj = loadSound ("classic.wav"); 
	 static AudioClip jp = loadSound ("jp.wav");
	
	static Timer t = new Timer(600, new ActionListener()
    {
		
		@Override
		public void actionPerformed(ActionEvent d) {
			// TODO Auto-generated method stub
			
			if ((ti == 0))
			{
				JOptionPane.showMessageDialog(Cy, "你輸啦廢物~");
				m6.setText("END.");
				ti = -1;
				if (JOptionPane.showOptionDialog(Cy,
						"你已經輸了！\n你的總分為:"+y+"\n要進排行榜還是離開？", "抱歉囉∼",
						JOptionPane.OK_CANCEL_OPTION,
						JOptionPane.INFORMATION_MESSAGE, null,
						new String[] { "排行榜？", "再見" },
						"default") == JOptionPane.OK_OPTION) 
				{    
					int name = JOptionPane.INFORMATION_MESSAGE;
					String in1 = JOptionPane.showInputDialog(Cy, "請輸入姓名", "輸入",
							name);
					for (int tg = 0; tg <= 9; tg++) {
						int score = (int) rkg.getValueAt(tg, 2);
						if (y > score) {
							score = y;
							data[tg][2] = y;
							data[tg][1] = in1;// 更新資料來源
							break;
						} else if (y == score) {
							score = y;
							data[tg + 1][2] = y;
							data[tg + 1][1] = in1;// 更新資料來源
							break;
						}
					}
					ranking.setVisible(true);
					ranking.setAlwaysOnTop(true);
				}
				if (JOptionPane.showOptionDialog(Cy,
						"你要離開嗎？", "　",
						JOptionPane.OK_CANCEL_OPTION,
						JOptionPane.INFORMATION_MESSAGE, null,
						new String[] { "對！！", "我要重來！" },
						"default") == JOptionPane.OK_OPTION)
				{
					System.exit(0);
				}
				else
				{
					if (JOptionPane.showOptionDialog(Cy,
							"你要重新開始嗎？", "　",
							JOptionPane.OK_CANCEL_OPTION,
							JOptionPane.INFORMATION_MESSAGE, null,
							new String[] { "重新開始！", "我才不要∼" },
							"default") == JOptionPane.OK_OPTION) 
					{
						s.setVisible(false);
						a15.setVisible(true);
						a17.setVisible(false);
						b1.setEnabled(true);
						b2.setEnabled(true);
						b2.setVisible(true);
						b3.setVisible(true);
						mk.setVisible(true);
						tgmk.setVisible(true);
						place.setVisible(true);
						ll.setVisible(true);
						me.setVisible(false);
						m1.setVisible(true);
						m2.setVisible(true);
						m3.setVisible(true);
						m4.setVisible(true);
						m5.setVisible(false);
						mk.setBounds(20,490,70,25); 
						tgmk.setBounds(20,510,70,25); 
						place.setBounds(180,490,70,25); 
						ll.setBounds(180,510,70,25); 
						m1.setBounds(100,493,55,20);
						m2.setBounds(100,513,55,20);
						m3.setBounds(260,493,35,20);
						m4.setBounds(260,513,35,20);
						Cy.setSize(500, 600);
						m1.setText("0");
						m2.setText("2000");
						m3.setText("1");
						ranking.setVisible(false);
						y = 0;								
					}
					else
					{
						if (JOptionPane.showOptionDialog(Cy,
								"你要離開嗎？", "　",
								JOptionPane.OK_CANCEL_OPTION,
								JOptionPane.INFORMATION_MESSAGE, null,
								new String[] { "對！！", "還不要" },
								"default") == JOptionPane.OK_OPTION)
						{
							System.exit(0);
						}
						else
						{
							b2.setEnabled(false);
						}
					}
				}
			}
			else if (ti > 0)
			{
			ti  = ti - 1; 
			m6.setText(String.valueOf(ti));	
			}
		}
    });
	
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub\
		
		 
		 fpj.loop();
		 JFrame.setDefaultLookAndFeelDecorated(true);
		 JDialog.setDefaultLookAndFeelDecorated(true);
		 Container rg = ranking.getContentPane(); 
	     rkg.setPreferredScrollableViewportSize(new Dimension(400,300));
	     rg.add(new JScrollPane(rkg),BorderLayout.CENTER);
	     TableColumn column=rkg.getColumnModel().getColumn(0);
	     column.setPreferredWidth(3);
	     TableColumn column1=rkg.getColumnModel().getColumn(2);
	     column1.setPreferredWidth(30);
	     rkg.setVisible(true);
	     rkg.setEnabled(true);
	     ranking.setSize(220, 230);
	     ranking.setVisible(false);
	     DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
	     centerRenderer.setHorizontalAlignment( JLabel.CENTER );
	     rkg.getColumnModel().getColumn(0).setCellRenderer( centerRenderer );
	     rkg.getColumnModel().getColumn(2).setCellRenderer( centerRenderer );
		
		imgs = new ImageIcon[10];
		imgs[Red] = new ImageIcon("images/img1.png");
		imgs[Blue] = new ImageIcon("images/img2.png");
		imgs[Yellow] = new ImageIcon("images/img3.png");
		imgs[Green] = new ImageIcon("images/img4.jfif");
		imgs[Black] = new ImageIcon("images/img5.jfif");
		imgs[White] = new ImageIcon("images/img6.png");
		imgs[Purple] = new ImageIcon("images/img7.png");
		imgs[Orange] = new ImageIcon("images/img8.png");
		imgs[Shadow] = new ImageIcon("images/img9.jpg");
		imgs[Dark] = new ImageIcon("images/img10.png");
		
		for (int r = 0; r < 10; r++) 
		{
			for (int c = 0; c < 10; c++) {
			B[r][c] = new MyJButton();			
			B[r][c].row = r;
			B[r][c].col = c;			
			B[r][c].color = (int) ((Math.random() * 8));
			int cc = B[r][c].color;// c = 0,1,2
			if ((c>0) && (c<10))
			{
					if (B[r][c-1].color == B[r][c].color) {
						B[r][c].color = (int) ((Math.random() * 8));
						cc = B[r][c].color;// c = 0,1,2
						B[r][c].setIcon( imgs[cc] );			
					}
					
			}
			if ((r > 0 && c>0) && (r<10 && c<10))
			{
					if ((B[r][c - 1].color == B[r][c].color)
							|| (B[r -1][c].color == B[r][c].color)) {
						B[r][c].color = (int) ((Math.random() * 8));
						cc = B[r][c].color;// c = 0,1,2
						B[r][c].setIcon( imgs[cc] );			
					}
			}
			B[r][c].setIcon( imgs[cc] );			
			B[r][c].addActionListener(Cy);
			a15.add(B[r][c]);
			}
		}
		
		for (int r = 0; r < 11; r++) 
		{
			for (int c = 0; c < 11; c++) {
			C[r][c] = new MyJButton();			
			C[r][c].row = r;
			C[r][c].col = c;			
			C[r][c].color = (int) ((Math.random() * 9));
			int cc = C[r][c].color;// c = 0,1,2
			if ((c>0) && (c<11))
			{
					if (C[r][c-1].color == C[r][c].color) {
						C[r][c].color = (int) ((Math.random() * 8));
						cc = C[r][c].color;// c = 0,1,2
						C[r][c].setIcon( imgs[cc] );			
					}
					
			}
			if ((r > 0 && c>0) && (r<11 && c<11))
			{
					if ((C[r][c - 1].color == C[r][c].color)
							|| (C[r -1][c].color == C[r][c].color)) {
						C[r][c].color = (int) ((Math.random() * 8));
						cc = C[r][c].color;// c = 0,1,2
						C[r][c].setIcon( imgs[cc] );			
					}
			}
			C[r][c].setIcon( imgs[cc] );			
			C[r][c].addActionListener(Cy);
			a16.add(C[r][c]);
			}
		}
		
		for (int r = 0; r < 12; r++) 
		{
			for (int c = 0; c < 12; c++) {
			D[r][c] = new MyJButton();			
			D[r][c].row = r;
			D[r][c].col = c;			
			D[r][c].color = (int) ((Math.random() * 10));
			int cc = D[r][c].color;// c = 0,1,2
			if ((c>0) && (c<12))
			{
					if (D[r][c-1].color == D[r][c].color) {
						D[r][c].color = (int) ((Math.random() * 8));
						cc = D[r][c].color;// c = 0,1,2
						D[r][c].setIcon( imgs[cc] );			
					}
					
			}
			if ((r > 0 && c>0) && (r<12 && c<12))
			{
					if ((D[r][c - 1].color == D[r][c].color)
							|| (D[r -1][c].color == D[r][c].color)) {
						D[r][c].color = (int) ((Math.random() * 8));
						cc = D[r][c].color;// c = 0,1,2
						D[r][c].setIcon( imgs[cc] );			
					}
			}
			D[r][c].setIcon( imgs[cc] );			
			D[r][c].addActionListener(Cy);
			a17.add(D[r][c]);
			}
		}
		
		try
		{
			Cy.setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("images/bg.jpg")))));
		}
		catch(IOException e)
		{
			e.setStackTrace(null);
		}
		
		GridLayout grid = new GridLayout(10,10);
		GridLayout grid2 = new GridLayout(11,11);
		GridLayout grid3 = new GridLayout(12,12);
		Cy.setSize(500, 600);
		cr.setBackground(Color.getHSBColor(500, 722, 900));
		Cy.setLayout(null);		
		Cy.setTitle("CandyCity");
		b1.addActionListener(Cy);
		b2.addActionListener(Cy);
		b3.addActionListener(Cy);
		b4.addActionListener(Cy);
		mk.setFont(new Font ("Serief",Font.PLAIN, 15));
		mk.setBounds(20,490,70,25); 
		mk.setVisible(false);
		tgmk.setFont(new Font ("Serief",Font.PLAIN, 15));
		tgmk.setBounds(20,510,70,25); 
		tgmk.setVisible(false);
		place.setFont(new Font ("Serief",Font.PLAIN, 15));
		place.setBounds(180,490,70,25); 
		place.setVisible(false);
		ll.setFont(new Font ("Serief",Font.PLAIN, 15));
		ll.setBounds(180,510,70,25); 
		ll.setVisible(false);
		sl.setFont(new Font ("Microsoft JhengHei",Font.ROMAN_BASELINE, 35));
		sl.setBounds(310,20,250,40); 
		sl.setVisible(false);
        sl.setOpaque(true);
        sl.setBackground(new Color(255, 0, 0, 0));
        sl.setText("<html>"
        		+ "<font color=#E0791F>*</font><font color=#C18C3E>*</font><font color=#A29F5D>隱</font><font color=#83B27C>藏</font><font color=#64C59B>關</font><font color=#45D8BA>卡</font><font color=#26EBD9>*</font><font color=#07FEF8>*</font>"
        		+ "</html>");
        about.addMouseListener(Cy);
        about.setBounds(450, 5, 30, 30);
        aboutc.setBounds(260, 12, 300, 150);
        aboutc.setVisible(false);
        aboutc.setText("<html><div style=\"text-align: right;\">本遊戲僅供娛樂，<br>"
        		+ "請勿隨意散播、發售或更改；<br>"
        		+ "如有問題請以電郵或其他方式<br>"
        		+ "聯絡本作品之作者們：<br>"
        		+ "s03352032、s03352009、s03353047<br>"
        		+ "感謝合作。<br>"
        		+ "\u00a9THUCS@103<br>"
        		+ "</html>");
		me.setFont(new Font ("Serief",Font.PLAIN, 15));
		me.setBounds(340,490,70,25); 
		me.setVisible(false);
		te.setFont(new Font ("Serief",Font.PLAIN, 15));
		te.setBounds(340,490,70,25); 
		te.setVisible(false);
		s.setText("<html>"
				+ "<div style=\"text-align: center;font-size:20px;font-weight:bold;\">&nbsp;&nbsp;歡迎來到CandyCity!<br>"
				+ "<div style=\"text-align: left;font-size:15px;font-weight:normal;font-family:Microsoft JhengHei;text-decoration:underline\">遊戲規則如下:<br>"
				+ "<div style=\"text-align: left;font-size:13px;font-weight:normal;font-family:Microsoft JhengHei;text-decoration:normal\">"
				+ "1.　串成3粒+100分;<br>"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;　4粒+250分;<br>"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;　5粒+500分;<br>"
				+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;　6粒+650分;<br>"
				+ "2.　「重新整理」按鈕用於介面上沒有可移動的時候，每次使用會按關卡程度扣分；請小心使用。<br>"
				+ "3.　本遊戲只有普通消除，並沒有特別糖果，請注意<br>"
				+ "4.　為創造新鮮感，上面跟左最邊是不會爆炸的喔~（但可移動）<br>"
				+ "5.　本遊戲的爆破方式只限橫向和縱向喲，並不會同時爆喔∼<br>"
				+ "</html>");
		s.setOpaque(true);
		s.setBounds(20, 80, 400, 400);
		m1.setEditable(false);
		m1.setBounds(100,493,55,20);
		m1.setVisible(false);
		m1.setBackground(Color.lightGray);
		m1.setText(""+mark);
		m2.setEditable(false);
		m2.setBounds(100,513,55,20);
		m2.setVisible(false);
		m2.setBackground(Color.lightGray);
		m3.setEditable(false);
		m3.setBounds(260,493,35,20);
		m3.setVisible(false);
		m3.setBackground(Color.lightGray);
		m4.setEditable(false);
		m4.setBounds(260,513,35,20);
		m4.setVisible(false);
		m4.setBackground(Color.lightGray);
		m5.setEditable(false);
		m5.setBounds(420,493,35,20);
		m5.setVisible(false);
		m5.setBackground(Color.lightGray);
		m6.setEditable(false);
		m6.setBounds(420,493,35,20);
		m6.setVisible(false);
		m6.setBackground(Color.lightGray);

		a15.setLayout(grid);
		a15.setBounds(20, 80, 400, 400);
		a16.setLayout(grid2);
		a16.setBounds(20, 80, 440, 440);
		a17.setLayout(grid3);
		a17.setBounds(20, 80, 480, 480);
		b1.setBounds(20,20,100,45);
		b2.setBounds(140,20,100,45);
		b2.setVisible(false);
		b3.setBounds(260,20,100,45);
		b3.setVisible(false);
		b4.setBounds(140,20,100,45);
		b4.setVisible(false);
		
		Cy.add(m1);
		Cy.add(m2);
		Cy.add(m3);
		Cy.add(m4);
		Cy.add(m5);
		Cy.add(m6);
		Cy.add(mk);
		Cy.add(tgmk);
		Cy.add(place);
		Cy.add(ll);
		Cy.add(sl);
		Cy.add(me);
		Cy.add(te);
		Cy.add(about);
		Cy.add(aboutc);
		Cy.add(s);
		Cy.add(a15);
		Cy.add(a16);
		Cy.add(a17);
		Cy.add(b1);
		Cy.add(b2);
		Cy.add(b3);
		Cy.add(b4);
		Cy.setVisible(true);
		a15.setVisible(false);
		a16.setVisible(false);
		a17.setVisible(false);
		Cy.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){System.exit(0);}
		});
		
	}
		
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		String t3 = m3.getText();				
		
		while (e.getSource() != null)
		{
			if (Integer.parseInt(t3) == 1)
			{
				if (mark <= 400) {
					m4.setText("E");
				} else if ((mark > 400)
						&& (mark <= 800)) {
					m4.setText("D");
				} else if ((mark <= 1300)
						&& (mark > 800)) {
					m4.setText("C");
				} else if ((mark <= 1800)
						&& (mark > 1300)) {
					m4.setText("B");
				} else if ((mark <= 2000)
						&& (mark > 1800)) {
					m4.setText("A");
				} else if (mark > 2000) {
					m4.setText("S");
				}
			}
			else if (Integer.parseInt(t3) == 2)
			{
				m4.setText("E");
				if (mark <= 500) {
					m4.setText("E");
				} else if ((mark > 500)
						&& (mark <= 1300)) {
					m4.setText("D");
				} else if ((mark <= 2100)
						&& (mark > 1300)) {
					m4.setText("C");
				} else if ((mark <= 2600)
						&& (mark > 2100)) {
					m4.setText("B");
				} else if ((mark <= 3000)
						&& (mark > 2600)) {
					m4.setText("A");
				} else if (mark > 3000) {
					m4.setText("S");
				}				
			}
			else if (Integer.parseInt(t3) == 3)
			{
				m4.setText("E");
				if (mark <= 1000) {
					m4.setText("E");
				} else if ((mark > 1000)
						&& (mark <= 1700)) {
					m4.setText("D");
				} else if ((mark <= 2400)
						&& (mark > 1700)) {
					m4.setText("C");
				} else if ((mark <= 3300)
						&& (mark > 2400)) {
					m4.setText("B");
				} else if ((mark <= 4000)
						&& (mark > 3300)) {
					m4.setText("A");
				} else if (mark > 4000) {
					m4.setText("S");
				}				
			}
			else if (Integer.parseInt(t3) == 4)
			{
				if (mark <= 1500) {
					m4.setText("E");
				} else if ((mark > 1500)
						&& (mark <= 2100)) {
					m4.setText("D");
				} else if ((mark <= 3000)
						&& (mark > 2100)) {
					m4.setText("C");
				} else if ((mark <= 4300)
						&& (mark > 3000)) {
					m4.setText("B");
				} else if ((mark <= 2000)
						&& (mark > 4300)) {
					m4.setText("A");
				} else if (mark > 5000) {
					m4.setText("S");
				}				
			}
			if ((Integer.parseInt(t3) == 1)
					&& (mark >= 2000)) 
			{
				y = y + mark;
				if (JOptionPane.showConfirmDialog(Cy, "要進入下一關嗎？", "勝利！",
						JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) 
				{		
					ti = 55;
					t.start();
					mark = mark*0;
					m1.setText("0");
					m2.setText("3000");
					m3.setText("2");
					m4.setText("E");
					a15.setVisible(false);
					a16.setVisible(true);
					Cy.setSize(550, 650);
					mk.setBounds(20,530,70,25); 
					tgmk.setBounds(20,550,70,25); 
					place.setBounds(180,530,70,25); 
					ll.setBounds(180,550,70,25); 
			        about.setBounds(500, 5, 30, 30);
			        aboutc.setBounds(310, 12, 300, 150);
					te.setVisible(true);
					te.setBounds(340,530,70,25);
					m1.setBounds(100,533,55,20);
					m2.setBounds(100,553,55,20);
					m3.setBounds(260,533,35,20);
					m4.setBounds(260,553,35,20);
					m6.setVisible(true);
					m6.setBounds(420,533,35,20);
				} 
				else
				{
					if (JOptionPane.showOptionDialog(Cy,
							"要離開遊戲嗎？", "什麼？",
							JOptionPane.OK_CANCEL_OPTION,
							JOptionPane.INFORMATION_MESSAGE, null,
							new String[] { "對！！", "等等！" },
							"default") == JOptionPane.OK_OPTION)
					{
						System.exit(0);
					}
					else
					{
						b2.setVisible(false);
						b4.setVisible(true);
					}
				}
			} 
			else if ((Integer.parseInt(t3) == 2)
					&& (mark >= 3000)) 
			{
				y = y + mark;
				mark = mark*0;
				System.out.print("wt is mark?"+mark);
				if (JOptionPane.showConfirmDialog(Cy, "要進入下一關嗎？", "勝利！",
						JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) 
				{
					t.stop();
					mark = mark*0;
					m1.setText(""+mark);
					m2.setText("4000");
					m3.setText("3");
					m4.setText("E");
					a16.setVisible(false);
					a17.setVisible(true);
					Cy.setSize(550, 680);
					mk.setBounds(20,570,70,25); 
					tgmk.setBounds(20,590,70,25); 
					place.setBounds(180,570,70,25); 
					ll.setBounds(180,590,70,25);
					te.setVisible(false);
					me.setVisible(true);
					me.setBounds(340,570,70,25);
					m1.setBounds(100,573,55,20);
					m2.setBounds(100,593,55,20);
					m3.setBounds(260,573,35,20);
					m4.setBounds(260,593,35,20);
					m5.setVisible(true);
					m5.setBounds(420,573,35,20);
					m6.setVisible(false);
				} 
				 else
					{
						if (JOptionPane.showOptionDialog(Cy,
								"要離開遊戲嗎？", "什麼？",
								JOptionPane.OK_CANCEL_OPTION,
								JOptionPane.INFORMATION_MESSAGE, null,
								new String[] { "對！！", "等等！" }, 
								"default") == JOptionPane.OK_OPTION)
						{
							System.exit(0);
						}
						else
						{
							b2.setVisible(false);
							b4.setVisible(true);
						}
					}
			} 
			else if ((Integer.parseInt(t3) == 3)
					&& (mark >= 4000)) 
			{
				y = y + mark;
				if (k == 0) 
				{
					if (JOptionPane.showConfirmDialog(Cy, "要進入下一關嗎？",
							"勝利！", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) 
					{							
						ti= 20;
						t.start();
						fpj.stop();
						jp.play();
						mark = mark*0;
						m1.setText(""+mark);
						m2.setText("5000");
						m3.setBounds(260,573,35,20);
						m3.setText("4");
						m4.setText("E");
						sl.setVisible(true);
						te.setVisible(true);
						me.setVisible(true);
						m5.setVisible(true);
						te.setBounds(340, 590, 70, 25);
						m6.setVisible(true);
						m6.setBounds(420, 593, 35, 20);
					} 
					 else
						{
							if (JOptionPane.showOptionDialog(Cy,
									"要離開遊戲嗎？", "什麼？",
									JOptionPane.OK_CANCEL_OPTION,
									JOptionPane.INFORMATION_MESSAGE, null,
									new String[] { "對！！", "等等！" }, 
									"default") == JOptionPane.OK_OPTION)
							{
								System.exit(0);
							}
							else
							{
								b2.setVisible(false);
								b4.setVisible(true);
							}
						}
				}
				if (k != 0) 
				{
					 AudioClip huy = loadSound ("cheers2.wav"); 
					 huy.play();
					 fpj.stop();
					if (JOptionPane.showOptionDialog(Cy,
							"你已完成全部關卡！\n你的總分為:"+y+"\n要停留還是離開？", "恭喜你！",
							JOptionPane.OK_CANCEL_OPTION,
							JOptionPane.INFORMATION_MESSAGE, null,
							new String[] { "停留一下...", "再見" },
							"default") == JOptionPane.OK_OPTION) 
					{    
						int name=JOptionPane.INFORMATION_MESSAGE;
						String in1=JOptionPane.showInputDialog(Cy,"請輸入姓名","輸入",name);
						for (int r = 1;r<=9;r++)
						{
							int score = (int) rkg.getValueAt(r, 2);
							if (y > score) 
							{
								score = y;
								data[r][2]=y;
								data[r][1]=in1;//更新資料來源
								break;
							}
							else if (y == score)
							{
								score = y;
								data[r+1][2]=y;
								data[r+1][1]=in1;//更新資料來源
								break;
							}
						}
						ranking.setVisible(true);
						ranking.setAlwaysOnTop(true);							
						if (JOptionPane.showOptionDialog(Cy,
								"你要重新開始嗎？", "　",
								JOptionPane.OK_CANCEL_OPTION,
								JOptionPane.INFORMATION_MESSAGE, null,
								new String[] { "重新開始！", "我才不要∼" },
								"default") == JOptionPane.OK_OPTION) 
						{
							fpj.play();
							ranking.setVisible(false);
							s.setVisible(false);
							a15.setVisible(true);
							a17.setVisible(false);
							b2.setEnabled(true);
							b2.setVisible(true);
							b3.setVisible(true);
							mk.setVisible(true);
							tgmk.setVisible(true);
							place.setVisible(true);
							ll.setVisible(true);
							me.setVisible(false);
							m1.setVisible(true);
							m2.setVisible(true);
							m3.setVisible(true);
							m4.setVisible(true);
							m5.setVisible(false);
							mk.setBounds(20,490,70,25); 
							tgmk.setBounds(20,510,70,25); 
							place.setBounds(180,490,70,25); 
							ll.setBounds(180,510,70,25); 
							m1.setBounds(100,493,55,20);
							m2.setBounds(100,513,55,20);
							m3.setBounds(260,493,35,20);
							m4.setBounds(260,513,35,20);
							Cy.setSize(500, 600);
							m1.setText(""+mark);
							m2.setText("3000");
							m3.setText("1");
							y = 0;								
						}
						else
						{
							if (JOptionPane.showOptionDialog(Cy,
									"你要離開嗎？", "　",
									JOptionPane.OK_CANCEL_OPTION,
									JOptionPane.INFORMATION_MESSAGE, null,
									new String[] { "對！！", "還不要" },
									"default") == JOptionPane.OK_OPTION)
							{
								System.exit(0);
							}
							else
							{
								b2.setEnabled(false);
							}
						}
					} 
					else 
					{
						if (JOptionPane.showOptionDialog(Cy,
								"你要離開嗎？", "　",
								JOptionPane.OK_CANCEL_OPTION,
								JOptionPane.INFORMATION_MESSAGE, null,
								new String[] { "對！！", "還不要" },
								"default") == JOptionPane.OK_OPTION)
						{
							System.exit(0);
						}
						else
						{
							b2.setEnabled(false);
						}
					}
				}
			}
			else if  ((Integer.parseInt(t3) == 4)
					&& (mark >= 5000)) 
			{
				t.stop();
				 fpj.stop();
				 AudioClip huy2 = loadSound ("cheers3.wav"); 
				 huy2.play();
				b2.setEnabled(false);
				y = y + mark;
				if (JOptionPane.showOptionDialog(Cy,
						"你已完成全部關卡！\n你的總分為:"+y+"\n要停留還是離開？", "恭喜你！",
						JOptionPane.OK_CANCEL_OPTION,
						JOptionPane.INFORMATION_MESSAGE, null,
						new String[] { "停留一下...", "再見" },
						"default") == JOptionPane.OK_OPTION) 
				{    
					int name=JOptionPane.INFORMATION_MESSAGE;
					String in1=JOptionPane.showInputDialog(Cy,"請輸入姓名","輸入",name);
					for (int r = 1;r<=9;r++)
					{
						int score = (int) rkg.getValueAt(r, 2);
						if (y > score) 
						{
							score = y;
							data[r][2]=y;
							data[r][1]=in1;//更新資料來源
							break;
						}
						else if (y == score)
						{
							score = y;
							data[r+1][2]=y;
							data[r+1][1]=in1;//更新資料來源
							break;
						}
					}
					ranking.setVisible(true);
					ranking.setAlwaysOnTop(true);							
					if (JOptionPane.showOptionDialog(Cy,
							"你要重新開始嗎？", "　",
							JOptionPane.OK_CANCEL_OPTION,
							JOptionPane.INFORMATION_MESSAGE, null,
							new String[] { "重新開始！", "我才不要∼" },
							"default") == JOptionPane.OK_OPTION) 
					{
						fpj.play();
						ranking.setVisible(false);
						s.setVisible(false);
						a15.setVisible(true);
						a17.setVisible(false);
						b2.setEnabled(true);
						b2.setVisible(true);
						b3.setVisible(true);
						mk.setVisible(true);
						tgmk.setVisible(true);
						place.setVisible(true);
						ll.setVisible(true);
						me.setVisible(false);
						m1.setVisible(true);
						m2.setVisible(true);
						m3.setVisible(true);
						m4.setVisible(true);
						m5.setVisible(false);
						mk.setBounds(20,490,70,25); 
						tgmk.setBounds(20,510,70,25); 
						place.setBounds(180,490,70,25); 
						ll.setBounds(180,510,70,25); 
						m1.setBounds(100,493,55,20);
						m2.setBounds(100,513,55,20);
						m3.setBounds(260,493,35,20);
						m4.setBounds(260,513,35,20);
						Cy.setSize(500, 600);
						m1.setText("0");
						m2.setText("3000");
						m3.setText("1");
						y = 0;								
					}
					else
					{
						if (JOptionPane.showOptionDialog(Cy,
								"你要離開嗎？", "　",
								JOptionPane.OK_CANCEL_OPTION,
								JOptionPane.INFORMATION_MESSAGE, null,
								new String[] { "對！！", "還不要" },
								"default") == JOptionPane.OK_OPTION)
						{
							System.exit(0);
						}
						else
						{
							b2.setEnabled(false);
						}
					}
				} 
			}
			
			
				if (e.getSource() == b1)
				{
					s.setVisible(false);
					a15.setVisible(true);
					b2.setVisible(true);
					b3.setVisible(true);
					mk.setVisible(true);
					tgmk.setVisible(true);
					place.setVisible(true);
					ll.setVisible(true);
					m1.setVisible(true);
					m2.setVisible(true);
					m3.setVisible(true);
					m4.setVisible(true);
					b1.setEnabled(false);
				}
				
				if (e.getSource() == b3)
				{
					if (JOptionPane.showOptionDialog(Cy,
							"你要退出遊戲嗎？", "注意！",
							JOptionPane.OK_CANCEL_OPTION,
							JOptionPane.INFORMATION_MESSAGE, null,
							new String[] { "對啊", "等等..." }, 
							"default") == JOptionPane.OK_OPTION) 
					{
						System.exit(0);
					}
				}
				
				if (e.getSource() == b4)
				{
							b2.setVisible(true);
							b4.setVisible(false);
					if ((Integer.parseInt(t3) == 1)
							&& (mark >= 3000)) 
					{
							m1.setText("0");
							m2.setText("4000");
							m3.setText("2");
							a15.setVisible(false);
							a16.setVisible(true);
							Cy.setSize(550, 650);
							mk.setBounds(20,530,70,25); 
							tgmk.setBounds(20,550,70,25); 
							place.setBounds(180,530,70,25); 
							ll.setBounds(180,550,70,25); 
							te.setVisible(true);
							te.setBounds(340,530,70,25);
							m1.setBounds(100,533,55,20);
							m2.setBounds(100,553,55,20);
							m3.setBounds(260,533,35,20);
							m4.setBounds(260,553,35,20);
							m6.setVisible(true);
							m6.setBounds(420,533,35,20);
					}
					if ((Integer.parseInt(t3) == 2)
							&& (mark >= 4000)) 
					{
							m1.setText("0");
							m2.setText("5000");
							m3.setText("3");
							a16.setVisible(false);
							a17.setVisible(true);
							Cy.setSize(550, 680);
							mk.setBounds(20,570,70,25); 
							tgmk.setBounds(20,590,70,25); 
							place.setBounds(180,570,70,25); 
							ll.setBounds(180,590,70,25); 
							te.setVisible(false);
							me.setVisible(true);
							me.setBounds(340,570,70,25);
							m1.setBounds(100,573,55,20);
							m2.setBounds(100,593,55,20);
							m3.setBounds(260,573,35,20);
							m4.setBounds(260,593,35,20);
							m6.setVisible(false);
					}
					if ((Integer.parseInt(t3) == 3)
							&& (mark >= 5000)) 
					{
							m1.setText("0");
							m2.setText("6000");
							m3.setBounds(300, 493, 55, 20);
							m3.setText("4");
							m4.setText("E");
							a16.setVisible(true);
							sl.setVisible(true);
							te.setVisible(true);
							me.setVisible(true);
							m5.setVisible(true);
							te.setBounds(340, 590, 70, 25);
							m6.setVisible(true);
							m6.setBounds(420, 593, 35, 20);
					}
				}				
				
			while (e.getSource() == b2) 
			{
				if (Integer.parseInt(t3) == 1)
				{
					mark = mark - 10;
					m1.setText("" + (mark));
					for (int r = 0; r < 10; r++) 
					{
						for (int c = 0; c < 10; c++) 
						{
						B[r][c].row = r;
						B[r][c].col = c;
						B[r][c].color = (int) ((Math.random() * 8));
						int cc = B[r][c].color;
						if ((c>0) && (c<10))
						{
								if (B[r][c-1].color == B[r][c].color) {
									B[r][c].color = (int) ((Math.random() * 8));
									cc = B[r][c].color;// c = 0,1,2
									B[r][c].setIcon( imgs[cc] );			
								}
								
						}
						if ((r > 0 && c>0) && (r<10 && c<10))
						{
								if ((B[r][c - 1].color == B[r][c].color)
										|| (B[r -1][c].color == B[r][c].color)) {
									B[r][c].color = (int) ((Math.random() * 8));
									cc = B[r][c].color;// c = 0,1,2
									B[r][c].setIcon( imgs[cc] );			
								}
						}
						B[r][c].setIcon(imgs[cc]);
						B[r][c].addActionListener(Cy);
						a15.add(B[r][c]);
						k = k + 1;
						}
					}
					for (int r = 0; r < 10; r++) 
					{
						for (int c = 0; c < 10; c++) 
						{
						B[r][c].row = r;
						B[r][c].col = c;
						B[r][c].color = (int) ((Math.random() * 8));
						int cc = B[r][c].color;
						if ((c>0) && (c<10))
						{
								if (B[r][c-1].color == B[r][c].color) {
									B[r][c].color = (int) ((Math.random() * 8));
									cc = B[r][c].color;// c = 0,1,2
									B[r][c].setIcon( imgs[cc] );			
								}
								
						}
						if ((r > 0 && c>0) && (r<10 && c<10))
						{
								if ((B[r][c - 1].color == B[r][c].color)
										|| (B[r -1][c].color == B[r][c].color)) {
									B[r][c].color = (int) ((Math.random() * 8));
									cc = B[r][c].color;// c = 0,1,2
									B[r][c].setIcon( imgs[cc] );			
								}
						}
						B[r][c].setIcon(imgs[cc]);
						B[r][c].addActionListener(Cy);
						a15.add(B[r][c]);
						k = k + 1;
						}
					}
				}
			
				 if (Integer.parseInt(t3) == 2)
				{
						mark = mark - 20;
					m1.setText("" + mark);
					for (int r = 0; r < 11; r++) 
					{
						for (int c = 0; c < 11; c++) 
						{	
						C[r][c].row = r;
						C[r][c].col = c;			
						C[r][c].color = (int) ((Math.random() * 9));
						int cc = C[r][c].color;
						if ((c>0) && (c<11))
						{
								if (C[r][c-1].color == C[r][c].color) {
									C[r][c].color = (int) ((Math.random() * 8));
									cc = C[r][c].color;// c = 0,1,2
									C[r][c].setIcon( imgs[cc] );			
								}
								
						}
						if ((r > 0 && c>0) && (r<11 && c<11))
						{
								if ((C[r][c - 1].color == C[r][c].color)
										|| (C[r -1][c].color == C[r][c].color)) {
									C[r][c].color = (int) ((Math.random() * 8));
									cc = C[r][c].color;// c = 0,1,2
									C[r][c].setIcon( imgs[cc] );			
								}
						}
						C[r][c].setIcon( imgs[cc] );			
						C[r][c].addActionListener(Cy);
						a16.add(C[r][c]);
						k = k + 1;
						}
					}
					for (int r = 0; r < 11; r++) 
					{
						for (int c = 0; c < 11; c++) 
						{	
						C[r][c].row = r;
						C[r][c].col = c;			
						C[r][c].color = (int) ((Math.random() * 9));
						int cc = C[r][c].color;
						if ((c>0) && (c<11))
						{
								if (C[r][c-1].color == C[r][c].color) {
									C[r][c].color = (int) ((Math.random() * 8));
									cc = C[r][c].color;// c = 0,1,2
									C[r][c].setIcon( imgs[cc] );			
								}
								
						}
						if ((r > 0 && c>0) && (r<11 && c<11))
						{
								if ((C[r][c - 1].color == C[r][c].color)
										|| (C[r -1][c].color == C[r][c].color)) {
									C[r][c].color = (int) ((Math.random() * 8));
									cc = C[r][c].color;// c = 0,1,2
									C[r][c].setIcon( imgs[cc] );			
								}
						}
						C[r][c].setIcon( imgs[cc] );			
						C[r][c].addActionListener(Cy);
						a16.add(C[r][c]);
						k = k + 1;
				
						}
					}
					for (int r = 0; r < 11; r++) 
					{
						for (int c = 0; c < 11; c++) 
						{	
						C[r][c].row = r;
						C[r][c].col = c;			
						C[r][c].color = (int) ((Math.random() * 9));
						int cc = C[r][c].color;
						C[r][c].setIcon( imgs[cc] );			
						C[r][c].addActionListener(Cy);
						a16.add(C[r][c]);
						k = k + 1;
					
						}
					}
				}
				 if (Integer.parseInt(t3) == 3)
				{
						mark = mark - 30;
					m1.setText("" + (mark));
					for (int r = 0; r < 12; r++) 
					{
						for (int c = 0; c < 12; c++) 
						{	
						D[r][c].row = r;
						D[r][c].col = c;			
						D[r][c].color = (int) ((Math.random() * 10));
						int cc = D[r][c].color;
						D[r][c].setIcon( imgs[cc] );
						if ((c>0) && (c<12))
						{
								if (D[r][c-1].color == D[r][c].color) {
									D[r][c].color = (int) ((Math.random() * 8));
									cc = D[r][c].color;// c = 0,1,2
									D[r][c].setIcon( imgs[cc] );			
								}
								
						}
						if ((r > 0 && c>0) && (r<12 && c<12))
						{
								if ((D[r][c - 1].color == D[r][c].color)
										|| (D[r -1][c].color == D[r][c].color)) {
									D[r][c].color = (int) ((Math.random() * 8));
									cc = D[r][c].color;// c = 0,1,2
									D[r][c].setIcon( imgs[cc] );			
								}
						}			
						D[r][c].addActionListener(Cy);
						a17.add(D[r][c]);
						k = k + 1;
				
						}
					}
					for (int r = 0; r < 12; r++) 
					{
						for (int c = 0; c < 12; c++) 
						{	
						D[r][c].row = r;
						D[r][c].col = c;			
						D[r][c].color = (int) ((Math.random() * 10));
						int cc = D[r][c].color;
						D[r][c].setIcon( imgs[cc] );	
						if ((c>0) && (c<12))
						{
								if (D[r][c-1].color == D[r][c].color) {
									D[r][c].color = (int) ((Math.random() * 8));
									cc = D[r][c].color;// c = 0,1,2
									D[r][c].setIcon( imgs[cc] );			
								}
								
						}
						if ((r > 0 && c>0) && (r<12 && c<12))
						{
								if ((D[r][c - 1].color == D[r][c].color)
										|| (D[r -1][c].color == D[r][c].color)) {
									D[r][c].color = (int) ((Math.random() * 8));
									cc = D[r][c].color;// c = 0,1,2
									D[r][c].setIcon( imgs[cc] );			
								}
						}		
						D[r][c].addActionListener(Cy);
						a17.add(D[r][c]);
						k = k + 1;
		
						}
					}
				}
				 if (Integer.parseInt(t3) == 4)
				{
						mark = mark - 40;
					m1.setText("" + (mark));
					for (int r = 0; r < 12; r++) 
					{
						for (int c = 0; c < 12; c++) 
						{	
						D[r][c].row = r;
						D[r][c].col = c;			
						D[r][c].color = (int) ((Math.random() * 10));
						int cc = D[r][c].color;
						D[r][c].setIcon( imgs[cc] );			
						D[r][c].addActionListener(Cy);
						a17.add(D[r][c]);
						k = k + 1;
						}
					}
					for (int r = 0; r < 12; r++) 
					{
						for (int c = 0; c < 12; c++) 
						{	
						D[r][c].row = r;
						D[r][c].col = c;			
						D[r][c].color = (int) ((Math.random() * 10));
						int cc = D[r][c].color;
						D[r][c].setIcon( imgs[cc] );			
						D[r][c].addActionListener(Cy);
						a17.add(D[r][c]);
						k = k + 1;
						}
					}
				}
				break;
			}
			while (
				  ((e.getSource() != b1) && (e.getSource() != b2) && (e.getSource() != b3) && (e.getSource() != b4)) 
				  && (e.getSource() == (MyJButton) (e.getSource()))
				  ) 
			{
				MyJButton jbn = (MyJButton) (e.getSource());
				jbn.validate();
					int r = jbn.row;
					int c = jbn.col;
					if (counter == 0) 
					{
						counter = 1;// 第一點
						r1 = r;
						c1 = c;
						AudioInputStream audioInputStream;
						Clip clip;
					try {
						audioInputStream = AudioSystem.getAudioInputStream(
							    new File("0137.wav"));
							clip = AudioSystem.getClip();
							clip.open(audioInputStream);
						FloatControl gainControl = 
						    (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
						gainControl.setValue(-20.0f); // Reduce volume by 10 decibels.
						clip.start();
					} catch (UnsupportedAudioFileException
							| IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}catch (LineUnavailableException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
					}
					} 
					else if (counter == 1) 
					{
						counter = 0;// 第二點
						r2 = r;
						c2 = c;

						if ((r2 == r1 + 1 && c1 == c2)
								|| (r2 == r1 - 1 && c1 == c2)
								|| (c2 == c1 + 1 && r1 == r2)
								|| (c2 == c1 - 1 && r1 == r2)) 
						{
							AudioInputStream audioInputStream;
								Clip clip;
							try {
								audioInputStream = AudioSystem.getAudioInputStream(
									    new File("0137.wav"));
									clip = AudioSystem.getClip();
									clip.open(audioInputStream);
								FloatControl gainControl = 
								    (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
								gainControl.setValue(-20.0f); // Reduce volume by 10 decibels.
								clip.start();
							} catch (UnsupportedAudioFileException
									| IOException e1) {
								e1.printStackTrace();
							}catch (LineUnavailableException e1) {
									e1.printStackTrace();
							}
							
							if (Integer.parseInt(t3) == 1)
							{
							int temp = B[r1][c1].color;
							B[r1][c1].color = B[r2][c2].color;
							B[r2][c2].color = temp;
							int cc;
							cc = B[r1][c1].color;
							B[r1][c1].setIcon(imgs[cc]);
							cc = B[r2][c2].color;
							B[r2][c2].setIcon(imgs[cc]);
							if (((r1>0 && r1<10) && (c1>0 && c1<10)) &&  ((r2>0 && r2<10) && (c2>0 && c2<10)))
							{
								for (int i = 1; i < 10; i++) {
									for (int j = 1; j < 10; j++) {
										if (B[i][j - 1].color == B[i][j].color) {
											ex = ex+1;
											System.out.print("\n當一橫有相同時::"+ex+",");
										}
										if (B[i][j - 1].color != B[i][j].color){
											if (ex == 2) {
												System.out.print("\nex=2:(3連):"+ex+",");
												System.out.print("\n");
												mark=mark +150;
												m1.setText(""
														+ (mark));
												ex = 0;
												if (j == 1) {
													B[i - 1][8]
															.setVisible(false);
													B[i - 1][7]
															.setVisible(false);
													B[i - 1][9]
															.setVisible(false);
													B[i - 1][8].color = 9880;
													B[i - 1][7].color = 8770;
													B[i - 1][9].color = 7660;
												} else {
													B[i][j - 1]
															.setVisible(false);
													B[i][j - 2]
															.setVisible(false);
													B[i][j - 3]
															.setVisible(false);
													B[i][j - 1].color = 9888;
													B[i][j - 2].color = 8777;
													B[i][j - 3].color = 7666;
												}
											}
											if (ex == 3) {
												System.out.print("\nex=3:(4連):"+ex+",");
												mark=mark +300;
												m1.setText(""
														+ (mark));
												ex = 0;
												if (j == 1) {
													B[i - 1][8]
															.setVisible(false);
													B[i - 1][7]
															.setVisible(false);
													B[i - 1][9]
															.setVisible(false);
													B[i - 1][6]
															.setVisible(false);
													B[i - 1][8].color = 9880;
													B[i - 1][7].color = 8770;
													B[i - 1][9].color = 7660;
													B[i - 1][6].color = 6550;
												} else {
													B[i][j - 1]
															.setVisible(false);
													B[i][j - 2]
															.setVisible(false);
													B[i][j - 3]
															.setVisible(false);
													B[i][j - 4]
															.setVisible(false);
													B[i][j - 1].color = 9888;
													B[i][j - 2].color = 8777;
													B[i][j - 3].color = 7666;
													B[i][j - 4].color = 6555;
												}
												System.out.print("\n");
											}
											if (ex == 4) {
												System.out.print("\nex=4:(5連):"+ex+",");
												mark=mark +550;
												m1.setText(""
														+ (mark));
												ex = 0;
												if (j == 1) {
													B[i - 1][8]
															.setVisible(false);
													B[i - 1][7]
															.setVisible(false);
													B[i - 1][9]
															.setVisible(false);
													B[i - 1][6]
															.setVisible(false);
													B[i - 1][5]
															.setVisible(false);
													B[i - 1][8].color = 9880;
													B[i - 1][7].color = 8770;
													B[i - 1][9].color = 7660;
													B[i - 1][6].color = 6550;
													B[i - 1][5].color = 5440;
												} else {
													B[i][j - 1]
															.setVisible(false);
													B[i][j - 2]
															.setVisible(false);
													B[i][j - 3]
															.setVisible(false);
													B[i][j - 4]
															.setVisible(false);
													B[i][j - 5]
															.setVisible(false);
													B[i][j - 1].color = 9888;
													B[i][j - 2].color = 8777;
													B[i][j - 3].color = 7666;
													B[i][j - 4].color = 6555;
													B[i][j - 5].color = 5444;
												}
											}
											if (ex == 5) {
												mark=mark +650;
												m1.setText(""
														+ (mark));
												ex = 0;
												if (j == 1) {
													B[i - 1][8]
															.setVisible(false);
													B[i - 1][7]
															.setVisible(false);
													B[i - 1][9]
															.setVisible(false);
													B[i - 1][6]
															.setVisible(false);
													B[i - 1][5]
															.setVisible(false);
													B[i - 1][4]
															.setVisible(false);
													B[i - 1][8].color = 54631;
													B[i - 1][7].color = 8770;
													B[i - 1][9].color = 4529;
													B[i - 1][6].color = 123;
													B[i - 1][5].color = 1231;
													B[i - 1][4].color = 789;
												} else {
													B[i][j - 1]
															.setVisible(false);
													B[i][j - 2]
															.setVisible(false);
													B[i][j - 3]
															.setVisible(false);
													B[i][j - 4]
															.setVisible(false);
													B[i][j - 5]
															.setVisible(false);
													B[i][j - 6]
															.setVisible(false);
													B[i][j - 1].color = 9888;
													B[i][j - 2].color = 52635;
													B[i][j - 3].color = 7666;
													B[i][j - 4].color = 23;
													B[i][j - 5].color = 5444;
													B[i][j - 6].color = 12456;
												}
											}
											ex = 0;
										}
									}									
								}
								for (int j = 1; j < 10; j++) {									
									for (int i = 1; i < 10; i++) {
										if (B[i - 1][j].color == B[i][j].color) {
											xe = xe+1;
											System.out.print("\n當|直有相同時::"+xe+",");
										}
										if (B[i - 1][j].color != B[i][j].color){
											if (xe == 2) {
												System.out.print("\nxe=2:(3連):"+xe+",");
												mark=mark +150;
												m1.setText(""
														+ (mark));
												xe = 0;
												if (i == 1) {
													B[8][j - 1]
															.setVisible(false);
													B[7][j - 1]
															.setVisible(false);
													B[9][j - 1]
															.setVisible(false);
													B[8][j - 1].color = 9880;
													B[7][j - 1].color = 8770;
													B[9][j - 1].color = 7660;
												} else {
												B[i-1][j].setVisible(false);
												B[i-2][j].setVisible(false);
												B[i-3][j].setVisible(false);
												B[i-1][j].color=9999;
												B[i-2][j].color=8888;
												B[i-3][j].color=7777;
												}
												System.out.print("\n");
											}
											if (xe == 3) {
												System.out.print("\nxe=3:(4連):"+xe+",");
												mark=mark +300;
												m1.setText(""
														+ (mark));
												xe = 0;
												if (i == 1) {
													B[8][j - 1]
															.setVisible(false);
													B[7][j - 1]
															.setVisible(false);
													B[9][j - 1]
															.setVisible(false);
													B[6][j - 1]
															.setVisible(false);
													B[8][j - 1].color = 9880;
													B[7][j - 1].color = 8770;
													B[9][j - 1].color = 7660;
													B[6][j - 1].color = 6550;
												} else {
												B[i-1][j].setVisible(false);
												B[i-2][j].setVisible(false);
												B[i-3][j].setVisible(false);
												B[i-4][j].setVisible(false);
												B[i-1][j].color=9999;
												B[i-2][j].color=8888;
												B[i-3][j].color=7777;
												B[i-4][j].color=6666;
												}
												System.out.print("\n");
											}
											if (xe == 4) {
												System.out.print("\nxe=4:(5連):"+xe+",");
												mark=mark +550;
												m1.setText(""
														+ (mark));
												xe = 0;
												if (i == 1) {
													B[8][j - 1]
															.setVisible(false);
													B[7][j - 1]
															.setVisible(false);
													B[9][j - 1]
															.setVisible(false);
													B[6][j - 1]
															.setVisible(false);
													B[5][j - 1]
															.setVisible(false);
													B[8][j - 1].color = 9880;
													B[7][j - 1].color = 8770;
													B[9][j - 1].color = 7660;
													B[6][j - 1].color = 6550;
													B[5][j - 1].color = 6550;
												} else {
												B[i-1][j].setVisible(false);
												B[i-2][j].setVisible(false);
												B[i-3][j].setVisible(false);
												B[i-4][j].setVisible(false);
												B[i-5][j].setVisible(false);
												B[i-1][j].color=82592;
												B[i-2][j].color=1278;
												B[i-3][j].color=789;
												B[i-4][j].color=8456;
												B[i-5][j].color=105;
												}
											}
											if (xe == 5) {
												mark=mark +650;
												m1.setText(""
														+ (mark));
												xe = 0;
												if (i == 1) {
													B[8][j - 1]
															.setVisible(false);
													B[7][j - 1]
															.setVisible(false);
													B[9][j - 1]
															.setVisible(false);
													B[6][j - 1]
															.setVisible(false);
													B[5][j - 1]
															.setVisible(false);
													B[4][j - 1]
															.setVisible(false);
													B[8][j - 1].color = 12370;
													B[7][j - 1].color = 8770;
													B[9][j - 1].color = 7254;
													B[6][j - 1].color = 6550;
													B[5][j - 1].color = 450;
													B[4][j - 1].color = 6550;
												} else {
												B[i-1][j].setVisible(false);
												B[i-2][j].setVisible(false);
												B[i-3][j].setVisible(false);
												B[i-4][j].setVisible(false);
												B[i-5][j].setVisible(false);
												B[i-6][j].setVisible(false);
												B[i-1][j].color=82592;
												B[i-2][j].color=546;
												B[i-3][j].color=789;
												B[i-4][j].color=213;
												B[i-5][j].color=860;
												B[i-6][j].color=48;
												}
											}
											xe = 0;
										}
									}									
								}
								
								if (ex < 2){
									mark = mark - 20;
									m1.setText("" + (mark));
									ex = 0;
									fu = fu + 1;
								}
								else if (xe < 2) {
									mark = mark - 20;
									m1.setText("" + (mark));
									xe = 0;
									ck = ck + 1;
								}
								if ((ex > 1) && (xe > 1))
								{
									mark = mark - 20;
									System.out.print("wt the fuck?: " + mark);
									m1.setText("" + (mark));
								}
								ex = 0;
								xe = 0;
							}
							ex = 0;
							xe = 0;
							}
							else if (Integer.parseInt(t3) == 2)
							{
								mark = 0;
							int temp1 = C[r1][c1].color;
							C[r1][c1].color = C[r2][c2].color;
							C[r2][c2].color = temp1;
							int cc1;
							cc1 = C[r1][c1].color;
							C[r1][c1].setIcon(imgs[cc1]);
							cc1 = C[r2][c2].color;
							C[r2][c2].setIcon(imgs[cc1]);
							if (((r1>0 && r1<11) && (c1>0 && c1<11)) &&  ((r2>0 && r2<11) && (c2>0 && c2<11)))
							{
								for (int i = 1; i < 11; i++) {
									for (int j = 1; j < 11; j++) {
										if (C[i][j - 1].color == C[i][j].color) {
											ex = ex+1;
											System.out.print("\n當一橫有相同時::"+ex+",");
										}
										if (C[i][j - 1].color != C[i][j].color){
											if (ex == 2) {
												System.out.print("\nex=2:(3連):"+ex+",");
												System.out.print("\n");
												mark=mark +150;
												m1.setText(""
														+ (mark));
												ex = 0;
												if (j == 1) {
													C[i - 1][9]
															.setVisible(false);
													C[i - 1][8]
															.setVisible(false);
													C[i - 1][10]
															.setVisible(false);
													C[i - 1][9].color = 9880;
													C[i - 1][8].color = 8770;
													C[i - 1][10].color = 7660;
												} else {
													C[i][j - 1]
															.setVisible(false);
													C[i][j - 2]
															.setVisible(false);
													C[i][j - 3]
															.setVisible(false);
													C[i][j - 1].color = 9888;
													C[i][j - 2].color = 8777;
													C[i][j - 3].color = 7666;
												}
											}
											if (ex == 3) {
												System.out.print("\nex=3:(4連):"+ex+",");
												mark=mark +300;
												m1.setText(""
														+ (mark));
												ex = 0;
												if (j == 1) {
													C[i - 1][8]
															.setVisible(false);
													C[i - 1][7]
															.setVisible(false);
													C[i - 1][9]
															.setVisible(false);
													C[i - 1][6]
															.setVisible(false);
													C[i - 1][8].color = 9880;
													C[i - 1][7].color = 8770;
													C[i - 1][9].color = 7660;
													C[i - 1][6].color = 6550;
												} else {
													C[i][j - 1]
															.setVisible(false);
													C[i][j - 2]
															.setVisible(false);
													C[i][j - 3]
															.setVisible(false);
													C[i][j - 4]
															.setVisible(false);
													C[i][j - 1].color = 9888;
													C[i][j - 2].color = 8777;
													C[i][j - 3].color = 7666;
													C[i][j - 4].color = 6555;
												}
												System.out.print("\n");
											}
											if (ex == 4) {
												System.out.print("\nex=4:(5連):"+ex+",");
												mark=mark +550;
												m1.setText(""
														+ (mark));
												ex = 0;
												if (j == 1) {
													C[i - 1][8]
															.setVisible(false);
													C[i - 1][7]
															.setVisible(false);
													C[i - 1][9]
															.setVisible(false);
													C[i - 1][6]
															.setVisible(false);
													C[i - 1][5]
															.setVisible(false);
													C[i - 1][8].color = 9880;
													C[i - 1][7].color = 8770;
													C[i - 1][9].color = 7660;
													C[i - 1][6].color = 6550;
													C[i - 1][5].color = 5440;
												} else {
													C[i][j - 1]
															.setVisible(false);
													C[i][j - 2]
															.setVisible(false);
													C[i][j - 3]
															.setVisible(false);
													C[i][j - 4]
															.setVisible(false);
													C[i][j - 5]
															.setVisible(false);
													C[i][j - 1].color = 9888;
													C[i][j - 2].color = 8777;
													C[i][j - 3].color = 7666;
													C[i][j - 4].color = 6555;
													C[i][j - 5].color = 5444;
												}
											}
											if (ex == 5) {
												mark=mark +650;
												m1.setText(""
														+ (mark));
												ex = 0;
												if (j == 1) {
													C[i - 1][8]
															.setVisible(false);
													C[i - 1][7]
															.setVisible(false);
													C[i - 1][9]
															.setVisible(false);
													C[i - 1][6]
															.setVisible(false);
													C[i - 1][5]
															.setVisible(false);
													C[i - 1][4]
															.setVisible(false);
													C[i - 1][8].color = 54631;
													C[i - 1][7].color = 8770;
													C[i - 1][9].color = 4529;
													C[i - 1][6].color = 123;
													C[i - 1][5].color = 1231;
													C[i - 1][4].color = 789;
												} else {
													C[i][j - 1]
															.setVisible(false);
													C[i][j - 2]
															.setVisible(false);
													C[i][j - 3]
															.setVisible(false);
													C[i][j - 4]
															.setVisible(false);
													C[i][j - 5]
															.setVisible(false);
													C[i][j - 6]
															.setVisible(false);
													C[i][j - 1].color = 9888;
													C[i][j - 2].color = 52635;
													C[i][j - 3].color = 7666;
													C[i][j - 4].color = 23;
													C[i][j - 5].color = 5444;
													C[i][j - 6].color = 12456;
												}
											}
											ex = 0;
										}
									}									
								}
								for (int j = 1; j < 10; j++) {									
									for (int i = 1; i < 10; i++) {
										if (C[i - 1][j].color == C[i][j].color) {
											xe = xe+1;
											System.out.print("\n當|直有相同時::"+xe+",");
										}
										if (C[i - 1][j].color != C[i][j].color){
											if (xe == 2) {
												System.out.print("\nxe=2:(3連):"+xe+",");
												mark=mark +150;
												m1.setText(""
														+ (mark));
												xe = 0;
												if (i == 1) {
													C[9][j - 1]
															.setVisible(false);
													C[8][j - 1]
															.setVisible(false);
													C[10][j - 1]
															.setVisible(false);
													C[9][j - 1].color = 9880;
													C[8][j - 1].color = 8770;
													C[10][j - 1].color = 7660;
												} else {
												C[i-1][j].setVisible(false);
												C[i-2][j].setVisible(false);
												C[i-3][j].setVisible(false);
												C[i-1][j].color=9999;
												C[i-2][j].color=8888;
												C[i-3][j].color=7777;
												}
												System.out.print("\n");
											}
											if (xe == 3) {
												System.out.print("\nxe=3:(4連):"+xe+",");
												mark=mark +300;
												m1.setText(""
														+ (mark));
												xe = 0;
												if (i == 1) {
													C[8][j - 1]
															.setVisible(false);
													C[7][j - 1]
															.setVisible(false);
													C[9][j - 1]
															.setVisible(false);
													C[6][j - 1]
															.setVisible(false);
													C[8][j - 1].color = 9880;
													C[7][j - 1].color = 8770;
													C[9][j - 1].color = 7660;
													C[6][j - 1].color = 6550;
												} else {
												C[i-1][j].setVisible(false);
												C[i-2][j].setVisible(false);
												C[i-3][j].setVisible(false);
												C[i-4][j].setVisible(false);
												C[i-1][j].color=9999;
												C[i-2][j].color=8888;
												C[i-3][j].color=7777;
												C[i-4][j].color=6666;
												}
												System.out.print("\n");
											}
											if (xe == 4) {
												System.out.print("\nxe=4:(5連):"+xe+",");
												mark=mark +550;
												m1.setText(""
														+ (mark));
												xe = 0;
												if (i == 1) {
													C[8][j - 1]
															.setVisible(false);
													C[7][j - 1]
															.setVisible(false);
													C[9][j - 1]
															.setVisible(false);
													C[6][j - 1]
															.setVisible(false);
													C[5][j - 1]
															.setVisible(false);
													C[8][j - 1].color = 9880;
													C[7][j - 1].color = 8770;
													C[9][j - 1].color = 7660;
													C[6][j - 1].color = 6550;
													C[5][j - 1].color = 6550;
												} else {
												C[i-1][j].setVisible(false);
												C[i-2][j].setVisible(false);
												C[i-3][j].setVisible(false);
												C[i-4][j].setVisible(false);
												C[i-5][j].setVisible(false);
												C[i-1][j].color=82592;
												C[i-2][j].color=1278;
												C[i-3][j].color=789;
												C[i-4][j].color=8456;
												C[i-5][j].color=105;
												}
											}
											if (xe == 5) {
												mark=mark +650;
												m1.setText(""
														+ (mark));
												xe = 0;
												if (i == 1) {
													C[8][j - 1]
															.setVisible(false);
													C[7][j - 1]
															.setVisible(false);
													C[9][j - 1]
															.setVisible(false);
													C[6][j - 1]
															.setVisible(false);
													C[5][j - 1]
															.setVisible(false);
													C[4][j - 1]
															.setVisible(false);
													C[8][j - 1].color = 12370;
													C[7][j - 1].color = 8770;
													C[9][j - 1].color = 7254;
													C[6][j - 1].color = 6550;
													C[5][j - 1].color = 450;
													C[4][j - 1].color = 6550;
												} else {
												C[i-1][j].setVisible(false);
												C[i-2][j].setVisible(false);
												C[i-3][j].setVisible(false);
												C[i-4][j].setVisible(false);
												C[i-5][j].setVisible(false);
												C[i-6][j].setVisible(false);
												C[i-1][j].color=82592;
												C[i-2][j].color=546;
												C[i-3][j].color=789;
												C[i-4][j].color=213;
												C[i-5][j].color=860;
												C[i-6][j].color=48;
												}
											}
											xe = 0;
										}
									}									
								}
								
								if (ex < 2){
									mark = mark - 30;
									m1.setText("" + (mark));
									ex = 0;
									fu = fu + 1;
								}
								else if (xe < 2) {
									mark = mark - 30;
									m1.setText("" + (mark));
									xe = 0;
									ck = ck + 1;
								}
								if ((ex > 1) && (xe > 1))
								{
									mark = mark - 30;
									System.out.print("wt the fuck?: " + mark);
									m1.setText("" + (mark));
								}
								ex = 0;
								xe = 0;
							}
							}
							else if (Integer.parseInt(t3) == 3)
							{
								mark = 0;
								String t5 = m5.getText();
								if (Integer.parseInt(t5) == 0)
								{
									JOptionPane.showMessageDialog(Cy, "你輸啦廢物~");
									m5.setText("END.");
									if (JOptionPane.showOptionDialog(Cy,
											"你已經輸了！\n你的總分為:"+y+"\n要進排行榜還是離開？", "抱歉囉∼",
											JOptionPane.OK_CANCEL_OPTION,
											JOptionPane.INFORMATION_MESSAGE, null,
											new String[] { "排行榜？", "再見" },
											"default") == JOptionPane.OK_OPTION) 
									{    
										int name=JOptionPane.INFORMATION_MESSAGE;
										String in1=JOptionPane.showInputDialog(Cy,"請輸入姓名","輸入",name);
										for (int d = 0;d<=9;d++)
										{
											int score = (int) rkg.getValueAt(d, 2);
											if (y > score) 
											{
												score = y;
												data[d][2]=y;
												data[d][1]=in1;//更新資料來源
												break;
											}
											else if (y == score)
											{
												score = y;
												data[d+1][2]=y;
												data[d+1][1]=in1;//更新資料來源
												break;
											}
										}
										ranking.setVisible(true);
										ranking.setAlwaysOnTop(true);
									}
									if (JOptionPane.showOptionDialog(Cy,
											"你要離開嗎？", "　",
											JOptionPane.OK_CANCEL_OPTION,
											JOptionPane.INFORMATION_MESSAGE, null,
											new String[] { "對！！", "我要重來！" },
											"default") == JOptionPane.OK_OPTION)
									{
										System.exit(0);
									}
									else
									{
										if (JOptionPane.showOptionDialog(Cy,
												"你要重新開始嗎？", "　",
												JOptionPane.OK_CANCEL_OPTION,
												JOptionPane.INFORMATION_MESSAGE, null,
												new String[] { "重新開始！", "我才不要∼" },
												"default") == JOptionPane.OK_OPTION) 
										{
											s.setVisible(false);
											a15.setVisible(true);
											a17.setVisible(false);
											b1.setEnabled(true);
											b2.setEnabled(true);
											b2.setVisible(true);
											b3.setVisible(true);
											mk.setVisible(true);
											tgmk.setVisible(true);
											place.setVisible(true);
											ll.setVisible(true);
											me.setVisible(false);
											m1.setVisible(true);
											m2.setVisible(true);
											m3.setVisible(true);
											m4.setVisible(true);
											m5.setVisible(false);
											mk.setBounds(20,490,70,25); 
											tgmk.setBounds(20,510,70,25); 
											place.setBounds(180,490,70,25); 
											ll.setBounds(180,510,70,25); 
											m1.setBounds(100,493,55,20);
											m2.setBounds(100,513,55,20);
											m3.setBounds(260,493,35,20);
											m4.setBounds(260,513,35,20);
											Cy.setSize(500, 600);
											m1.setText("0");
											m2.setText("3000");
											m3.setText("1");
											ranking.setVisible(false);
											y = 0;								
										}
										else
										{
											if (JOptionPane.showOptionDialog(Cy,
													"你要離開嗎？", "　",
													JOptionPane.OK_CANCEL_OPTION,
													JOptionPane.INFORMATION_MESSAGE, null,
													new String[] { "對！！", "還不要" },
													"default") == JOptionPane.OK_OPTION)
											{
												System.exit(0);
											}
											else
											{
												b2.setEnabled(false);
											}
										}
									}
								}
							int temp2 = D[r1][c1].color;
							D[r1][c1].color = D[r2][c2].color;
							D[r2][c2].color = temp2;
							int cc2;
							cc2 = D[r1][c1].color;
							D[r1][c1].setIcon(imgs[cc2]);
							cc2 = D[r2][c2].color;
							D[r2][c2].setIcon(imgs[cc2]);

							if (((r1>0 && r1<12) && (c1>0 && c1<12)) &&  ((r2>0 && r2<12) && (c2>0 && c2<12)))
							{
								for (int i = 1; i < 12; i++) {
									for (int j = 1; j < 12; j++) {
										if (D[i][j - 1].color == D[i][j].color) {
											ex = ex+1;
											System.out.print("\n當一橫有相同時::"+ex+",");
										}
										if (D[i][j - 1].color != D[i][j].color){
											if (ex == 2) {
												System.out.print("\nex=2:(3連):"+ex+",");
												mark=mark +150;
												m1.setText(""
														+ (mark));
												ex = 0;

												if (j == 1) {
													D[i - 1][10]
															.setVisible(false);
													D[i - 1][9]
															.setVisible(false);
													D[i - 1][11]
															.setVisible(false);
													D[i - 1][10].color = 9880;
													D[i - 1][9].color = 8770;
													D[i - 1][11].color = 7660;
												} else {
													D[i][j - 1]
															.setVisible(false);
													D[i][j - 2]
															.setVisible(false);
													D[i][j - 3]
															.setVisible(false);
													D[i][j - 1].color = 9888;
													D[i][j - 2].color = 8777;
													D[i][j - 3].color = 7666;
												}
												System.out.print("\n");
											}
											if (ex == 3) {
												System.out.print("\nex=3:(4連):"+ex+",");
												mark=mark +300;
												m1.setText(""
														+ (mark));
												ex = 0;
												System.out.print("\n");
											}
											if (ex == 4) {
												System.out.print("\nex=4:(5連):"+ex+",");
												mark=mark +550;
												m1.setText(""
														+ (mark));
												ex = 0;
											}
											if (ex == 5) {
												mark=mark +650;
												m1.setText(""
														+ (mark));
												ex = 0;
											}
											ex = 0;
										}
									}									
								}
								for (int j = 1; j < 12; j++) {									
									for (int i = 1; i < 12; i++) {
										if (D[i - 1][j].color == D[i][j].color) {
											xe = xe+1;
											System.out.print("\n當|直有相同時::"+xe+",");
										}
										if (D[i - 1][j].color != D[i][j].color){
											if (xe == 2) {
												System.out.print("\nxe=2:(3連):"+xe+",");
												mark=mark +150;
												m1.setText(""
														+ (mark));
												xe = 0;
												if (i == 1) {
													D[10][j - 1]
															.setVisible(false);
													D[9][j - 1]
															.setVisible(false);
													D[11][j - 1]
															.setVisible(false);
													D[10][j - 1].color = 9880;
													D[9][j - 1].color = 8770;
													D[11][j - 1].color = 7660;
												} else {
												D[i-1][j].setVisible(false);
												D[i-2][j].setVisible(false);
												D[i-3][j].setVisible(false);
												D[i-1][j].color=9999;
												D[i-2][j].color=8888;
												D[i-3][j].color=7777;
												}
												System.out.print("\n");
											}
											if (xe == 3) {
												System.out.print("\nxe=3:(4連):"+xe+",");
												mark=mark +300;
												m1.setText(""
														+ (mark));
												xe = 0;
												System.out.print("\n");
											}
											if (xe == 4) {
												System.out.print("\nxe=4:(5連):"+xe+",");
												mark=mark +550;
												m1.setText(""
														+ (mark));
												xe = 0;
											}
											if (xe == 5) {
												mark=mark +650;
												m1.setText(""
														+ (mark));
												xe = 0;
											}
											xe = 0;
										}
									}									
								}
								
								if (ex < 3){
									mark = mark - 50;
									m1.setText("" + (mark));
									ex = 0;
									fu = fu + 1;
								}
								if ((xe < 3)&&(fu < 0 )) {
									mark = mark - 50;
									m1.setText("" + (mark));
									xe = 0;
									ck = ck + 1;
								}
								ex = 0;
								xe = 0;
							}
								if (Integer.parseInt(t5) > 0)
								{
									m5.setText(""+ (Integer.parseInt(t5) - 1));
								}
								
							}
							else if (Integer.parseInt(t3) == 4)
							{
								mark = 0;
								String t5 = m5.getText();
								if (Integer.parseInt(t5) == 0)
								{
									JOptionPane.showMessageDialog(Cy, "你輸啦廢物~");
									m5.setText("END.");
									if (JOptionPane.showOptionDialog(Cy,
											"你已經輸了！\n你的總分為:"+y+"\n要進排行榜還是離開？", "抱歉囉∼",
											JOptionPane.OK_CANCEL_OPTION,
											JOptionPane.INFORMATION_MESSAGE, null,
											new String[] { "排行榜？", "再見" },
											"default") == JOptionPane.OK_OPTION) 
									{    
										int name=JOptionPane.INFORMATION_MESSAGE;
										String in1=JOptionPane.showInputDialog(Cy,"請輸入姓名","輸入",name);
										for (int d = 0;d<=9;d++)
										{
											int score = (int) rkg.getValueAt(d, 2);
											if (y > score) 
											{
												score = y;
												data[d][2]=y;
												data[d][1]=in1;//更新資料來源
												break;
											}
											else if (y == score)
											{
												score = y;
												data[d+1][2]=y;
												data[d+1][1]=in1;//更新資料來源
												break;
											}
										}
										ranking.setVisible(true);
										ranking.setAlwaysOnTop(true);
									}
									if (JOptionPane.showOptionDialog(Cy,
											"你要離開嗎？", "　",
											JOptionPane.OK_CANCEL_OPTION,
											JOptionPane.INFORMATION_MESSAGE, null,
											new String[] { "對！！", "我要重來！" },
											"default") == JOptionPane.OK_OPTION)
									{
										System.exit(0);
									}
									else
									{
										if (JOptionPane.showOptionDialog(Cy,
												"你要重新開始嗎？", "　",
												JOptionPane.OK_CANCEL_OPTION,
												JOptionPane.INFORMATION_MESSAGE, null,
												new String[] { "重新開始！", "我才不要∼" },
												"default") == JOptionPane.OK_OPTION) 
										{
											s.setVisible(false);
											a15.setVisible(true);
											a17.setVisible(false);
											b1.setEnabled(true);
											b2.setEnabled(true);
											b2.setVisible(true);
											b3.setVisible(true);
											mk.setVisible(true);
											tgmk.setVisible(true);
											place.setVisible(true);
											ll.setVisible(true);
											me.setVisible(false);
											m1.setVisible(true);
											m2.setVisible(true);
											m3.setVisible(true);
											m4.setVisible(true);
											m5.setVisible(false);
											mk.setBounds(20,490,70,25); 
											tgmk.setBounds(20,510,70,25); 
											place.setBounds(180,490,70,25); 
											ll.setBounds(180,510,70,25); 
											m1.setBounds(100,493,55,20);
											m2.setBounds(100,513,55,20);
											m3.setBounds(260,493,35,20);
											m4.setBounds(260,513,35,20);
											Cy.setSize(500, 600);
											m1.setText("0");
											m2.setText("3000");
											m3.setText("1");
											ranking.setVisible(false);
											y = 0;								
										}
										else
										{
											if (JOptionPane.showOptionDialog(Cy,
													"你要離開嗎？", "　",
													JOptionPane.OK_CANCEL_OPTION,
													JOptionPane.INFORMATION_MESSAGE, null,
													new String[] { "對！！", "還不要" },
													"default") == JOptionPane.OK_OPTION)
											{
												System.exit(0);
											}
											else
											{
												b2.setEnabled(false);
											}
										}
									}
								}
							int temp2 = D[r1][c1].color;
							D[r1][c1].color = D[r2][c2].color;
							D[r2][c2].color = temp2;
							int cc2;
							cc2 = D[r1][c1].color;
							D[r1][c1].setIcon(imgs[cc2]);
							cc2 = D[r2][c2].color;
							D[r2][c2].setIcon(imgs[cc2]);

							if (((r1>0 && r1<12) && (c1>0 && c1<12)) &&  ((r2>0 && r2<12) && (c2>0 && c2<12)))
							{
								for (int i = 1; i < 12; i++) {
									for (int j = 1; j < 12; j++) {
										if (D[i][j - 1].color == D[i][j].color) {
											ex = ex+1;
											System.out.print("\n當一橫有相同時::"+ex+",");
										}
										if (D[i][j - 1].color != D[i][j].color){
											if (ex == 2) {
												System.out.print("\nex=2:(3連):"+ex+",");
												mark=mark +150;
												m1.setText(""
														+ (mark));
												ex = 0;
												System.out.print("\n");
											}
											if (ex == 3) {
												System.out.print("\nex=3:(4連):"+ex+",");
												mark=mark +300;
												m1.setText(""
														+ (mark));
												ex = 0;
												System.out.print("\n");
											}
											if (ex == 4) {
												System.out.print("\nex=4:(5連):"+ex+",");
												mark=mark +550;
												m1.setText(""
														+ (mark));
												ex = 0;
											}
											if (ex == 5) {
												mark=mark +650;
												m1.setText(""
														+ (mark));
												ex = 0;
											}
											if (ex == 6) {
												mark=mark +750;
												m1.setText(""
														+ (mark));
												ex = 0;
											}
											if (ex == 7) {
												mark=mark +850;
												m1.setText(""
														+ (mark));
												ex = 0;
											}
											if (ex == 8) {
												mark=mark +950;
												m1.setText(""
														+ (mark));
												ex = 0;
											}
											ex = 0;
										}
									}									
								}
								for (int j = 1; j < 12; j++) {									
									for (int i = 1; i < 12; i++) {
										if (D[i - 1][j].color == D[i][j].color) {
											xe = xe+1;
											System.out.print("\n當|直有相同時::"+xe+",");
										}
										if (B[i - 1][j].color != B[i][j].color){
											if (xe == 2) {
												System.out.print("\nxe=2:(3連):"+xe+",");
												mark=mark +150;
												m1.setText(""
														+ (mark));
												xe = 0;
												System.out.print("\n");
											}
											if (xe == 3) {
												System.out.print("\nxe=3:(4連):"+xe+",");
												mark=mark +300;
												m1.setText(""
														+ (mark));
												xe = 0;
												System.out.print("\n");
											}
											if (xe == 4) {
												System.out.print("\nxe=4:(5連):"+xe+",");
												mark=mark +550;
												m1.setText(""
														+ (mark));
												xe = 0;
											}
											if (xe == 5) {
												mark=mark +650;
												m1.setText(""
														+ (mark));
												xe = 0;
											}
											if (xe == 6) {
												mark=mark +750;
												m1.setText(""
														+ (mark));
												xe = 0;
											}
											if (xe == 7) {
												mark=mark +850;
												m1.setText(""
														+ (mark));
												xe = 0;
											}
											if (xe == 8) {
												mark=mark +950;
												m1.setText(""
														+ (mark));
												xe = 0;
											}
											xe = 0;
										}
									}									
								}
								
								if (ex < 3){
									mark = mark - 50;
									m1.setText("" + (mark));
									ex = 0;
									fu = fu + 1;
								}
								if ((xe < 3)&&(fu < 0 )) {
									mark = mark - 50;
									m1.setText("" + (mark));
									xe = 0;
									ck = ck + 1;
								}
								ex = 0;
								xe = 0;
							}
								if (Integer.parseInt(t5) > 0)
								{
									m5.setText(""+ (Integer.parseInt(t5) - 1));
								}
								
							}
						}
					}
				break;
			}
		break;
	}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		aboutc.setVisible(true);
	}
	@Override
	public void mouseExited(MouseEvent e) {
		aboutc.setVisible(false);
	}
	@Override
	public void mousePressed(MouseEvent arg0) {}
	@Override
	public void mouseReleased(MouseEvent arg0) {}
	@Override
	public void mouseClicked(MouseEvent arg0) {}
}

