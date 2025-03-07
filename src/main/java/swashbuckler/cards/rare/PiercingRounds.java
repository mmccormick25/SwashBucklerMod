package swashbuckler.cards.rare;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.ApplyPowerAction;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.powers.AbstractPower;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import swashbuckler.cards.AbstractEasyCard;
import swashbuckler.powers.PiercingRoundsPower;


import static swashbuckler.ModFile.makeID;

public class PiercingRounds extends AbstractEasyCard {
    public final static String ID = makeID("PiercingRounds");
    // intellij stuff skill, self, uncommon, , , , , ,

    public PiercingRounds() {
        super(ID, 1, CardType.POWER, CardRarity.RARE, CardTarget.SELF); // This card is a 2 cost basic attack targeting enemy
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot((AbstractGameAction)new ApplyPowerAction((AbstractCreature)p, (AbstractCreature)p, (AbstractPower)new PiercingRoundsPower((AbstractCreature)p, 1), 1));
    }

    @Override
    public void upp() {
        upgradeBaseCost(0);
    }
}