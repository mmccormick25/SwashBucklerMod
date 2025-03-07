package swashbuckler.actions;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.CardGroup;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.localization.UIStrings;
import swashbuckler.cards.tempCards.Treasure;

import java.util.ArrayList;
import java.util.Iterator;

import static swashbuckler.util.Wiz.makeInHand;

public class LootAction extends AbstractGameAction {
    private AbstractPlayer p;

    private final boolean upgrade;

    private static final UIStrings uiStrings = CardCrawlGame.languagePack.getUIString("ExhumeAction");

    public static final String[] TEXT = uiStrings.TEXT;

    private ArrayList<AbstractCard> exhumes = new ArrayList<>();

    public LootAction(boolean upgrade) {
        this.upgrade = upgrade;
        this.p = AbstractDungeon.player;
        setValues((AbstractCreature)this.p, (AbstractCreature)AbstractDungeon.player, this.amount);
        this.actionType = AbstractGameAction.ActionType.CARD_MANIPULATION;
        this.duration = Settings.ACTION_DUR_FAST;
    }

    public void update() {
        if (this.duration == Settings.ACTION_DUR_FAST) {
            if (this.p.exhaustPile.isEmpty()) {
                this.isDone = true;
                return;
            }
            ArrayList<AbstractCard> cardsToRemove = new ArrayList<>();
            for (AbstractCard abstractCard : this.p.exhaustPile.group) {
                if (abstractCard.cardID.equals("swashbuckler:Treasure")) {
                    abstractCard.unfadeOut();
                    makeInHand(new Treasure());
                    cardsToRemove.add(abstractCard);
                    abstractCard.unhover();
                    abstractCard.fadingOut = false;
                }
            }
            for (AbstractCard card : cardsToRemove) {
                this.p.exhaustPile.removeCard(card);
            }
            this.isDone = true;
        }
    }
}
