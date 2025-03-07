package swashbuckler.cards.common;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import swashbuckler.actions.MakeTreasureAction;
import swashbuckler.cards.AbstractEasyCard;
import swashbuckler.cards.tempCards.Treasure;

import static swashbuckler.ModFile.makeID;
import static swashbuckler.util.Wiz.atb;
import static swashbuckler.util.Wiz.makeInHand;

public class Sail extends AbstractEasyCard {
    public final static String ID = makeID("Sail");
    // intellij stuff skill, self, uncommon, , , , , ,

    public Sail() {
        super(ID, 1, CardType.SKILL, CardRarity.COMMON, CardTarget.SELF); // This card is a 2 cost basic attack targeting enemy
        cardsToPreview = new Treasure(); // Preview a miracle
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        atb(new DrawCardAction(1));
        atb(new MakeTreasureAction());
    }

    @Override
    public void upp() {
    }
}