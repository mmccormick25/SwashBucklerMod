package swashbuckler.cards.uncommon;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.AbstractPower;
import swashbuckler.actions.MakeTreasureAction;
import swashbuckler.cards.AbstractEasyCard;
import swashbuckler.powers.LambdaPower;

import static swashbuckler.ModFile.makeID;
import static swashbuckler.util.Wiz.applyToSelf;
import static swashbuckler.util.Wiz.atb;

public class GhostlyRemains extends AbstractEasyCard {
    public final static String ID = makeID("GhostlyRemains");
    // intellij stuff power, self, uncommon

    public GhostlyRemains() {
        super(ID, 1, CardType.POWER, CardRarity.UNCOMMON, CardTarget.SELF);
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        applyToSelf(new LambdaPower(makeID("GhostlyRemainsPower"), "Ghostly Remains", AbstractPower.PowerType.BUFF, false, p, 0) {
            @Override
            public void onExhaust(AbstractCard card) {
                if (card.isEthereal) {
                    atb(new MakeTreasureAction());
                }
            }

            @Override
            public void updateDescription() {
                description = "Ghostly Remains";
            }
        });
    }

    @Override
    public void upp() {
        upgradeBaseCost(0);
    }
}