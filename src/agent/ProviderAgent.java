package agent;

import gui.ProviderGui;
import jade.core.Agent;
import model.ProviderMessage;
import requestPerformer.ProviderRequestPerformer;

/**
 * @author Dylan Zote
 * created on 12/7/2021
 * Project jadeTutorial
 **/
public class ProviderAgent extends Agent {
    private ProviderGui providerGui;

    public ProviderAgent(ProviderGui providerGui) {
        this.providerGui = providerGui;
    }


    @Override
    protected void setup () {
        System.out.println("provider " + getAID().getName() + " signed in successfully ");
        
        var providerAgent = getAID().getName();
        var myGui = new ProviderGui(this);
        myGui.setVisible(myGui.isVisible());

        addBehaviour( new ProviderRequestPerformer());
    }

    public void SendMessage(ProviderMessage providerMessage) {
        addBehaviour(new  ProviderRequestPerformer());
    }

}
