package swashbuckler.cards.common;

import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.AbstractPower;
import swashbuckler.cards.AbstractEasyCard;
import swashbuckler.powers.BleedPower;

import static swashbuckler.ModFile.makeID;
import static swashbuckler.util.Wiz.applyToEnemy;

public class Riposte extends AbstractEasyCard {
    public final static String ID = makeID("Riposte");
    // intellij stuff skill, self, uncommon, , , , , ,

    public Riposte() {
        super(ID, 1, CardType.SKILL, CardRarity.COMMON, CardTarget.ENEMY); // This card is a 2 cost basic attack targeting enemy
        baseMagicNumber = magicNumber = 2;
        baseBlock = 8;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        blck();
        applyToEnemy(m, new BleedPower(makeID("BleedPower"), "Bleed", AbstractPower.PowerType.DEBUFF, true, m, magicNumber));
    }

    @Override
    public void upp() {
        upgradeBlock(3);
        upgradeMagicNumber(1);
    }
}