@file:OptIn(ExperimentalMaterial3Api::class)

package com.d121211050.lorempicsum.ui

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.lifecycle.viewmodel.compose.viewModel
import com.d121211050.lorempicsum.R
import com.d121211050.lorempicsum.ui.screens.HomeScreen
import com.d121211050.lorempicsum.ui.screens.LoremPicsumViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoremPicsumApp() {
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = { LoremPicsumTopAppBar(scrollBehavior = scrollBehavior) }
    ) {
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {
            val loremPicsumViewModel: LoremPicsumViewModel =
                viewModel(factory = LoremPicsumViewModel.Factory)
            HomeScreen(
                loremPicsumUiState = loremPicsumViewModel.loremPicsumUiState,
                retryAction = loremPicsumViewModel::getLoremPicsum
            )
        }
    }
}

@Composable
fun LoremPicsumTopAppBar(scrollBehavior: TopAppBarScrollBehavior, modifier: Modifier = Modifier) {
    CenterAlignedTopAppBar(
        scrollBehavior = scrollBehavior,
        title = {
            Text(
                text = stringResource(R.string.app_name),
                style = MaterialTheme.typography.headlineMedium.copy(
                    fontWeight = FontWeight.Medium)
            )
        },
        modifier = modifier
    )
}
