package swashbuckler.cards.common;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import swashbuckler.cards.AbstractEasyCard;

import static swashbuckler.ModFile.makeID;

public class SwiftShots extends AbstractEasyCard{ // This card implements StartupCard, an extra 'type' of card that adds the ability to trigger at the start of combat.
    public final static String ID = makeID(SwiftShots.class.getSimpleName());
    // intellij stuff skill, self, uncommon, , , , , ,

    public SwiftShots() {
        super(ID, 1, CardType.ATTACK, CardRarity.COMMON, CardTarget.ENEMY); // This card is a 1 cost Common Skill that targets an enemy.
        baseDamage = 4;
        isMultiDamage = true; // This card attacks ALL enemies, so isMultiDamage is true...
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        dmg(m, AbstractGameAction.AttackEffect.FIRE);
        dmg(m, AbstractGameAction.AttackEffect.FIRE);
    }

    @Override
    public void upp() {
        upgradeDamage(2);
    }
}