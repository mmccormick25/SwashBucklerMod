package swashbuckler.util;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ExhaustSpecificCardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;

public class HelperFunctions {

    public static boolean hasTreasure() {
        for (AbstractCard c : AbstractDungeon.player.hand.group) {
            System.out.println(c.cardID);
            if (c.cardID.equals("swashbuckler:Treasure")) {
                return true;
            }
        }
        return false;
    }

    public static int countTreasure() {
        int count = 0;
        for (AbstractCard c : AbstractDungeon.player.hand.group) {
            System.out.println(c.cardID);
            if (c.cardID.equals("swashbuckler:Treasure")) {
                count++;
            }
        }
        return count;
    }

}
