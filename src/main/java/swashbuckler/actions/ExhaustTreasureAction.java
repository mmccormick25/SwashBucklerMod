package swashbuckler.actions;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.actions.common.ExhaustSpecificCardAction;
import com.megacrit.cardcrawl.unlock.UnlockTracker;

public class ExhaustTreasureAction extends AbstractGameAction {
    private float startingDuration = Settings.ACTION_DUR_FAST;

    public void update() {
        for (AbstractCard c : AbstractDungeon.player.hand.group) {
            System.out.println(c.cardID);
            if (c.cardID.equals("swashbuckler:Treasure")) {
                addToTop((AbstractGameAction) new ExhaustSpecificCardAction(c, AbstractDungeon.player.hand));
                break;
            }
        }
        this.isDone = true;
    }
}
