package swashbuckler.cards.common;

import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import swashbuckler.actions.ExhaustTreasureAction;
import swashbuckler.cards.AbstractEasyCard;
import swashbuckler.util.HelperFunctions;

import static swashbuckler.ModFile.makeID;
import static swashbuckler.util.Wiz.atb;

public class Deal extends AbstractEasyCard {
    public final static String ID = makeID("Deal");
    // intellij stuff skill, self, basic, , ,  5, 3, ,

    public Deal() {
        super(ID, 1, CardType.SKILL, CardRarity.COMMON, CardTarget.SELF);
        baseMagicNumber = magicNumber = 2;
        baseSecondMagic = secondMagic = 3;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        if (HelperFunctions.hasTreasure()) {
            atb(new ExhaustTreasureAction());
            atb(new DrawCardAction(secondMagic));
        } else {
            atb(new DrawCardAction(magicNumber));
        }
    }

    @Override
    public void upp() {
        upgradeMagicNumber(1);
        upgradeSecondMagic(1);
    }
}