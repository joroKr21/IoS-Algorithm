package org.coinor.tsp;

import org.coinor.opents.*;

public class MySwapMove implements Move 
{
    public int customer;
    public int movement;
    
    
    public MySwapMove( int customer, int movement )
    {   
        this.customer = customer;
        this.movement = movement;
    }   // end constructor
    
    
    public void operateOn( Solution soln )
    {
        int[] tour = ((MySolution)soln).tour;
        int   pos1 = -1;
        int   pos2 = -1;
        
        // Find positions
        for( int i = 0; i < tour.length && pos1 < 0; i++ )
            if( tour[i] == customer ) 
                pos1 = i;
        pos2 = pos1 + movement;
        
        // Swap
        int cust2 = tour[pos2];
        tour[pos1] = cust2;
        tour[pos2] = customer;
    }   // end operateOn
    
    
    /** Identify a move for SimpleTabuList */
    public int hashCode()
    {   
        return customer;
    }   // end hashCode
    
}   // end class MySwapMove
