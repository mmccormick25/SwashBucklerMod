package swashbuckler.cards.uncommon;

import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import com.megacrit.cardcrawl.powers.AbstractPower;
import swashbuckler.cards.AbstractEasyCard;
import swashbuckler.cards.tempCards.Knife;
import swashbuckler.powers.BleedPower;

import static swashbuckler.ModFile.makeID;
import static swashbuckler.util.Wiz.applyToEnemy;
import static swashbuckler.util.Wiz.makeInHand;

public class SliceAndDice extends AbstractEasyCard {
    public final static String ID = makeID("SliceAndDice");
    // intellij stuff skill, self, uncommon, , , , , ,

    public SliceAndDice() {
        super(ID, 1, CardType.SKILL, CardRarity.UNCOMMON, CardTarget.SELF); // This card is a 2 cost basic attack targeting enemy
        baseMagicNumber = magicNumber = 2;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        for (AbstractMonster mo : (AbstractDungeon.getCurrRoom()).monsters.monsters) {
            applyToEnemy(mo, new BleedPower(makeID("BleedPower"), "Bleed", AbstractPower.PowerType.DEBUFF, true, mo, magicNumber));
        }
        makeInHand(new Knife());
        makeInHand(new Knife());
    }

    @Override
    public void upp() {
        upgradeMagicNumber(1);
    }
}