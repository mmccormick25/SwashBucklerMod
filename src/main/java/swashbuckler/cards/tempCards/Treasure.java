package swashbuckler.cards.tempCards;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.GainEnergyAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import swashbuckler.cards.AbstractEasyCard;

import static swashbuckler.ModFile.makeID;
import static swashbuckler.util.Wiz.makeInHand;

public class Treasure extends AbstractEasyCard {
    public final static String ID = makeID("Treasure");
    // intellij stuff skill, self, uncommon, , , , , ,

    public Treasure() {
        super(ID, 0, CardType.SKILL, CardRarity.SPECIAL, CardTarget.SELF); // This card is a 2 cost basic attack targeting enemy
        this.exhaust = true;
        baseMagicNumber = magicNumber = 1;
        this.selfRetain = true;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        addToBot((AbstractGameAction)new GainEnergyAction(magicNumber));
    }

    @Override
    public void upp() {upgradeMagicNumber(1);}
}