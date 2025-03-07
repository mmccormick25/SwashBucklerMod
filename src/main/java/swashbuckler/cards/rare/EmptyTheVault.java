package swashbuckler.cards.rare;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import swashbuckler.actions.ExhaustTreasureAction;
import swashbuckler.cards.AbstractEasyCard;
import swashbuckler.util.HelperFunctions;

import static com.megacrit.cardcrawl.helpers.input.InputActionSet.settings;
import static swashbuckler.ModFile.makeID;
import static swashbuckler.util.HelperFunctions.countTreasure;
import static swashbuckler.util.Wiz.atb;

public class EmptyTheVault extends AbstractEasyCard {
    public final static String ID = makeID("EmptyTheVault");
    // intellij stuff attack, enemy, basic, 6, 3,  , , ,

    public EmptyTheVault() {
        super(ID, 1, CardType.ATTACK, CardRarity.RARE, CardTarget.SELF);
        baseDamage = damage = 7;
        this.exhaust = true;
        isMultiDamage = true;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        int count = countTreasure();

        for (int i = 0; i < count; i++) {
            atb(new ExhaustTreasureAction());
        }

        for (int i = 0; i < count; i++) {
            allDmg(AbstractGameAction.AttackEffect.FIRE); // and allDmg is used instead of dmg.
        }

    }

    @Override
    public void upp() {
        upgradeDamage(3);
    }
}