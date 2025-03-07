package swashbuckler.cards.rare;

import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.AbstractPower;
import swashbuckler.cards.AbstractEasyCard;
import swashbuckler.powers.LambdaPower;

import static swashbuckler.ModFile.makeID;
import static swashbuckler.util.Wiz.applyToSelf;

public class BigSpender extends AbstractEasyCard {
    public final static String ID = makeID("BigSpender");
    // intellij stuff skill, self, uncommon, , , , , ,

    public BigSpender() {
        super(ID, 3, CardType.POWER, CardRarity.RARE, CardTarget.SELF); // This card is a 2 cost basic attack targeting enemy
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        applyToSelf(new LambdaPower(makeID("BigSpenderPower"), "BigSpender", AbstractPower.PowerType.BUFF, false, p, 0) {
            @Override
            public void updateDescription() {
                description = "Big Spender";
            }
        });
    }

    @Override
    public void upp() {
        upgradeBaseCost(2);
    }
}