package tubes.maven.Thread;


import java.util.ArrayList;

import tubes.maven.Player.Deck;


public class DeckThreat implements Runnable{
    private static DeckThreat deckThreat;

    private ArrayList<StatusDeck> deckStatus;
    
    private DeckThreat(Deck deck){
        deckStatus = new ArrayList<StatusDeck>();
        for (int i = 0; i < deck.getDeck().size(); i++)  {
            deckStatus.add(new StatusDeck(deck.getDeck().get(i)));
        }
    }


    public static DeckThreat getDeckThreatInstance(Deck deck){
        if (deckThreat == null) {
            deckThreat = new DeckThreat(deck);
        }
        return deckThreat;
    }

    public static DeckThreat getDeckThreatInstance(){
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
