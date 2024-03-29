package de.polylymer.commands.implementation

import de.polylymer.KordEXT.member
import de.polylymer.commands.SlashCommand
import dev.kord.common.annotation.KordPreview
import dev.kord.core.behavior.interaction.followUp
import dev.kord.core.entity.interaction.Interaction

@KordPreview
object RandomCommand : SlashCommand(
    name = "random",
    description = "Don't ask"
) {

    val list = listOf("https://cdn.discordapp.com/attachments/774273183804948500/811650709484208169/unknown.png", "https://tenor.com/view/finals-spongebob-squidward-nervous-breakdown-gif-12911512", "https://tenor.com/view/walking-shoes-sneaker-going-away-gif-13461262", "https://tenor.com/view/shaun-the-sheep6-shaun-the-sheep-shaun-das-schaf-shaun-le-mouton-shaun-vita-da-pecora-gif-16663792",
    "https://tenor.com/view/shaun-the-sheep-farmageddon-aardman-shaun-movie-funny-gif-14478418", "https://tenor.com/view/patricick-yum-yum-comiendo-gif-10070451", "https://tenor.com/view/goat-goat-lick-tongue-out-gif-5193394", "https://tenor.com/view/dance-spongebob-current-mood-gif-5089933", "https://tenor.com/view/squidward-crazy-paper-college-spongebob-gif-5439517", "https://tenor.com/view/dance-shark-summer-vibes-gif-7929165",
    "https://media.discordapp.net/attachments/774274615408328724/809743719057326122/ouahhhh_MeIn_CaPe_GeHt_NiChT.gif", "https://tenor.com/view/embarrassed-spongebob-ciao-im-out-bye-gif-5120732",
        "\"Nam ist ein Junge und kein Mädchen\" ~ Mysterio", "\"BlueSneakers ist kein Blauer Sneaker sonder einer Blauer Schleicher\" ~ BlueSneakers", "https://cdn.discordapp.com/attachments/774596130541142037/811914431029837835/tenor.gif", "https://cdn.discordapp.com/attachments/774596130541142037/811914767747776522/200.gif", "https://cdn.discordapp.com/attachments/774596130541142037/811917662019649536/mrbean_foeyqqrl.gif", "{ping} hast du eig bisschen obsi für mich? xD")

    override suspend fun handleCommand(interaction: Interaction) {
        interaction.ackowledgePublic().followUp {
            content = list.random().replace("{ping}", interaction.member().asMember().mention)
        }
    }

}