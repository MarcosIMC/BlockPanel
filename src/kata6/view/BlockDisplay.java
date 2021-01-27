/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kata6.view;

import kata6.model.Block;

/**
 *
 * @author marke
 */
public interface BlockDisplay extends Block.Observer{
    void display(Block block);
    Block block();
    
}
