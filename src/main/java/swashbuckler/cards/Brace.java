package swashbuckler.cards;

import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import swashbuckler.actions.ExhaustTreasureAction;
import swashbuckler.util.HelperFunctions;

import static swashbuckler.ModFile.makeID;
import static swashbuckler.util.Wiz.atb;

public class Brace extends AbstractEasyCard {
    public final static String ID = makeID("Brace");
    // intellij stuff skill, self, basic, , ,  5, 3, ,

    public Brace() {
        super(ID, 1, CardType.SKILL, CardRarity.BASIC, CardTarget.SELF);
        baseBlock = 5;
        magicNumber = baseMagicNumber = 11;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        if (HelperFunctions.hasTreasure()) {
            atb(new ExhaustTreasureAction());
            atb(new GainBlockAction(AbstractDungeon.player, magicNumber));
        } else {
            atb(new GainBlockAction(AbstractDungeon.player, baseBlock));
        }
    }

    @Override
    public void upp() {
        upgradeBlock(3);
        upgradeMagicNumber(3);
    }
}