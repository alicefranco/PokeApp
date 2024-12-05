package pt.pprojects.pokelist.presentation.pokemondetails

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import pt.pprojects.pokelist.R
import pt.pprojects.pokelist.presentation.model.DetailItem
import pt.pprojects.pokelist.presentation.model.PokemonDetails

@Composable
fun PokemonDetail(pokemon: PokemonDetails, onCloseDetails: () -> Unit) {
    Header(pokemon.pokemonNumber, onCloseDetails)
    AsyncImage(
        model = pokemon.images.frontDefault,
        contentDescription = "Pokemon image",
        contentScale = ContentScale.Fit,
        modifier = Modifier.size(250.dp)
    )
    Text(
        pokemon.pokemonName,
        textAlign = TextAlign.Center,
        fontWeight = FontWeight.Bold,
        fontSize = 24.sp,
        modifier = Modifier
            .fillMaxWidth()
    )
    Text(
        pokemon.pokemonName,
        textAlign = TextAlign.Center,
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp,
        color = Color.Gray,
        modifier = Modifier
            .fillMaxWidth()
    )
    PhysicalDetails(pokemon)
    HorizontalDivider(
        thickness = 1.dp,
        color = Color.Gray,
        modifier = Modifier.padding(horizontal = 16.dp)
    )
    DifferentForms(pokemon)
    HorizontalDivider(
        color = Color.Gray,
        thickness = 1.dp,
        modifier = Modifier.padding(horizontal = 16.dp)

    )
    ItemList(title = stringResource(R.string.label_abilities), content = pokemon.abilities)
    HorizontalDivider(
        color = Color.Gray,
        thickness = 1.dp,
        modifier = Modifier.padding(horizontal = 16.dp)

    )
    ItemList(title = stringResource(R.string.label_moves), content = pokemon.moves)
}

@Composable
fun Header(id: String, onCloseDetails: () -> Unit) {
    Row (
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Text(
            id,
            modifier = Modifier.padding(top = 2.dp)
        )
        IconButton(
            onClick = onCloseDetails,
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_close),
                contentScale = ContentScale.Fit,
                contentDescription = "Logo",
            )
        }
    }
}

@Composable
fun PhysicalDetails(pokemon: PokemonDetails) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp, bottom = 16.dp),
        verticalAlignment = Alignment.Bottom,
        horizontalArrangement = Arrangement.SpaceEvenly,
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                pokemon.weight,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
            )
            Text(
                stringResource(R.string.label_weight),
                textAlign = TextAlign.Center,
                color = Color.Gray,
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(top = 6.dp)
            )
        }
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Row {
                pokemon.types.forEach {
                    Column(
                        modifier = Modifier.padding(horizontal = 4.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Image(
                            modifier = Modifier
                                .padding(top = 16.dp)
                                .size(36.dp),
                            painter = painterResource(id = it.image),
                            contentScale = ContentScale.Fit,
                            contentDescription = "Type",
                        )
                        Text(
                            it.name,
                            textAlign = TextAlign.Center,
                            color = Color.Gray,
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }
        }
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                pokemon.height,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
            )
            Text(
                stringResource(R.string.label_height),
                textAlign = TextAlign.Center,
                color = Color.Gray,
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(top = 6.dp)
            )
        }
    }
}

@Composable
fun DifferentForms(pokemon: PokemonDetails) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp, bottom = 8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly,
    ) {
        pokemon.images.frontShiny?.let {
            PokemonForm(image = it, type = R.drawable.ic_gender_male_shiny)
        }
        pokemon.images.frontFemale?.let {
            PokemonForm(image = it, type = R.drawable.ic_gender_female)
        }
        pokemon.images.frontFemaleShiny?.let {
            PokemonForm(image = it, type = R.drawable.ic_gender_female_shiny)
        }
    }
}

@Composable
fun PokemonForm(image: String, type: Int) {
    Box(
        contentAlignment = Alignment.BottomEnd
    ) {
        AsyncImage(
            model = image,
            contentDescription = "Pokemon form",
            contentScale = ContentScale.Fit,
            modifier = Modifier.size(100.dp)
        )
        Image(
            painter = painterResource(type),
            contentDescription = "Form type"
        )
    }
}

@Composable
fun ItemList(title: String, content: List<DetailItem>) {
    Text(
        title,
        textAlign = TextAlign.Start,
        fontWeight = FontWeight.Bold,
        fontSize = 12.sp,
        color = Color.Gray,
        modifier = Modifier
            .padding(top = 8.dp, start = 16.dp, end = 16.dp)
            .fillMaxWidth()
    )
    Column(
        modifier = Modifier
            .padding(start = 16.dp, end = 16.dp, bottom = 8.dp)
            .fillMaxWidth()
    ) {
        content.forEach {
            Row {
                Image(
                    painter = painterResource(R.drawable.ic_dot),
                    contentDescription = "Item dot"
                )
                Text(
                    it.description,
                    fontSize = 14.sp
                )
            }
        }
    }
}