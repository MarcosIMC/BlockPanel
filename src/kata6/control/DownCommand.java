/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kata6.control;

import kata6.model.Block;

/**
 *
 * @author marke
 */
public class DownCommand implements Command{
    private final Block block;

    public DownCommand(Block block) {
        this.block = block;
    }
    
    
    
    @Override
    public void execute() {
        block.down();
    }
}
