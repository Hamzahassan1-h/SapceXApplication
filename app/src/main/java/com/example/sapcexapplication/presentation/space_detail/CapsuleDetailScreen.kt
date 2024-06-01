package com.example.sapcexapplication.presentation.space_detail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.sapcexapplication.domain.model.CapsuleDetail
import com.example.sapcexapplication.presentation.Screen
import com.example.sapcexapplication.presentation.space_list.componenets.CapsuleListItem

@Composable
fun CapsuleDetailScreen (
    viewModel: CapsuleDetailViewModel = hiltViewModel()
    //navController: NavController
){
    val state = viewModel.state.value
    Box(modifier = Modifier.fillMaxSize()){
        state.capsules?.let { capsules ->
            LazyColumn (
                modifier = Modifier.fillMaxSize(),
                //contentPadding = PaddingValues(20.dp)
            ){
                items(state.capsules){ capsule ->
                        Text(
                            text = "{${capsule.details}}"
                        )
                }
            }
        }

        if (state.error.isNotBlank()){
            Text(
                text = state.error,
                //color = MaterialTheme.colorScheme,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .align(Alignment.Center)
            )
        }
        if (state.isLoading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
    }

}