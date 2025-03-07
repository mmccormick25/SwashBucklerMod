package swashbuckler.cards.common;

import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import swashbuckler.actions.MakeTreasureAction;
import swashbuckler.cards.AbstractEasyCard;
import swashbuckler.cards.tempCards.Treasure;
import swashbuckler.cards.tempCards.Knife;

import static swashbuckler.ModFile.makeID;
import static swashbuckler.util.Wiz.atb;
import static swashbuckler.util.Wiz.makeInHand;

public class HiddenWeapon extends AbstractEasyCard {
    public final static String ID = makeID("HiddenWeapon");
    // intellij stuff skill, self, basic, , ,  5, 3, ,

    public HiddenWeapon() {
        super(ID, 1, CardType.SKILL, CardRarity.COMMON, CardTarget.SELF);
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        atb(new MakeTreasureAction());
        makeInHand(new Knife());
    }

    @Override
    public void upp() {
        upgradeBaseCost(0);
    }
}