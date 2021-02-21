package de.polylymer.commands.implementation

import de.polylymer.commands.SlashCommand
import dev.kord.common.Color
import dev.kord.common.annotation.KordPreview
import dev.kord.core.behavior.channel.TextChannelBehavior
import dev.kord.core.behavior.followUp
import dev.kord.core.entity.Message
import dev.kord.core.entity.channel.TextChannel
import dev.kord.core.entity.interaction.Interaction
import dev.kord.rest.Image
import dev.kord.rest.builder.message.EmbedBuilder
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.toList

@KordPreview
object StatsCommand : SlashCommand(
    name = "stats",
    description = "Shows your profile-stats"
) {

    override suspend fun handleCommand(interaction: Interaction) {
        interaction.acknowledge(true).followUp {
            embed {
                title = interaction.member.asUser().username
                val thumb = EmbedBuilder.Thumbnail()
                thumb.url = interaction.getGuild().getIconUrl(Image.Format.GIF)!!
                thumbnail = thumb
                val foot = EmbedBuilder.Footer()
                foot.icon = interaction.getGuild().getIconUrl(Image.Format.GIF)!!
                foot.text = interaction.getGuild().name
                footer = foot
                color = Color(0, 251, 255)
                field {
                    name = "Joined At"
                    value = interaction.member.asMember().memberData.joinedAt
                }
                field {
                    name = "Pending"
                    value = interaction.member.asMember().memberData.pending.toString()
                }
                if (!interaction.member.asMember().memberData.premiumSince.value.isNullOrEmpty()) {
                    field {
                        name = "Nitro since"
                        value = interaction.member.asMember().memberData.premiumSince.value!!
                    }
                }
                field {
                    name = "Roles"
                    var string = ""
                    for (id in interaction.member.asMember().memberData.roles) {
                        string += "@${interaction.guild.getRole(id).name}, "
                    }
                    value = string
                }
            }
        }
    }
}