package AllCards;

import GameCards.CardClass;
import GameCards.Minion;
import GameCards.Rarity;
import Logic_GUIInterfaces.GameChar;
import Logic_cards.CardVisitor;
import javax.persistence.Entity;

@Entity
public class MurlocRaider extends Minion {
    public MurlocRaider() {
    }

    public MurlocRaider(String cardName, int manaCost, int gemCost, CardClass cardClass, Rarity rarity, String cardDescription, int attack, int hp) {
        super(cardName,manaCost,gemCost,cardClass,rarity,cardDescription,attack,hp);
    }
    @Override
    public void accept(CardVisitor cardVisitor, GameChar target) {
        cardVisitor.murlocRaiderVisit(this,target);
    }
}
