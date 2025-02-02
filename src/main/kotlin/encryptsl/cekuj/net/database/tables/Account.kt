package encryptsl.cekuj.net.database.tables

import org.jetbrains.exposed.sql.Table

object Account : Table("lite_eco") {
    private val id = integer( "id").autoIncrement()
    val username = varchar("username", 36)
    val uuid = varchar("uuid", 36)
    val money = double("money")

    override val primaryKey: PrimaryKey = PrimaryKey(id)
}