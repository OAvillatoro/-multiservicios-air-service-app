package com.multiserviciosoriente.airserviceapp.presentation.screens.requests

import androidx.compose.foundation.BorderStroke
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
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ScheduleTechnicianScreen(
    onBackClick: () -> Unit
) {
    val primaryBlue = Color(0xFF003F99)
    val darkBlue = Color(0xFF002B75)
    val orange = Color(0xFFFF9800)
    val green = Color(0xFF00865A)
    val textDark = Color(0xFF17213D)

    var scheduledDate by remember { mutableStateOf("21/05/2024") }
    var scheduledTime by remember { mutableStateOf("09:30 AM") }
    var technician by remember { mutableStateOf("Carlos Méndez - Técnico HVAC") }
    var technicianPhone by remember { mutableStateOf("7000-1111") }
    var observations by remember { mutableStateOf("El técnico llevará repuestos básicos para revisión inicial.") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF7F9FD))
            .navigationBarsPadding()
    ) {
        ScheduleTopBar(
            primaryBlue = primaryBlue,
            darkBlue = darkBlue,
            onBackClick = onBackClick
        )

        Column(
            modifier = Modifier
                .weight(1f)
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 18.dp)
        ) {
            Spacer(modifier = Modifier.height(14.dp))

            Text(
                text = "Inicio  ›  Solicitudes  ›  Bandeja de solicitudes  ›  Programar y asignar técnico",
                color = Color(0xFF4B5878),
                fontSize = 13.sp
            )

            Spacer(modifier = Modifier.height(16.dp))

            Surface(
                modifier = Modifier.fillMaxWidth(),
                color = Color.White,
                shape = RoundedCornerShape(18.dp),
                shadowElevation = 4.dp
            ) {
                Column(
                    modifier = Modifier.padding(18.dp)
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Box(
                            modifier = Modifier
                                .size(58.dp)
                                .clip(RoundedCornerShape(12.dp))
                                .background(primaryBlue),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = "📅",
                                fontSize = 28.sp
                            )
                        }

                        Spacer(modifier = Modifier.width(14.dp))

                        Column(
                            modifier = Modifier.weight(1f)
                        ) {
                            Text(
                                text = "Programar y Asignar Técnico",
                                color = textDark,
                                fontSize = 24.sp,
                                fontWeight = FontWeight.Bold
                            )

                            Text(
                                text = "Programe la visita y asigne un técnico para esta solicitud.",
                                color = Color(0xFF5D6678),
                                fontSize = 14.sp
                            )
                        }

                        OutlinedButton(
                            onClick = {},
                            shape = RoundedCornerShape(12.dp)
                        ) {
                            Text(
                                text = "? Ayuda",
                                color = primaryBlue,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(18.dp))

                    RequestInformationCard(
                        primaryBlue = primaryBlue,
                        orange = orange
                    )

                    Spacer(modifier = Modifier.height(14.dp))

                    Surface(
                        modifier = Modifier.fillMaxWidth(),
                        color = Color.White,
                        shape = RoundedCornerShape(16.dp),
                        border = BorderStroke(1.dp, Color(0xFFE1E6F0))
                    ) {
                        Column(
                            modifier = Modifier.padding(16.dp)
                        ) {
                            Text(
                                text = "Programación del servicio",
                                color = primaryBlue,
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold
                            )

                            Spacer(modifier = Modifier.height(14.dp))

                            Row(
                                horizontalArrangement = Arrangement.spacedBy(12.dp)
                            ) {
                                ScheduleTextField(
                                    label = "Fecha programada *",
                                    value = scheduledDate,
                                    onValueChange = { scheduledDate = it },
                                    placeholder = "Seleccione fecha",
                                    primaryBlue = primaryBlue,
                                    modifier = Modifier.weight(1f)
                                )

                                ScheduleTextField(
                                    label = "Hora programada *",
                                    value = scheduledTime,
                                    onValueChange = { scheduledTime = it },
                                    placeholder = "Seleccione hora",
                                    primaryBlue = primaryBlue,
                                    modifier = Modifier.weight(1f)
                                )
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(14.dp))

                    Surface(
                        modifier = Modifier.fillMaxWidth(),
                        color = Color.White,
                        shape = RoundedCornerShape(16.dp),
                        border = BorderStroke(1.dp, Color(0xFFE1E6F0))
                    ) {
                        Column(
                            modifier = Modifier.padding(16.dp)
                        ) {
                            Text(
                                text = "Asignación de técnico",
                                color = primaryBlue,
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold
                            )

                            Spacer(modifier = Modifier.height(14.dp))

                            Row(
                                horizontalArrangement = Arrangement.spacedBy(12.dp)
                            ) {
                                ScheduleTextField(
                                    label = "Técnico asignado *",
                                    value = technician,
                                    onValueChange = { technician = it },
                                    placeholder = "Seleccione técnico disponible",
                                    primaryBlue = primaryBlue,
                                    modifier = Modifier.weight(1.35f)
                                )

                                ScheduleTextField(
                                    label = "Teléfono",
                                    value = technicianPhone,
                                    onValueChange = { technicianPhone = it },
                                    placeholder = "Teléfono",
                                    primaryBlue = primaryBlue,
                                    modifier = Modifier.weight(1f),
                                    keyboardType = KeyboardType.Phone
                                )
                            }

                            Spacer(modifier = Modifier.height(14.dp))

                            Surface(
                                modifier = Modifier.fillMaxWidth(),
                                color = green.copy(alpha = 0.10f),
                                shape = RoundedCornerShape(12.dp)
                            ) {
                                Text(
                                    text = "✅ Técnico disponible para la fecha y hora seleccionada.",
                                    color = green,
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight.Medium,
                                    modifier = Modifier.padding(12.dp)
                                )
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(14.dp))

                    Surface(
                        modifier = Modifier.fillMaxWidth(),
                        color = Color.White,
                        shape = RoundedCornerShape(16.dp),
                        border = BorderStroke(1.dp, Color(0xFFE1E6F0))
                    ) {
                        Column(
                            modifier = Modifier.padding(16.dp)
                        ) {
                            ScheduleTextField(
                                label = "Observaciones",
                                value = observations,
                                onValueChange = { observations = it },
                                placeholder = "Ingrese observaciones para la orden de trabajo...",
                                primaryBlue = primaryBlue,
                                minLines = 4
                            )

                            Spacer(modifier = Modifier.height(8.dp))

                            Text(
                                text = "50/250",
                                color = Color(0xFF5D6678),
                                fontSize = 12.sp,
                                modifier = Modifier.align(Alignment.End)
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(18.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(12.dp)
                    ) {
                        OutlinedButton(
                            onClick = onBackClick,
                            modifier = Modifier
                                .weight(1f)
                                .height(54.dp),
                            shape = RoundedCornerShape(12.dp)
                        ) {
                            Text(
                                text = "Cancelar",
                                color = primaryBlue,
                                fontWeight = FontWeight.Bold
                            )
                        }

                        Button(
                            onClick = onBackClick,
                            modifier = Modifier
                                .weight(1.1f)
                                .height(54.dp),
                            shape = RoundedCornerShape(12.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = primaryBlue
                            )
                        ) {
                            Text(
                                text = "Guardar programación",
                                color = Color.White,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(20.dp))
        }
    }
}

@Composable
private fun ScheduleTopBar(
    primaryBlue: Color,
    darkBlue: Color,
    onBackClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(96.dp)
            .background(
                Brush.horizontalGradient(
                    listOf(darkBlue, primaryBlue)
                )
            )
            .padding(horizontal = 18.dp),
        contentAlignment = Alignment.Center
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "☰",
                color = Color.White,
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.clickable { onBackClick() }
            )

            Spacer(modifier = Modifier.width(16.dp))

            Column {
                Text(
                    text = "MultiServicios de Oriente",
                    color = Color.White,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = "Panel de Administración",
                    color = Color.White.copy(alpha = 0.88f),
                    fontSize = 13.sp
                )
            }

            Spacer(modifier = Modifier.weight(1f))

            Text(
                text = "🔎",
                fontSize = 24.sp
            )

            Spacer(modifier = Modifier.width(12.dp))

            Box {
                Text(
                    text = "🔔",
                    fontSize = 25.sp
                )

                Box(
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .size(18.dp)
                        .clip(CircleShape)
                        .background(Color(0xFFE53935)),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "5",
                        color = Color.White,
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
    }
}

@Composable
private fun RequestInformationCard(
    primaryBlue: Color,
    orange: Color
) {
    Surface(
        modifier = Modifier.fillMaxWidth(),
        color = Color.White,
        shape = RoundedCornerShape(16.dp),
        border = BorderStroke(1.dp, Color(0xFFE1E6F0))
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = "Información de la solicitud",
                color = primaryBlue,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    ScheduleInfoItem(
                        label = "ID Solicitud",
                        value = "#SOL-2024-0057"
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    ScheduleInfoItem(
                        label = "Cliente",
                        value = "María López Torres",
                        secondary = "7123-4567"
                    )
                }

                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    ScheduleInfoItem(
                        label = "Equipo",
                        value = "LG Dual Inverter",
                        secondary = "18,000 BTU\nSN: LG18DI2023B009874"
                    )
                }

                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    Text(
                        text = "Tipo de servicio",
                        color = Color(0xFF5D6678),
                        fontSize = 12.sp
                    )

                    Spacer(modifier = Modifier.height(6.dp))

                    Surface(
                        color = orange.copy(alpha = 0.12f),
                        shape = RoundedCornerShape(12.dp),
                        border = BorderStroke(1.dp, orange.copy(alpha = 0.35f))
                    ) {
                        Text(
                            text = "🛠  Mantenimiento correctivo",
                            color = Color(0xFFE65100),
                            fontSize = 13.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(10.dp)
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            ScheduleTextField(
                label = "Descripción de la solicitud",
                value = "El equipo no enfría correctamente y hace un ruido extraño al encender.",
                onValueChange = {},
                placeholder = "",
                primaryBlue = primaryBlue,
                minLines = 3
            )

            Spacer(modifier = Modifier.height(14.dp))

            Row(
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                ScheduleTextField(
                    label = "Fecha preferida por el cliente",
                    value = "18/05/2024",
                    onValueChange = {},
                    placeholder = "",
                    primaryBlue = primaryBlue,
                    modifier = Modifier.weight(1f)
                )

                ScheduleTextField(
                    label = "Horario preferido por el cliente",
                    value = "02:00 PM",
                    onValueChange = {},
                    placeholder = "",
                    primaryBlue = primaryBlue,
                    modifier = Modifier.weight(1f)
                )
            }
        }
    }
}

@Composable
private fun ScheduleInfoItem(
    label: String,
    value: String,
    secondary: String = ""
) {
    Text(
        text = label,
        color = Color(0xFF5D6678),
        fontSize = 12.sp
    )

    Text(
        text = value,
        color = Color(0xFF17213D),
        fontSize = 15.sp,
        fontWeight = FontWeight.Bold,
        lineHeight = 19.sp
    )

    if (secondary.isNotBlank()) {
        Text(
            text = secondary,
            color = Color(0xFF4B5878),
            fontSize = 13.sp,
            lineHeight = 17.sp
        )
    }
}

@Composable
private fun ScheduleTextField(
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
            fontSize = 13.sp,
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
                    fontSize = 13.sp
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