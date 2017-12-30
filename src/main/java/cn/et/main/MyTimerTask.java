package cn.et.main;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TimerTask;

import cn.et.model.MyNews;
import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class MyTimerTask extends TimerTask {
	MyNews news=new MyNews();
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		try {
			Configuration cfg = new Configuration(Configuration.VERSION_2_3_23);
			cfg.setDirectoryForTemplateLoading(
			        new File("src/main/resources"));
			cfg.setObjectWrapper(new DefaultObjectWrapper(Configuration.VERSION_2_3_23));  
			Map root = new HashMap();
			List<Map> newsList=news.queryNews();
			root.put("newsList",newsList );
			Template temp = cfg.getTemplate("index.ftl");
			String saveFile="src/main/webapp/index.html";
			FileOutputStream fos=new FileOutputStream(new File(saveFile));
			Writer out = new OutputStreamWriter(fos);
			temp.process(root, out);
			out.flush(); 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	}
}
