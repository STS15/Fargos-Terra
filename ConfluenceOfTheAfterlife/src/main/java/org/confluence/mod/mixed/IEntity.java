package org.confluence.mod.mixed;

public interface IEntity {
    void confluence$entity_setCoolDown(int ticks);

    void confluence$setOriginalNoGravity(boolean bool);

    boolean confluence$isInShimmer();

    byte HAD_SETUP = -1;
    byte HAS_GRAVITY = 0;
    byte NO_GRAVITY = 1;
}
