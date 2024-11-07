package pt.pprojects.pokelist.presentation.pokelist

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.absolutePadding
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import pt.pprojects.pokelist.presentation.model.PokemonItem
import coil3.compose.AsyncImage

@Composable
fun PokeList(
    modifier: Modifier,
    pokemons: List<PokemonItem>,
    onItemClick: () -> Unit
) {
    Column(
        modifier = modifier
    ) {
        pokemons.forEach { pokemon ->
            PokemonCard(pokemon, onItemClick)
        }
    }
}

@Composable
fun PokemonCard(pokemon: PokemonItem, onItemClick: () -> Unit) {
    ElevatedCard(
        elevation = CardDefaults.cardElevation(defaultElevation =16.dp),
        shape = RoundedCornerShape(6.dp),
        modifier = Modifier.absolutePadding(
            left = 16.dp,
            top = 16.dp,
            right = 16.dp
        ),
        onClick = onItemClick
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                modifier = Modifier.padding(16.dp),
                text = pokemon.number,
            )
            Text(
                text = pokemon.name,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth(),
                textAlign = TextAlign.Start
            )
            AsyncImage(
                model = pokemon.image,
                contentDescription = "Pokemon ${pokemon.number} Image",
                modifier = Modifier
                    .size(64.dp)
                    .padding(end = 16.dp)
            )
        }
    }
}
