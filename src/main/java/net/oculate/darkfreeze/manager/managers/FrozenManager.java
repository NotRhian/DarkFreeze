package net.oculate.darkfreeze.manager.managers;

import net.oculate.darkfreeze.DarkFreeze;
import net.oculate.darkfreeze.manager.Manager;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class FrozenManager extends Manager {

    private Set<UUID> frozenPlayers;

    public FrozenManager(DarkFreeze plugin) {
        super(plugin);
        frozenPlayers = new HashSet<>();
    }

    public void freezePlayer(UUID uuid) {
        frozenPlayers.add(uuid);
    }

    public void unfreezePlayer(UUID uuid) {
        frozenPlayers.remove(uuid);
    }

    public boolean isFrozen(UUID uuid) {
        return frozenPlayers.contains(uuid);
    }

    public void unfreezeAll() {
        frozenPlayers.clear();
    }
}