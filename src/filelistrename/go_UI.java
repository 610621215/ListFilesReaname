package filelistrename;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.LayoutManager;
import java.awt.Rectangle;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class go_UI implements ActionListener{
	JFrame jf=null;
	String data1="";
	String data2="";
	static int x=300;
	static int y=250;
	static int width=300;
	static int height=150;
	JLabel jl=new JLabel("\"Input path and file name(ex:C:\\a.jpg)\"");//Label1
	TextField jtf=new TextField("PATH",20);//Input text
	JLabel jl2=new JLabel("\"Replace with naeme?");
	TextField jtf2=new TextField("name",20);
	public go_UI() {
		// TODO Auto-generated constructor stub
		jf=new JFrame("Changing many files name");
		jf.setBounds(new Rectangle(x,y, width, height));
		jf.setLayout(new GridLayout(5,1));//Setting layout
		//example https://javatutorial.net/java-swing-jframe-layouts
		jf.add(jl);
		jf.add(jtf);
		jf.add(jl2);
		jf.add(jtf2);
		jf.add(set_button());
		jf.setVisible(true);
	}
	public Button set_button() {
		Button btn = new Button("Submit");
		btn.setBounds(jf.getWidth(),jf.getHeight()/10,jf.getX()/10,jf.getY()/10);
		btn.addActionListener(this);
		return btn;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		try {
			data1=jtf.getText();	
			System.out.println(data1);
			File f1=new File(data1);
			String path=f1.getParent();
			String file_name=f1.getName();
			System.out.println(f1.getParent());
			data2=jtf2.getText();
			System.out.println(data2);
			if(rule(path)||rule(file_name))
				new message_box("Empty file,checking path and name of file");
			else
				new go_doing(path,file_name,data2);
		}catch(Exception ex) {
			new message_box(ex.toString());	
		}
	}
	public boolean rule(String data) {
		if(data==null)
			return true;
		return false;
	}
}
