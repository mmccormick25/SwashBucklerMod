package swashbuckler.cards.uncommon;

import com.megacrit.cardcrawl.actions.common.GainBlockAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import swashbuckler.actions.MakeTreasureAction;
import swashbuckler.cards.AbstractEasyCard;

import static swashbuckler.ModFile.makeID;
import static swashbuckler.util.Wiz.atb;

public class SpectralMist extends AbstractEasyCard {
    public final static String ID = makeID("SpectralMist");
    // intellij stuff skill, self, basic, , ,  5, 3, ,

    public SpectralMist() {
        super(ID, 2, CardType.SKILL, CardRarity.UNCOMMON, CardTarget.SELF);
        baseBlock = 16;
        this.isEthereal = true;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        atb(new GainBlockAction(AbstractDungeon.player, baseBlock));
    }

    @Override
    public void upp() {
        upgradeBlock(4);
    }
}