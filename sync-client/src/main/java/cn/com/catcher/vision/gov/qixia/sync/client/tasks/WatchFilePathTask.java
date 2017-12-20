package cn.com.catcher.vision.gov.qixia.sync.client.tasks;

import java.io.File;
import java.io.IOException;  
import java.nio.file.FileSystems;  
import java.nio.file.Path;  
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;  
import java.nio.file.WatchKey;  
import java.nio.file.WatchService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static java.nio.file.StandardCopyOption.*;

import cn.com.catcher.vision.gov.qixia.sync.client.util.HttpConnectionUtil;
import cn.com.catcher.vision.gov.qixia.sync.client.util.PropertyUtil;
/**
 * ָ��Ŀ¼�ļ��仯�����
 * @author cancer
 *
 */
public class WatchFilePathTask extends Thread
{
	 private static final Logger logger = LoggerFactory.getLogger(WatchFilePathTask.class);

    
   
	// �洢���������ͼ���Ŀ¼�Ķ�Ӧ  
	    private static Map pathMap = null;  
	    private WatchService watcher;// Ŀ¼��������  
	    private WatchKey key;// Ŀ¼��Ӧ�ļ���key  
    
    @Override
    public void run()
    {
        try
        {
        	
        	String baseDir = PropertyUtil.getProperty("baseDir");
        	
        	String faceData = PropertyUtil.getProperty("faceData");
        	String images = PropertyUtil.getProperty("images");
        	String tempImages = PropertyUtil.getProperty("tempImages");
        	
        	String url = PropertyUtil.getProperty("receiver.url");
        
        	
        	watcher = FileSystems.getDefault().newWatchService();  
            pathMap = new HashMap();  
            registDirs(faceData);
            registDirs(images);
            registDirs(tempImages);
            
            while (true) {  
                // �ȴ�ֱ������¼��ź�  
                WatchKey signal;  
                try {  
                    signal = watcher.take();  
                } catch (InterruptedException x) {  
                    return;  
                }  
                for (WatchEvent<?> event : signal.pollEvents()) {  
                	   WatchEvent.Kind kind = event.kind();  
                    if (kind == StandardWatchEventKinds.OVERFLOW) {  
                        continue;  
                    }  
                    WatchEvent<Path> ev = (WatchEvent<Path>)event;  
      
                    Path name = ev.context();  
                    String fileName = name.getFileName().toString();  
                    String dirPath = pathMap.get(signal) + "/" + fileName;  
                    if (kind.name().equals("ENTRY_CREATE")) { 
                    	if(fileName.indexOf(".") == -1)//˵����Ŀ¼
                    	{
                            Path path = Paths.get(dirPath);  
                           
                            key = path.register(watcher, StandardWatchEventKinds.ENTRY_CREATE);  
                            pathMap.put(key, dirPath); 
                            
                           
                    	}else //��Ҫ�ϴ��ļ�
                    	{
                    		
                    		 HttpConnectionUtil.uploadFile(url+"?dirPath="+dirPath+"&prefixPath="+baseDir+"&islog=false",new String[] { dirPath });
                    	
                    		 logger.info("sync file success:"+dirPath);
                    	}
 
                    } 
                    System.out.println("event:" + kind.name() + ";file:" + dirPath);  
//                    FileWatchEventArgs args = new FileWatchEventArgs(kind.name(),  
//                            pathMap.get(signal), fileName);  
//                    notifiy(args);// ֪ͨ���й۲����¼����  
                }  
                if(!signal.reset()){  
                    break;  
                }  
            }  

  
        } catch (Exception e)
        {
        	logger.error(e.getMessage(),e);
        }
    }
    
    // �ݹ��ȡ����Ŀ¼  
    private void getAllDirs(File dir, List dirs) {  
        if (dir.isDirectory()) {  
            dirs.add(dir);  
            File[] fs = dir.listFiles();  
            for (File f : fs) {  
                getAllDirs(f, dirs);  
            }  
        }  
    }   
    private void registDirs(String dir) throws IOException {  
        List<File> dirs = new ArrayList();  
        File dirRoot = new File(dir);  
        getAllDirs(dirRoot, dirs);  
        // ѭ��·��������Ŀ¼���map  
        for (File eveDir : dirs) {  
            Path path = Paths.get(eveDir.getAbsolutePath());  
            // ���Ŀ¼���ļ��ĸ��¡�������ɾ���¼�  
            try {  
                key = path.register(watcher, StandardWatchEventKinds.ENTRY_CREATE);  
                pathMap.put(key, eveDir.getAbsolutePath());  
            } catch (IOException e) {  
                e.printStackTrace();  
            }  
        }  
    }  
}