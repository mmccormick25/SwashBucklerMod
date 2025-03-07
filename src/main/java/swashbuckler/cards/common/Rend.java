package swashbuckler.cards.common;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.AbstractPower;
import swashbuckler.cards.AbstractEasyCard;
import swashbuckler.cards.tempCards.Treasure;
import swashbuckler.powers.BleedPower;
import swashbuckler.powers.LambdaPower;

import static swashbuckler.ModFile.makeID;
import static swashbuckler.util.Wiz.*;
import static swashbuckler.util.Wiz.removePower;

public class Rend extends AbstractEasyCard {
    public final static String ID = makeID("Rend");
    // intellij stuff skill, self, uncommon, , , , , ,

    public Rend() {
        super(ID, 0, CardType.SKILL, CardRarity.COMMON, CardTarget.ENEMY); // This card is a 2 cost basic attack targeting enemy
        baseMagicNumber = magicNumber = 2;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        applyToEnemy(m, new BleedPower(makeID("BleedPower"), "Bleed", AbstractPower.PowerType.DEBUFF, true, m, magicNumber));
    }

    @Override
    public void upp() {
        upgradeMagicNumber(2);
    }
}