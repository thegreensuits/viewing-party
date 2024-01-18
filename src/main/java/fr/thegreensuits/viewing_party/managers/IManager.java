package fr.thegreensuits.viewing_party.managers;

public interface IManager {
    void init();
    default void stop() {}
}
