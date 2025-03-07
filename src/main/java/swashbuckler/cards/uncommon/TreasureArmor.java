package swashbuckler.cards.uncommon;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.AbstractPower;
import swashbuckler.cards.AbstractEasyCard;
import swashbuckler.powers.LambdaPower;

import static swashbuckler.ModFile.makeID;
import static swashbuckler.util.Wiz.applyToSelf;
import static swashbuckler.util.Wiz.atb;

public class TreasureArmor extends AbstractEasyCard {
    public final static String ID = makeID("TreasureArmor");
    // intellij stuff power, self, uncommon

    public TreasureArmor() {
        super(ID, 1, CardType.POWER, CardRarity.UNCOMMON, CardTarget.SELF);
        baseMagicNumber = magicNumber = 3;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        applyToSelf(new LambdaPower(makeID("TreasureArmorPower"), "Treasure Armor", AbstractPower.PowerType.BUFF, false, p, magicNumber) {
            @Override
            public void onExhaust(AbstractCard card) {
                if (card.cardID.equals("swashbuckler:Treasure")) {
                    addToBot((AbstractGameAction) new GainBlockAction(p, amount, Settings.FAST_MODE));
                }
            }

            @Override
            public void updateDescription() {
                description = "Treasure Armor " + amount;
            }
        });
    }

    @Override
    public void upp() {
        upgradeMagicNumber(1);
    }
}