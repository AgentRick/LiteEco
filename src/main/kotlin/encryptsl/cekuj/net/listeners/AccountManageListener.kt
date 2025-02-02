package encryptsl.cekuj.net.listeners

import encryptsl.cekuj.net.LiteEco
import encryptsl.cekuj.net.api.enums.OperationType
import encryptsl.cekuj.net.api.events.AccountManageEvent
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener

class AccountManageListener(private val liteEco: LiteEco) : Listener {

    @EventHandler
    fun onEconomyManage(event: AccountManageEvent) {
        val player: Player = event.player

        when (event.operationType) {
            OperationType.CREATE_ACCOUNT -> { liteEco.api.createAccount(player, liteEco.config.getDouble("economy.starting_balance")) }
            OperationType.CACHING_ACCOUNT -> { liteEco.api.cacheAccount(player, liteEco.preparedStatements.getBalance(player.uniqueId))}
            OperationType.SYNC_ACCOUNT -> liteEco.api.syncAccount(player)
            OperationType.REMOVE_ACCOUNT -> liteEco.api.deleteAccount(player)
        }
    }
}