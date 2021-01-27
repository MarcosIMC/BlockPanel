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
public class RightCommand implements Command{
    private final Block block;

    public RightCommand(Block block) {
        this.block = block;
    }
    
    
    
    @Override
    public void execute() {
        block.right();
    }    
}
