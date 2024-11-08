package pt.pprojects.pokelist.presentation.pokemondetails

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.absolutePadding
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import pt.pprojects.pokelist.R


const val POKE_DETAILS = "details"
@Composable
fun PokemonDetailScreen(pokemonId: String, onCloseDetails: () -> Unit) {
    Box(
        modifier = Modifier.background(colorResource(id = R.color.colorPrimary))
    ) {
        ElevatedCard(
            elevation = CardDefaults.cardElevation(defaultElevation = 16.dp),
            shape = RoundedCornerShape(6.dp),
            modifier = Modifier.absolutePadding(
                left = 16.dp,
                top = 16.dp,
                right = 16.dp
            ),
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = Color.White)
            ) {
                FirstRow("#1", onCloseDetails)
                AsyncImage(
                    model = "https://images-wixmp-ed30a86b8c4ca887773594c2.wixmp.com/f/4a47b50e-cf1a-4594-9276-a81dd8cb914a/dfaasvy-f73ddbaa-d4f2-4863-addf-9391cbf363bd.png?token=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1cm46YXBwOjdlMGQxODg5ODIyNjQzNzNhNWYwZDQxNWVhMGQyNmUwIiwiaXNzIjoidXJuOmFwcDo3ZTBkMTg4OTgyMjY0MzczYTVmMGQ0MTVlYTBkMjZlMCIsIm9iaiI6W1t7InBhdGgiOiJcL2ZcLzRhNDdiNTBlLWNmMWEtNDU5NC05Mjc2LWE4MWRkOGNiOTE0YVwvZGZhYXN2eS1mNzNkZGJhYS1kNGYyLTQ4NjMtYWRkZi05MzkxY2JmMzYzYmQucG5nIn1dXSwiYXVkIjpbInVybjpzZXJ2aWNlOmZpbGUuZG93bmxvYWQiXX0.8IpIN-i91mA5kTKmI7jJQPr7r5LiTBLZSJ0mYhivmac",
                    contentDescription = "Pokemon image"
                )
                Text(
                    "Bulbasaur",
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp,
                    modifier = Modifier
                        .fillMaxWidth()
                )
                Text(
                    "Bulbasaur",
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                    color = Color.Gray,
                    modifier = Modifier
                        .fillMaxWidth()
                )
                PhysicalDetails()
                HorizontalDivider(
                    thickness = 1.dp,
                    color = Color.Gray,
                    modifier = Modifier.padding(16.dp)
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceEvenly,
                ) {
                    Image(
                        painter = painterResource(R.drawable.ic_1),
                        contentDescription = "",
                        contentScale = ContentScale.Fit,
                        modifier = Modifier.size(100.dp)
                    )
                    Image(
                        painter = painterResource(R.drawable.ic_1),
                        contentDescription = "",
                        contentScale = ContentScale.Fit,
                        modifier = Modifier.size(100.dp)
                    )
                    Image(
                        painter = painterResource(R.drawable.ic_1),
                        contentDescription = "",
                        contentScale = ContentScale.Fit,
                        modifier = Modifier.size(100.dp)
                    )
                }
                HorizontalDivider(
                    color = Color.Gray,
                    thickness = 1.dp,
                    modifier = Modifier.padding(horizontal = 16.dp)

                )
                Text(
                "ABILITIES",
                    textAlign = TextAlign.Start,
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp,
                    color = Color.Gray,
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth()
                )
                LazyColumn {}
            }
        }
    }
}

@Composable
fun FirstRow(id: String, onCloseDetails: () -> Unit) {
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
fun PhysicalDetails() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly,
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                "62.9Kg",
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
            )
            Text(
                "WEIGHT",
                textAlign = TextAlign.Center,
                color = Color.Gray,
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
            )
        }
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Image(
                modifier = Modifier
                    .padding(top = 16.dp)
                    .size(36.dp),
                painter = painterResource(id = R.drawable.ic_fire),
                contentScale = ContentScale.Fit,
                contentDescription = "Type",
            )
            Text(
                "FIRE",
                textAlign = TextAlign.Center,
                color = Color.Gray,
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
            )
        }
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                "0.7m",
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
            )
            Text(
                "HEIGHT",
                textAlign = TextAlign.Center,
                color = Color.Gray,
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
            )
        }
    }
}


//    private fun handleResult(result: Result<PokemonDetails>) {
//        when (result) {
//            is Result.Success -> {
//                setPokemonDetails(result.data)
//            }
//            is Result.Loading -> {
//            }
//            is Result.Error -> {
//                showErrorDialog(getString(R.string.error_title), result.cause.message)
//            }
//        }
//    }
//
//    private fun showErrorDialog(
//        title: String,
//        message: String?
//    ) {
//        this.showDialog(
//            title,
//            message,
//            positiveAction = {
//                pokemonId?.let { pokemonDetailsViewModel.getPokemonDetails(it) }
//            },
//            negativeAction = {
//                finish()
//            }
//        )
//    }
//}