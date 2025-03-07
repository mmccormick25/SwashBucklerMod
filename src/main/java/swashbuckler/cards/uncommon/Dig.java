package swashbuckler.cards.uncommon;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.StrengthPower;
import swashbuckler.actions.EasyXCostAction;
import swashbuckler.actions.MakeTreasureAction;
import swashbuckler.cards.AbstractEasyCard;
import swashbuckler.cards.tempCards.Treasure;

import static swashbuckler.ModFile.makeID;
import static swashbuckler.util.Wiz.*;

public class Dig extends AbstractEasyCard {
    public final static String ID = makeID("Dig");
    // intellij stuff skill, self, uncommon, , , , , ,


    public Dig() {
        super(ID, -1, CardType.SKILL, CardRarity.UNCOMMON, CardTarget.SELF);
        baseMagicNumber = magicNumber = 1;
        exhaust = true;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        atb(new EasyXCostAction(this, (effect, params) -> {
            for (int i = 0; i < effect + params[0]; i++)
                atb(new MakeTreasureAction());
            return true;
        }, magicNumber));
    }

    @Override
    public void upp() {
        upgradeMagicNumber(1);
    }
}