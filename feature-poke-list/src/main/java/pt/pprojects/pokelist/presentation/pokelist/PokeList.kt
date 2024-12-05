package pt.pprojects.pokelist.presentation.pokelist

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.absolutePadding
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
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
import androidx.compose.foundation.lazy.items
import coil3.compose.AsyncImage

@Composable
fun PokeList(
    modifier: Modifier,
    pokemons: List<PokemonItem>,
    onItemClick: (String) -> Unit
) {
    LazyColumn(
        modifier = modifier
    ) {
        items(pokemons) { pokemon ->
            PokemonCard(pokemon, onItemClick)
        }
    }
}

@Composable
fun PokemonCard(pokemon: PokemonItem, onItemClick: (String) -> Unit) {
    ElevatedCard(
        elevation = CardDefaults.cardElevation(defaultElevation =16.dp),
        shape = RoundedCornerShape(6.dp),
        modifier = Modifier.absolutePadding(
            left = 16.dp,
            top = 16.dp,
            right = 16.dp
        ),
        onClick = {
            onItemClick(pokemon.number)
        }
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
