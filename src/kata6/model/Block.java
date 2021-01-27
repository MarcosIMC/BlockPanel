/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kata6.model;

import java.util.List;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author marke
 */
public class Block {
    private int x;
    private int y;
    public static final int MAX = 7;
    private final Timer timer;
    private List<Observer> observers;
    
    public Block(int x, int y) {
        this.x = x;
        this.y = y;
        this.timer = new Timer();
        this.timer.schedule(task(), 1000, 500);
        this.observers = new ArrayList<>();
    }

    public void register(Observer observer){
        observers.add(observer);
    }
    
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    
    public void left(){
        if (x == 1) return;
        x--;
        change();
    }
    
    public void right(){
        if (x == MAX) return;
        x++;
        change();
    }
    
    public void up(){
        if (y == MAX) return;
        y++;
        change();
    }
    
    public void down(){
        if (y == 1) return;
        y--;
        change();
    }

    private TimerTask task() {
        return new TimerTask() {
            @Override
            public void run() {
                double r = Math.random();
                if(r > 0.4) return;
                if (r > 0.3) up();
                else if (r > 0.2) down();
                else if (r > 0.1) left();
                else right();
            }
        };
    }

    private void change() {
        for (Observer observer : observers){
            observer.change();
        }
    }
    
    public interface Observer {
        public void change();
    }
}
