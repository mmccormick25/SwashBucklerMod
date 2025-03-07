package swashbuckler.powers;

import com.megacrit.cardcrawl.cards.DamageInfo;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.powers.AbstractPower;

import static swashbuckler.util.Wiz.removePower;

public class LeechPower extends LambdaPower {
    public LeechPower(String ID, String name, PowerType powerType, boolean isTurnBased, AbstractCreature owner, int amount) {
        super(ID, name, powerType, isTurnBased, owner, amount);
    }

        @Override
        public void atEndOfTurn(boolean isPlayer) {
            this.amount--;
            if (this.amount <= 0) {
                removePower(this);
            }
        }

    @Override
    public void updateDescription() {
        description = "Leech " + amount;
        }
}

