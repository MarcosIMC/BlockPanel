/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kata6.apps.swing;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JPanel;
import kata6.view.BlockDisplay;

/**
 *
 * @author marke
 */
public class BlockPanel extends JPanel implements BlockDisplay {
    private final int max;
    private final int size;
    private int x;
    private int y;
    private Moved moved = new Moved.Null();

    public BlockPanel(int max, int size) {
        this.max = max;
        this.size = size;
        MouseHandler mouseHandler = new MouseHandler();
        this.addMouseListener(mouseHandler);
        this.addMouseMotionListener(mouseHandler);
    }  
    
    
    @Override
    public void paint(Graphics g){
        g.setColor(Color.white);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
        g.setColor(Color.black);
        int max = this.max * this.size;
        for (int i = 0; i <= max; i=i+this.size) {
            g.drawLine(0, i, max, i);
            g.drawLine(i, 0, i, max);            
        }

        g.setColor(Color.red);
        g.fillRect(x*size, y*size, size, size);
    }    

    @Override
    public void display(int x, int y) {
        this.x = x;
        this.y = y;
        repaint();
    }

    @Override
    public void on(Moved moved) {
        this.moved = moved;
    }

    private class MouseHandler implements MouseMotionListener, MouseListener{
        private boolean grabbed = false;
        
        @Override
        public void mouseDragged(MouseEvent e) {
            if (grabbed) moved.to(e.getX()/size, e.getY()/size);
        }

        @Override
        public void mouseMoved(MouseEvent e) {
        }

        @Override
        public void mouseClicked(MouseEvent e) {
        }

        @Override
        public void mousePressed(MouseEvent e) {
            grabbed = e.getX()/size == x && e.getY()/size == y;
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }

        private boolean isIn(int x, int target) {
           return x == target; 
        }
    }
}
