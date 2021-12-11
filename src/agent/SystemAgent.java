package agent;

import gui.ProviderGui;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;
import requestPerformer.ProviderRequestPerformer;

/**
 * @author Dylan Zote
 * created on 12/7/2021
 * Project jadeTutorial
 **/
public class SystemAgent extends Agent {

    @Override
    protected void setup () {
        System.out.println("system " + getAID().getName() + " signed in successfully ");


        addBehaviour( new OfferRequestsServer());
    }

    private class OfferRequestsServer extends CyclicBehaviour {
        public void action() {
            MessageTemplate mt = MessageTemplate.MatchPerformative(ACLMessage.CFP);
            ACLMessage msg = myAgent.receive(mt);
            if (msg != null) {
                // CFP Message received. Process it
                String title = msg.getContent();
                ACLMessage reply = msg.createReply();


                if (reply != null) {
                    // The requested book is available for sale. Reply with the price
                    reply.setPerformative(ACLMessage.PROPOSE);
                    reply.setContent("accepted");
                } else {
                    // The requested book is NOT available for sale.
                    reply.setPerformative(ACLMessage.REFUSE);
                    reply.setContent("refusede");
                }
                myAgent.send(reply);
            } else {
                block();
            }
        }
    }  // End of inner class OfferRequestsServer

}


