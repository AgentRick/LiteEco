package encryptsl.cekuj.net.api.events.admin
import org.bukkit.OfflinePlayer
import org.bukkit.command.CommandSender
import org.bukkit.event.Cancellable
import org.bukkit.event.Event
import org.bukkit.event.HandlerList

@Suppress("UNUSED")
class EconomyMoneyWithdrawEvent(val commandSender: CommandSender, val offlinePlayer: OfflinePlayer, val money: Double, val silent: Boolean): Event(), Cancellable {

    private var isCancelled: Boolean = false

    override fun getHandlers(): HandlerList {
        return HANDLERS
    }

    override fun isCancelled(): Boolean {
        return isCancelled
    }

    override fun setCancelled(cancel: Boolean) {
        this.isCancelled = cancel
    }

    companion object {
        private val HANDLERS = HandlerList()
        @JvmStatic
        fun getHandlerList(): HandlerList {
            return HANDLERS
        }
    }
}