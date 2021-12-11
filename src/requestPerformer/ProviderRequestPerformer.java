package requestPerformer;

import agent.ProviderAgent;
import jade.core.behaviours.Behaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;

/**
 * @author Dylan Zote
 * created on 12/8/2021
 * Project jadeTutorial
 **/

public class ProviderRequestPerformer extends Behaviour {

    private int step = 0;
    @Override
    public void action() {
        switch (step) {
            case 0:
                ACLMessage msg = new ACLMessage(ACLMessage.CFP);
                msg.addReceiver(myAgent.getAID());
                msg.setContent("agent login");
                msg.setConversationId("login-trade");
                msg.setReplyWith("cfp"+System.currentTimeMillis()); // Unique value
                myAgent.send(msg);

                // Prepare the template to get proposals
                var mt = MessageTemplate.and(MessageTemplate.MatchConversationId("login-trade"),
                        MessageTemplate.MatchInReplyTo(msg.getReplyWith()));
                step = 1;
                break;
            case 1:
                MessageTemplate mts = MessageTemplate.MatchPerformative(ACLMessage.CFP);
                ACLMessage msgs = myAgent.receive(mts);
                if (msgs != null) {
                    // CFP Message received. Process it
                    String title = msgs.getContent();
                    ACLMessage reply = msgs.createReply();


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
                break;
        }
    }

    @Override
    public boolean done() {
        return false;
    }
}
