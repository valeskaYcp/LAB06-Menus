package com.example.lab06

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsScreen(navController: NavHostController) {
    var notificationsEnabled by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Configuración") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = "Volver"
                        )
                    }
                }
            )
        },
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Text(
                    text = "Ajustes",
                    style = MaterialTheme.typography.titleMedium
                )

                SettingSwitch(
                    label = "Habilitar Notificaciones",
                    checked = notificationsEnabled,
                    onCheckedChange = { enabled -> notificationsEnabled = enabled }
                )

                SettingLabel(
                    text = "Cambiar Contraseña",
                    onClick = { /* cambiar la contraseña */ }
                )
                SettingLabel(
                    text = "Cambiar el idioma",
                    onClick = { /* cambiar el idioma */ }
                )
                SettingLabel(
                    text = "Actualizar Información",
                    onClick = { /* actualizar información */ }
                )
                SettingLabel(
                    text = "Configuración de Privacidad",
                    onClick = { /* configurar privacidad */ }
                )
                SettingLabel(
                    text = "Eliminar Cuenta",
                    onClick = { /* eliminar cuenta */ },
                    textColor = Color.Red
                )
                SettingLabel(
                    text = "Cerrar Sesión",
                    onClick = { /* cerrar sesión */ }
                )
            }
        }
    )
}

@Composable
fun SettingSwitch(label: String, checked: Boolean, onCheckedChange: (Boolean) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = label)
        Switch(
            checked = checked,
            onCheckedChange = onCheckedChange
        )
    }
}

@Composable
fun SettingLabel(text: String, onClick: () -> Unit, textColor: Color = MaterialTheme.colorScheme.onBackground) {
    Text(
        text = text,
        color = textColor,
        fontSize = 16.sp,
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onClick)
            .padding(8.dp)
    )
}
