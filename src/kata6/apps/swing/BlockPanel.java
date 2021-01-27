/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kata6.apps.swing;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import kata6.model.Block;
import kata6.view.BlockDisplay;

/**
 *
 * @author marke
 */
public class BlockPanel extends JPanel implements BlockDisplay {

    private Block block;
    private static final int SIZE = 100;
    
    @Override
    public void paint(Graphics g){
        g.setColor(Color.white);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
        g.setColor(Color.black);
        int size = Block.MAX * SIZE;
        for (int i = 0; i <= size; i=i+SIZE) {
            g.drawLine(0, i, size, i);
            g.drawLine(i, 0, i, size);            
        }

        g.setColor(Color.red);
        g.fillRect((block.getX()-1)*SIZE, (Block.MAX-block.getY())*SIZE, SIZE, SIZE);
    }

    @Override
    public void display(Block block) {
        this.block = block;
        this.block.register(this);
        repaint();
    }

    @Override
    public Block block() {
        return block;
    }

    @Override
    public void change() {
        repaint();
    }
    
}
