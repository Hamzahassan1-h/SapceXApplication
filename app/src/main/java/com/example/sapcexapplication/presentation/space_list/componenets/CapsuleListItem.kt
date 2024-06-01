package com.example.sapcexapplication.presentation.space_list.componenets

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.sapcexapplication.domain.model.Capsule

@Composable
fun CapsuleListItem (
    capsule: Capsule,
    onItemClick: (Capsule) -> Unit
) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onItemClick(capsule) }
            .padding(20.dp),
        //horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "${capsule.capsuleId}. ${capsule.capsuleSerial}",
            style = MaterialTheme.typography.bodyMedium,
            overflow = TextOverflow.Ellipsis
        )
//        Text(
//            text =
//        )
    }

}