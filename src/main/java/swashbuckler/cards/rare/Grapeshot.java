package swashbuckler.cards.rare;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import swashbuckler.cards.AbstractEasyCard;

import static swashbuckler.ModFile.makeID;

public class Grapeshot extends AbstractEasyCard{ // This card implements StartupCard, an extra 'type' of card that adds the ability to trigger at the start of combat.
    public final static String ID = makeID(Grapeshot.class.getSimpleName());
    // intellij stuff skill, self, uncommon, , , , , ,

    public Grapeshot() {
        super(ID, 1, CardType.ATTACK, CardRarity.RARE, CardTarget.SELF); // This card is a 1 cost Common Skill that targets an enemy.
        baseDamage = 4;
        isMultiDamage = true; // This card attacks ALL enemies, so isMultiDamage is true...
        this.isEthereal = true;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        allDmg(AbstractGameAction.AttackEffect.FIRE); // and allDmg is used instead of dmg.
        allDmg(AbstractGameAction.AttackEffect.FIRE); // and allDmg is used instead of dmg.
        allDmg(AbstractGameAction.AttackEffect.FIRE); // and allDmg is used instead of dmg.
        //addToTop(new ExhaustTreasureAction());
    }

    @Override
    public void upp() {
        upgradeDamage(1);
    }
}