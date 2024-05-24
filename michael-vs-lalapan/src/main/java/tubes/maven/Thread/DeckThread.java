package tubes.maven.Thread;


import java.util.ArrayList;

import tubes.maven.Player.Deck;


public class DeckThread implements Runnable{
    private static DeckThread deckThread;

    private ArrayList<StatusDeck> deckStatus;
    
    private DeckThread(Deck deck){
        deckStatus = new ArrayList<StatusDeck>();
        for (int i = 0; i < deck.getDeck().size(); i++)  {
            deckStatus.add(new StatusDeck(deck.getDeck().get(i)));
        }
    }

    public static void setDeckThreadInstance(DeckThread deck){
        deckThread = deck;
    }


    public static DeckThread getDeckThreadInstance(Deck deck){
        if (deckThread == null) {
            deckThread = new DeckThread(deck);
        }
        return deckThread;
    }

    public static DeckThread getDeckThreadInstance(){
        return deckThread;
    }

    public static void resetDeckThread(){
        deckThread = null;
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
