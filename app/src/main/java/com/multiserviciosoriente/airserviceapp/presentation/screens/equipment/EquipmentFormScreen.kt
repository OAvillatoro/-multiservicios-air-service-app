package com.multiserviciosoriente.airserviceapp.presentation.screens.equipment

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun EquipmentFormScreen(
    onBackClick: () -> Unit,
    onSaveClick: () -> Unit
) {
    val primaryBlue = Color(0xFF003F99)
    val darkBlue = Color(0xFF002B75)
    val orange = Color(0xFFFF9800)
    val textDark = Color(0xFF17213D)

    var equipmentType by remember { mutableStateOf("Minisplit Inverter") }
    var brand by remember { mutableStateOf("") }
    var model by remember { mutableStateOf("") }
    var serialNumber by remember { mutableStateOf("") }
    var location by remember { mutableStateOf("") }
    var technicalDetails by remember { mutableStateOf("") }
    var installationDate by remember { mutableStateOf("") }
    var capacity by remember { mutableStateOf("") }
    var voltage by remember { mutableStateOf("") }
    var refrigerantGas by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF7F9FD))
            .navigationBarsPadding()
    ) {
        Column(
            modifier = Modifier
                .weight(1f)
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 18.dp)
        ) {
            Spacer(modifier = Modifier.height(22.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "‹",
                    color = darkBlue,
                    fontSize = 42.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.clickable { onBackClick() }
                )

                Column(
                    modifier = Modifier.padding(start = 12.dp)
                ) {
                    Text(
                        text = "Agregar equipo",
                        color = textDark,
                        fontSize = 26.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Text(
                        text = "Completa la información técnica del equipo",
                        color = Color(0xFF5D6678),
                        fontSize = 14.sp
                    )
                }
            }

            Spacer(modifier = Modifier.height(18.dp))

            Surface(
                modifier = Modifier.fillMaxWidth(),
                color = Color.White,
                shape = RoundedCornerShape(18.dp),
                shadowElevation = 4.dp
            ) {
                Column(
                    modifier = Modifier.padding(18.dp)
                ) {
                    SectionTitle(
                        icon = "📋",
                        title = "Información básica",
                        color = primaryBlue
                    )

                    Spacer(modifier = Modifier.height(14.dp))

                    AppTextField(
                        label = "Tipo de equipo *",
                        value = equipmentType,
                        onValueChange = { equipmentType = it },
                        placeholder = "Ej. Minisplit Inverter",
                        primaryBlue = primaryBlue
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    Row(
                        horizontalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        AppTextField(
                            label = "Marca *",
                            value = brand,
                            onValueChange = { brand = it },
                            placeholder = "Ej. Samsung",
                            primaryBlue = primaryBlue,
                            modifier = Modifier.weight(1f)
                        )

                        AppTextField(
                            label = "Modelo *",
                            value = model,
                            onValueChange = { model = it },
                            placeholder = "Ej. WindFree 12,000 BTU",
                            primaryBlue = primaryBlue,
                            modifier = Modifier.weight(1f)
                        )
                    }

                    Spacer(modifier = Modifier.height(12.dp))

                    AppTextField(
                        label = "Número de serie *",
                        value = serialNumber,
                        onValueChange = { serialNumber = it },
                        placeholder = "Ej. SA12WF2024A001256",
                        primaryBlue = primaryBlue
                    )
                }
            }

            Spacer(modifier = Modifier.height(14.dp))

            Surface(
                modifier = Modifier.fillMaxWidth(),
                color = Color.White,
                shape = RoundedCornerShape(18.dp),
                shadowElevation = 4.dp
            ) {
                Column(
                    modifier = Modifier.padding(18.dp)
                ) {
                    SectionTitle(
                        icon = "📍",
                        title = "Ubicación del equipo",
                        color = primaryBlue
                    )

                    Spacer(modifier = Modifier.height(14.dp))

                    AppTextField(
                        label = "Ubicación *",
                        value = location,
                        onValueChange = { location = it },
                        placeholder = "Ej. Sala principal",
                        primaryBlue = primaryBlue
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    AppTextField(
                        label = "Descripción adicional",
                        value = technicalDetails,
                        onValueChange = { technicalDetails = it },
                        placeholder = "Ej. Pared este, al lado de la ventana",
                        primaryBlue = primaryBlue,
                        minLines = 3
                    )
                }
            }

            Spacer(modifier = Modifier.height(14.dp))

            Surface(
                modifier = Modifier.fillMaxWidth(),
                color = Color.White,
                shape = RoundedCornerShape(18.dp),
                shadowElevation = 4.dp
            ) {
                Column(
                    modifier = Modifier.padding(18.dp)
                ) {
                    SectionTitle(
                        icon = "⚙️",
                        title = "Detalles técnicos",
                        color = primaryBlue
                    )

                    Spacer(modifier = Modifier.height(14.dp))

                    Row(
                        horizontalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        AppTextField(
                            label = "Capacidad BTU",
                            value = capacity,
                            onValueChange = { capacity = it },
                            placeholder = "Ej. 12000",
                            primaryBlue = primaryBlue,
                            keyboardType = KeyboardType.Number,
                            modifier = Modifier.weight(1f)
                        )

                        AppTextField(
                            label = "Voltaje",
                            value = voltage,
                            onValueChange = { voltage = it },
                            placeholder = "Ej. 220",
                            primaryBlue = primaryBlue,
                            keyboardType = KeyboardType.Number,
                            modifier = Modifier.weight(1f)
                        )
                    }

                    Spacer(modifier = Modifier.height(12.dp))

                    AppTextField(
                        label = "Tipo de gas refrigerante",
                        value = refrigerantGas,
                        onValueChange = { refrigerantGas = it },
                        placeholder = "Ej. R-410A",
                        primaryBlue = primaryBlue
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    AppTextField(
                        label = "Fecha de instalación *",
                        value = installationDate,
                        onValueChange = { installationDate = it },
                        placeholder = "Ej. 15/04/2024",
                        primaryBlue = primaryBlue
                    )
                }
            }

            Spacer(modifier = Modifier.height(14.dp))

            Surface(
                modifier = Modifier.fillMaxWidth(),
                color = Color(0xFFFFF7E8),
                shape = RoundedCornerShape(14.dp)
            ) {
                Row(
                    modifier = Modifier.padding(14.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier
                            .size(42.dp)
                            .clip(CircleShape)
                            .background(orange.copy(alpha = 0.18f)),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "ℹ️",
                            fontSize = 22.sp
                        )
                    }

                    Spacer(modifier = Modifier.width(10.dp))

                    Text(
                        text = "La información del equipo permitirá asociarlo a solicitudes de mantenimiento preventivo o correctivo.",
                        color = Color(0xFF4B5878),
                        fontSize = 14.sp,
                        lineHeight = 19.sp
                    )
                }
            }

            Spacer(modifier = Modifier.height(18.dp))
        }

        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 14.dp, vertical = 8.dp),
            color = Color.White,
            shape = RoundedCornerShape(18.dp),
            shadowElevation = 6.dp
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(76.dp)
                    .padding(horizontal = 12.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                OutlinedButton(
                    onClick = onBackClick,
                    modifier = Modifier.weight(1f),
                    shape = RoundedCornerShape(12.dp)
                ) {
                    Text(
                        text = "Cancelar",
                        color = primaryBlue,
                        fontWeight = FontWeight.Bold
                    )
                }

                Button(
                    onClick = onSaveClick,
                    modifier = Modifier.weight(1.4f),
                    shape = RoundedCornerShape(12.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = primaryBlue
                    )
                ) {
                    Text(
                        text = "Guardar equipo",
                        color = Color.White,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
    }
}

@Composable
private fun SectionTitle(
    icon: String,
    title: String,
    color: Color
) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(38.dp)
                .clip(RoundedCornerShape(10.dp))
                .background(color.copy(alpha = 0.12f)),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = icon,
                fontSize = 20.sp
            )
        }

        Spacer(modifier = Modifier.width(10.dp))

        Text(
            text = title,
            color = color,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )
    }

    Spacer(modifier = Modifier.height(8.dp))

    Divider()
}

@Composable
private fun AppTextField(
    label: String,
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String,
    primaryBlue: Color,
    modifier: Modifier = Modifier,
    minLines: Int = 1,
    keyboardType: KeyboardType = KeyboardType.Text
) {
    Column(
        modifier = modifier
    ) {
        Text(
            text = label,
            color = Color(0xFF17213D),
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(6.dp))

        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            placeholder = {
                Text(
                    text = placeholder,
                    color = Color(0xFF8A93A6),
                    fontSize = 14.sp
                )
            },
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(12.dp),
            minLines = minLines,
            keyboardOptions = KeyboardOptions(
                keyboardType = keyboardType
            ),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = primaryBlue,
                unfocusedBorderColor = Color(0xFFD0D7E2),
                cursorColor = primaryBlue,
                focusedTextColor = Color(0xFF17213D),
                unfocusedTextColor = Color(0xFF17213D),
                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color.White
            )
        )
    }
}

