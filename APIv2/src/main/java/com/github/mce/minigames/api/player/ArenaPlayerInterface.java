/*
    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.
*/

package com.github.mce.minigames.api.player;

import java.io.Serializable;
import java.util.Locale;
import java.util.UUID;

import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

import com.github.mce.minigames.api.MinigameException;
import com.github.mce.minigames.api.arena.ArenaInterface;
import com.github.mce.minigames.api.arena.WaitQueue;
import com.github.mce.minigames.api.context.MinigameStorage;
import com.github.mce.minigames.api.gui.ClickGuiInterface;
import com.github.mce.minigames.api.gui.GuiSessionInterface;
import com.github.mce.minigames.api.locale.LocalizedMessageInterface;
import com.github.mce.minigames.api.perms.PermissionsInterface;
import com.github.mce.minigames.api.util.function.MgOutgoingStubbing;
import com.github.mce.minigames.api.util.function.MgPredicate;

/**
 * Interface representing players, maybe inside arenas.
 * 
 * @author mepeisen
 */
public interface ArenaPlayerInterface
{
    
    // common methods (player info)
    
    /**
     * Returns the bukkit player (if this player is online).
     * 
     * @return bukkit player.
     */
    Player getBukkitPlayer();
    
    /**
     * Returns the name of the player.
     * 
     * @return name of the player.
     */
    String getName();
    
    /**
     * Returns the bukkit offline player.
     * 
     * @return bukkit offline player.
     */
    OfflinePlayer getOfflinePlayer();
    
    /**
     * Returns the players uuid.
     * 
     * @return uuid.
     */
    UUID getPlayerUUID();
    
    // localization
    
    /**
     * Sends a message to given player.
     * 
     * @param msg
     *            message to send.
     * @param args
     *            arguments to use for this message.
     */
    void sendMessage(LocalizedMessageInterface msg, Serializable... args);
    
    /**
     * Returns the preferred locale
     * 
     * @return preferred user locale or {@code null} if the player uses server default locale.
     */
    Locale getPreferredLocale();
    
    /**
     * Sets the preferred locale for this user.
     * 
     * @param locale
     *            preferred locale
     * @throws MinigameException
     *             thrown if there are problems saving the data.
     */
    void setPreferredLocale(Locale locale) throws MinigameException;
    
    // arena data
    
    /**
     * Returns the arena this player is currently in; within a match.
     * 
     * @return arena or {@code null} if this player is currently not within any arena.
     */
    ArenaInterface getArena();
    
    /**
     * Get the waiting queues this player joined.
     * 
     * @return waiting queues.
     */
    Iterable<WaitQueue> getWaitingQueues();
    
    /**
     * Joins a waiting queue for the next match.
     * 
     * @param queue
     */
    void join(WaitQueue queue);
    
    // permissions check
    
    /**
     * Checks if the user has a permission.
     * 
     * @param perm
     *            permission to check.
     * @return {@code true} if the user has a permission.
     */
    boolean checkPermission(PermissionsInterface perm);
    
    // storage
    
    /**
     * Returns a storage only available within the current execution context.
     * 
     * <p>
     * This storage can be useful to temporary add data, for example across multiple events.
     * </p>
     * 
     * @return context storage.
     */
    MinigameStorage getContextStorage();
    
    /**
     * Returns a session storage only hold in memory.
     * 
     * <p>
     * This storage can be useful to temporary add data till the server stops or the user logs out.
     * </p>
     * 
     * @return session storage.
     */
    MinigameStorage getSessionStorage();
    
    /**
     * Returns a persistent storage written to disc.
     * 
     * <p>
     * This storage can be useful to persistent data on the disc.
     * </p>
     * 
     * @return context storage.
     */
    MinigameStorage getPersistentStorage();
    
    // gui
    
    /**
     * Returns the current gui session (if any)
     * 
     * @return gui session or {@code null} if the user has no opened gui.
     */
    GuiSessionInterface getGuiSession();
    
    /**
     * Lets the player opening a new gui session.
     * 
     * @param gui
     *            gui to display
     * @return gui session
     * @throws MinigameException
     *             thrown if the player is not online.
     */
    GuiSessionInterface openGui(ClickGuiInterface gui) throws MinigameException;
    
    // stubbing
    
    /**
     * Checks this player for given criteria and invokes either then or else statements.
     * 
     * <p>
     * NOTICE: If the test function throws an exception it will be re thrown and no then or else statement will be invoked.
     * </p>
     * 
     * @param test
     *            test functions for testing the player matching any criteria.
     * 
     * @return the outgoing stub to apply then or else consumers.
     * 
     * @throws MinigameException
     *             will be thrown if either the test function or then/else consumers throw the exception.
     */
    MgOutgoingStubbing<ArenaPlayerInterface> when(MgPredicate<ArenaPlayerInterface> test) throws MinigameException;
    
    /**
     * Returns a test function to check if the user is online on the current server.
     * 
     * @return predicate to return {@code true} if the arena player is online.
     */
    static MgPredicate<ArenaPlayerInterface> isOnline()
    {
        return (pl) -> pl.getBukkitPlayer() != null;
    }
    
    /**
     * Returns a test function to check if the user is inside any arena on the current server.
     * 
     * @return predicate to return {@code true} if the player is inside any arena on the current server.
     */
    static MgPredicate<ArenaPlayerInterface> isInArena()
    {
        return (pl) -> pl.getArena() != null;
    }
    
    /**
     * Returns a test function to check if the user has a given permission.
     * 
     * @param perm
     *            the permission to check.
     * 
     * @return predicate to return {@code true} if the player has given permission.
     */
    static MgPredicate<ArenaPlayerInterface> hasPerm(PermissionsInterface perm)
    {
        return (pl) -> pl.checkPermission(perm);
    }
    
}
