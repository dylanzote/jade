package agent;

import jade.core.Agent;

import java.util.logging.Logger;


/**
 * @author Dylan Zote
 * created on 12/7/2021
 * Project jadeTutorial
 **/

public class ClientAgent extends Agent{

    @Override
    protected void setup () {
        System.out.println("Hallo! Buyer-agent " +getAID().getName()+ "is ready.");
        System.out.println("Hallo! Buyer-agent " +getAID().getName()+ "is ready.");
        System.out.println("Hallo! Buyer-agent " +getAID().getName()+ "is ready.");
    }

}
