package Test2_1;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Users {
    //List where we store our users
    private static List<User2> listOfUsers = new ArrayList<>();

    //the runnable task that gona be passed to scheduled executor to run once a day at midnight
    private static final Runnable everyDayUpdate = new EveryDayUpdate();

    static{
        //creating executor service
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);
        // holds have many minutes left until midnight
        Long midnight = LocalDateTime.now().until(LocalDate.now().plusDays(1).atStartOfDay(), ChronoUnit.MINUTES);

        // schedule executur service to run today at midnight and repeat every day
        executorService.scheduleAtFixedRate(everyDayUpdate, midnight, 1440, TimeUnit.MINUTES);
    }

    //method to add users to list
    public void addUser(User2 user){
        listOfUsers.add(user);
    }

    //perform action on given users
    public void doAction(User2 user){
        if(listOfUsers.contains(user)) {
            int index = listOfUsers.indexOf(user);
            listOfUsers.get(index).doAction();
        }else{
            System.out.println("There no such user in the list");
        }
    }

    // runnable task that call for all user nextDay method
    static class EveryDayUpdate implements Runnable{

        @Override
        public void run() {
            for (int i = 0; i < listOfUsers.size(); i++) {
                listOfUsers.get(i).nextDay();
            }
        }
    }

}


