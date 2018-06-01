package S_18_1.s_2_2;


import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * ① 通过@Scheduled声明该方法是计划任务，使用fixedRate属性每隔固定时间执行。
 * ② 使用cron属性可按照指定时间执行，本例指的是每天11点28分执行；
 * cron是UNIX和类UNIX(Linux)系统下的定时任务。
 */
@Service
public class ScheduleTaskService {
    private static final SimpleDateFormat DATE_FORMAT=new SimpleDateFormat("HH:mm:ss");

    @Scheduled(fixedRate = 5000)//1
    public static void reportCurrentTime(){
        System.out.println("每隔5秒执行一次:"+DATE_FORMAT.format(new Date()));
    }

//    @Scheduled(cron = "0 28 11 ? * *"  ) //②
    @Scheduled(cron = "0 46 10 ? * *")//指定在10点46分执行
    public static void fixTimeExecution(){
        System.out.println("在指定时间"+DATE_FORMAT.format(new Date())+"执行");

    }

}
/**


 import java.text.SimpleDateFormat;
 import java.util.Date;

 import org.springframework.scheduling.annotation.Scheduled;
 import org.springframework.stereotype.Service;

 @Service
 public class ScheduledTaskService {

 private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

 @Scheduled(fixedRate = 5000) //①
 public void reportCurrentTime() {
 System.out.println("每隔五秒执行一次 " + dateFormat.format(new Date()));
 }

 @Scheduled(cron = "0 28 11 ? * *"  ) //②
 public void fixTimeExecution(){
 System.out.println("在指定时间 " + dateFormat.format(new Date())+"执行");
 }
 }
 */