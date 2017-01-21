/*
    Copyright 2016 by minigameslib.de
    All rights reserved.
    If you do not own a hand-signed commercial license from minigames.de
    you are not allowed to use this software in any way except using
    GPL (see below).

------

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

package de.minigameslib.mgapi.impl;

import de.minigameslib.mclib.api.enums.ChildEnum;
import de.minigameslib.mclib.api.locale.LocalizedMessage;
import de.minigameslib.mclib.api.locale.LocalizedMessageInterface;
import de.minigameslib.mclib.api.locale.LocalizedMessages;
import de.minigameslib.mclib.api.locale.MessageComment;
import de.minigameslib.mclib.api.locale.MessageComment.Argument;
import de.minigameslib.mclib.api.locale.MessageSeverityType;
import de.minigameslib.mgapi.impl.MglibMessages.MglibCoreErrors;
import de.minigameslib.mgapi.impl.arena.ArenaImpl;
import de.minigameslib.mgapi.impl.cmd.AdminCheckCommand;
import de.minigameslib.mgapi.impl.cmd.AdminCommand;
import de.minigameslib.mgapi.impl.cmd.AdminCreateCommand;
import de.minigameslib.mgapi.impl.cmd.AdminDeleteCommand;
import de.minigameslib.mgapi.impl.cmd.AdminDisableCommand;
import de.minigameslib.mgapi.impl.cmd.AdminEnableCommand;
import de.minigameslib.mgapi.impl.cmd.AdminGuiCommand;
import de.minigameslib.mgapi.impl.cmd.AdminInviteCommand;
import de.minigameslib.mgapi.impl.cmd.AdminMaintainCommand;
import de.minigameslib.mgapi.impl.cmd.AdminSGuiCommand;
import de.minigameslib.mgapi.impl.cmd.AdminStartCommand;
import de.minigameslib.mgapi.impl.cmd.AdminStopCommand;
import de.minigameslib.mgapi.impl.cmd.AdminTestCommand;
import de.minigameslib.mgapi.impl.cmd.ArenaCommand;
import de.minigameslib.mgapi.impl.cmd.ArenasCommand;
import de.minigameslib.mgapi.impl.cmd.InfoCommand;
import de.minigameslib.mgapi.impl.cmd.InfoExtensionCommand;
import de.minigameslib.mgapi.impl.cmd.InfoExtensionsCommand;
import de.minigameslib.mgapi.impl.cmd.InfoMinigameCommand;
import de.minigameslib.mgapi.impl.cmd.InfoMinigamesCommand;
import de.minigameslib.mgapi.impl.cmd.JoinCommand;
import de.minigameslib.mgapi.impl.cmd.LeaveCommand;
import de.minigameslib.mgapi.impl.cmd.ManualCommand;
import de.minigameslib.mgapi.impl.cmd.Mg2Command;
import de.minigameslib.mgapi.impl.cmd.SpectateCommand;

/**
 * The common messages.
 * 
 * @author mepeisen
 */
@LocalizedMessages(value = "core")
@ChildEnum({
    // core
    MglibCoreErrors.class,
    ArenaImpl.Messages.class,
    // commands
    Mg2Command.Messages.class,
    InfoCommand.Messages.class,
    InfoMinigamesCommand.Messages.class,
    InfoExtensionsCommand.Messages.class,
    InfoMinigameCommand.Messages.class,
    InfoExtensionCommand.Messages.class,
    ArenasCommand.Messages.class,
    ArenaCommand.Messages.class,
    JoinCommand.Messages.class,
    SpectateCommand.Messages.class,
    ManualCommand.Messages.class,
    LeaveCommand.Messages.class,
    // admin commands
    AdminCommand.Messages.class,
    AdminCreateCommand.Messages.class,
    AdminDeleteCommand.Messages.class,
    AdminEnableCommand.Messages.class,
    AdminDisableCommand.Messages.class,
    AdminCheckCommand.Messages.class,
    AdminMaintainCommand.Messages.class,
    AdminStartCommand.Messages.class,
    AdminStopCommand.Messages.class,
    AdminTestCommand.Messages.class,
    AdminInviteCommand.Messages.class,
    AdminGuiCommand.Messages.class,
    AdminSGuiCommand.Messages.class,
})
public enum MglibMessages implements LocalizedMessageInterface
{
    
    /** Arena is disabled. */
    @LocalizedMessage(defaultMessage = "DISABLED", severity = MessageSeverityType.Error)
    @MessageComment({"Arena is disabled."})
    ArenaStateDisabled,
    
    /** Arena is under maintenance. */
    @LocalizedMessage(defaultMessage = "MAINTENANCE", severity = MessageSeverityType.Error)
    @MessageComment({"Arena is under meintenance."})
    ArenaStateMaintenance,
    
    /** Arena is in join state. */
    @LocalizedMessage(defaultMessage = "JOIN", severity = MessageSeverityType.Success)
    @MessageComment({"Arena is in join state."})
    ArenaStateJoin,
    
    /** Arena is starting. */
    @LocalizedMessage(defaultMessage = "START", severity = MessageSeverityType.Warning)
    @MessageComment({"Arena is starting."})
    ArenaStateStarting,
    
    /** Arena is in PreMatch state. */
    @LocalizedMessage(defaultMessage = "PRE-MATCH", severity = MessageSeverityType.Winner)
    @MessageComment({"Arena is in pre-match state."})
    ArenaStatePreMatch,
    
    /** Arena is in Match state. */
    @LocalizedMessage(defaultMessage = "MATCH", severity = MessageSeverityType.Winner)
    @MessageComment({"Arena is in match state."})
    ArenaStateMatch,
    
    /** Arena is in PostMatch state. */
    @LocalizedMessage(defaultMessage = "POST-MATCH", severity = MessageSeverityType.Winner)
    @MessageComment({"Arena is in post-match state."})
    ArenaStatePostMatch,
    
    /** Arena is resetting. */
    @LocalizedMessage(defaultMessage = "RESET", severity = MessageSeverityType.Warning)
    @MessageComment({"Arena is resetting."})
    ArenaStateRestarting,
    
    /** Library is initializing. */
    @LocalizedMessage(defaultMessage = "INIT", severity = MessageSeverityType.Error)
    @MessageComment({"Library is initializing."})
    StateInitializing,
    
    /** Library is running. */
    @LocalizedMessage(defaultMessage = "RUNNING", severity = MessageSeverityType.Success)
    @MessageComment({"Library is running."})
    StateRunning,
    
    /** Library is terminating. */
    @LocalizedMessage(defaultMessage = "TERMINATING", severity = MessageSeverityType.Error)
    @MessageComment({"Library is terminating."})
    StateTerminating,
    
    /** Library is sleeping/ inactive. */
    @LocalizedMessage(defaultMessage = "SLEEPING", severity = MessageSeverityType.Error)
    @MessageComment({"Library is sleeping."})
    StateSleeping,
    
    /** true flag */
    @LocalizedMessage(defaultMessage = "✓", severity = MessageSeverityType.Success)
    @MessageComment({"true flag"})
    FlagTrue,
    
    /** false flag */
    @LocalizedMessage(defaultMessage = "✗", severity = MessageSeverityType.Error)
    @MessageComment({"false flag"})
    FlagFalse,
    
    /**
     * Standard plugin version
     */
    @LocalizedMessage(defaultMessage = "default")
    @MessageComment({"Standard plugin version"})
    ModeStandard,
    
    /**
     * Premium plugin vrsion
     */
    @LocalizedMessage(defaultMessage = "premium")
    @MessageComment({"Premium plugin version"})
    ModePremium;
    
    /**
     * Common error messages
     */
    @LocalizedMessages(value = "core.errors")
    public enum MglibCoreErrors implements LocalizedMessageInterface
    {
        
        /**
         * Library is in wrong state; operation cannot proceed.
         */
        @LocalizedMessage(defaultMessage = "Library in wrong state.", severity = MessageSeverityType.Error)
        @MessageComment({"Library is in wrong state; operation cannot proceed."})
        LibInWrongState,
        
        /**
         * Arena name contains illegal characters.
         */
        @LocalizedMessage(defaultMessage = "Arena name contains illegal characters.", severity = MessageSeverityType.Error)
        @MessageComment(
                value = {"Arena name contains illegal characters."},
                args = {@Argument("Arena name")})
        InvalidArenaName,
        
        /**
         * Arena data filename does not correspond to internal name.
         */
        @LocalizedMessage(defaultMessage = "Arena data filename (" + LocalizedMessage.BLUE + "%1$s.yml" + LocalizedMessage.DARK_RED + ") does not correspond to internal name. Did you copy yml files?", severity = MessageSeverityType.Error)
        @MessageComment(
                value = {"Arena data filename does not correspond to internal name."},
                args = {@Argument("Arena name")})
        ArenaNameMismatch,
        
        /**
         * Arena is duplicate
         */
        @LocalizedMessage(defaultMessage = "Arena " + LocalizedMessage.BLUE + "%1$s.yml" + LocalizedMessage.DARK_RED + " already exists", severity = MessageSeverityType.Error)
        @MessageComment(
                value = {"Arena is duplicate"},
                args = {@Argument("Arena name")})
        ArenaDuplicate,
        
        /**
         * Plugin tries to register multiple minigames
         */
        @LocalizedMessage(defaultMessage = "Plugin " + LocalizedMessage.BLUE + "%1$s.yml" + LocalizedMessage.DARK_RED + " already registered a minigame", severity = MessageSeverityType.Error)
        @MessageComment(
            value = {"Plugin tries to register multiple minigames"},
            args = {@Argument("Plugin name")})
        PluginMinigameDuplicate,
        
        /**
         * Minigame with given name is already registered
         */
        @LocalizedMessage(defaultMessage = "Minigame " + LocalizedMessage.BLUE + "%1$s.yml" + LocalizedMessage.DARK_RED + " already registered", severity = MessageSeverityType.Error)
        @MessageComment(
            value = {"Minigame with given name is already registered"},
            args = {@Argument("Minigame name")})
        MinigameAlreadyRegistered,
        
        /**
         * Plugin tries to register multiple extensions
         */
        @LocalizedMessage(defaultMessage = "Plugin " + LocalizedMessage.BLUE + "%1$s.yml" + LocalizedMessage.DARK_RED + " already registered an extension", severity = MessageSeverityType.Error)
        @MessageComment(
            value = {"Plugin tries to register multiple extensions"},
            args = {@Argument("Plugin name")})
        PluginExtensionDuplicate,
        
        /**
         * Extension with given name is already registered
         */
        @LocalizedMessage(defaultMessage = "Extension " + LocalizedMessage.BLUE + "%1$s.yml" + LocalizedMessage.DARK_RED + " already registered", severity = MessageSeverityType.Error)
        @MessageComment(
            value = {"Extension with given name is already registered"},
            args = {@Argument("Extension name")})
        ExtensionAlreadyRegistered,
        
    }
    
}
