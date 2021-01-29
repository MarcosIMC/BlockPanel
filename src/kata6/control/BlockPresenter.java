/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kata6.control;

import kata6.model.Block;
import kata6.view.BlockDisplay;

/**
 *
 * @author marke
 */
public class BlockPresenter implements Block.Observer{
    private final Block block;
    private final BlockDisplay blockDisplay;

    public BlockPresenter(Block block, BlockDisplay blockDisplay) {
        this.block = block;
        this.blockDisplay = blockDisplay;
        this.block.register(this);
        this.blockDisplay.on(moved());
        this.paint();
    }
    
    @Override
    public void change() {
        paint();
    }

    private void paint() {
        blockDisplay.display(block.getX()-1, Block.MAX-block.getY());
    }

    private BlockDisplay.Moved moved() {
        return new BlockDisplay.Moved(){
            @Override
            public void to(int x, int y){
                block.pos(x+1, Block.MAX-y);
            }
        };
    }
    
}
