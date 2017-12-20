package cn.com.catcher.vision.gov.qixia.sync.client.listener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import cn.com.catcher.vision.gov.qixia.sync.client.tasks.WatchFilePathTask;

@Component
public class ThreadStartUpListenser implements ServletContextListener
{
	 private static final Logger logger = LoggerFactory.getLogger(ThreadStartUpListenser.class);

	 private static WatchFilePathTask r = new WatchFilePathTask();
    
    /*
     * tomcat启动的时候创建一个线程
     * */
    @Override
    public void contextInitialized(ServletContextEvent paramServletContextEvent)
    {
        r.start();
        logger.info("ImportUserFromFileTask is started!");
    }
    
    /*
     * tomcat关闭的时候销毁这个线程
     * */
    @Override
    public void contextDestroyed(ServletContextEvent paramServletContextEvent)
    {
        r.interrupt();
    }

}