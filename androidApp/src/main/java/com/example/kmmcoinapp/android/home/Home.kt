package com.example.kmmcoinapp.android.home

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.kmmcoinapp.domain.domain_model.Coin
import com.example.kmmcoinapp.domain.domain_model.Status
import com.example.kmmcoinapp.presentation.GenericState
import com.example.kmmcoinapp.presentation.home.GetAllCoinsViewModel
import org.koin.androidx.compose.getViewModel


@Composable
fun Home(
    viewModel: GetAllCoinsViewModel = getViewModel()
) {
    val state by viewModel.state.collectAsState()
    LaunchedEffect(key1 = Unit) {
        viewModel.getAllCoins(1, 10)
    }
    CoinList(state = state)
}

@Composable
fun CoinList(
    state: GenericState<List<Coin>>
) {

    val listState = rememberLazyListState()
    LazyColumn(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp),
        state = listState,
        contentPadding = PaddingValues(16.dp),
        modifier = Modifier.fillMaxSize()
    ) {
        item {
            Spacer(Modifier.windowInsetsTopHeight(WindowInsets.safeDrawing))
        }
        when (state) {
            is GenericState.Idle -> loading()
            is GenericState.Loading -> loading()
            is GenericState.Response -> itemList(state.data)
            is GenericState.Error -> error(state.status)
            else -> placeHolder()


        }
    }
}

fun LazyListScope.placeHolder() {

}

fun LazyListScope.error(status: Status) {
    item {
        Text(text = status.errorMessage.toString())
    }
}

fun LazyListScope.itemList(
    coinList: List<Coin>
) {
    items(coinList) { item ->
        coinItem(item)
    }
}

fun LazyListScope.loading() {
    item {
        CircularProgressIndicator()
    }
}

@Composable
fun coinItem(coin: Coin) {
    Card(
        shape = MaterialTheme.shapes.medium,
        modifier = Modifier
            .fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        elevation = CardDefaults.cardElevation(1.dp)
    ) {

        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = coin.name.toString(),
                style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Bold),
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
            Text(
                text = coin.rank.toString(),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                style = MaterialTheme.typography.bodyMedium
            )

            Text(
                text = coin.symbol.toString(), style = MaterialTheme.typography.bodySmall.copy(
                    MaterialTheme.colorScheme.primary, fontWeight = FontWeight.Bold
                )
            )
        }
    }
}
