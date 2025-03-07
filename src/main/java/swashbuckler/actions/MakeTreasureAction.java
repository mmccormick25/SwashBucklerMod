package swashbuckler.actions;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.UIStrings;
import swashbuckler.cards.tempCards.Treasure;

import java.util.ArrayList;

import static swashbuckler.util.Wiz.makeInHand;

public class MakeTreasureAction extends AbstractGameAction {
    private AbstractPlayer p;

    private static final UIStrings uiStrings = CardCrawlGame.languagePack.getUIString("ExhumeAction");

    public static final String[] TEXT = uiStrings.TEXT;

    private ArrayList<AbstractCard> exhumes = new ArrayList<>();

    public MakeTreasureAction() {
        this.p = AbstractDungeon.player;
        setValues((AbstractCreature)this.p, (AbstractCreature)AbstractDungeon.player, this.amount);
        this.actionType = ActionType.CARD_MANIPULATION;
        this.duration = Settings.ACTION_DUR_FAST;
    }

    public void update() {
        Treasure t = new Treasure();
        if (p.hasPower("swashbuckler:BigSpenderPower")) {
            t.upgrade();
        }
        makeInHand(t);
        this.isDone = true;
    }
}
