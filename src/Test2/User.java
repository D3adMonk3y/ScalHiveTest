package Test2;

import java.io.Serializable;
import java.util.Random;

public class User implements Serializable {
    private static int userCount = 0;
    private int id;
    private String userName;
    private int level;
    private int experience;
    private boolean paid;
    private int actionPerDay;
    private int paidDays;

    //The constructor receives as argument only the account name and boolean value if this account is paid, the other fields are filled automatically
    public User(String userName, boolean paid) {
        id = userCount++;
        this.userName = userName;
        // level start from 0 and can only be increased
        level = 0;
        experience = 0;

        // if the account is paid, then the amount of paid days initialized by the setPaidDaysTo30 method by the value of 30
        if(paid) {
            this.paid = true;
            setPaidDaysTo30();
        }else{
            //if account is free paidDays field set to 0, and action per day i set to 3
            this.paid = false;
            paidDays = 0;
            actionPerDay = 3;
        }
    }

    //SETTERS
    public void setUserName(String userName) {
        this.userName = userName;
    }

    private void setExpirience(int experience) {
        this.experience = experience;

    }

    // if the account is paid, then the amount of paid days initialized by the setPaidDaysTo30 method by the value of 30
    public void setPaid(boolean paid) {
        if(paid) {
            this.paid = true;
            setPaidDaysTo30();
        }else{
            this.paid = false;
            paidDays = 0;
        }

    }

    // level can only be increased
    private void increaseLevel(int level){
        this.level += level;
    }

    private void setActionPerDay(int actionPerDay) {
        this.actionPerDay = actionPerDay;
    }

    //if user is paid set paid days value to 30
    private void setPaidDaysTo30() {
        paidDays = 30;
    }

    //method that called every day to decrease paid days and reset action per day if user is not paid
    private void decreacePaidDays() {
        if(paidDays >= 1)
            paidDays-- ;
        else{
            paid = false;
            setActionPerDay(3);
        }
    }

    public void setPaidDays(int paidDays) {
        this.paidDays = paidDays;
    }

    //GETTERS
    public int getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public int getLevel() {
        return level;
    }

    public int getExperience() {
        return experience;
    }

    public boolean isPaid() {
        return paid;
    }

    public int getActionPerDay() {
        return actionPerDay;
    }

    public int getPaidDays() {
        return paidDays;
    }

    // action method, that add to user experience a random value bounded by 250 and print to console 'do Action',
    // if user is free method  check if action is available and if it is do Action and decrease action per day value
    public void doAction(){
        if(this.isPaid()){
            System.out.println("do Action");
            experience += new Random().nextInt(250);
        }else{
            if(this.getActionPerDay()>0){
                System.out.println("do Action");
                experience += new Random().nextInt(250);
                this.setActionPerDay(this.getActionPerDay()-1);
            }else{
                System.out.println("The action per day is finished!");
            }
        }
    }

    //the method that must be call at midnight every day
    public void nextDay(){
        //if experience is higher than 500 than level increase by experience/500
        if(this.getExperience() > 500){
            this.increaseLevel(experience/500);
            //experience set remainder of division
            this.setExpirience(experience%500);
        }

        // reset number of action per day if user is free or decrease paid days if user is paid
        if(!this.isPaid() && getActionPerDay()!=3)
        setActionPerDay(3);

        if(isPaid())
            decreacePaidDays();
    }
}
