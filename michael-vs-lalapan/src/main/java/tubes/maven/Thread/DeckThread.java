package tubes.maven.Thread;


import java.util.ArrayList;

import tubes.maven.Player.Deck;


public class DeckThread implements Runnable{
    private static DeckThread deckThreat;

    private ArrayList<StatusDeck> deckStatus;
    
    private DeckThread(Deck deck){
        deckStatus = new ArrayList<StatusDeck>();
        for (int i = 0; i < deck.getDeck().size(); i++)  {
            deckStatus.add(new StatusDeck(deck.getDeck().get(i)));
        }
    }

    public static void setDeckThreatInstance(DeckThread deck){
        deckThreat = deck;
    }


    public static DeckThread getDeckThreatInstance(Deck deck){
        if (deckThreat == null) {
            deckThreat = new DeckThread(deck);
        }
        return deckThreat;
    }

    public static DeckThread getDeckThreatInstance(){
        return deckThreat;
    }

    public static void resetDeckThreat(){
        deckThreat = null;
    }

    @Override
    public void run() {
            for (StatusDeck statusDeck : deckStatus) {
                if (!statusDeck.isReadyToPlant() && statusDeck.getLastTimeCreated() + statusDeck.getInterval() <= Time.getTime().getTotalSeconds()) {
                    statusDeck.setReadyToPlant(true);
                }
            }
        
    }

    public ArrayList<StatusDeck> getDeckStatus() {
        return deckStatus;
    }
}
