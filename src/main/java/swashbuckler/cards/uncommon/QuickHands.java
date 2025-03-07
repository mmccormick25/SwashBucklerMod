package swashbuckler.cards.uncommon;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import swashbuckler.cards.AbstractEasyCard;
import swashbuckler.cards.tempCards.Treasure;

import static swashbuckler.ModFile.makeID;
import static swashbuckler.util.Wiz.atb;
import static swashbuckler.util.Wiz.makeInHand;

public class QuickHands extends AbstractEasyCard {
    public final static String ID = makeID("QuickHands");
    // intellij stuff skill, self, uncommon, , , , , ,

    public QuickHands() {
        super(ID, 0, CardType.SKILL, CardRarity.UNCOMMON, CardTarget.SELF); // This card is a 2 cost basic attack targeting enemy
        baseMagicNumber = magicNumber = 2;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        if (p.gold >= 3) {
            AbstractDungeon.player.loseGold(3);
            atb(new DrawCardAction(magicNumber));
        }
    }

    @Override
    public void upp() {
        upgradeMagicNumber(1);
    }
}