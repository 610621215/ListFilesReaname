package filelistrename;

import java.io.File;
import java.util.StringTokenizer;


public class go_doing {

	public go_doing(String path,String file_name,String replace_name) {
		// TODO Auto-generated constructor stub
		main(path, file_name,replace_name);
	}
	public static void main(String path,String file_name,String replace_name) {
		String p_paths=path+"\\";
		File file=new File(p_paths);
		System.out.println(file_name);
		String[] paths=file.list();
		int count=0;
		for(String p:paths) {
			try {
				String fn=p;
				System.out.println(p);
				String[] file_info=get_subfile(file_name);
				String storge_name=file_info[0];
				String storge_type=file_info[1];
				System.out.println(file_name);
				if(fn.contains(storge_name)) {
					fn=fn.replace(storge_name, replace_name);
					File tp=new File(p_paths+p);
//					fn=fn+"."+storge_type;
					tp.renameTo(new File(p_paths+fn));
					count++;
				}
			}catch(Exception ex) {
				System.out.println(ex.toString());
			}
		}
		System.out.println(count);
		new message_box("success");
	}
	public static String[] get_subfile(String filename) {
		System.out.println(filename);
		StringTokenizer st=new StringTokenizer(filename, ".");
		String[] type=new String[2];
		int index=0;
		while(st.hasMoreElements()) {
			type[index]=st.nextToken();
			index++;
		}
		return type;
	}
}
