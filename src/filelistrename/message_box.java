package filelistrename;

import java.awt.Label;

import javax.swing.JFrame;

public class message_box {
	JFrame message_box=null;
	public message_box(String msg) {
		message_box=new JFrame("success");
		message_box.add(new Label(msg));
		message_box.setVisible(true);
		message_box.setBounds(150, 150, 200, 150);
	}

}
