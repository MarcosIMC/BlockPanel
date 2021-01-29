/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kata6.view;


/**
 *
 * @author marke
 */
public interface BlockDisplay{
    void display(int x, int y);    
    void on(Moved moved);
    
    interface Moved {
        void to(int x, int y);

        public static class Null implements Moved{
            @Override
            public void to(int x, int y) {
            }
        }
    }
}
