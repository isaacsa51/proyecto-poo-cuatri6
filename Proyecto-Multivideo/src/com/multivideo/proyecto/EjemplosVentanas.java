// NO ELIMINAR SON EJEMPLOS DE VENTANAS SACADOS DE INTERNET EN CASO DE PODERSE UTILIZAR


//            JLabel label1,label2,label3,label4,label5,label6,label7,label8,label9,label10,label11,label12,s1,s2,s3;
//		JPanel panel;
//		JFrame jf;
//		JButton register;
//		JTextField textfield1,textfield2,textfield3,textfield4a,textfield4b,textfield4c,textfield5,textfield6,textfield7,textfield8,textfield9;
//		JPasswordField passwordfield1;
//		JRadioButton radiobutton2,radiobutton3;
//		String name,gender,dob1,dob2,dob,dobb,password,mobileNumber,email,area,state,nationality,selectedState;
//		JComboBox combobox1;
//		int index,count;
//		String states[] = new String[50];
//
//		jf=new javax.swing.JFrame("Registration Form");
//		panel=new javax.swing.JPanel();
//		jf.add(panel);
//		panel.setBackground(new Color(191,239,255));
//		panel.setLayout(null);
//		jf.setSize(970,700);
//		jf.show();
//
//		label1=new javax.swing.JLabel("Registration Form");
//		label1.setFont(new Font("Dialog", Font.ITALIC, 24));
//		label1.setBounds(300,20,400,40);
//		panel.add(label1);
//
//		label2=new javax.swing.JLabel("Name");
//		label2.setFont(new Font("Dialog", Font.BOLD, 20));
//		label2.setBounds(100,80,150,40);
//		panel.add(label2);
//
//		label3=new javax.swing.JLabel("Gender");
//		label3.setFont(new Font("Dialog", Font.BOLD, 20));
//		label3.setBounds(100,140,150,40);
//		panel.add(label3);
//
//		label4=new javax.swing.JLabel("Password");
//		label4.setFont(new Font("Dialog", Font.BOLD, 20));
//		label4.setBounds(100,200,150,40);
//		panel.add(label4);
//
//		label5=new javax.swing.JLabel("Date Of Birth");
//		label5.setFont(new Font("Dialog", Font.BOLD, 20));
//		label5.setBounds(100,260,150,40);
//		panel.add(label5);
//
//		label6=new javax.swing.JLabel("Mobile Number");
//		label6.setFont(new Font("Dialog", Font.BOLD, 20));
//		label6.setBounds(100,320,150,40);
//		panel.add(label6);
//
//		label7=new javax.swing.JLabel("E-mail");
//		label7.setFont(new Font("Dialog", Font.BOLD, 20));
//		label7.setBounds(100,380,150,40);
//		panel.add(label7);
//
//		label8=new javax.swing.JLabel("Area");
//		label8.setFont(new Font("Dialog", Font.BOLD, 20));
//		label8.setBounds(100,440,150,40);
//		panel.add(label8);
//
//		label9=new javax.swing.JLabel("State");
//		label9.setFont(new Font("Dialog", Font.BOLD, 20));
//		label9.setBounds(100,500,150,40);
//		panel.add(label9);
//
//		textfield1=new javax.swing.JTextField();
//		textfield1.setFont(new Font("Dialog", Font.BOLD, 16));
//		textfield1.setBounds(350,80,180,30);
//		panel.add(textfield1);
//
//		label10=new javax.swing.JLabel("Male");
//		label10.setFont(new Font("Dialog", Font.BOLD, 20));
//		label10.setBounds(350,140,60,40);
//		panel.add(label10);
//
//		label11=new javax.swing.JLabel("Female");
//		label11.setFont(new Font("Dialog", Font.BOLD, 20));
//		label11.setBounds(460,140,100,40);
//		panel.add(label11);
//
//		label12=new javax.swing.JLabel("Nationality");
//		label12.setFont(new Font("Dialog", Font.BOLD, 20));
//		label12.setBounds(100,560,150,40);
//		panel.add(label12);
//
//		radiobutton2=new javax.swing.JRadioButton();
//		radiobutton2.setFont(new Font("Dialog", Font.BOLD, 16));
//		radiobutton2.setBounds(420,140,20,30);
//		panel.add(radiobutton2);
//
//		radiobutton3=new javax.swing.JRadioButton();
//		radiobutton3.setFont(new Font("Dialog", Font.BOLD, 16));
//		radiobutton3.setBounds(570,140,20,30);
//		panel.add(radiobutton3);
//
//		ButtonGroup jb = new ButtonGroup();
//		jb.add(radiobutton2);
//		jb.add(radiobutton3);
//
//		textfield3=new javax.swing.JPasswordField();
//		textfield3.setFont(new Font("Dialog", Font.BOLD, 16));
//		textfield3.setBounds(350,200,180,30);
//		panel.add(textfield3);
//
//		textfield4a=new javax.swing.JTextField();
//		textfield4a.setFont(new Font("Dialog", Font.BOLD, 16));
//		textfield4a.setBounds(350,260,40,30);
//		panel.add(textfield4a);
//
//		s1=new javax.swing.JLabel("/");
//		s1.setFont(new Font("Dialog", Font.BOLD, 16));
//		s1.setBounds(400,260,20,30);
//		panel.add(s1);
//
//		textfield4b=new javax.swing.JTextField();
//		textfield4b.setFont(new Font("Dialog", Font.BOLD, 16));
//		textfield4b.setBounds(430,260,40,30);
//		panel.add(textfield4b);
//
//		s2=new javax.swing.JLabel("/");
//		s2.setFont(new Font("Dialog", Font.BOLD, 16));
//		s2.setBounds(480,260,20,30);
//		panel.add(s2);
//
//		textfield4c=new javax.swing.JTextField();
//		textfield4c.setFont(new Font("Dialog", Font.BOLD, 16));
//		textfield4c.setBounds(510,260,100,30);
//		panel.add(textfield4c);
//
//		s3=new javax.swing.JLabel("DD/MM/YYYY");
//		s3.setFont(new Font("Dialog", Font.BOLD, 16));
//		s3.setBounds(620,260,150,30);
//		panel.add(s3);
//
//		textfield5=new javax.swing.JTextField();
//		textfield5.setFont(new Font("Dialog", Font.BOLD, 16));
//		textfield5.setBounds(350,320,180,30);
//		panel.add(textfield5);
//
//		textfield6=new javax.swing.JTextField();
//		textfield6.setFont(new Font("Dialog", Font.BOLD, 16));
//		textfield6.setBounds(350,380,180,30);
//		panel.add(textfield6);
//
//		textfield7=new javax.swing.JTextField();
//		textfield7.setFont(new Font("Dialog", Font.BOLD, 16));
//		textfield7.setBounds(350,440,180,30);
//		panel.add(textfield7);
//
//		textfield8=new javax.swing.JTextField();
//		textfield8.setFont(new Font("Dialog", Font.BOLD, 16));
//		textfield8.setBounds(350,500,180,30);
//		//panel.add(textfield8);
//
//		textfield9=new javax.swing.JTextField();
//		textfield9.setFont(new Font("Dialog", Font.BOLD, 16));
//		textfield9.setBounds(350,560,180,30);
//		panel.add(textfield9);
//
//		register = new javax.swing.JButton("Register");
//		register.setFont(new Font("Dialog", Font.BOLD, 16));
//		register.setBounds(250,620,100,30);
//		panel.add(register);
//
//		combobox1 = new JComboBox();
//		combobox1.setBounds(350,500,180,30);
//		combobox1.setFont(new Font("Dialog",Font.BOLD,18));
//		panel.add(combobox1);
//
//		states[0] = "Andra Pradesh";
//		states[1] = "Arunachal Pradesh";
//		states[2] = "Assam";
//		states[3] = "Bihar";
//		states[4] = "Chhattisgarh";
//		states[5] = "Goa";
//		states[6] = "Gujarat";
//		states[7] = "Haryana";
//		states[8] = "Himachal Pradesh";
//		states[9] = "Jammu and Kashmir";
//		states[10] = "Jharkhand";
//		states[11] = "Karnataka";
//		states[12] = "Kerala";
//		states[13] = "Madya Pradesh";
//		states[14] = "Maharashtra";
//		states[15] = "Manipur";
//		states[16] = "Meghalaya";
//		states[17] = "Mizoram";
//		states[18] = "Nagaland";
//		states[19] = "Orissa";
//		states[20] = "Punjab";
//		states[21] = "Rajasthan";
//		states[22] = "Sikkim";
//		states[23] = "Tamil Nadu";
//		states[24] = "Tripura";
//		states[25] = "Uttaranchal";
//		states[26] = "Uttar Pradesh";
//		states[27] = "West Bengal";
//		states[28] = "Andaman and Nicobar Islands";
//		states[29] = "Chandigarh";
//		states[30] = "Dadar and Nagar Haveli";
//		states[31] = "Daman and Diu";
//		states[32] = "Delhi";
//		states[33] = "Lakshadeep";
//		states[34] = "Pondicherry";
            
            
            
            
	
//            JLabel l1, l2, l3, l4, l5, l6, l7, l8;  
//            JTextField tf1, tf2, tf5, tf6, tf7;  
//            JButton btn1, btn2;  
//            JPasswordField p1, p2;  
//                setVisible(true);  
//                setSize(700, 700);  
//                setLayout(null);
//                setResizable(false);
//                setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);  
//                setTitle("Modificar producto(s)");  
//                l1 = new JLabel("Modificación de un producto");  
//                l1.setForeground(Color.red);  
//                l1.setFont(new Font("San Serif", Font.BOLD, 14));  
//                l2 = new JLabel("Name:");  
//                l3 = new JLabel("Email-ID:");  
//                l4 = new JLabel("Create Passowrd:");  
//                l5 = new JLabel("Confirm Password:");  
//                l6 = new JLabel("Country:");  
//                l7 = new JLabel("State:");  
//                l8 = new JLabel("Phone No:");   
//                tf1 = new JTextField();  
//                tf2 = new JTextField();  
//                p1 = new JPasswordField();  
//                p2 = new JPasswordField();  
//                tf5 = new JTextField();  
//                tf6 = new JTextField();  
//                tf7 = new JTextField();  
//                btn1 = new JButton("Submit");  
//                btn2 = new JButton("Clear");  
//                l1.setBounds(100, 30, 400, 30);  
//                l2.setBounds(80, 70, 200, 30);  
//                l3.setBounds(80, 110, 200, 30);  
//                l4.setBounds(80, 150, 200, 30);  
//                l5.setBounds(80, 190, 200, 30);  
//                l6.setBounds(80, 230, 200, 30);  
//                l7.setBounds(80, 270, 200, 30);  
//                l8.setBounds(80, 310, 200, 30);  
//                tf1.setBounds(300, 70, 200, 30);  
//                tf2.setBounds(300, 110, 200, 30);  
//                p1.setBounds(300, 150, 200, 30);  
//                p2.setBounds(300, 190, 200, 30);  
//                tf5.setBounds(300, 230, 200, 30);  
//                tf6.setBounds(300, 270, 200, 30);  
//                tf7.setBounds(300, 310, 200, 30);  
//                btn1.setBounds(50, 350, 100, 30);  
//                btn2.setBounds(170, 350, 100, 30);  
//                add(l1);  
//                add(l2);  
//                add(tf1);  
//                add(l3);  
//                add(tf2);  
//                add(l4);  
//                add(p1);  
//                add(l5);  
//                add(p2);  
//                add(l6);  
//                add(tf5);  
//                add(l7);  
//                add(tf6);  
//                add(l8);  
//                add(tf7);  
//                add(btn1);  
//                add(btn2);