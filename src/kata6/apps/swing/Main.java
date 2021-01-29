/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kata6.apps.swing;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import kata6.control.BlockPresenter;
import kata6.control.Command;
import kata6.control.DownCommand;
import kata6.control.LeftCommand;
import kata6.control.RightCommand;
import kata6.control.UpCommand;
import kata6.model.Block;
import kata6.view.BlockDisplay;

/**
 *
 * @author marke
 */
public class Main extends JFrame{

    private static final int BLOCK_SIZE = 100;
    public static void main(String[] args) {
        // TODO code application logic here     
        new Main().execute();
    }
    private BlockDisplay blockDisplay;
    private Map<String,Command> commands = new HashMap<>(); 
    private final BlockPresenter blockPresenter;
    
    public Main(){
        this.setTitle("Block shifter");
        this.setSize(700, 762);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.getContentPane().add(blockPanel());
        Block block = new Block (4,4);
        this.blockPresenter = new BlockPresenter(block, blockDisplay);
        this.add(toolbar(), BorderLayout.SOUTH);
        this.commands.put("left", new LeftCommand(block));
        this.commands.put("right", new RightCommand(block));
        this.commands.put("up", new UpCommand(block));
        this.commands.put("down", new DownCommand(block));
    }

    private void execute() {
        this.setVisible(true);
    }

    private JPanel blockPanel() {
        BlockPanel blockPanel = new BlockPanel(Block.MAX, BLOCK_SIZE);
        this.blockDisplay = blockPanel;
        return blockPanel;
    }    

    private JMenuBar toolbar() {
    JMenuBar menu = new JMenuBar();
    menu.add(button("left"));
    menu.add(button("up"));
    menu.add(button("down"));
    menu.add(button("right"));  
    return menu;
}

    private JButton button(String name) {
        JButton button = new JButton(name);
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    commands.get(name).execute();
                }
            });
            return button;
    }
}
