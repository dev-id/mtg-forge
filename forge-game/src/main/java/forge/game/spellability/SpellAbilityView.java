package forge.game.spellability;

import forge.game.card.CardView;
import forge.trackable.TrackableCollection;
import forge.trackable.TrackableObject;
import forge.trackable.TrackableProperty;


public class SpellAbilityView extends TrackableObject {
    public static SpellAbilityView get(SpellAbility spab) {
        return spab == null ? null : spab.getView();
    }

    public static TrackableCollection<SpellAbilityView> getCollection(Iterable<SpellAbility> spabs) {
        if (spabs == null) {
            return null;
        }
        TrackableCollection<SpellAbilityView> collection = new TrackableCollection<SpellAbilityView>();
        for (SpellAbility spab : spabs) {
            collection.add(spab.getView());
        }
        return collection;
    }

    SpellAbilityView(SpellAbility sa) {
        super(sa.getId());
        updateHostCard(sa);
        updateDescription(sa);
        updatePromptIfOnlyPossibleAbility(sa);
    }

    @Override
    public String toString() {
        return this.getDescription();
    }

    public CardView getHostCard() {
        return get(TrackableProperty.HostCard);
    }
    void updateHostCard(SpellAbility sa) {
        set(TrackableProperty.HostCard, CardView.get(sa.getHostCard()));
    }

    public String getDescription() {
        return get(TrackableProperty.Description);
    }
    void updateDescription(SpellAbility sa) {
        set(TrackableProperty.Description, sa.toUnsuppressedString());
    }

    public boolean canPlay() {
        return get(TrackableProperty.CanPlay);
    }
    void updateCanPlay(SpellAbility sa) {
        set(TrackableProperty.CanPlay, sa.canPlay());
    }

    public boolean promptIfOnlyPossibleAbility() {
        return get(TrackableProperty.PromptIfOnlyPossibleAbility);
    }
    void updatePromptIfOnlyPossibleAbility(SpellAbility sa) {
        set(TrackableProperty.PromptIfOnlyPossibleAbility, sa.promptIfOnlyPossibleAbility());
    }
}
